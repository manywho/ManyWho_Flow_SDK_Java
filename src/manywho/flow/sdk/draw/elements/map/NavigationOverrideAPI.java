package manywho.flow.sdk.draw.elements.map;

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

public class NavigationOverrideAPI extends JSONObject implements Serializable
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

	private String privatenavigationElementId;
	public final String getNavigationElementId()
	{
		return privatenavigationElementId;
	}
	public final void setNavigationElementId(String value)
	{
		privatenavigationElementId = value;
	}

	private String privatenavigationItemId;
	public final String getNavigationItemId()
	{
		return privatenavigationItemId;
	}
	public final void setNavigationItemId(String value)
	{
		privatenavigationItemId = value;
	}

	private boolean privateisEnabled;
	public final boolean getIsEnabled()
	{
		return privateisEnabled;
	}
	public final void setIsEnabled(boolean value)
	{
		privateisEnabled = value;
	}

	private boolean privateisVisible;
	public final boolean getIsVisible()
	{
		return privateisVisible;
	}
	public final void setIsVisible(boolean value)
	{
		privateisVisible = value;
	}

	private String privatelocationMapElementId;
	public final String getLocationMapElementId()
	{
		return privatelocationMapElementId;
	}
	public final void setLocationMapElementId(String value)
	{
		privatelocationMapElementId = value;
	}
}