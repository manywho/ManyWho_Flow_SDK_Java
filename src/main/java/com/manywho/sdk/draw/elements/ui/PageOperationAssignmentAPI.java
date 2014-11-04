package com.manywho.sdk.draw.elements.ui;

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

public class PageOperationAssignmentAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 
	 The form element to have the assignment applied.
	*/
	private PageObjectReferenceAPI privateassignee;
	public final PageObjectReferenceAPI getAssignee()
	{
		return privateassignee;
	}
	public final void setAssignee(PageObjectReferenceAPI value)
	{
		privateassignee = value;
	}

	/** 
	 The form element of value to use in the assignment.
	*/
	private PageObjectReferenceAPI privateassignor;
	public final PageObjectReferenceAPI getAssignor()
	{
		return privateassignor;
	}
	public final void setAssignor(PageObjectReferenceAPI value)
	{
		privateassignor = value;
	}
}