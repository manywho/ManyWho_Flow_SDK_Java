package com.manywho.sdk.run.elements.config;

import com.manywho.sdk.run.elements.ui.*;

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

public class UIServiceRequestAPI extends ServiceRequestAPI
{
	private static final long serialVersionUID = 1L;

	private String privatecurrentMapElementId;
	public final String getCurrentMapElementId()
	{
		return privatecurrentMapElementId;
	}
	public final void setCurrentMapElementId(String value)
	{
		privatecurrentMapElementId = value;
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