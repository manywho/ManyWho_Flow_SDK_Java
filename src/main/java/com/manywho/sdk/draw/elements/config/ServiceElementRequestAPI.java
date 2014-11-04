package com.manywho.sdk.draw.elements.config;

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

public class ServiceElementRequestAPI extends ServiceElementAPI
{
	private static final long serialVersionUID = 1L;

	private String privateuri;
	public final String getUri()
	{
		return privateuri;
	}
	public final void setUri(String value)
	{
		privateuri = value;
	}

	private String privateformat;
	public final String getFormat()
	{
		return privateformat;
	}
	public final void setFormat(String value)
	{
		privateformat = value;
	}

	private java.util.ArrayList<ServiceValueRequestAPI> privateconfigurationValues;
	public final java.util.ArrayList<ServiceValueRequestAPI> getConfigurationValues()
	{
		return privateconfigurationValues;
	}
	public final void setConfigurationValues(java.util.ArrayList<ServiceValueRequestAPI> value)
	{
		privateconfigurationValues = value;
	}

	private boolean privateprovidesLogic;
	public final boolean getProvidesLogic()
	{
		return privateprovidesLogic;
	}
	public final void setProvidesLogic(boolean value)
	{
		privateprovidesLogic = value;
	}

	private boolean privateprovidesViews;
	public final boolean getProvidesViews()
	{
		return privateprovidesViews;
	}
	public final void setProvidesViews(boolean value)
	{
		privateprovidesViews = value;
	}

	private boolean privateprovidesFiles;
	public final boolean getProvidesFiles()
	{
		return privateprovidesFiles;
	}
	public final void setProvidesFiles(boolean value)
	{
		privateprovidesFiles = value;
	}

	private boolean privateprovidesDatabase;
	public final boolean getProvidesDatabase()
	{
		return privateprovidesDatabase;
	}
	public final void setProvidesDatabase(boolean value)
	{
		privateprovidesDatabase = value;
	}

	private boolean privateprovidesIdentity;
	public final boolean getProvidesIdentity()
	{
		return privateprovidesIdentity;
	}
	public final void setProvidesIdentity(boolean value)
	{
		privateprovidesIdentity = value;
	}

	private boolean privateprovidesSocial;
	public final boolean getProvidesSocial()
	{
		return privateprovidesSocial;
	}
	public final void setProvidesSocial(boolean value)
	{
		privateprovidesSocial = value;
	}

	private boolean privateprovidesLocation;
	public final boolean getProvidesLocation()
	{
		return privateprovidesLocation;
	}
	public final void setProvidesLocation(boolean value)
	{
		privateprovidesLocation = value;
	}

	private java.util.ArrayList<ServiceActionRequestAPI> privateactions;
	public final java.util.ArrayList<ServiceActionRequestAPI> getActions()
	{
		return privateactions;
	}
	public final void setActions(java.util.ArrayList<ServiceActionRequestAPI> value)
	{
		privateactions = value;
	}

	private ServiceInstallRequestAPI privateinstall;
	public final ServiceInstallRequestAPI getInstall()
	{
		return privateinstall;
	}
	public final void setInstall(ServiceInstallRequestAPI value)
	{
		privateinstall = value;
	}

	private boolean privateupdateByName;
	public final boolean getUpdateByName()
	{
		return privateupdateByName;
	}
	public final void setUpdateByName(boolean value)
	{
		privateupdateByName = value;
	}
}