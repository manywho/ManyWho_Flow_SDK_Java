package com.manywho.sdk.services.database;

import com.manywho.sdk.services.configuration.Configuration;

import java.util.List;

/**
 * This interface is used when the service builder needs to handle write-only Database operations, so any Save or
 * Delete action.
 *
 * @param <C> the service's Configuration type
 * @param <T> the type of the ManyWho type to be used
 */
public interface WritableDatabase<C extends Configuration, T> {
    /**
     * Implementations of this method should take the object that is passed in, assign an ID to it, save it in the
     * appropriate store then return the object again populated with the created ID.
     *
     * @param configuration the populated Configuration object
     * @param object        the populated ManyWho object to create in the store
     * @return a typed ManyWho object populated with an ID
     */
    T create(C configuration, T object);

    /**
     * Implementations of this method should take the objects that are passed in, assign IDs to each one, save them in
     * the appropriate store then return the list of objects again, populated with the created IDs.
     *
     * @param configuration the populated Configuration object
     * @param objects       a list of populated ManyWho objects to create in the store
     * @return a list of typed ManyWho objects populated with IDs
     */
    List<T> create(C configuration, List<T> objects);

    /**
     * Implementations of this method should take the object that is passed in and delete it from the appropriate store.
     *
     * @param configuration the populated Configuration object
     * @param object        the populated ManyWho object to delete from the store
     */
    void delete(C configuration, T object);

    /**
     * Implementations of this method should take the objects that are passed in and delete them from the appropriate
     * store.
     *
     * @param configuration the populated Configuration object
     * @param objects       the populated ManyWho object to delete from the store
     */
    void delete(C configuration, List<T> objects);

    /**
     * Implementations of this method should take the object passed in, update the existing record in the appropriate
     * store, then return the now-updated object again.
     *
     * @param configuration the populated Configuration object
     * @param object        the populated ManyWho object to update in the store
     * @return a typed ManyWho object with, including any updated fields
     */
    T update(C configuration, T object);

    /**
     * Implementations of this method should take the objects passed in, update the existing records in the appropriate
     * store, then return the now-updated objects again.
     *
     * @param configuration the populated Configuration object
     * @param objects       the populated ManyWho objects to update in the store
     * @return a list of typed ManyWho objects, including any updated fields
     */
    List<T> update(C configuration, List<T> objects);
}
