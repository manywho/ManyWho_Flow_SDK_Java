package manywho.flow.sdk.translate.elements.ui;

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

public class PageComponentTranslationResponseAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privatepageContainerDeveloperName;
	public final String getPageContainerDeveloperName()
	{
		return privatepageContainerDeveloperName;
	}
	public final void setPageContainerDeveloperName(String value)
	{
		privatepageContainerDeveloperName = value;
	}

	private String privatedeveloperName;
	public final String getDeveloperName()
	{
		return privatedeveloperName;
	}
	public final void setDeveloperName(String value)
	{
		privatedeveloperName = value;
	}

	private String privatecomponentType;
	public final String getComponentType()
	{
		return privatecomponentType;
	}
	public final void setComponentType(String value)
	{
		privatecomponentType = value;
	}

	private String privatecontentContentValueId;
	public final String getContentContentValueId()
	{
		return privatecontentContentValueId;
	}
	public final void setContentContentValueId(String value)
	{
		privatecontentContentValueId = value;
	}

	private String privatelabelContentValueId;
	public final String getLabelContentValueId()
	{
		return privatelabelContentValueId;
	}
	public final void setLabelContentValueId(String value)
	{
		privatelabelContentValueId = value;
	}

	private String privatehintValueContentValueId;
	public final String getHintValueContentValueId()
	{
		return privatehintValueContentValueId;
	}
	public final void setHintValueContentValueId(String value)
	{
		privatehintValueContentValueId = value;
	}

	private String privatehelpInfoContentValueId;
	public final String getHelpInfoContentValueId()
	{
		return privatehelpInfoContentValueId;
	}
	public final void setHelpInfoContentValueId(String value)
	{
		privatehelpInfoContentValueId = value;
	}

	private java.util.ArrayList<PageComponentColumnTranslationResponseAPI> privatecolumns;
	public final java.util.ArrayList<PageComponentColumnTranslationResponseAPI> getColumns()
	{
		return privatecolumns;
	}
	public final void setColumns(java.util.ArrayList<PageComponentColumnTranslationResponseAPI> value)
	{
		privatecolumns = value;
	}
}