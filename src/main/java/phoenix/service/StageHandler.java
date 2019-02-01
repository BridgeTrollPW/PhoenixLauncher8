package phoenix.service;

import javafx.stage.Stage;

public class StageHandler {
    private final Stage primaryStage;
    private boolean locked;

    public StageHandler(Stage stage) {
        this.primaryStage = stage;
    }

    private boolean isLocked() {
        return locked;
    }

    public Stage aquire() {
        if (this.isLocked())
            return null;

        this.setLocked(true);
        return primaryStage;
    }

    public void free() {
        this.setLocked(false);
    }

    private void setLocked(boolean lock) {
        this.locked = lock;
    }
}
