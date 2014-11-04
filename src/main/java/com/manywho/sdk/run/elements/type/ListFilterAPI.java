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

public class ListFilterAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The identifier of the actual object to filter by - this basically gives an individual result back.
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
	 The comparison type to use when evaluating the wheres.
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
	 Use the list of provided objects as the filter for the lookup.  This allows us to refresh data that can be transient in the remote system.
	*/
	private boolean privatefilterByProvidedObjects;
	public final boolean getFilterByProvidedObjects()
	{
		return privatefilterByProvidedObjects;
	}
	public final void setFilterByProvidedObjects(boolean value)
	{
		privatefilterByProvidedObjects = value;
	}

	/** 
	 The where filter to apply to the list.
	*/
	private java.util.ArrayList<ListFilterWhereAPI> privatewhere;
	public final java.util.ArrayList<ListFilterWhereAPI> getWhere()
	{
		return privatewhere;
	}
	public final void setWhere(java.util.ArrayList<ListFilterWhereAPI> value)
	{
		privatewhere = value;
	}

	/** 
	 The developer name of the column to order by.
	*/
	private String privateorderByPropertyDeveloperName;
	public final String getOrderByPropertyDeveloperName()
	{
		return privateorderByPropertyDeveloperName;
	}
	public final void setOrderByPropertyDeveloperName(String value)
	{
		privateorderByPropertyDeveloperName = value;
	}

	/** 
	 The direction of the ordering.
	*/
	private String privateorderByDirectionType;
	public final String getOrderByDirectionType()
	{
		return privateorderByDirectionType;
	}
	public final void setOrderByDirectionType(String value)
	{
		privateorderByDirectionType = value;
	}

	/** 
	 The number of objects to retrieve in the list.
	*/
	private int privatelimit;
	public final int getLimit()
	{
		return privatelimit;
	}
	public final void setLimit(int value)
	{
		privatelimit = value;
	}

	/** 
	 The number of records to skip past to effectively support paging of the data.
	*/
	private int privateoffset;
	public final int getOffset()
	{
		return privateoffset;
	}
	public final void setOffset(int value)
	{
		privateoffset = value;
	}

	/** 
	 The search string that should be used in addition to any filter criteria.
	*/
	private String privatesearch;
	public final String getSearch()
	{
		return privatesearch;
	}
	public final void setSearch(String value)
	{
		privatesearch = value;
	}
}