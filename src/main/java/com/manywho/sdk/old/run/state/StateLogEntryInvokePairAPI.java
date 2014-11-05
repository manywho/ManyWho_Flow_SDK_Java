package com.manywho.sdk.old.run.state;

import java.io.Serializable;

import org.json.JSONObject;

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

public class StateLogEntryInvokePairAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private EngineInvokeRequestAPI privateengineInvokeRequest;
	public final EngineInvokeRequestAPI getEngineInvokeRequest()
	{
		return privateengineInvokeRequest;
	}
	public final void setEngineInvokeRequest(EngineInvokeRequestAPI value)
	{
		privateengineInvokeRequest = value;
	}

	private EngineInvokeResponseAPI privateengineInvokeResponse;
	public final EngineInvokeResponseAPI getEngineInvokeResponse()
	{
		return privateengineInvokeResponse;
	}
	public final void setEngineInvokeResponse(EngineInvokeResponseAPI value)
	{
		privateengineInvokeResponse = value;
	}

	private String privateorder;
	public final String getOrder()
	{
		return privateorder;
	}
	public final void setOrder(String value)
	{
		privateorder = value;
	}
}