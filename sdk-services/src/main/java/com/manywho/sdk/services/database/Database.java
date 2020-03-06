package com.manywho.sdk.services.database;

import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.types.Type;

/**
 * This interface combines the {@link ReadOnlyDatabase} and {@link WritableDatabase} interfaces to use when every kind
 * of Database operation is needed.
 *
 * @param <C> the service's Configuration type
 * @param <T> the type of the ManyWho type to be used
 */
public interface Database<C extends Configuration, T extends Type> extends WritableDatabase<C, T>, ReadOnlyDatabase<C, T> {
}
