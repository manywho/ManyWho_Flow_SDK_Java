package com.manywho.sdk.old.run;

import java.io.Serializable;

import org.json.JSONObject;

import com.manywho.sdk.old.run.elements.ui.*;
import com.manywho.sdk.old.translate.*;

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

public class EngineNavigationResponseAPI extends JSONObject implements Serializable
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

	private String privatedeveloperName;
	public final String getDeveloperName()
	{
		return privatedeveloperName;
	}
	public final void setDeveloperName(String value)
	{
		privatedeveloperName = value;
	}

	private String privatelabel;
	public final String getLabel()
	{
		return privatelabel;
	}
	public final void setLabel(String value)
	{
		privatelabel = value;
	}

	private java.util.ArrayList<NavigationItemResponseAPI> privatenavigationItemResponses;
	public final java.util.ArrayList<NavigationItemResponseAPI> getNavigationItemResponses()
	{
		return privatenavigationItemResponses;
	}
	public final void setNavigationItemResponses(java.util.ArrayList<NavigationItemResponseAPI> value)
	{
		privatenavigationItemResponses = value;
	}

	private java.util.ArrayList<NavigationItemDataResponseAPI> privatenavigationItemDataResponses;
	public final java.util.ArrayList<NavigationItemDataResponseAPI> getNavigationItemDataResponses()
	{
		return privatenavigationItemDataResponses;
	}
	public final void setNavigationItemDataResponses(java.util.ArrayList<NavigationItemDataResponseAPI> value)
	{
		privatenavigationItemDataResponses = value;
	}

	private java.util.ArrayList<EngineValueAPI> privatetags;
	public final java.util.ArrayList<EngineValueAPI> getTags()
	{
		return privatetags;
	}
	public final void setTags(java.util.ArrayList<EngineValueAPI> value)
	{
		privatetags = value;
	}
}