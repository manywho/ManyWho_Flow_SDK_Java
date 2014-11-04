package com.manywho.sdk.draw.elements.ui;

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

public class PageComponentColumnAPI extends JSONObject implements Serializable
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

	private String privatetypeElementPropertyId;
	public final String getTypeElementPropertyId()
	{
		return privatetypeElementPropertyId;
	}
	public final void setTypeElementPropertyId(String value)
	{
		privatetypeElementPropertyId = value;
	}

	private boolean privateisBound;
	public final boolean getIsBound()
	{
		return privateisBound;
	}
	public final void setIsBound(boolean value)
	{
		privateisBound = value;
	}

	private String privateboundTypeElementPropertyId;
	public final String getBoundTypeElementPropertyId()
	{
		return privateboundTypeElementPropertyId;
	}
	public final void setBoundTypeElementPropertyId(String value)
	{
		privateboundTypeElementPropertyId = value;
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

	private boolean privateisDisplayValue;
	public final boolean getIsDisplayValue()
	{
		return privateisDisplayValue;
	}
	public final void setIsDisplayValue(boolean value)
	{
		privateisDisplayValue = value;
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