package com.manywho.sdk.run.elements.type;

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

public class ObjectDataTypeAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privatetypeElementId;
	public final String getTypeElementId()
	{
		return privatetypeElementId;
	}
	public final void setTypeElementId(String value)
	{
		privatetypeElementId = value;
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

	private java.util.ArrayList<ObjectDataTypePropertyAPI> privateproperties;
	public final java.util.ArrayList<ObjectDataTypePropertyAPI> getProperties()
	{
		return privateproperties;
	}
	public final void setProperties(java.util.ArrayList<ObjectDataTypePropertyAPI> value)
	{
		privateproperties = value;
	}
}