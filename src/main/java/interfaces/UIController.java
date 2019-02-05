package interfaces;

import javafx.stage.Stage;
import util.StageHandler;

public class UIController
{
    protected Stage stage;

    public void run(StageHandler stageHandler)
    {
        this.stage = stageHandler.aquire();
    }
}
