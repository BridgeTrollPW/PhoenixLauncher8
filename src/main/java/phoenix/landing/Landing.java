package phoenix.landing;

import interfaces.UIController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import service.StageHandler;

import java.io.IOException;

public class Landing extends UIController
{
    @Override
    public void run(StageHandler stageHandler)
    {
        super.run(stageHandler);
        Parent root = null;
        try
        {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("phoenix/landing/landing.fxml"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("phoenix/landing/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        stageHandler.free();
    }
}
