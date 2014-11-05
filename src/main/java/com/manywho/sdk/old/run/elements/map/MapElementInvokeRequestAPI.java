package com.manywho.sdk.old.run.elements.map;

import java.io.Serializable;

import org.json.JSONObject;

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

public class MapElementInvokeRequestAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privateselectedOutcomeId;
	public final String getSelectedOutcomeId()
	{
		return privateselectedOutcomeId;
	}
	public final void setSelectedOutcomeId(String value)
	{
		privateselectedOutcomeId = value;
	}

	private PageRequestAPI privatepageRequest;
	public final PageRequestAPI getPageRequest()
	{
		return privatepageRequest;
	}
	public final void setPageRequest(PageRequestAPI value)
	{
		privatepageRequest = value;
	}
}