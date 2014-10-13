package manywho.flow.sdk.draw.flow;

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

public class FlowGraphResponseAPI extends FlowGraphRequestAPI
{
	private static final long serialVersionUID = 1L;

	private String privatetenantId;
	public final String getTenantId()
	{
		return privatetenantId;
	}
	public final void setTenantId(String value)
	{
		privatetenantId = value;
	}
}