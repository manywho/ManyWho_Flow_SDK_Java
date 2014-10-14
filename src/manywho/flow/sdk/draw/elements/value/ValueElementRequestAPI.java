package manywho.flow.sdk.draw.elements.value;

import manywho.flow.sdk.run.elements.type.*;
import manywho.flow.sdk.draw.elements.map.*;

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

public class ValueElementRequestAPI extends ValueElementAPI
{
	private static final long serialVersionUID = 1L;

	private boolean privateisFixed;
	public final boolean getIsFixed()
	{
		return privateisFixed;
	}
	public final void setIsFixed(boolean value)
	{
		privateisFixed = value;
	}

	private String privateaccess;
	public final String getAccess()
	{
		return privateaccess;
	}
	public final void setAccess(String value)
	{
		privateaccess = value;
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

	private String privatedefaultContentValue;
	public final String getDefaultContentValue()
	{
		return privatedefaultContentValue;
	}
	public final void setDefaultContentValue(String value)
	{
		privatedefaultContentValue = value;
	}

	private java.util.ArrayList<ObjectAPI> privatedefaultObjectData;
	public final java.util.ArrayList<ObjectAPI> getDefaultObjectData()
	{
		return privatedefaultObjectData;
	}
	public final void setDefaultObjectData(java.util.ArrayList<ObjectAPI> value)
	{
		privatedefaultObjectData = value;
	}

	private java.util.ArrayList<OperationAPI> privateinitializationOperations;
	public final java.util.ArrayList<OperationAPI> getInitializationOperations()
	{
		return privateinitializationOperations;
	}
	public final void setInitializationOperations(java.util.ArrayList<OperationAPI> value)
	{
		privateinitializationOperations = value;
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