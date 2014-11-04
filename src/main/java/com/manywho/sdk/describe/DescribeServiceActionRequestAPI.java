package com.manywho.sdk.describe;

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

public class DescribeServiceActionRequestAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 
	 The Uri part to identify the action this data pertains to.
	*/
	private String privateuriPart;
	public final String getUriPart()
	{
		return privateuriPart;
	}
	public final void setUriPart(String value)
	{
		privateuriPart = value;
	}

	/** 
	 The service inputs that need to be provided.
	*/
	private java.util.ArrayList<DescribeValueAPI> privateserviceInputs;
	public final java.util.ArrayList<DescribeValueAPI> getServiceInputs()
	{
		return privateserviceInputs;
	}
	public final void setServiceInputs(java.util.ArrayList<DescribeValueAPI> value)
	{
		privateserviceInputs = value;
	}

	/** 
	 The service outputs that will be provided back.
	*/
	private java.util.ArrayList<DescribeValueAPI> privateserviceOutputs;
	public final java.util.ArrayList<DescribeValueAPI> getServiceOutputs()
	{
		return privateserviceOutputs;
	}
	public final void setServiceOutputs(java.util.ArrayList<DescribeValueAPI> value)
	{
		privateserviceOutputs = value;
	}
}