package com.manywho.sdk.old.draw.elements.value;

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

public class ValueElementIdAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	public ValueElementIdAPI()
	{

	}

	public ValueElementIdAPI(String id, String typeElementPropertyId, String command)
	{
		this.setId(id);
		this.setTypeElementPropertyId(typeElementPropertyId);
		this.setCommand(command);
	}

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

	private String privatecommand;
	public final String getCommand()
	{
		return privatecommand;
	}
	public final void setCommand(String value)
	{
		privatecommand = value;
	}
}