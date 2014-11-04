package com.manywho.sdk.draw.elements.ui;

import java.io.Serializable;

import org.json.JSONObject;

import com.manywho.sdk.draw.elements.type.*;
import com.manywho.sdk.draw.elements.value.*;

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

public class PageComponentAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privateid;
	public final String getId()
	{
		return privateid;
	}
	public final void setId(String value)
	{
		privateid = value;
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

	private ValueElementIdAPI privatevalueElementValueBindingReferenceId;
	public final ValueElementIdAPI getValueElementValueBindingReferenceId()
	{
		return privatevalueElementValueBindingReferenceId;
	}
	public final void setValueElementValueBindingReferenceId(ValueElementIdAPI value)
	{
		privatevalueElementValueBindingReferenceId = value;
	}

	private ValueElementIdAPI privatevalueElementDataBindingReferenceId;
	public final ValueElementIdAPI getValueElementDataBindingReferenceId()
	{
		return privatevalueElementDataBindingReferenceId;
	}
	public final void setValueElementDataBindingReferenceId(ValueElementIdAPI value)
	{
		privatevalueElementDataBindingReferenceId = value;
	}

	/** 
	 Used to get the data in real-time from the external data source - using this object data request as the configuration of that
	 request.
	*/
	private ObjectDataRequestConfigAPI privateobjectDataRequest;
	public final ObjectDataRequestConfigAPI getObjectDataRequest()
	{
		return privateobjectDataRequest;
	}
	public final void setObjectDataRequest(ObjectDataRequestConfigAPI value)
	{
		privateobjectDataRequest = value;
	}

	/** 
	 Used to get the file data in real-time from the external data source - using the file data request as the configuration of that
	 request.
	*/
	private FileDataRequestConfigAPI privatefileDataRequest;
	public final FileDataRequestConfigAPI getFileDataRequest()
	{
		return privatefileDataRequest;
	}
	public final void setFileDataRequest(FileDataRequestConfigAPI value)
	{
		privatefileDataRequest = value;
	}

	/** 
	 The resource location of the image used in image type components.
	*/
	private String privateimageUri;
	public final String getImageUri()
	{
		return privateimageUri;
	}
	public final void setImageUri(String value)
	{
		privateimageUri = value;
	}

	private String privatepageContainerId;
	public final String getPageContainerId()
	{
		return privatepageContainerId;
	}
	public final void setPageContainerId(String value)
	{
		privatepageContainerId = value;
	}

	private String privatepageContainerDeveloperName;
	public final String getPageContainerDeveloperName()
	{
		return privatepageContainerDeveloperName;
	}
	public final void setPageContainerDeveloperName(String value)
	{
		privatepageContainerDeveloperName = value;
	}

	/** 
	 We have a developer name field solely for external services - so they can match fields appropriately with respect
	 to form layouts for types.
	*/
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

	private String privatecontent;
	public final String getContent()
	{
		return privatecontent;
	}
	public final void setContent(String value)
	{
		privatecontent = value;
	}

	private String privatelabel;
	public final String getLabel()
	{
		return privatelabel;
	}
	public final void setLabel(String value)
	{
		privatelabel = value;
	}

	private java.util.ArrayList<PageComponentColumnAPI> privatecolumns;
	public final java.util.ArrayList<PageComponentColumnAPI> getColumns()
	{
		return privatecolumns;
	}
	public final void setColumns(java.util.ArrayList<PageComponentColumnAPI> value)
	{
		privatecolumns = value;
	}

	private int privatesize;
	public final int getSize()
	{
		return privatesize;
	}
	public final void setSize(int value)
	{
		privatesize = value;
	}

	private int privatemaxSize;
	public final int getMaxSize()
	{
		return privatemaxSize;
	}
	public final void setMaxSize(int value)
	{
		privatemaxSize = value;
	}

	private int privateheight;
	public final int getHeight()
	{
		return privateheight;
	}
	public final void setHeight(int value)
	{
		privateheight = value;
	}

	private int privatewidth;
	public final int getWidth()
	{
		return privatewidth;
	}
	public final void setWidth(int value)
	{
		privatewidth = value;
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

	private boolean privateisMultiSelect;
	public final boolean getIsMultiSelect()
	{
		return privateisMultiSelect;
	}
	public final void setIsMultiSelect(boolean value)
	{
		privateisMultiSelect = value;
	}

	private boolean privateisSearchable;
	public final boolean getIsSearchable()
	{
		return privateisSearchable;
	}
	public final void setIsSearchable(boolean value)
	{
		privateisSearchable = value;
	}

	private String privatehintValue;
	public final String getHintValue()
	{
		return privatehintValue;
	}
	public final void setHintValue(String value)
	{
		privatehintValue = value;
	}

	private String privatehelpInfo;
	public final String getHelpInfo()
	{
		return privatehelpInfo;
	}
	public final void setHelpInfo(String value)
	{
		privatehelpInfo = value;
	}

	private int privateorder;
	public final int getOrder()
	{
		return privateorder;
	}
	public final void setOrder(int value)
	{
		privateorder = value;
	}

	private java.util.HashMap<String, String> privateattributes;
	public final java.util.HashMap<String, String> getAttributes()
	{
		return privateattributes;
	}
	public final void setAttributes(java.util.HashMap<String, String> value)
	{
		privateattributes = value;
	}

	private java.util.ArrayList<PageTagAPI> privatetags;
	public final java.util.ArrayList<PageTagAPI> getTags()
	{
		return privatetags;
	}
	public final void setTags(java.util.ArrayList<PageTagAPI> value)
	{
		privatetags = value;
	}
}