package com.manywho.sdk.draw.elements.group;

import java.io.Serializable;

import org.json.JSONObject;

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

public class GroupAuthorizationAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privateserviceElementId;
	public final String getServiceElementId()
	{
		return privateserviceElementId;
	}
	public final void setServiceElementId(String value)
	{
		privateserviceElementId = value;
	}

	private String privateglobalAuthenticationType;
	public final String getGlobalAuthenticationType()
	{
		return privateglobalAuthenticationType;
	}
	public final void setGlobalAuthenticationType(String value)
	{
		privateglobalAuthenticationType = value;
	}

	private String privatestreamBehaviourType;
	public final String getStreamBehaviourType()
	{
		return privatestreamBehaviourType;
	}
	public final void setStreamBehaviourType(String value)
	{
		privatestreamBehaviourType = value;
	}

	private java.util.ArrayList<GroupAuthorizationGroupAPI> privategroups;
	public final java.util.ArrayList<GroupAuthorizationGroupAPI> getGroups()
	{
		return privategroups;
	}
	public final void setGroups(java.util.ArrayList<GroupAuthorizationGroupAPI> value)
	{
		privategroups = value;
	}

	private java.util.ArrayList<GroupAuthorizationUserAPI> privateusers;
	public final java.util.ArrayList<GroupAuthorizationUserAPI> getUsers()
	{
		return privateusers;
	}
	public final void setUsers(java.util.ArrayList<GroupAuthorizationUserAPI> value)
	{
		privateusers = value;
	}

	private java.util.ArrayList<GroupAuthorizationLocationAPI> privatelocations;
	public final java.util.ArrayList<GroupAuthorizationLocationAPI> getLocations()
	{
		return privatelocations;
	}
	public final void setLocations(java.util.ArrayList<GroupAuthorizationLocationAPI> value)
	{
		privatelocations = value;
	}
}