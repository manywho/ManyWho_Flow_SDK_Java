package com.manywho.sdk.old.translate;

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

public class CultureAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The id for the culture.
	*/
	private String privateid;
	public final String getId()
	{
		return privateid;
	}
	public final void setId(String value)
	{
		privateid = value;
	}

	/** 
	 The developer name for the culture.
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
	 The developer summary for the culture.
	*/
	private String privatedeveloperSummary;
	public final String getDeveloperSummary()
	{
		return privatedeveloperSummary;
	}
	public final void setDeveloperSummary(String value)
	{
		privatedeveloperSummary = value;
	}

	/** 
	 The brand for the culture.
	*/
	private String privatebrand;
	public final String getBrand()
	{
		return privatebrand;
	}
	public final void setBrand(String value)
	{
		privatebrand = value;
	}

	/** 
	 The language for the culture.
	*/
	private String privatelanguage;
	public final String getLanguage()
	{
		return privatelanguage;
	}
	public final void setLanguage(String value)
	{
		privatelanguage = value;
	}

	/** 
	 The country for the culture.
	*/
	private String privatecountry;
	public final String getCountry()
	{
		return privatecountry;
	}
	public final void setCountry(String value)
	{
		privatecountry = value;
	}

	/** 
	 The variant for the culture.
	*/
	private String privatevariant;
	public final String getVariant()
	{
		return privatevariant;
	}
	public final void setVariant(String value)
	{
		privatevariant = value;
	}
}