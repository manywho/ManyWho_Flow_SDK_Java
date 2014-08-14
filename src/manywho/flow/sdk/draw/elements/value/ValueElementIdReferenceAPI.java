package manywho.flow.sdk.draw.elements.value;

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

public class ValueElementIdReferenceAPI extends ValueElementIdAPI
{
	private static final long serialVersionUID = 1L;

	private String privateversionId;
	public final String getVersionId()
	{
		return privateversionId;
	}
	public final void setVersionId(String value)
	{
		privateversionId = value;
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

	private String privatetypeElementDeveloperName;
	public final String getTypeElementDeveloperName()
	{
		return privatetypeElementDeveloperName;
	}
	public final void setTypeElementDeveloperName(String value)
	{
		privatetypeElementDeveloperName = value;
	}

	private String privatetypeElementPropertyDeveloperName;
	public final String getTypeElementPropertyDeveloperName()
	{
		return privatetypeElementPropertyDeveloperName;
	}
	public final void setTypeElementPropertyDeveloperName(String value)
	{
		privatetypeElementPropertyDeveloperName = value;
	}

	private String privatetypeElementPropertyTypeElementId;
	public final String getTypeElementPropertyTypeElementId()
	{
		return privatetypeElementPropertyTypeElementId;
	}
	public final void setTypeElementPropertyTypeElementId(String value)
	{
		privatetypeElementPropertyTypeElementId = value;
	}

	private String privateelementType;
	public final String getElementType()
	{
		return privateelementType;
	}
	public final void setElementType(String value)
	{
		privateelementType = value;
	}

	private String privatetypeElementId;
	public final String getTypeElementId()
	{
		return privatetypeElementId;
	}
	public final void setTypeElementId(String value)
	{
		privatetypeElementId = value;
	}

	private String privatecontentType;
	public final String getContentType()
	{
		return privatecontentType;
	}
	public final void setContentType(String value)
	{
		privatecontentType = value;
	}

	private boolean privateisFixed;
	public final boolean getIsFixed()
	{
		return privateisFixed;
	}
	public final void setIsFixed(boolean value)
	{
		privateisFixed = value;
	}
}