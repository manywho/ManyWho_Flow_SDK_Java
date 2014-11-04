package com.manywho.sdk.draw.elements.ui;

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

public class NavigationElementRequestAPI extends NavigationElementAPI
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

	private java.util.ArrayList<NavigationItemAPI> privatenavigationItems;
	public final java.util.ArrayList<NavigationItemAPI> getNavigationItems()
	{
		return privatenavigationItems;
	}
	public final void setNavigationItems(java.util.ArrayList<NavigationItemAPI> value)
	{
		privatenavigationItems = value;
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