package manywho.flow.sdk.run.elements.type;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.run.elements.config.*;
import manywho.flow.sdk.translate.*;
import manywho.flow.sdk.run.*;

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

public class ObjectDataRequestAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The state id that allows us to make the correct version references.
	*/
	private String privatestateId;
	public final String getStateId()
	{
		return privatestateId;
	}
	public final void setStateId(String value)
	{
		privatestateId = value;
	}

	/** 
	 The unique token for this data job.  The token can be used to help the plugin cache multiple data calls.  If the token is provided, we can match it up
	 with a previous data request - if we choose to cache it.
	*/
	private String privatetoken;
	public final String getToken()
	{
		return privatetoken;
	}
	public final void setToken(String value)
	{
		privatetoken = value;
	}

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
	 The authorization information for this element.  The authorization information will be used to validate user queries but can
	 also be used in messages etc, to manage notification.
	*/
	private AuthorizationAPI privateauthorization;
	public final AuthorizationAPI getAuthorization()
	{
		return privateauthorization;
	}
	public final void setAuthorization(AuthorizationAPI value)
	{
		privateauthorization = value;
	}

	/** 
	 The configuration information that comes from the service element.
	*/
	private java.util.ArrayList<EngineValueAPI> privateconfigurationValues;
	public final java.util.ArrayList<EngineValueAPI> getConfigurationValues()
	{
		return privateconfigurationValues;
	}
	public final void setConfigurationValues(java.util.ArrayList<EngineValueAPI> value)
	{
		privateconfigurationValues = value;
	}

	/** 
	 The command to be executed on the remote service.
	*/
	private CommandRequestAPI privatecommand;
	public final CommandRequestAPI getCommand()
	{
		return privatecommand;
	}
	public final void setCommand(CommandRequestAPI value)
	{
		privatecommand = value;
	}

	/** 
	 The culture for the service request.
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
	 The filter to apply to the data at runtime.
	*/
	private ListFilterAPI privatelistFilter;
	public final ListFilterAPI getListFilter()
	{
		return privatelistFilter;
	}
	public final void setListFilter(ListFilterAPI value)
	{
		privatelistFilter = value;
	}

	/** 
	 This gives the data service the descriptor information needed to pull the information together on the server side.  We use
	 a separate object as we may not want to do a full property selection - the contents and tree included in here will give us a
	 full query for the data service.
	*/
	private ObjectDataTypeAPI privateobjectDataType;
	public final ObjectDataTypeAPI getObjectDataType()
	{
		return privateobjectDataType;
	}
	public final void setObjectDataType(ObjectDataTypeAPI value)
	{
		privateobjectDataType = value;
	}

	/** 
	 The list of objects to insert, update or delete.
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
}