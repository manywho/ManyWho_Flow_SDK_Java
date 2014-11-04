package com.manywho.sdk.run.elements.ui;

import java.io.Serializable;

import org.json.JSONObject;

import com.manywho.sdk.run.*;

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

public class PageContainerDataResponseAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privatepageContainerId;
	public final String getPageContainerId()
	{
		return privatepageContainerId;
	}
	public final void setPageContainerId(String value)
	{
		privatepageContainerId = value;
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

	private boolean privateisEditable;
	public final boolean getIsEditable()
	{
		return privateisEditable;
	}
	public final void setIsEditable(boolean value)
	{
		privateisEditable = value;
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