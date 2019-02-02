package phoenix.entrypoint;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import interfaces.UIController;
import service.StageHandler;
import service.WebAssetLoader;

import java.io.IOException;

public class Splash extends UIController
{
    public void run(StageHandler stageHandler)
    {
        super.run(stageHandler);
        Parent root = null;
        try
        {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("phoenix/entrypoint/splash.fxml"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        // TODO: Implement WebAssetLoader Thread Pool
        WebAssetLoader webAssetLoader = new WebAssetLoader();
        stage.close();
        stageHandler.free();
    }
}
