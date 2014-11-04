package com.manywho.sdk.social;

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

public class AttachmentAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privatename;
	public final String getName()
	{
		return privatename;
	}
	public final void setName(String value)
	{
		privatename = value;
	}

	private String privateiconUrl;
	public final String getIconUrl()
	{
		return privateiconUrl;
	}
	public final void setIconUrl(String value)
	{
		privateiconUrl = value;
	}

	private String privatedownloadUrl;
	public final String getDownloadUrl()
	{
		return privatedownloadUrl;
	}
	public final void setDownloadUrl(String value)
	{
		privatedownloadUrl = value;
	}

	private String privatesize;
	public final String getSize()
	{
		return privatesize;
	}
	public final void setSize(String value)
	{
		privatesize = value;
	}

	private String privatedescription;
	public final String getDescription()
	{
		return privatedescription;
	}
	public final void setDescription(String value)
	{
		privatedescription = value;
	}

	private String privatetype;
	public final String getType()
	{
		return privatetype;
	}
	public final void setType(String value)
	{
		privatetype = value;
	}
}