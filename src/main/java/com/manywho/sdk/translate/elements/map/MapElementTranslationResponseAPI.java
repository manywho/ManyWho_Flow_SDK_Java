package com.manywho.sdk.translate.elements.map;

import com.manywho.sdk.translate.elements.*;

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

public class MapElementTranslationResponseAPI extends ElementTranslationResponseAPI
{
	private static final long serialVersionUID = 1L;

	private String privateuserContentContentValueId;
	public final String getUserContentContentValueId()
	{
		return privateuserContentContentValueId;
	}
	public final void setUserContentContentValueId(String value)
	{
		privateuserContentContentValueId = value;
	}

	private String privatestatusMessageContentValueId;
	public final String getStatusMessageContentValueId()
	{
		return privatestatusMessageContentValueId;
	}
	public final void setStatusMessageContentValueId(String value)
	{
		privatestatusMessageContentValueId = value;
	}

	private String privatepostUpdateMessageContentValueId;
	public final String getPostUpdateMessageContentValueId()
	{
		return privatepostUpdateMessageContentValueId;
	}
	public final void setPostUpdateMessageContentValueId(String value)
	{
		privatepostUpdateMessageContentValueId = value;
	}

	private String privatenotAuthorizedMessageContentValueId;
	public final String getNotAuthorizedMessageContentValueId()
	{
		return privatenotAuthorizedMessageContentValueId;
	}
	public final void setNotAuthorizedMessageContentValueId(String value)
	{
		privatenotAuthorizedMessageContentValueId = value;
	}

	private java.util.ArrayList<OutcomeTranslationResponseAPI> privateoutcomes;
	public final java.util.ArrayList<OutcomeTranslationResponseAPI> getOutcomes()
	{
		return privateoutcomes;
	}
	public final void setOutcomes(java.util.ArrayList<OutcomeTranslationResponseAPI> value)
	{
		privateoutcomes = value;
	}
}