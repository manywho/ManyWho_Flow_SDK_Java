package com.manywho.sdk.draw.elements.map;

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

public class ComparisonAPI extends JSONObject implements Serializable
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

	private String privatecomparisonType;
	public final String getComparisonType()
	{
		return privatecomparisonType;
	}
	public final void setComparisonType(String value)
	{
		privatecomparisonType = value;
	}

	private java.util.ArrayList<RuleAPI> privaterules;
	public final java.util.ArrayList<RuleAPI> getRules()
	{
		return privaterules;
	}
	public final void setRules(java.util.ArrayList<RuleAPI> value)
	{
		privaterules = value;
	}

	private java.util.ArrayList<ComparisonAPI> privatecomparisons;
	public final java.util.ArrayList<ComparisonAPI> getComparisons()
	{
		return privatecomparisons;
	}
	public final void setComparisons(java.util.ArrayList<ComparisonAPI> value)
	{
		privatecomparisons = value;
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