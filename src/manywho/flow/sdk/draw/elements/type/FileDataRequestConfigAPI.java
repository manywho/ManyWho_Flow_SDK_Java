package manywho.flow.sdk.draw.elements.type;

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

public class FileDataRequestConfigAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The Id for the service element associated with this file data.  The service element will give us the connection setTings
	 and allow us to validate various bits of info.
	*/
	private String privateserviceElementId;
	public final String getServiceElementId()
	{
		return privateserviceElementId;
	}
	public final void setServiceElementId(String value)
	{
		privateserviceElementId = value;
	}

	/** 
	 The reference for the folder - this can be an identifier or a path - whatever the service implementation needs.
	*/
	private String privateresourcePath;
	public final String getResourcePath()
	{
		return privateresourcePath;
	}
	public final void setResourcePath(String value)
	{
		privateresourcePath = value;
	}

	/** 
	 The reference for the file - this can be an identifier or a file name - whatever the service implementation needs.
	*/
	private String privateresourceFile;
	public final String getResourceFile()
	{
		return privateresourceFile;
	}
	public final void setResourceFile(String value)
	{
		privateresourceFile = value;
	}
}