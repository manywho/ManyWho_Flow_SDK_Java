package manywho.flow.sdk.run;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.run.state.*;
import manywho.flow.sdk.run.elements.map.*;
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

public class EngineInvokeRequestAPI extends JSONObject implements Serializable
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

	private String privatecurrentMapElementId;
	public final String getCurrentMapElementId()
	{
		return privatecurrentMapElementId;
	}
	public final void setCurrentMapElementId(String value)
	{
		privatecurrentMapElementId = value;
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

	private String privateselectedNavigationItemId;
	public final String getSelectedNavigationItemId()
	{
		return privateselectedNavigationItemId;
	}
	public final void setSelectedNavigationItemId(String value)
	{
		privateselectedNavigationItemId = value;
	}

	private String privateinvokeType;
	public final String getInvokeType()
	{
		return privateinvokeType;
	}
	public final void setInvokeType(String value)
	{
		privateinvokeType = value;
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

	private GeoLocationAPI privategeoLocation;
	public final GeoLocationAPI getGeoLocation()
	{
		return privategeoLocation;
	}
	public final void setGeoLocation(GeoLocationAPI value)
	{
		privategeoLocation = value;
	}

	private MapElementInvokeRequestAPI privatemapElementInvokeRequest;
	public final MapElementInvokeRequestAPI getMapElementInvokeRequest()
	{
		return privatemapElementInvokeRequest;
	}
	public final void setMapElementInvokeRequest(MapElementInvokeRequestAPI value)
	{
		privatemapElementInvokeRequest = value;
	}

	private String privatemode;
	public final String getMode()
	{
		return privatemode;
	}
	public final void setMode(String value)
	{
		privatemode = value;
	}
}