package manywho.flow.sdk.run.elements.ui;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.run.elements.type.*;
import manywho.flow.sdk.run.*;

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

public class PageComponentDataResponseAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privatepageComponentId;
	public final String getPageComponentId()
	{
		return privatepageComponentId;
	}
	public final void setPageComponentId(String value)
	{
		privatepageComponentId = value;
	}

	private boolean privateisEnabled;
	public final boolean getIsEnabled()
	{
		return privateisEnabled;
	}
	public final void setIsEnabled(boolean value)
	{
		privateisEnabled = value;
	}

	private boolean privateisEditable;
	public final boolean getIsEditable()
	{
		return privateisEditable;
	}
	public final void setIsEditable(boolean value)
	{
		privateisEditable = value;
	}

	private boolean privateisRequired;
	public final boolean getIsRequired()
	{
		return privateisRequired;
	}
	public final void setIsRequired(boolean value)
	{
		privateisRequired = value;
	}

	private boolean privateisVisible;
	public final boolean getIsVisible()
	{
		return privateisVisible;
	}
	public final void setIsVisible(boolean value)
	{
		privateisVisible = value;
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

	private ObjectDataRequestAPI privateobjectDataRequest;
	public final ObjectDataRequestAPI getObjectDataRequest()
	{
		return privateobjectDataRequest;
	}
	public final void setObjectDataRequest(ObjectDataRequestAPI value)
	{
		privateobjectDataRequest = value;
	}

	private FileDataRequestAPI privatefileDataRequest;
	public final FileDataRequestAPI getFileDataRequest()
	{
		return privatefileDataRequest;
	}
	public final void setFileDataRequest(FileDataRequestAPI value)
	{
		privatefileDataRequest = value;
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

	private String privatecontent;
	public final String getContent()
	{
		return privatecontent;
	}
	public final void setContent(String value)
	{
		privatecontent = value;
	}

	private String privateimageUri;
	public final String getImageUri()
	{
		return privateimageUri;
	}
	public final void setImageUri(String value)
	{
		privateimageUri = value;
	}

	private boolean privateisValid;
	public final boolean getIsValid()
	{
		return privateisValid;
	}
	public final void setIsValid(boolean value)
	{
		privateisValid = value;
	}

	private String privatevalidationMessage;
	public final String getValidationMessage()
	{
		return privatevalidationMessage;
	}
	public final void setValidationMessage(String value)
	{
		privatevalidationMessage = value;
	}

	private java.util.ArrayList<EngineValueAPI> privatetags;
	public final java.util.ArrayList<EngineValueAPI> getTags()
	{
		return privatetags;
	}
	public final void setTags(java.util.ArrayList<EngineValueAPI> value)
	{
		privatetags = value;
	}
}