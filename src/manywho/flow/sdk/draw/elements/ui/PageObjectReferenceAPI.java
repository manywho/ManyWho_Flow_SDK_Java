package manywho.flow.sdk.draw.elements.ui;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.draw.elements.value.*;

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

public class PageObjectReferenceAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The identifier for the field post save - this is used in place of the field reference.
	*/
	private String privatepageObjectReferenceId;
	public final String getPageObjectReferenceId()
	{
		return privatepageObjectReferenceId;
	}
	public final void setPageObjectReferenceId(String value)
	{
		privatepageObjectReferenceId = value;
	}

	/** 
	 The identifier for any inner reference value references.  The Id in the form is not the shared element id but rather
	 the form element id.  However, for inner references, we can use the type element id as this is not specific to the shared
	 element binding - but rather the object or list type generically.
	*/
	private String privatetypeElementPropertyId;
	public final String getTypeElementPropertyId()
	{
		return privatetypeElementPropertyId;
	}
	public final void setTypeElementPropertyId(String value)
	{
		privatetypeElementPropertyId = value;
	}

	/** 
	 The temporary field reference from the client application - pre-save.  The notation for this should be the fully qualified
	 path from the root form: e.g. [Section Name].[Column Name].[Cell Name].[Field Name]
	*/
	private String privatepageObjectReferenceDeveloperName;
	public final String getPageObjectReferenceDeveloperName()
	{
		return privatepageObjectReferenceDeveloperName;
	}
	public final void setPageObjectReferenceDeveloperName(String value)
	{
		privatepageObjectReferenceDeveloperName = value;
	}

	/** 
	 This is a design time thing - at runtime, we'd use this as the source of the value as opposed to an element on the form.
	*/
	private ValueElementIdAPI privatevalueElementToReferenceId;
	public final ValueElementIdAPI getValueElementToReferenceId()
	{
		return privatevalueElementToReferenceId;
	}
	public final void setValueElementToReferenceId(ValueElementIdAPI value)
	{
		privatevalueElementToReferenceId = value;
	}

	/** 
	 The meta-data to reference on the field:
	 Value - the actual value of the field
	 MetaData.Visible - indicates if the form element should be visible or not
	 MetaData.Required - the required status of the input
	 MetaData.Enabled - the enabled/disabled status of the input
	 MetaData.Filter - only for lists - basically only show the entries that match a particular category (this will allow simply dynamic lists)
	 MetaData.Validation - dynamically bind a validation rule to the input
	*/
	private String privatemetadataType;
	public final String getMetadataType()
	{
		return privatemetadataType;
	}
	public final void setMetadataType(String value)
	{
		privatemetadataType = value;
	}
}