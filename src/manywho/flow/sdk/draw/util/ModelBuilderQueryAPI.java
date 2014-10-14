package manywho.flow.sdk.draw.util;

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

public class ModelBuilderQueryAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privatesearch;
	public final String getSearch()
	{
		return privatesearch;
	}
	public final void setSearch(String value)
	{
		privatesearch = value;
	}

	private String privatecomparisionType;
	public final String getComparisionType()
	{
		return privatecomparisionType;
	}
	public final void setComparisionType(String value)
	{
		privatecomparisionType = value;
	}

	private java.util.ArrayList<ModelBuilderQueryWhereAPI> privatewhere;
	public final java.util.ArrayList<ModelBuilderQueryWhereAPI> getWhere()
	{
		return privatewhere;
	}
	public final void setWhere(java.util.ArrayList<ModelBuilderQueryWhereAPI> value)
	{
		privatewhere = value;
	}

	private int privatelimit;
	public final int getLimit()
	{
		return privatelimit;
	}
	public final void setLimit(int value)
	{
		privatelimit = value;
	}

	private int privatesize;
	public final int getSize()
	{
		return privatesize;
	}
	public final void setSize(int value)
	{
		privatesize = value;
	}

	private String privateorderBy;
	public final String getOrderBy()
	{
		return privateorderBy;
	}
	public final void setOrderBy(String value)
	{
		privateorderBy = value;
	}

	private String privateorderDirection;
	public final String getOrderDirection()
	{
		return privateorderDirection;
	}
	public final void setOrderDirection(String value)
	{
		privateorderDirection = value;
	}

	private String privateflowId;
	public final String getFlowId()
	{
		return privateflowId;
	}
	public final void setFlowId(String value)
	{
		privateflowId = value;
	}

	private boolean privateisSnapShot;
	public final boolean getIsSnapShot()
	{
		return privateisSnapShot;
	}
	public final void setIsSnapShot(boolean value)
	{
		privateisSnapShot = value;
	}
}