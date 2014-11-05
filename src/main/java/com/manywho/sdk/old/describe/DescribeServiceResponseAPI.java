package com.manywho.sdk.old.describe;

import java.io.Serializable;

import org.json.JSONObject;

import com.manywho.sdk.old.translate.*;

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

public class DescribeServiceResponseAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The culture for the service request.
	*/
	private CultureAPI privateculture;
	public final CultureAPI getCulture()
	{
		return privateculture;
	}
	public final void setCulture(CultureAPI value)
	{
		privateculture = value;
	}

	/** 
	 The Uri for the service to describe.
	*/
	private String privateuri;
	public final String getUri()
	{
		return privateuri;
	}
	public final void setUri(String value)
	{
		privateuri = value;
	}

	/** 
	 Configuration information that's required to set up the service.  These are values that are typically not associated with
	 input/output or moment in time information - this is stuff that is required for the service to function correctly.
	*/
	private java.util.ArrayList<DescribeValueAPI> privateconfigurationValues;
	public final java.util.ArrayList<DescribeValueAPI> getConfigurationValues()
	{
		return privateconfigurationValues;
	}
	public final void setConfigurationValues(java.util.ArrayList<DescribeValueAPI> value)
	{
		privateconfigurationValues = value;
	}

	/** 
	 Tells the system whether or not the service exposes logic actions.
	*/
	private boolean privateprovidesLogic;
	public final boolean getProvidesLogic()
	{
		return privateprovidesLogic;
	}
	public final void setProvidesLogic(boolean value)
	{
		privateprovidesLogic = value;
	}

	/** 
	 Tells the system whether or not the service exposes views.
	*/
	private boolean privateprovidesViews;
	public final boolean getProvidesViews()
	{
		return privateprovidesViews;
	}
	public final void setProvidesViews(boolean value)
	{
		privateprovidesViews = value;
	}

	/** 
	 Indicates if this service provides object data support for the provided types.
	*/
	private boolean privateprovidesDatabase;
	public final boolean getProvidesDatabase()
	{
		return privateprovidesDatabase;
	}
	public final void setProvidesDatabase(boolean value)
	{
		privateprovidesDatabase = value;
	}

	/** 
	 Indicates if this service provides identity information for authentication and authorization calls.
	*/
	private boolean privateprovidesIdentity;
	public final boolean getProvidesIdentity()
	{
		return privateprovidesIdentity;
	}
	public final void setProvidesIdentity(boolean value)
	{
		privateprovidesIdentity = value;
	}

	/** 
	 Indicates if this service provides social networking capabilities to the flow.
	*/
	private boolean privateprovidesSocial;
	public final boolean getProvidesSocial()
	{
		return privateprovidesSocial;
	}
	public final void setProvidesSocial(boolean value)
	{
		privateprovidesSocial = value;
	}

	/** 
	 Indicates if this service provides files for download and upload. This is logically separate from the social networking where it is
	 assumed the feed supports basic file attachments.
	*/
	private boolean privateprovidesFiles;
	public final boolean getProvidesFiles()
	{
		return privateprovidesFiles;
	}
	public final void setProvidesFiles(boolean value)
	{
		privateprovidesFiles = value;
	}

	/** 
	 The actions available for this service.  The actions are basically a proxy for methods.
	*/
	private java.util.ArrayList<DescribeServiceActionResponseAPI> privateactions;
	public final java.util.ArrayList<DescribeServiceActionResponseAPI> getActions()
	{
		return privateactions;
	}
	public final void setActions(java.util.ArrayList<DescribeServiceActionResponseAPI> value)
	{
		privateactions = value;
	}

	/** 
	 Contains the description of model elements we'd like to install as part of this service.  When something is installed,
	 it simply takes the information from the insert as if it were done by the designer (e.g. no translations, it's basically 
	 just the meta-data, but can only be modified by the service - not the end user (except translations of labels, etc)).  
	 If the service getS updated, then those changes are applied as if they're a different version of this type.
	*/
	private DescribeServiceInstallResponseAPI privateinstall;
	public final DescribeServiceInstallResponseAPI getInstall()
	{
		return privateinstall;
	}
	public final void setInstall(DescribeServiceInstallResponseAPI value)
	{
		privateinstall = value;
	}
}