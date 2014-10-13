package manywho.flow.sdk.run.elements.map;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.run.elements.ui.*;

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

public class MapElementInvokeResponseAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privatemapElementId;
	public final String getMapElementId()
	{
		return privatemapElementId;
	}
	public final void setMapElementId(String value)
	{
		privatemapElementId = value;
	}

	private String privatedeveloperName;
	public final String getDeveloperName()
	{
		return privatedeveloperName;
	}
	public final void setDeveloperName(String value)
	{
		privatedeveloperName = value;
	}

	private PageResponseAPI privatepageResponse;
	public final PageResponseAPI getPageResponse()
	{
		return privatepageResponse;
	}
	public final void setPageResponse(PageResponseAPI value)
	{
		privatepageResponse = value;
	}

	private java.util.ArrayList<OutcomeResponseAPI> privateoutcomeResponses;
	public final java.util.ArrayList<OutcomeResponseAPI> getOutcomeResponses()
	{
		return privateoutcomeResponses;
	}
	public final void setOutcomeResponses(java.util.ArrayList<OutcomeResponseAPI> value)
	{
		privateoutcomeResponses = value;
	}

	private java.util.HashMap<String, String> privaterootFaults;
	public final java.util.HashMap<String, String> getRootFaults()
	{
		return privaterootFaults;
	}
	public final void setRootFaults(java.util.HashMap<String, String> value)
	{
		privaterootFaults = value;
	}
}