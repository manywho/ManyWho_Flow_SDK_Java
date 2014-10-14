package manywho.flow.sdk.describe;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.run.*;
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

public class DescribeServiceRequestAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

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
	 The Uri for the service to describe.
	*/
	private String privateuri;
	public final String getUri()
	{
		return privateuri;
	}
	public final void setUri(String value)
	{
		privateuri = value;
	}

	/** 
	 Configuration values provided by the end user to help the describe.
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
}