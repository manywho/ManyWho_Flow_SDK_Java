package com.manywho.sdk.services.database;

import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.services.configuration.Configuration;

public interface RawDatabase<C extends Configuration, T extends MObject> extends DatabaseBase<C, T> {
}
