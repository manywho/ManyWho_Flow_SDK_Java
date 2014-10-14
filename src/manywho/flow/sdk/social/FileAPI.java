package manywho.flow.sdk.social;

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

public class FileAPI extends JSONObject implements Serializable
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

	private String privatename;
	public final String getName()
	{
		return privatename;
	}
	public final void setName(String value)
	{
		privatename = value;
	}

	private long privatesize;
	public final long getSize()
	{
		return privatesize;
	}
	public final void setSize(long value)
	{
		privatesize = value;
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

	private String privateurl;
	public final String getUrl()
	{
		return privateurl;
	}
	public final void setUrl(String value)
	{
		privateurl = value;
	}

	private String privatedelete_url;
	public final String getDelete_url()
	{
		return privatedelete_url;
	}
	public final void setDelete_url(String value)
	{
		privatedelete_url = value;
	}

	private String privatethumbnail_url;
	public final String getThumbnail_url()
	{
		return privatethumbnail_url;
	}
	public final void setThumbnail_url(String value)
	{
		privatethumbnail_url = value;
	}

	private String privatedelete_type;
	public final String getDelete_type()
	{
		return privatedelete_type;
	}
	public final void setDelete_type(String value)
	{
		privatedelete_type = value;
	}
}