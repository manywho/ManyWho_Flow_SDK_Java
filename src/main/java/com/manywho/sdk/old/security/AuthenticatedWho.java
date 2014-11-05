package com.manywho.sdk.old.security;

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

public class AuthenticatedWho extends JSONObject implements Serializable, IAuthenticatedWho
{
	private static final long serialVersionUID = 1L;

	private String privateManyWhoUserId;
	public final String getManyWhoUserId()
	{
		return privateManyWhoUserId;
	}
	public final void setManyWhoUserId(String value)
	{
		privateManyWhoUserId = value;
	}

	private String privateManyWhoTenantId;
	public final String getManyWhoTenantId()
	{
		return privateManyWhoTenantId;
	}
	public final void setManyWhoTenantId(String value)
	{
		privateManyWhoTenantId = value;
	}

	private String privateManyWhoToken;
	public final String getManyWhoToken()
	{
		return privateManyWhoToken;
	}
	public final void setManyWhoToken(String value)
	{
		privateManyWhoToken = value;
	}

	private IGeoLocation privateGeoLocation;
	public final IGeoLocation getGeoLocation()
	{
		return privateGeoLocation;
	}
	public final void setGeoLocation(IGeoLocation value)
	{
		privateGeoLocation = value;
	}

	private String privateUserId;
	public final String getUserId()
	{
		return privateUserId;
	}
	public final void setUserId(String value)
	{
		privateUserId = value;
	}

	private String privateUsername;
	public final String getUsername()
	{
		return privateUsername;
	}
	public final void setUsername(String value)
	{
		privateUsername = value;
	}

	private String privateEmail;
	public final String getEmail()
	{
		return privateEmail;
	}
	public final void setEmail(String value)
	{
		privateEmail = value;
	}

	private String privateIdentityProvider;
	public final String getIdentityProvider()
	{
		return privateIdentityProvider;
	}
	public final void setIdentityProvider(String value)
	{
		privateIdentityProvider = value;
	}

	private String privateToken;
	public final String getToken()
	{
		return privateToken;
	}
	public final void setToken(String value)
	{
		privateToken = value;
	}

	private String privateTenantName;
	public final String getTenantName()
	{
		return privateTenantName;
	}
	public final void setTenantName(String value)
	{
		privateTenantName = value;
	}

	private String privateDirectoryName;
	public final String getDirectoryName()
	{
		return privateDirectoryName;
	}
	public final void setDirectoryName(String value)
	{
		privateDirectoryName = value;
	}

	private String privateDirectoryId;
	public final String getDirectoryId()
	{
		return privateDirectoryId;
	}
	public final void setDirectoryId(String value)
	{
		privateDirectoryId = value;
	}

	private String privateFirstName;
	public final String getFirstName()
	{
		return privateFirstName;
	}
	public final void setFirstName(String value)
	{
		privateFirstName = value;
	}

	private String privateLastName;
	public final String getLastName()
	{
		return privateLastName;
	}
	public final void setLastName(String value)
	{
		privateLastName = value;
	}
}