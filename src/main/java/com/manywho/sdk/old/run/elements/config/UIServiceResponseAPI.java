package com.manywho.sdk.old.run.elements.config;

import com.manywho.sdk.old.run.elements.map.*;
import com.manywho.sdk.old.run.elements.ui.*;

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

public class UIServiceResponseAPI extends ServiceResponseAPI
{
	private static final long serialVersionUID = 1L;

	private PageResponseAPI privatepageResponse;
	public final PageResponseAPI getPageResponse()
	{
		return privatepageResponse;
	}
	public final void setPageResponse(PageResponseAPI value)
	{
		privatepageResponse = value;
	}

	private java.util.ArrayList<OutcomeResponseAPI> privateoutcomeResponses;
	public final java.util.ArrayList<OutcomeResponseAPI> getOutcomeResponses()
	{
		return privateoutcomeResponses;
	}
	public final void setOutcomeResponses(java.util.ArrayList<OutcomeResponseAPI> value)
	{
		privateoutcomeResponses = value;
	}

	private boolean privateisComplete;
	public final boolean getIsComplete()
	{
		return privateisComplete;
	}
	public final void setIsComplete(boolean value)
	{
		privateisComplete = value;
	}

	private String privateselectedOutcomeId;
	public final String getSelectedOutcomeId()
	{
		return privateselectedOutcomeId;
	}
	public final void setSelectedOutcomeId(String value)
	{
		privateselectedOutcomeId = value;
	}
}