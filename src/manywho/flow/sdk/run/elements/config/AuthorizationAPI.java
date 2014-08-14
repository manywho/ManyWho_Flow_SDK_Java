package manywho.flow.sdk.run.elements.config;

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

public class AuthorizationAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private java.util.ArrayList<UserAPI> privateusers;
	public final java.util.ArrayList<UserAPI> getUsers()
	{
		return privateusers;
	}
	public final void setUsers(java.util.ArrayList<UserAPI> value)
	{
		privateusers = value;
	}

	private java.util.ArrayList<GroupAPI> privategroups;
	public final java.util.ArrayList<GroupAPI> getGroups()
	{
		return privategroups;
	}
	public final void setGroups(java.util.ArrayList<GroupAPI> value)
	{
		privategroups = value;
	}

	private String privaterunningAuthenticationId;
	public final String getRunningAuthenticationId()
	{
		return privaterunningAuthenticationId;
	}
	public final void setRunningAuthenticationId(String value)
	{
		privaterunningAuthenticationId = value;
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
}