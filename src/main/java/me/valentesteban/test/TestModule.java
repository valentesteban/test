package me.valentesteban.test;

import me.valentesteban.test.file.YamlFile;
import me.valentesteban.test.placeholder.PlaceholderModule;
import me.valentesteban.test.scoreboard.registry.ScoreboardRegistry;
import me.valentesteban.test.service.Service;
import me.valentesteban.test.service.impl.ListenerService;
import me.valentesteban.test.service.impl.PlaceholderService;
import me.valentesteban.test.service.impl.SchedulerService;
import team.unnamed.inject.AbstractModule;

import java.util.HashSet;
import java.util.Set;

public class TestModule
        extends AbstractModule {
    private final Test test;

    public TestModule(Test test) {
        this.test = test;
    }

    @Override
    protected void configure() {
        YamlFile config = new YamlFile(test, "config");
        bind(YamlFile.class)
                .toInstance(config);

        bind(YamlFile.class)
                .named("scoreboards")
                .toInstance(new YamlFile(test, "scoreboards"));

        multibind(Service.class)
                .asCollection(Set.class, HashSet::new)
                .to(ListenerService.class)
                .to(PlaceholderService.class)
                .to(SchedulerService.class)
                .singleton();

        bind(ScoreboardRegistry.class)
                .singleton();

        install(new PlaceholderModule());

        bind(Test.class).toInstance(test);
    }
}
