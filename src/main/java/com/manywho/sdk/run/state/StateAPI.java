package com.manywho.sdk.run.state;

import java.io.Serializable;

import org.json.JSONObject;

import com.manywho.sdk.draw.flow.*;

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

public class StateAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privateid;
	public final String getId()
	{
		return privateid;
	}
	public final void setId(String value)
	{
		privateid = value;
	}

	private String privateparentId;
	public final String getParentId()
	{
		return privateparentId;
	}
	public final void setParentId(String value)
	{
		privateparentId = value;
	}

	private java.util.Date privatedateCreated = new java.util.Date(0);
	public final java.util.Date getDateCreated()
	{
		return privatedateCreated;
	}
	public final void setDateCreated(java.util.Date value)
	{
		privatedateCreated = value;
	}

	private java.util.Date privatedateModified = new java.util.Date(0);
	public final java.util.Date getDateModified()
	{
		return privatedateModified;
	}
	public final void setDateModified(java.util.Date value)
	{
		privatedateModified = value;
	}

	private FlowIdAPI privatecurrentFlowId;
	public final FlowIdAPI getCurrentFlowId()
	{
		return privatecurrentFlowId;
	}
	public final void setCurrentFlowId(FlowIdAPI value)
	{
		privatecurrentFlowId = value;
	}

	private String privatecurrentFlowDeveloperName;
	public final String getCurrentFlowDeveloperName()
	{
		return privatecurrentFlowDeveloperName;
	}
	public final void setCurrentFlowDeveloperName(String value)
	{
		privatecurrentFlowDeveloperName = value;
	}

	private String privatecurrentMapElementId;
	public final String getCurrentMapElementId()
	{
		return privatecurrentMapElementId;
	}
	public final void setCurrentMapElementId(String value)
	{
		privatecurrentMapElementId = value;
	}

	private String privatecurrentMapElementDeveloperName;
	public final String getCurrentMapElementDeveloperName()
	{
		return privatecurrentMapElementDeveloperName;
	}
	public final void setCurrentMapElementDeveloperName(String value)
	{
		privatecurrentMapElementDeveloperName = value;
	}

	private String privatecurrentStreamId;
	public final String getCurrentStreamId()
	{
		return privatecurrentStreamId;
	}
	public final void setCurrentStreamId(String value)
	{
		privatecurrentStreamId = value;
	}

	private String privatecurrentRunningUserId;
	public final String getCurrentRunningUserId()
	{
		return privatecurrentRunningUserId;
	}
	public final void setCurrentRunningUserId(String value)
	{
		privatecurrentRunningUserId = value;
	}

	private String privateexternalIdentifier;
	public final String getExternalIdentifier()
	{
		return privateexternalIdentifier;
	}
	public final void setExternalIdentifier(String value)
	{
		privateexternalIdentifier = value;
	}

	private String privatemanywhoTenantId;
	public final String getManyWhoTenantId()
	{
		return privatemanywhoTenantId;
	}
	public final void setManyWhoTenantId(String value)
	{
		privatemanywhoTenantId = value;
	}

	private java.util.HashMap<String, String> privateannotations;
	public final java.util.HashMap<String, String> getAnnotations()
	{
		return privateannotations;
	}
	public final void setAnnotations(java.util.HashMap<String, String> value)
	{
		privateannotations = value;
	}

	private java.util.ArrayList<StateEntryAPI> privatestateEntries;
	public final java.util.ArrayList<StateEntryAPI> getStateEntries()
	{
		return privatestateEntries;
	}
	public final void setStateEntries(java.util.ArrayList<StateEntryAPI> value)
	{
		privatestateEntries = value;
	}

	private StateEntryAPI privateprecommitStateEntry;
	public final StateEntryAPI getPrecommitStateEntry()
	{
		return privateprecommitStateEntry;
	}
	public final void setPrecommitStateEntry(StateEntryAPI value)
	{
		privateprecommitStateEntry = value;
	}

	private java.util.ArrayList<StateValueAPI> privatevalues;
	public final java.util.ArrayList<StateValueAPI> getValues()
	{
		return privatevalues;
	}
	public final void setValues(java.util.ArrayList<StateValueAPI> value)
	{
		privatevalues = value;
	}

	private String privateauthorizationHeader;
	public final String getAuthorizationHeader()
	{
		return privateauthorizationHeader;
	}
	public final void setAuthorizationHeader(String value)
	{
		privateauthorizationHeader = value;
	}
}