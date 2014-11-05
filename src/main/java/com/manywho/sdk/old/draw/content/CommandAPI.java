package com.manywho.sdk.old.draw.content;

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

public class CommandAPI extends JSONObject implements Serializable
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

	private String privatecommandType;
	public final String getCommandType()
	{
		return privatecommandType;
	}
	public final void setCommandType(String value)
	{
		privatecommandType = value;
	}

	private java.util.HashMap<String, String> privateproperties;
	public final java.util.HashMap<String, String> getProperties()
	{
		return privateproperties;
	}
	public final void setProperties(java.util.HashMap<String, String> value)
	{
		privateproperties = value;
	}
}