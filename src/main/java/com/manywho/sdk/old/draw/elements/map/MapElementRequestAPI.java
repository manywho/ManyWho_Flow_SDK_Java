package com.manywho.sdk.old.draw.elements.map;

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

public class MapElementRequestAPI extends MapElementAPI
{
	private static final long serialVersionUID = 1L;

	private String privatepageElementId;
	public final String getPageElementId()
	{
		return privatepageElementId;
	}
	public final void setPageElementId(String value)
	{
		privatepageElementId = value;
	}

	private java.util.ArrayList<OperationAPI> privateoperations;
	public final java.util.ArrayList<OperationAPI> getOperations()
	{
		return privateoperations;
	}
	public final void setOperations(java.util.ArrayList<OperationAPI> value)
	{
		privateoperations = value;
	}

	private MessageActionAPI privateviewMessageAction;
	public final MessageActionAPI getViewMessageAction()
	{
		return privateviewMessageAction;
	}
	public final void setViewMessageAction(MessageActionAPI value)
	{
		privateviewMessageAction = value;
	}

	private java.util.ArrayList<MessageActionAPI> privatemessageActions;
	public final java.util.ArrayList<MessageActionAPI> getMessageActions()
	{
		return privatemessageActions;
	}
	public final void setMessageActions(java.util.ArrayList<MessageActionAPI> value)
	{
		privatemessageActions = value;
	}

	private java.util.ArrayList<DataActionAPI> privatedataActions;
	public final java.util.ArrayList<DataActionAPI> getDataActions()
	{
		return privatedataActions;
	}
	public final void setDataActions(java.util.ArrayList<DataActionAPI> value)
	{
		privatedataActions = value;
	}

	private java.util.ArrayList<NavigationOverrideAPI> privatenavigationOverrides;
	public final java.util.ArrayList<NavigationOverrideAPI> getNavigationOverrides()
	{
		return privatenavigationOverrides;
	}
	public final void setNavigationOverrides(java.util.ArrayList<NavigationOverrideAPI> value)
	{
		privatenavigationOverrides = value;
	}

	private boolean privateclearNavigationOverrides;
	public final boolean getClearNavigationOverrides()
	{
		return privateclearNavigationOverrides;
	}
	public final void setClearNavigationOverrides(boolean value)
	{
		privateclearNavigationOverrides = value;
	}

	private boolean privatepostUpdateToStream;
	public final boolean getPostUpdateToStream()
	{
		return privatepostUpdateToStream;
	}
	public final void setPostUpdateToStream(boolean value)
	{
		privatepostUpdateToStream = value;
	}

	private String privateuserContent;
	public final String getUserContent()
	{
		return privateuserContent;
	}
	public final void setUserContent(String value)
	{
		privateuserContent = value;
	}

	private String privatestatusMessage;
	public final String getStatusMessage()
	{
		return privatestatusMessage;
	}
	public final void setStatusMessage(String value)
	{
		privatestatusMessage = value;
	}

	private String privatepostUpdateMessage;
	public final String getPostUpdateMessage()
	{
		return privatepostUpdateMessage;
	}
	public final void setPostUpdateMessage(String value)
	{
		privatepostUpdateMessage = value;
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

	private String privatepostUpdateWhenType;
	public final String getPostUpdateWhenType()
	{
		return privatepostUpdateWhenType;
	}
	public final void setPostUpdateWhenType(String value)
	{
		privatepostUpdateWhenType = value;
	}

	private boolean privateupdateByName;
	public final boolean getUpdateByName()
	{
		return privateupdateByName;
	}
	public final void setUpdateByName(boolean value)
	{
		privateupdateByName = value;
	}
}