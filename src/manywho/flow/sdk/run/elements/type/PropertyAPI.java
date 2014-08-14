package manywho.flow.sdk.run.elements.type;

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

public class PropertyAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privatetypeElementPropertyId;
	public final String getTypeElementPropertyId()
	{
		return privatetypeElementPropertyId;
	}
	public final void setTypeElementPropertyId(String value)
	{
		privatetypeElementPropertyId = value;
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

	private String privatecontentValue;
	public final String getContentValue()
	{
		return privatecontentValue;
	}
	public final void setContentValue(String value)
	{
		privatecontentValue = value;
	}

	private java.util.ArrayList<ObjectAPI> privateobjectData;
	public final java.util.ArrayList<ObjectAPI> getObjectData()
	{
		return privateobjectData;
	}
	public final void setObjectData(java.util.ArrayList<ObjectAPI> value)
	{
		privateobjectData = value;
	}
}