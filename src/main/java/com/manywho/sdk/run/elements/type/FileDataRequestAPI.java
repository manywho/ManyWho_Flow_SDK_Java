package com.manywho.sdk.run.elements.type;

import java.io.Serializable;

import org.json.JSONObject;

import com.manywho.sdk.run.elements.config.*;
import com.manywho.sdk.translate.*;
import com.manywho.sdk.run.*;

/*!

Copyright 2013 ManyWho, Inc.

Licensed under the ManyWho License, Version 1.0 (the "License"); you may not use this
file except in compliance with the License.

You may obtain a copy of the License at: http://manywho.com/sharedsource

Unless required by applicable law or agreed to in writing, software distributed under
the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied. See the License for the specific language governing
permissions and limitations under the License.

*/

public class FileDataRequestAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The state id that allows us to make the correct version references.
	*/
	private String privatestateId;
	public final String getStateId()
	{
		return privatestateId;
	}
	public final void setStateId(String value)
	{
		privatestateId = value;
	}

	/** 
	 The service to grab the files from.
	*/
	private String privateserviceElementId;
	public final String getServiceElementId()
	{
		return privateserviceElementId;
	}
	public final void setServiceElementId(String value)
	{
		privateserviceElementId = value;
	}

	/** 
	 The unique token for this data job.  The token can be used to help the plugin cache multiple data calls.  If the token is provided, we can match it up
	 with a previous data request - if we choose to cache it.
	*/
	private String privatetoken;
	public final String getToken()
	{
		return privatetoken;
	}
	public final void setToken(String value)
	{
		privatetoken = value;
	}

	/** 
	 The authorization information for this element.  The authorization information will be used to validate user queries but can
	 also be used in messages etc, to manage notification.
	*/
	private AuthorizationAPI privateauthorization;
	public final AuthorizationAPI getAuthorization()
	{
		return privateauthorization;
	}
	public final void setAuthorization(AuthorizationAPI value)
	{
		privateauthorization = value;
	}

	/** 
	 The configuration information that comes from the service element.
	*/
	private java.util.ArrayList<EngineValueAPI> privateconfigurationValues;
	public final java.util.ArrayList<EngineValueAPI> getConfigurationValues()
	{
		return privateconfigurationValues;
	}
	public final void setConfigurationValues(java.util.ArrayList<EngineValueAPI> value)
	{
		privateconfigurationValues = value;
	}

	/** 
	 The culture for the service request.
	*/
	private CultureAPI privateculture;
	public final CultureAPI getCulture()
	{
		return privateculture;
	}
	public final void setCulture(CultureAPI value)
	{
		privateculture = value;
	}

	/** 
	 The resouce path to use when sourcing the files.
	*/
	private String privateresourcePath;
	public final String getResourcePath()
	{
		return privateresourcePath;
	}
	public final void setResourcePath(String value)
	{
		privateresourcePath = value;
	}

	/** 
	 The resouce path to use when sourcing a specific file.
	*/
	private String privateresourceFile;
	public final String getResourceFile()
	{
		return privateresourceFile;
	}
	public final void setResourceFile(String value)
	{
		privateresourceFile = value;
	}

	/** 
	 The filter to apply to the data at runtime.
	*/
	private FileListFilterAPI privatelistFilter;
	public final FileListFilterAPI getListFilter()
	{
		return privatelistFilter;
	}
	public final void setListFilter(FileListFilterAPI value)
	{
		privatelistFilter = value;
	}
}