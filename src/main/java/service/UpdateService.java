package service;

import model.http.Response;
import util.HTTPClient;

import java.io.IOException;

public class UpdateService
{

    public static Response checkUpdate()
    {
        String clientVer = "0-0-1";

        HTTPClient httpClient = new HTTPClient();
        httpClient.setUrl("127.0.0.1:8081/update/check/" + clientVer);
        httpClient.setProtocol(HTTPClient.Protocol.HTTP);
        Response response = new Response();
        try
        {
            response = httpClient.get();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return response;
    }
}
