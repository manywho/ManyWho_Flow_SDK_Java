package com.manywho.sdk.old.draw.elements.ui;

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

public class PageElementRequestAPI extends PageElementAPI
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

	private java.util.ArrayList<PageContainerAPI> privatepageContainers;
	public final java.util.ArrayList<PageContainerAPI> getPageContainers()
	{
		return privatepageContainers;
	}
	public final void setPageContainers(java.util.ArrayList<PageContainerAPI> value)
	{
		privatepageContainers = value;
	}

	private java.util.ArrayList<PageComponentAPI> privatepageComponents;
	public final java.util.ArrayList<PageComponentAPI> getPageComponents()
	{
		return privatepageComponents;
	}
	public final void setPageComponents(java.util.ArrayList<PageComponentAPI> value)
	{
		privatepageComponents = value;
	}

	private java.util.ArrayList<PageConditionAPI> privatepageConditions;
	public final java.util.ArrayList<PageConditionAPI> getPageConditions()
	{
		return privatepageConditions;
	}
	public final void setPageConditions(java.util.ArrayList<PageConditionAPI> value)
	{
		privatepageConditions = value;
	}

	private boolean privatestopConditionsOnFirstTrue;
	public final boolean getStopConditionsOnFirstTrue()
	{
		return privatestopConditionsOnFirstTrue;
	}
	public final void setStopConditionsOnFirstTrue(boolean value)
	{
		privatestopConditionsOnFirstTrue = value;
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

	private java.util.ArrayList<PageTagAPI> privatetags;
	public final java.util.ArrayList<PageTagAPI> getTags()
	{
		return privatetags;
	}
	public final void setTags(java.util.ArrayList<PageTagAPI> value)
	{
		privatetags = value;
	}

	private boolean privateupdateByName;
	public final boolean getUpdateByName()
	{
		return privateupdateByName;
	}
	public final void setUpdateByName(boolean value)
	{
		privateupdateByName = value;
	}
}