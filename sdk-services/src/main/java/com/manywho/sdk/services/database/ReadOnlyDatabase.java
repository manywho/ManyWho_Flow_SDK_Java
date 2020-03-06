package com.manywho.sdk.services.database;

import com.manywho.sdk.api.draw.content.Command;
import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataType;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.types.Type;

import java.util.List;

/**
 * This interface is used when the service builder needs to handle read-only Database operations, so basically any Load
 * action.
 *
 * @param <C> the service's Configuration type
 * @param <T> the type of the ManyWho type to be used
 */
public interface ReadOnlyDatabase<C extends Configuration, T extends Type> {
    /**
     * Implementations of this method should look up a single item in the appropriate store with the given ID.
     *
     * @param configuration the populated Configuration object
     * @param objectDataType information about the type of object that is expected to be returned by the service
     * @param command       the command to execute when querying, if any
     * @param id            the object's external ID
     * @return a single object of the defined ManyWho type
     */
    T find(C configuration, ObjectDataType objectDataType, Command command, String id);

    /**
     * Implementations of this method should look up items in the appropriate store using the given filter.
     *
     * @param configuration the populated Configuration object
     * @param objectDataType information about the type of object that is expected to be returned by the service
     * @param command       the command to execute when querying, if any
     * @param filter        the filtering options to be used when querying for objects
     * @param objects        the list of objects sent in the request, if any
     * @return a list of objects of the defined ManyWho type
     */
    List<T> findAll(C configuration, ObjectDataType objectDataType, Command command, ListFilter filter, List<MObject> objects);
}
