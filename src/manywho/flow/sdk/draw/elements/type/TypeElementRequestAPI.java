package manywho.flow.sdk.draw.elements.type;

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

public class TypeElementRequestAPI extends TypeElementAPI
{
	private static final long serialVersionUID = 1L;

	private java.util.ArrayList<TypeElementPropertyAPI> privateproperties;
	public final java.util.ArrayList<TypeElementPropertyAPI> getProperties()
	{
		return privateproperties;
	}
	public final void setProperties(java.util.ArrayList<TypeElementPropertyAPI> value)
	{
		privateproperties = value;
	}

	private java.util.ArrayList<TypeElementBindingAPI> privatebindings;
	public final java.util.ArrayList<TypeElementBindingAPI> getBindings()
	{
		return privatebindings;
	}
	public final void setBindings(java.util.ArrayList<TypeElementBindingAPI> value)
	{
		privatebindings = value;
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