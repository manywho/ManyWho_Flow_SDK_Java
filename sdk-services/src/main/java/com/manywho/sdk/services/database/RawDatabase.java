package com.manywho.sdk.services.database;

import com.manywho.sdk.api.draw.content.Command;
import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataType;
import com.manywho.sdk.services.configuration.Configuration;

import java.util.List;

/**
 * This interface is used when the service builder needs to handle raw ManyWho objects in their Database calls. This is
 * normally only required if a dynamic Type is used instead of a statically-defined one.
 *
 * @param <C> the service's Configuration type
 */
public interface RawDatabase<C extends Configuration> extends WritableDatabase<C, MObject> {
    /**
     * Implementations of this method should look up a single item in the appropriate store with the given ID, and
     * return a ManyWho object that includes the properties given in the <code>objectDataType</code> parameter.
     *
     * @param configuration  the populated Configuration object
     * @param objectDataType information about the type of object that is expected to be returned by the Service
     * @param command        the command to execute when querying, if any
     * @param id             the object's external ID
     * @return a single ManyWho object
     */
    MObject find(C configuration, ObjectDataType objectDataType, Command command, String id);

    /**
     * Implementations of this method should look up items in the appropriate store using the given filter, and return
     * a list of ManyWho objects that include the properties given in the <code>objectDataType</code> parameter.
     *
     * @param configuration  the populated Configuration object
     * @param objectDataType information about the type of objects that are expected to be returned by the Service
     * @param command        the command to execute when querying, if any
     * @param filter         the filtering options to be used when querying for objects
     * @return a list of ManyWho objects
     */
    List<MObject> findAll(C configuration, ObjectDataType objectDataType, Command command, ListFilter filter);
}
