package manywho.flow.sdk.run.elements.type;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.translate.*;

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

public class ObjectDataResponseAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The culture for the service response.
	*/
	private CultureAPI privateculture;
	public final CultureAPI getCulture()
	{
		return privateculture;
	}
	public final void setCulture(CultureAPI value)
	{
		privateculture = value;
	}

	/** 
	 The list of objects post select, insert, update, delete
	*/
	private java.util.ArrayList<ObjectAPI> privateobjectData;
	public final java.util.ArrayList<ObjectAPI> getObjectData()
	{
		return privateobjectData;
	}
	public final void setObjectData(java.util.ArrayList<ObjectAPI> value)
	{
		privateobjectData = value;
	}

	/** 
	 Indicates if there are more results available based on the offset and limit provided
	*/
	private boolean privatehasMoreResults;
	public final boolean getHasMoreResults()
	{
		return privatehasMoreResults;
	}
	public final void setHasMoreResults(boolean value)
	{
		privatehasMoreResults = value;
	}
}