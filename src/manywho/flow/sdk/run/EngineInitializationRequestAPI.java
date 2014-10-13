package manywho.flow.sdk.run;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.draw.flow.*;

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

public class EngineInitializationRequestAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private FlowIdAPI privateflowId;
	public final FlowIdAPI getFlowId()
	{
		return privateflowId;
	}
	public final void setFlowId(FlowIdAPI value)
	{
		privateflowId = value;
	}

	private String privatestateId;
	public final String getStateId()
	{
		return privatestateId;
	}
	public final void setStateId(String value)
	{
		privatestateId = value;
	}

	private String privateparentStateId;
	public final String getParentStateId()
	{
		return privateparentStateId;
	}
	public final void setParentStateId(String value)
	{
		privateparentStateId = value;
	}

	private String privateexternalIdentifier;
	public final String getExternalIdentifier()
	{
		return privateexternalIdentifier;
	}
	public final void setExternalIdentifier(String value)
	{
		privateexternalIdentifier = value;
	}

	private java.util.HashMap<String, String> privateannotations;
	public final java.util.HashMap<String, String> getAnnotations()
	{
		return privateannotations;
	}
	public final void setAnnotations(java.util.HashMap<String, String> value)
	{
		privateannotations = value;
	}

	private java.util.ArrayList<EngineValueAPI> privateinputs;
	public final java.util.ArrayList<EngineValueAPI> getInputs()
	{
		return privateinputs;
	}
	public final void setInputs(java.util.ArrayList<EngineValueAPI> value)
	{
		privateinputs = value;
	}

	private String privateplayerUrl;
	public final String getPlayerUrl()
	{
		return privateplayerUrl;
	}
	public final void setPlayerUrl(String value)
	{
		privateplayerUrl = value;
	}

	private String privatejoinPlayerUrl;
	public final String getJoinPlayerUrl()
	{
		return privatejoinPlayerUrl;
	}
	public final void setJoinPlayerUrl(String value)
	{
		privatejoinPlayerUrl = value;
	}

	private String privatemode;
	public final String getMode()
	{
		return privatemode;
	}
	public final void setMode(String value)
	{
		privatemode = value;
	}

	private String privatereportingMode;
	public final String getReportingMode()
	{
		return privatereportingMode;
	}
	public final void setReportingMode(String value)
	{
		privatereportingMode = value;
	}
}