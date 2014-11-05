package com.manywho.sdk.old.draw.elements.ui;

import java.io.Serializable;

import org.json.JSONObject;

import com.manywho.sdk.old.draw.elements.type.*;

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

public class PageOperationFilterAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 This is the reference field to apply the filter information contained in this action.
	*/
	private String privatepageComponentId;
	public final String getPageComponentId()
	{
		return privatepageComponentId;
	}
	public final void setPageComponentId(String value)
	{
		privatepageComponentId = value;
	}

	/** 
	 A temporary reference to the field on which to apply this filter configuration.
	*/
	private String privatepageComponentDeveloperName;
	public final String getPageComponentDeveloperName()
	{
		return privatepageComponentDeveloperName;
	}
	public final void setPageComponentDeveloperName(String value)
	{
		privatepageComponentDeveloperName = value;
	}

	/** 
	 This is the type element entry for the column field to do the filtering on.
	*/
	private String privatecolumnTypeElementPropertyId;
	public final String getColumnTypeElementPropertyId()
	{
		return privatecolumnTypeElementPropertyId;
	}
	public final void setColumnTypeElementPropertyId(String value)
	{
		privatecolumnTypeElementPropertyId = value;
	}

	/** 
	 The criteria for the filter to apply to the column.
	*/
	private String privatecriteriaType;
	public final String getCriteriaType()
	{
		return privatecriteriaType;
	}
	public final void setCriteriaType(String value)
	{
		privatecriteriaType = value;
	}

	/** 
	 The value to reference when performing the filter.
	*/
	private PageObjectReferenceAPI privatefilterValue;
	public final PageObjectReferenceAPI getFilterValue()
	{
		return privatefilterValue;
	}
	public final void setFilterValue(PageObjectReferenceAPI value)
	{
		privatefilterValue = value;
	}

	/** 
	 This object will not be null if we want to apply a different object data request to the field in question.  This allows us
	 to do more complex data querying than that provided by the "in-UI" Filter object above.  You cannot use the filter above
	 with the object data request - it's basically either or.
	*/
	private ObjectDataRequestConfigAPI privateobjectDataRequest;
	public final ObjectDataRequestConfigAPI getObjectDataRequest()
	{
		return privateobjectDataRequest;
	}
	public final void setObjectDataRequest(ObjectDataRequestConfigAPI value)
	{
		privateobjectDataRequest = value;
	}
}