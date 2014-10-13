package manywho.flow.sdk.run;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.run.state.*;
import manywho.flow.sdk.run.elements.ui.*;
import manywho.flow.sdk.run.elements.map.*;
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

public class EngineInvokeResponseAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private CultureAPI privateculture;
	public final CultureAPI getCulture()
	{
		return privateculture;
	}
	public final void setCulture(CultureAPI value)
	{
		privateculture = value;
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

	private String privatestateToken;
	public final String getStateToken()
	{
		return privatestateToken;
	}
	public final void setStateToken(String value)
	{
		privatestateToken = value;
	}

	private String privatealertEmail;
	public final String getAlertEmail()
	{
		return privatealertEmail;
	}
	public final void setAlertEmail(String value)
	{
		privatealertEmail = value;
	}

	private String privatewaitMessage;
	public final String getWaitMessage()
	{
		return privatewaitMessage;
	}
	public final void setWaitMessage(String value)
	{
		privatewaitMessage = value;
	}

	private String privatenotAuthorizedMessage;
	public final String getNotAuthorizedMessage()
	{
		return privatenotAuthorizedMessage;
	}
	public final void setNotAuthorizedMessage(String value)
	{
		privatenotAuthorizedMessage = value;
	}

	private String privatecurrentMapElementId;
	public final String getCurrentMapElementId()
	{
		return privatecurrentMapElementId;
	}
	public final void setCurrentMapElementId(String value)
	{
		privatecurrentMapElementId = value;
	}

	private String privatecurrentStreamId;
	public final String getCurrentStreamId()
	{
		return privatecurrentStreamId;
	}
	public final void setCurrentStreamId(String value)
	{
		privatecurrentStreamId = value;
	}

	private String privateinvokeType;
	public final String getInvokeType()
	{
		return privateinvokeType;
	}
	public final void setInvokeType(String value)
	{
		privateinvokeType = value;
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

	private java.util.ArrayList<MapElementInvokeResponseAPI> privatemapElementInvokeResponses;
	public final java.util.ArrayList<MapElementInvokeResponseAPI> getMapElementInvokeResponses()
	{
		return privatemapElementInvokeResponses;
	}
	public final void setMapElementInvokeResponses(java.util.ArrayList<MapElementInvokeResponseAPI> value)
	{
		privatemapElementInvokeResponses = value;
	}

	private StateLogAPI privatestateLog;
	public final StateLogAPI getStateLog()
	{
		return privatestateLog;
	}
	public final void setStateLog(StateLogAPI value)
	{
		privatestateLog = value;
	}

	private java.util.ArrayList<EngineValueAPI> privatepreCommitStateValues;
	public final java.util.ArrayList<EngineValueAPI> getPreCommitStateValues()
	{
		return privatepreCommitStateValues;
	}
	public final void setPreCommitStateValues(java.util.ArrayList<EngineValueAPI> value)
	{
		privatepreCommitStateValues = value;
	}

	private java.util.ArrayList<EngineValueAPI> privatestateValues;
	public final java.util.ArrayList<EngineValueAPI> getStateValues()
	{
		return privatestateValues;
	}
	public final void setStateValues(java.util.ArrayList<EngineValueAPI> value)
	{
		privatestateValues = value;
	}

	private java.util.ArrayList<EngineValueAPI> privateoutputs;
	public final java.util.ArrayList<EngineValueAPI> getOutputs()
	{
		return privateoutputs;
	}
	public final void setOutputs(java.util.ArrayList<EngineValueAPI> value)
	{
		privateoutputs = value;
	}

	private String privatestatusCode;
	public final String getStatusCode()
	{
		return privatestatusCode;
	}
	public final void setStatusCode(String value)
	{
		privatestatusCode = value;
	}

	private String privaterunFlowUri;
	public final String getRunFlowUri()
	{
		return privaterunFlowUri;
	}
	public final void setRunFlowUri(String value)
	{
		privaterunFlowUri = value;
	}

	private String privatejoinFlowUri;
	public final String getJoinFlowUri()
	{
		return privatejoinFlowUri;
	}
	public final void setJoinFlowUri(String value)
	{
		privatejoinFlowUri = value;
	}

	private EngineAuthorizationContextAPI privateauthorizationContext;
	public final EngineAuthorizationContextAPI getAuthorizationContext()
	{
		return privateauthorizationContext;
	}
	public final void setAuthorizationContext(EngineAuthorizationContextAPI value)
	{
		privateauthorizationContext = value;
	}

	private java.util.ArrayList<NavigationElementReferenceAPI> privatenavigationElementReferences;
	public final java.util.ArrayList<NavigationElementReferenceAPI> getNavigationElementReferences()
	{
		return privatenavigationElementReferences;
	}
	public final void setNavigationElementReferences(java.util.ArrayList<NavigationElementReferenceAPI> value)
	{
		privatenavigationElementReferences = value;
	}
}