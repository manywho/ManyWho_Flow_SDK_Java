package manywho.flow.sdk.draw.elements.ui;

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

public class PageConditionAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private java.util.ArrayList<PageRuleAPI> privatepageRules;
	public final java.util.ArrayList<PageRuleAPI> getPageRules()
	{
		return privatepageRules;
	}
	public final void setPageRules(java.util.ArrayList<PageRuleAPI> value)
	{
		privatepageRules = value;
	}

	/** 
	 The rules that must evaluate to "true" for this condition to fire the associated actions.
	*/
	private String privatecomparisonType;
	public final String getComparisonType()
	{
		return privatecomparisonType;
	}
	public final void setComparisonType(String value)
	{
		privatecomparisonType = value;
	}

	/** 
	 These are the actions to be performed based on the above rules evaluating to true.  We do not need to bind a specific field
	 to events as we consider all fields as event generating in the UI by default.  If we want to do smart optimization, we need
	 to look at each of the rules and derive which fields to bind events from that - we don't explicitly give a list.
	*/
	private java.util.ArrayList<PageOperationAPI> privatepageOperations;
	public final java.util.ArrayList<PageOperationAPI> getPageOperations()
	{
		return privatepageOperations;
	}
	public final void setPageOperations(java.util.ArrayList<PageOperationAPI> value)
	{
		privatepageOperations = value;
	}
}