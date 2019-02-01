package phoenix.interfaces;

import phoenix.service.StageHandler;

public interface UIController
{
    void run(StageHandler stageHandler);
    void terminate();
}
