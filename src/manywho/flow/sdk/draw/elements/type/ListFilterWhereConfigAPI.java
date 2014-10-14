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

public class ListFilterWhereConfigAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The column to filter by.
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
	 The criteria of the filter.
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
	 The value to filter by.
	*/
	private ValueElementIdAPI privatevalueElementToReferenceId;
	public final ValueElementIdAPI getValueElementToReferenceId()
	{
		return privatevalueElementToReferenceId;
	}
	public final void setValueElementToReferenceId(ValueElementIdAPI value)
	{
		privatevalueElementToReferenceId = value;
	}
}