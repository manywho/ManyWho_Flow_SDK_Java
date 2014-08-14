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

public class MessageListAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	public MessageListAPI()
	{
		setMessages(new java.util.ArrayList<MessageAPI>());
	}

	private java.util.ArrayList<MessageAPI> privatemessages;
	public final java.util.ArrayList<MessageAPI> getMessages()
	{
		return privatemessages;
	}
	public final void setMessages(java.util.ArrayList<MessageAPI> value)
	{
		privatemessages = value;
	}

	private String privatenextPage;
	public final String getNextPage()
	{
		return privatenextPage;
	}
	public final void setNextPage(String value)
	{
		privatenextPage = value;
	}
}