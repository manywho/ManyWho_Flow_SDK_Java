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

public class MessageAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	public MessageAPI()
	{
		this.setAttachments(new java.util.ArrayList<AttachmentAPI>());
		this.setComments(new java.util.ArrayList<MessageAPI>());
		this.setLikerIds(new java.util.ArrayList<String>());
	}

	private String privateid;
	public final String getId()
	{
		return privateid;
	}
	public final void setId(String value)
	{
		privateid = value;
	}

	private String privaterepliedToId;
	public final String getRepliedToId()
	{
		return privaterepliedToId;
	}
	public final void setRepliedToId(String value)
	{
		privaterepliedToId = value;
	}

	private String privatetext;
	public final String getText()
	{
		return privatetext;
	}
	public final void setText(String value)
	{
		privatetext = value;
	}

	private java.util.Date privatecreatedDate = new java.util.Date(0);
	public final java.util.Date getCreatedDate()
	{
		return privatecreatedDate;
	}
	public final void setCreatedDate(java.util.Date value)
	{
		privatecreatedDate = value;
	}

	private WhoAPI privatesender;
	public final WhoAPI getSender()
	{
		return privatesender;
	}
	public final void setSender(WhoAPI value)
	{
		privatesender = value;
	}

	private java.util.ArrayList<AttachmentAPI> privateattachments;
	public final java.util.ArrayList<AttachmentAPI> getAttachments()
	{
		return privateattachments;
	}
	public final void setAttachments(java.util.ArrayList<AttachmentAPI> value)
	{
		privateattachments = value;
	}

	private java.util.ArrayList<MessageAPI> privatecomments;
	public final java.util.ArrayList<MessageAPI> getComments()
	{
		return privatecomments;
	}
	public final void setComments(java.util.ArrayList<MessageAPI> value)
	{
		privatecomments = value;
	}

	private java.util.ArrayList<String> privatelikerIds;
	public final java.util.ArrayList<String> getLikerIds()
	{
		return privatelikerIds;
	}
	public final void setLikerIds(java.util.ArrayList<String> value)
	{
		privatelikerIds = value;
	}

	/** 
	 This property is not sent back to the caller
	*/
	private String privatemyLikeId;
	public final String getMyLikeId()
	{
		return privatemyLikeId;
	}
	public final void setMyLikeId(String value)
	{
		privatemyLikeId = value;
	}

	private int privatecommentsCount;
	public final int getCommentsCount()
	{
		return privatecommentsCount;
	}
	public final void setCommentsCount(int value)
	{
		privatecommentsCount = value;
	}
}