package com.manywho.sdk.draw.flow;

import com.manywho.sdk.security.*;

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

public class FlowResponseAPI extends FlowRequestAPI
{
	private static final long serialVersionUID = 1L;

	private java.util.Date privatedateCreated = new java.util.Date(0);
	public final java.util.Date getDateCreated()
	{
		return privatedateCreated;
	}
	public final void setDateCreated(java.util.Date value)
	{
		privatedateCreated = value;
	}

	private java.util.Date privatedateModified = new java.util.Date(0);
	public final java.util.Date getDateModified()
	{
		return privatedateModified;
	}
	public final void setDateModified(java.util.Date value)
	{
		privatedateModified = value;
	}

	private BuilderWhoAPI privatewhoCreated;
	public final BuilderWhoAPI getWhoCreated()
	{
		return privatewhoCreated;
	}
	public final void setWhoCreated(BuilderWhoAPI value)
	{
		privatewhoCreated = value;
	}

	private BuilderWhoAPI privatewhoModified;
	public final BuilderWhoAPI getWhoModified()
	{
		return privatewhoModified;
	}
	public final void setWhoModified(BuilderWhoAPI value)
	{
		privatewhoModified = value;
	}

	private BuilderWhoAPI privatewhoOwner;
	public final BuilderWhoAPI getWhoOwner()
	{
		return privatewhoOwner;
	}
	public final void setWhoOwner(BuilderWhoAPI value)
	{
		privatewhoOwner = value;
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

	private boolean privateisActive;
	public final boolean getIsActive()
	{
		return privateisActive;
	}
	public final void setIsActive(boolean value)
	{
		privateisActive = value;
	}

	private boolean privateisDefault;
	public final boolean getIsDefault()
	{
		return privateisDefault;
	}
	public final void setIsDefault(boolean value)
	{
		privateisDefault = value;
	}
}