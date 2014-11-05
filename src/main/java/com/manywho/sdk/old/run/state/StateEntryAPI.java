package com.manywho.sdk.old.run.state;

import java.io.Serializable;

import org.json.JSONObject;

import com.manywho.sdk.old.draw.flow.*;

public class StateEntryAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privateid;
	public final String getId()
	{
		return privateid;
	}
	public final void setId(String value)
	{
		privateid = value;
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

	private String privateflowDeveloperName;
	public final String getFlowDeveloperName()
	{
		return privateflowDeveloperName;
	}
	public final void setFlowDeveloperName(String value)
	{
		privateflowDeveloperName = value;
	}

	private String privatemapElementId;
	public final String getMapElementId()
	{
		return privatemapElementId;
	}
	public final void setMapElementId(String value)
	{
		privatemapElementId = value;
	}

	private String privatemapElementDeveloperName;
	public final String getMapElementDeveloperName()
	{
		return privatemapElementDeveloperName;
	}
	public final void setMapElementDeveloperName(String value)
	{
		privatemapElementDeveloperName = value;
	}

	private java.util.Date privatedateCommitted = new java.util.Date(0);
	public final java.util.Date getDateCommitted()
	{
		return privatedateCommitted;
	}
	public final void setDateCommitted(java.util.Date value)
	{
		privatedateCommitted = value;
	}

	private java.util.ArrayList<StateValueAPI> privatevalues;
	public final java.util.ArrayList<StateValueAPI> getValues()
	{
		return privatevalues;
	}
	public final void setValues(java.util.ArrayList<StateValueAPI> value)
	{
		privatevalues = value;
	}

	private java.util.ArrayList<UserInteractionAPI> privateuserInteractions;
	public final java.util.ArrayList<UserInteractionAPI> getUserInteractions()
	{
		return privateuserInteractions;
	}
	public final void setUserInteractions(java.util.ArrayList<UserInteractionAPI> value)
	{
		privateuserInteractions = value;
	}
}