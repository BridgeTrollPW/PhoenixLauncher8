package util;

import model.http.ErrorCode;
import model.http.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HTTPClient
{

    public enum Protocol {
        HTTP,
        HTTPS
    }

    private String targetUrl;
    private Protocol protocol;
    private HttpURLConnection connection;
    private Map<String, String> headers;

    public HTTPClient() {
        this.headers = new HashMap<>();
        this.protocol = Protocol.HTTP;
    }

    public HTTPClient setUrl(String url) {
        this.targetUrl = url;
        return this;
    }

    public HTTPClient setProtocol(Protocol protocol) {
        this.protocol = protocol;
        return this;
    }

    public HTTPClient setHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    /**
     * TODO: something still throws an unhandled exception on normal rest errors like 404
     * TODO: use headers for request
     * @return Response
     * @throws IOException
     */
    public Response get() throws IOException {
        try {
            connection = (HttpURLConnection) new URL(this.protocol.toString() + "://" + this.targetUrl).openConnection();
        } catch (MalformedURLException malformedUrl) {
            Response httpResponse = new Response();
            httpResponse.setError(ErrorCode.MALFORMED_URL);
            return httpResponse;
        } catch (IOException e) {
            Response httpResponse = new Response();
            ErrorCode error = ErrorCode.UNKNOWN;
            error.setMessage(e.getMessage());
            httpResponse.setError(error);
            return httpResponse;
        }

        connection.setUseCaches(false);
        connection.setDoOutput(true);
        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            Response httpResponse = new Response();
            httpResponse.setError(ErrorCode.PROTOCOL_ERROR);
            return httpResponse;
        }
        try {
            connection.connect();
        } catch (IOException e) {
            Response httpResponse = new Response();
            ErrorCode error = ErrorCode.UNKNOWN;
            error.setMessage(e.getMessage());
            httpResponse.setError(error);
            return httpResponse;
        }

        //Get Response
        InputStream is = connection.getInputStream();

        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();

        Response httpResponse = new Response();
        httpResponse.setContentLength(connection.getContentLength());
        httpResponse.setBody(response.toString());
        httpResponse.setResponseCode(connection.getResponseCode());

        return httpResponse;
    }
}
