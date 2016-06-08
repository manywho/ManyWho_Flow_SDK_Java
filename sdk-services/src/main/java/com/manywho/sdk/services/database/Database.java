package com.manywho.sdk.services.database;

import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.types.Type;

public interface Database<C extends Configuration, T extends Type> extends WritableDatabase<C, T>, ReadOnlyDatabase<C, T> {
}
