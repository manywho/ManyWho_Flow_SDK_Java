package manywho.flow.sdk.translate;

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

public class ContentValueDocumentTranslationAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The set of content value translations for a particular element. The key of the content value is the identifier for the
	 property in the element.
	*/
	private java.util.HashMap<String, String> privatecontentValues;
	public final java.util.HashMap<String, String> getContentValues()
	{
		return privatecontentValues;
	}
	public final void setContentValues(java.util.HashMap<String, String> value)
	{
		privatecontentValues = value;
	}
}