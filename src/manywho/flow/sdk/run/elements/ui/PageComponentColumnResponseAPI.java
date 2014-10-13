package manywho.flow.sdk.run.elements.ui;

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

/** 
 This acts as the column descriptor for rendering the table content stored in the content property (as part of the parent
 field definition).
*/
public class PageComponentColumnResponseAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 This is the developer name of the type element entry.
	*/
	private String privatedeveloperName;
	public final String getDeveloperName()
	{
		return privatedeveloperName;
	}
	public final void setDeveloperName(String value)
	{
		privatedeveloperName = value;
	}

	private String privatetypeElementPropertyId;
	public final String getTypeElementPropertyId()
	{
		return privatetypeElementPropertyId;
	}
	public final void setTypeElementPropertyId(String value)
	{
		privatetypeElementPropertyId = value;
	}

	private String privatelabel;
	public final String getLabel()
	{
		return privatelabel;
	}
	public final void setLabel(String value)
	{
		privatelabel = value;
	}

	private boolean privateisDisplayValue;
	public final boolean getIsDisplayValue()
	{
		return privateisDisplayValue;
	}
	public final void setIsDisplayValue(boolean value)
	{
		privateisDisplayValue = value;
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