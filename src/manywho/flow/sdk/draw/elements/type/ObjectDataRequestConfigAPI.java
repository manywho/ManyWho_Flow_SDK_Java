package manywho.flow.sdk.draw.elements.type;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.draw.content.*;

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
 This object stores the configuration information we need to make object data requests as part of a map element request or
 as part of a form field.
*/
public class ObjectDataRequestConfigAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The Id for the service element associated with this object data.  The service element will give us the connection setTings
	 and allow us to validate various info around the type.
	*/
	private String privatetypeElementBindingId;
	public final String getTypeElementBindingId()
	{
		return privatetypeElementBindingId;
	}
	public final void setTypeElementBindingId(String value)
	{
		privatetypeElementBindingId = value;
	}

	/** 
	 This will give us all of the object and field data we need to successfully make a request against the specified type.  We will
	 pass the type properties etc so the called service can optimize around exactly what the user is asking for.
	*/
	private String privatetypeElementId;
	public final String getTypeElementId()
	{
		return privatetypeElementId;
	}
	public final void setTypeElementId(String value)
	{
		privatetypeElementId = value;
	}

	/** 
	 The filter to apply to the data at runtime.
	*/
	private ListFilterConfigAPI privatelistFilter;
	public final ListFilterConfigAPI getListFilter()
	{
		return privatelistFilter;
	}
	public final void setListFilter(ListFilterConfigAPI value)
	{
		privatelistFilter = value;
	}

	/** 
	 Any additional attributes to help with the object data request.
	*/
	private CommandAPI privatecommand;
	public final CommandAPI getCommand()
	{
		return privatecommand;
	}
	public final void setCommand(CommandAPI value)
	{
		privatecommand = value;
	}
}