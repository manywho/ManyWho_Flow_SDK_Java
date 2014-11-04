package com.manywho.sdk.translate.elements.ui;

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

public class PageElementTranslationResponseAPI extends ElementTranslationResponseAPI
{
	private static final long serialVersionUID = 1L;

	private String privatelabelContentValueId;
	public final String getLabelContentValueId()
	{
		return privatelabelContentValueId;
	}
	public final void setLabelContentValueId(String value)
	{
		privatelabelContentValueId = value;
	}

	private java.util.ArrayList<PageContainerTranslationResponseAPI> privatepageContainers;
	public final java.util.ArrayList<PageContainerTranslationResponseAPI> getPageContainers()
	{
		return privatepageContainers;
	}
	public final void setPageContainers(java.util.ArrayList<PageContainerTranslationResponseAPI> value)
	{
		privatepageContainers = value;
	}

	private java.util.ArrayList<PageComponentTranslationResponseAPI> privatepageComponents;
	public final java.util.ArrayList<PageComponentTranslationResponseAPI> getPageComponents()
	{
		return privatepageComponents;
	}
	public final void setPageComponents(java.util.ArrayList<PageComponentTranslationResponseAPI> value)
	{
		privatepageComponents = value;
	}
}