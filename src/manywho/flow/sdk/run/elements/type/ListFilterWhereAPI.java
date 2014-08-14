package manywho.flow.sdk.run.elements.type;

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

public class ListFilterWhereAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privatecolumnName;
	public final String getColumnName()
	{
		return privatecolumnName;
	}
	public final void setColumnName(String value)
	{
		privatecolumnName = value;
	}

	private String privatecriteriaType;
	public final String getCriteriaType()
	{
		return privatecriteriaType;
	}
	public final void setCriteriaType(String value)
	{
		privatecriteriaType = value;
	}

	private String privatevalue;
	public final String getValue()
	{
		return privatevalue;
	}
	public final void setValue(String value)
	{
		privatevalue = value;
	}
}