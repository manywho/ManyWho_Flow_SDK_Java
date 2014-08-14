package manywho.flow.sdk.security;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.run.*;

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

public class AuthenticationCredentialsAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 Any additional configuration values that may have been applied by the engine to help with authentication.
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

	private String privateauthenticationType;
	public final String getAuthenticationType()
	{
		return privateauthenticationType;
	}
	public final void setAuthenticationType(String value)
	{
		privateauthenticationType = value;
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

	private String privatepassword;
	public final String getPassword()
	{
		return privatepassword;
	}
	public final void setPassword(String value)
	{
		privatepassword = value;
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

	private String privatecode;
	public final String getCode()
	{
		return privatecode;
	}
	public final void setCode(String value)
	{
		privatecode = value;
	}

	private String privatesessionToken;
	public final String getSessionToken()
	{
		return privatesessionToken;
	}
	public final void setSessionToken(String value)
	{
		privatesessionToken = value;
	}

	private String privatesessionUrl;
	public final String getSessionUrl()
	{
		return privatesessionUrl;
	}
	public final void setSessionUrl(String value)
	{
		privatesessionUrl = value;
	}

	private String privateloginUrl;
	public final String getLoginUrl()
	{
		return privateloginUrl;
	}
	public final void setLoginUrl(String value)
	{
		privateloginUrl = value;
	}

	private String privateredirectUri;
	public final String getRedirectUri()
	{
		return privateredirectUri;
	}
	public final void setRedirectUri(String value)
	{
		privateredirectUri = value;
	}

	private String privateinstanceUrl;
	public final String getInstanceUrl()
	{
		return privateinstanceUrl;
	}
	public final void setInstanceUrl(String value)
	{
		privateinstanceUrl = value;
	}
}