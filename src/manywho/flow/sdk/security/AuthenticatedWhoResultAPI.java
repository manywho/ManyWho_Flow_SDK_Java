package manywho.flow.sdk.security;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.translate.*;

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

public class AuthenticatedWhoResultAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privateuserId;
	public final String getUserId()
	{
		return privateuserId;
	}
	public final void setUserId(String value)
	{
		privateuserId = value;
	}

	private String privateemail;
	public final String getEmail()
	{
		return privateemail;
	}
	public final void setEmail(String value)
	{
		privateemail = value;
	}

	private String privateusername;
	public final String getUsername()
	{
		return privateusername;
	}
	public final void setUsername(String value)
	{
		privateusername = value;
	}

	private String privatefirstName;
	public final String getFirstName()
	{
		return privatefirstName;
	}
	public final void setFirstName(String value)
	{
		privatefirstName = value;
	}

	private String privatelastName;
	public final String getLastName()
	{
		return privatelastName;
	}
	public final void setLastName(String value)
	{
		privatelastName = value;
	}

	private String privatedirectoryId;
	public final String getDirectoryId()
	{
		return privatedirectoryId;
	}
	public final void setDirectoryId(String value)
	{
		privatedirectoryId = value;
	}

	private String privatedirectoryName;
	public final String getDirectoryName()
	{
		return privatedirectoryName;
	}
	public final void setDirectoryName(String value)
	{
		privatedirectoryName = value;
	}

	private String privatetenantName;
	public final String getTenantName()
	{
		return privatetenantName;
	}
	public final void setTenantName(String value)
	{
		privatetenantName = value;
	}

	private String privatetenantId;
	public final String getTenantId()
	{
		return privatetenantId;
	}
	public final void setTenantId(String value)
	{
		privatetenantId = value;
	}

	private String privateidentityProvider;
	public final String getIdentityProvider()
	{
		return privateidentityProvider;
	}
	public final void setIdentityProvider(String value)
	{
		privateidentityProvider = value;
	}

	private String privatetoken;
	public final String getToken()
	{
		return privatetoken;
	}
	public final void setToken(String value)
	{
		privatetoken = value;
	}

	private String privatestatus;
	public final String getStatus()
	{
		return privatestatus;
	}
	public final void setStatus(String value)
	{
		privatestatus = value;
	}

	private String privatestatusMessage;
	public final String getStatusMessage()
	{
		return privatestatusMessage;
	}
	public final void setStatusMessage(String value)
	{
		privatestatusMessage = value;
	}

	private CultureAPI privateculture;
	public final CultureAPI getCulture()
	{
		return privateculture;
	}
	public final void setCulture(CultureAPI value)
	{
		privateculture = value;
	}
}