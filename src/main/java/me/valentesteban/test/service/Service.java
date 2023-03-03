package me.valentesteban.test.service;

public interface Service {
    void start();

    default void stop() {}
}
