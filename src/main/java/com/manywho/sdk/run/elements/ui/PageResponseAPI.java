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

public class PageResponseAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privatelabel;
	public final String getLabel()
	{
		return privatelabel;
	}
	public final void setLabel(String value)
	{
		privatelabel = value;
	}

	private java.util.ArrayList<PageContainerResponseAPI> privatepageContainerResponses;
	public final java.util.ArrayList<PageContainerResponseAPI> getPageContainerResponses()
	{
		return privatepageContainerResponses;
	}
	public final void setPageContainerResponses(java.util.ArrayList<PageContainerResponseAPI> value)
	{
		privatepageContainerResponses = value;
	}

	private java.util.ArrayList<PageComponentResponseAPI> privatepageComponentResponses;
	public final java.util.ArrayList<PageComponentResponseAPI> getPageComponentResponses()
	{
		return privatepageComponentResponses;
	}
	public final void setPageComponentResponses(java.util.ArrayList<PageComponentResponseAPI> value)
	{
		privatepageComponentResponses = value;
	}

	private java.util.ArrayList<PageComponentDataResponseAPI> privatepageComponentDataResponses;
	public final java.util.ArrayList<PageComponentDataResponseAPI> getPageComponentDataResponses()
	{
		return privatepageComponentDataResponses;
	}
	public final void setPageComponentDataResponses(java.util.ArrayList<PageComponentDataResponseAPI> value)
	{
		privatepageComponentDataResponses = value;
	}

	private java.util.ArrayList<PageContainerDataResponseAPI> privatepageContainerDataResponses;
	public final java.util.ArrayList<PageContainerDataResponseAPI> getPageContainerDataResponses()
	{
		return privatepageContainerDataResponses;
	}
	public final void setPageContainerDataResponses(java.util.ArrayList<PageContainerDataResponseAPI> value)
	{
		privatepageContainerDataResponses = value;
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

	private java.util.HashMap<String, String> privateattributes;
	public final java.util.HashMap<String, String> getAttributes()
	{
		return privateattributes;
	}
	public final void setAttributes(java.util.HashMap<String, String> value)
	{
		privateattributes = value;
	}

	private int privateorder;
	public final int getOrder()
	{
		return privateorder;
	}
	public final void setOrder(int value)
	{
		privateorder = value;
	}
}