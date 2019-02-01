package phoenix.entrypoint;

import phoenix.service.StageHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartRoutine extends Application
{
    private static StageHandler stageHandler;

    public static void main(String[] args)
    {

        System.out.println("Hello Phoenix Launcher 0.8.0");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        stageHandler = new StageHandler(primaryStage);
        (new Splash()).run(StartRoutine.stageHandler);
    }


    @Override
    public void stop() throws Exception
    {
        super.stop();
    }
}
