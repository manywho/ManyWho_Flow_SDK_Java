package manywho.flow.sdk.draw.elements.type;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.draw.elements.value.*;

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

public class ListFilterConfigAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The identifier of the actual object to filter by - this basically gives an individual result back.
	*/
	private ValueElementIdAPI privatefilterId;
	public final ValueElementIdAPI getFilterId()
	{
		return privatefilterId;
	}
	public final void setFilterId(ValueElementIdAPI value)
	{
		privatefilterId = value;
	}

	/** 
	 The comparison when evaluating the 'where' entries.  This is either "AND" or "OR" and we do not support nesting (just yet anyway).
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
	 The where filter to apply to the list.
	*/
	private java.util.ArrayList<ListFilterWhereConfigAPI> privatewhere;
	public final java.util.ArrayList<ListFilterWhereConfigAPI> getWhere()
	{
		return privatewhere;
	}
	public final void setWhere(java.util.ArrayList<ListFilterWhereConfigAPI> value)
	{
		privatewhere = value;
	}

	/** 
	 The type element entry id of the column to order by.
	*/
	private String privateorderByTypeElementPropertyId;
	public final String getOrderByTypeElementPropertyId()
	{
		return privateorderByTypeElementPropertyId;
	}
	public final void setOrderByTypeElementPropertyId(String value)
	{
		privateorderByTypeElementPropertyId = value;
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
}