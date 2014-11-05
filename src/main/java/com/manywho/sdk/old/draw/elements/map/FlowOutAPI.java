package com.manywho.sdk.old.draw.elements.map;

import java.io.Serializable;

import org.json.JSONObject;

import com.manywho.sdk.old.draw.flow.*;
import com.manywho.sdk.old.draw.elements.value.*;

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

public class FlowOutAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private ValueElementIdAPI privatevalueElementStateId;
	public final ValueElementIdAPI getValueElementStateId()
	{
		return privatevalueElementStateId;
	}
	public final void setValueElementStateId(ValueElementIdAPI value)
	{
		privatevalueElementStateId = value;
	}

	private FlowIdAPI privateflowId;
	public final FlowIdAPI getFlowId()
	{
		return privateflowId;
	}
	public final void setFlowId(FlowIdAPI value)
	{
		privateflowId = value;
	}

	private ValueElementIdAPI privatevalueElementExternalIdentifierId;
	public final ValueElementIdAPI getValueElementExternalIdentifierId()
	{
		return privatevalueElementExternalIdentifierId;
	}
	public final void setValueElementExternalIdentifierId(ValueElementIdAPI value)
	{
		privatevalueElementExternalIdentifierId = value;
	}
}