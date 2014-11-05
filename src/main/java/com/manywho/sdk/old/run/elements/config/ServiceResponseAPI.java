package com.manywho.sdk.old.run.elements.config;

import java.io.Serializable;

import org.json.JSONObject;

import com.manywho.sdk.old.translate.*;
import com.manywho.sdk.old.run.*;

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

public class ServiceResponseAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The token for this service request.  The token is needed for the service execution manager to identify the correct state.
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
	 The tenant for which the response applies.
	*/
	private String privatetenantId;
	public final String getTenantId()
	{
		return privatetenantId;
	}
	public final void setTenantId(String value)
	{
		privatetenantId = value;
	}

	/** 
	 Tells the engine what this service would like it to do.  At the moment, there are really only
	 two possible commands: WAIT (to tell the engine to wait for a completed response) or DONE (to
	 tell the engine that it has completed its work.
	*/
	private String privateinvokeType;
	public final String getInvokeType()
	{
		return privateinvokeType;
	}
	public final void setInvokeType(String value)
	{
		privateinvokeType = value;
	}

	/** 
	 The wait message to show the user if we're dealing with an asynchronous message.
	*/
	private String privatewaitMessage;
	public final String getWaitMessage()
	{
		return privatewaitMessage;
	}
	public final void setWaitMessage(String value)
	{
		privatewaitMessage = value;
	}

	/** 
	 The outputs from the service response.  The service can return interim output values if we're in
	 a WAIT engine command state.
	*/
	private java.util.ArrayList<EngineValueAPI> privateoutputs;
	public final java.util.ArrayList<EngineValueAPI> getOutputs()
	{
		return privateoutputs;
	}
	public final void setOutputs(java.util.ArrayList<EngineValueAPI> value)
	{
		privateoutputs = value;
	}

	/** 
	 The culture for the response.
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
	 Any general root faults that happened from making the request.
	*/
	private java.util.HashMap<String, String> privaterootFaults;
	public final java.util.HashMap<String, String> getRootFaults()
	{
		return privaterootFaults;
	}
	public final void setRootFaults(java.util.HashMap<String, String> value)
	{
		privaterootFaults = value;
	}

	/** 
	 The faults that occurred with the input values that were provided in the request.
	*/
	private java.util.ArrayList<ValueFaultAPI> privatevalueFaults;
	public final java.util.ArrayList<ValueFaultAPI> getValueFaults()
	{
		return privatevalueFaults;
	}
	public final void setValueFaults(java.util.ArrayList<ValueFaultAPI> value)
	{
		privatevalueFaults = value;
	}

	/** 
	 The debug mode to run the engine in.  For the service response, we do not pass the mode up into the engine as it would make it impossible to step through
	 currently as the user won't have access (though we simply haven't tried it - it might work).
	*/
	private String privatemode;
	public final String getMode()
	{
		return privatemode;
	}
	public final void setMode(String value)
	{
		privatemode = value;
	}

	/** 
	 Passes back any annotations to the service.
	*/
	private java.util.HashMap<String, String> privateannotations;
	public final java.util.HashMap<String, String> getAnnotations()
	{
		return privateannotations;
	}
	public final void setAnnotations(java.util.HashMap<String, String> value)
	{
		privateannotations = value;
	}
}