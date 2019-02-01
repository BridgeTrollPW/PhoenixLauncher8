package interfaces;

import service.StageHandler;

public interface UIController
{
    void run(StageHandler stageHandler);
    void terminate();
}
