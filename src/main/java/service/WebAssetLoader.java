package service;

import model.http.Response;
import util.HTTPClient;

import java.io.IOException;

//TODO Rename to webapiclient and implement as rest api client in here
public class WebAssetLoader
{
    public WebAssetLoader()
    {
        HTTPClient http = new HTTPClient();
        http.setUrl("127.0.0.1:8081/ping");
        http.setProtocol(HTTPClient.Protocol.HTTP);

        Response response = new Response();
        try
        {
            response = http.get();
        }
        catch (IOException e)
        {
            System.out.println("Error calling ping");
        }
        System.out.println(response.getBody());

        //UpdateService updateService = new UpdateService();

    }
}
