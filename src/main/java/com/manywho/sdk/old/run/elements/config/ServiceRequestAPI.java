package com.manywho.sdk.old.run.elements.config;

import java.io.Serializable;

import com.manywho.sdk.old.run.elements.map.OutcomeAvailableAPI;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.json.JSONObject;

import com.manywho.sdk.old.draw.elements.group.*;
import com.manywho.sdk.old.translate.*;
import com.manywho.sdk.old.run.*;

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

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceRequestAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The token for this service request.  The token is needed for the service execution manager to identify the correct state.
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
	 The tenant from which this service request eminated.
	*/
	private String privatetenantId;
	public final String getTenantId()
	{
		return privatetenantId;
	}
	public final void setTenantId(String value)
	{
		privatetenantId = value;
	}

	/** 
	 The Uri for any callbacks from the remote service.
	*/
	private String privatecallbackUri;
	public final String getCallbackUri()
	{
		return privatecallbackUri;
	}
	public final void setCallbackUri(String value)
	{
		privatecallbackUri = value;
	}

	/** 
	 Provides the caller with the URI for the player this flow is currently using to run.
	*/
	private String privatejoinPlayerUri;
	public final String getJoinPlayerUri()
	{
		return privatejoinPlayerUri;
	}
	public final void setJoinPlayerUri(String value)
	{
		privatejoinPlayerUri = value;
	}

	/** 
	 Provides the caller with the URI for the player and the associated app.
	*/
	private String privateplayerUri;
	public final String getPlayerUri()
	{
		return privateplayerUri;
	}
	public final void setPlayerUri(String value)
	{
		privateplayerUri = value;
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
	 The Uri for the service to invoke.
	*/
	private String privateuri;
	public final String getUri()
	{
		return privateuri;
	}
	public final void setUri(String value)
	{
		privateuri = value;
	}

	/** 
	 The configuration information needed for the service to function.
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
	 The outcomes for the service.
	*/
	private java.util.ArrayList<OutcomeAvailableAPI> privateoutcomes;
	public final java.util.ArrayList<OutcomeAvailableAPI> getOutcomes()
	{
		return privateoutcomes;
	}
	public final void setOutcomes(java.util.ArrayList<OutcomeAvailableAPI> value)
	{
		privateoutcomes = value;
	}

    /**
     The inputs for the service.
     */
    private java.util.ArrayList<EngineValueAPI> privateinputs;
    public final java.util.ArrayList<EngineValueAPI> getInputs()
    {
        return privateinputs;
    }
    public final void setInputs(java.util.ArrayList<EngineValueAPI> value)
    {
        privateinputs = value;
    }

	/** 
	 The authorization context the message is running within. If we're running identity with the same service, this will tell the user
	 which users are currently authorized. The purpose of this property is to help with notifications - not to restrict access - that is
	 managed by the ManyWho engine.
	*/
	private GroupAuthorizationAPI privateauthorization;
	public final GroupAuthorizationAPI getAuthorization()
	{
		return privateauthorization;
	}
	public final void setAuthorization(GroupAuthorizationAPI value)
	{
		privateauthorization = value;
	}

	/** 
	 We pass the annotations as part of the service request.
	*/
	private java.util.HashMap<String, String> privateannotations;
	public final java.util.HashMap<String, String> getAnnotations()
	{
		return privateannotations;
	}
	public final void setAnnotations(java.util.HashMap<String, String> value)
	{
		privateannotations = value;
	}
}