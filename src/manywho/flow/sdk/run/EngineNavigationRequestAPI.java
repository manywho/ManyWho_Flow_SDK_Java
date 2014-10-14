package manywho.flow.sdk.run;

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

public class EngineNavigationRequestAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CultureAPI privateculture;
	public final CultureAPI getCulture()
	{
		return privateculture;
	}
	public final void setCulture(CultureAPI value)
	{
		privateculture = value;
	}

	private String privatestateId;
	public final String getStateId()
	{
		return privatestateId;
	}
	public final void setStateId(String value)
	{
		privatestateId = value;
	}

	private String privatestateToken;
	public final String getStateToken()
	{
		return privatestateToken;
	}
	public final void setStateToken(String value)
	{
		privatestateToken = value;
	}

	private String privatenavigationElementId;
	public final String getNavigationElementId()
	{
		return privatenavigationElementId;
	}
	public final void setNavigationElementId(String value)
	{
		privatenavigationElementId = value;
	}
}