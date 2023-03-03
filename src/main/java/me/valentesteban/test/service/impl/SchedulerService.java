package me.valentesteban.test.service.impl;

import me.valentesteban.test.Test;
import me.valentesteban.test.scheduler.ScoreboardScheduler;
import me.valentesteban.test.service.Service;
import team.unnamed.inject.InjectAll;

@InjectAll
public class SchedulerService
        implements Service {

    private Test test;
    private ScoreboardScheduler scoreboardScheduler;

    @Override
    public void start() {
        scoreboardScheduler.runTaskTimerAsynchronously(test, 300, 1);
    }

    @Override
    public void stop() {
        scoreboardScheduler.cancel();
    }
}