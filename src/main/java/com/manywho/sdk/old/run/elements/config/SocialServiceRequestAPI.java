package com.manywho.sdk.old.run.elements.config;

import com.manywho.sdk.old.social.*;

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

public class SocialServiceRequestAPI extends ServiceRequestAPI
{
	private static final long serialVersionUID = 1L;

	private NewMessageAPI privatenewMessage;
	public final NewMessageAPI getNewMessage()
	{
		return privatenewMessage;
	}
	public final void setNewMessage(NewMessageAPI value)
	{
		privatenewMessage = value;
	}

	private String privatepage;
	public final String getPage()
	{
		return privatepage;
	}
	public final void setPage(String value)
	{
		privatepage = value;
	}

	private int privatepageSize;
	public final int getPageSize()
	{
		return privatepageSize;
	}
	public final void setPageSize(int value)
	{
		privatepageSize = value;
	}

	private AttachmentAPI privateattachment;
	public final AttachmentAPI getAttachment()
	{
		return privateattachment;
	}
	public final void setAttachment(AttachmentAPI value)
	{
		privateattachment = value;
	}
}