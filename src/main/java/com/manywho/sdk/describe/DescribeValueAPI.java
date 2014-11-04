package com.manywho.sdk.describe;

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

public class DescribeValueAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The developer name for the value.
	*/
	private String privatedeveloperName;
	public final String getDeveloperName()
	{
		return privatedeveloperName;
	}
	public final void setDeveloperName(String value)
	{
		privatedeveloperName = value;
	}

	/** 
	 The content for this value.
	*/
	private String privatecontentValue;
	public final String getContentValue()
	{
		return privatecontentValue;
	}
	public final void setContentValue(String value)
	{
		privatecontentValue = value;
	}

	/** 
	 Indicates if the value is required.
	*/
	private boolean privateisRequired;
	public final boolean getIsRequired()
	{
		return privateisRequired;
	}
	public final void setIsRequired(boolean value)
	{
		privateisRequired = value;
	}

	/** 
	 The content type for the value.
	*/
	private String privatecontentType;
	public final String getContentType()
	{
		return privatecontentType;
	}
	public final void setContentType(String value)
	{
		privatecontentType = value;
	}

	/** 
	 This allows the describe value to reference supported types.
	*/
	private String privatetypeElementDeveloperName;
	public final String getTypeElementDeveloperName()
	{
		return privatetypeElementDeveloperName;
	}
	public final void setTypeElementDeveloperName(String value)
	{
		privatetypeElementDeveloperName = value;
	}
}