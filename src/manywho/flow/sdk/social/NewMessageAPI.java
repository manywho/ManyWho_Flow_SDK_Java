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

public class NewMessageAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	public NewMessageAPI()
	{
		this.setUploadedFiles(new java.util.ArrayList<FileAPI>());
		this.setMentionedWhos(new java.util.ArrayList<MentionedWhoAPI>());
	}

	private String privatesenderId;
	public final String getSenderId()
	{
		return privatesenderId;
	}
	public final void setSenderId(String value)
	{
		privatesenderId = value;
	}

	private String privatemessageText;
	public final String getMessageText()
	{
		return privatemessageText;
	}
	public final void setMessageText(String value)
	{
		privatemessageText = value;
	}

	private String privaterepliedTo;
	public final String getRepliedTo()
	{
		return privaterepliedTo;
	}
	public final void setRepliedTo(String value)
	{
		privaterepliedTo = value;
	}

	private java.util.ArrayList<FileAPI> privateuploadedFiles;
	public final java.util.ArrayList<FileAPI> getUploadedFiles()
	{
		return privateuploadedFiles;
	}
	public final void setUploadedFiles(java.util.ArrayList<FileAPI> value)
	{
		privateuploadedFiles = value;
	}

	private java.util.ArrayList<MentionedWhoAPI> privatementionedWhos;
	public final java.util.ArrayList<MentionedWhoAPI> getMentionedWhos()
	{
		return privatementionedWhos;
	}
	public final void setMentionedWhos(java.util.ArrayList<MentionedWhoAPI> value)
	{
		privatementionedWhos = value;
	}
}