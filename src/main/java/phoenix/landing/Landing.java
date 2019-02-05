package phoenix.landing;

import interfaces.UIController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import service.UpdateService;
import util.StageHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Landing extends UIController implements Initializable
{
    @FXML
    private TextArea apiResponse;

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

    /**
     *
     */
    @FXML
    private void dos(ActionEvent event)
    {
        Scene s = ((Button)event.getTarget()).getScene();
        apiResponse = (TextArea)s.lookup("#apiresponse");
        apiResponse.setText("");
        apiResponse.appendText(UpdateService.checkUpdate().getBody());

    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
