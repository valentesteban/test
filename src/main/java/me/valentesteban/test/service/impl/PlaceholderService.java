package me.valentesteban.test.service.impl;

import me.valentesteban.test.placeholder.applier.PlaceholderApplier;
import me.valentesteban.test.placeholder.types.UserPlaceholder;
import me.valentesteban.test.service.Service;
import team.unnamed.inject.InjectAll;

@InjectAll
public class PlaceholderService
        implements Service {

    private PlaceholderApplier placeholderApplier;
    private UserPlaceholder userPlaceHolder;

    @Override
    public void start() {
        placeholderApplier.getPlaceHolders().add(userPlaceHolder);
    }
}