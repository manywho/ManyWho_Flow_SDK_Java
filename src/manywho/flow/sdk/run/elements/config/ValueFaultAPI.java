package manywho.flow.sdk.run.elements.config;

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

public class ValueFaultAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The reference id of the value with the fault.
	*/
	private String privatevalueElementToReferenceId;
	public final String getValueElementToReferenceId()
	{
		return privatevalueElementToReferenceId;
	}
	public final void setValueElementToReferenceId(String value)
	{
		privatevalueElementToReferenceId = value;
	}

	/** 
	 The reference type element entry id of the value with the fault.
	*/
	private String privatevalueElementTypeElementPropertyToReferenceId;
	public final String getValueElementTypeElementPropertyToReferenceId()
	{
		return privatevalueElementTypeElementPropertyToReferenceId;
	}
	public final void setValueElementTypeElementPropertyToReferenceId(String value)
	{
		privatevalueElementTypeElementPropertyToReferenceId = value;
	}

	/** 
	 The fault code to send back to the engine.
	*/
	private String privatefaultCode;
	public final String getFaultCode()
	{
		return privatefaultCode;
	}
	public final void setFaultCode(String value)
	{
		privatefaultCode = value;
	}

	/** 
	 The fault message to send back to the engine.
	*/
	private String privatefaultMessage;
	public final String getFaultMessage()
	{
		return privatefaultMessage;
	}
	public final void setFaultMessage(String value)
	{
		privatefaultMessage = value;
	}
}