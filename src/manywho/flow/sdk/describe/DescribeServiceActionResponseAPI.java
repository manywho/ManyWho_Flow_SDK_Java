package manywho.flow.sdk.describe;

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

public class DescribeServiceActionResponseAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The part of the Uri that will allow us to call this action as part of the service.  For example,
	 if you specify "myaction", the full Uri for the service would be "https://myservice.com/myservice/myaction".
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
	 The label for this action.
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

	/** 
	 The developer summary for the service operation.
	*/
	private String privatedeveloperSummary;
	public final String getDeveloperSummary()
	{
		return privatedeveloperSummary;
	}
	public final void setDeveloperSummary(String value)
	{
		privatedeveloperSummary = value;
	}

	/** 
	 For UI actions, this property provides the bindable outcomes so the author can wire buttons to steps in the flow.
	*/
	private java.util.ArrayList<DescribeUIServiceActionOutcomeAPI> privateserviceActionOutcomes;
	public final java.util.ArrayList<DescribeUIServiceActionOutcomeAPI> getServiceActionOutcomes()
	{
		return privateserviceActionOutcomes;
	}
	public final void setServiceActionOutcomes(java.util.ArrayList<DescribeUIServiceActionOutcomeAPI> value)
	{
		privateserviceActionOutcomes = value;
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

	/** 
	 Indicates if this message action is for views rather than logic.
	*/
	private boolean privateisViewMessageAction;
	public final boolean getIsViewMessageAction()
	{
		return privateisViewMessageAction;
	}
	public final void setIsViewMessageAction(boolean value)
	{
		privateisViewMessageAction = value;
	}
}