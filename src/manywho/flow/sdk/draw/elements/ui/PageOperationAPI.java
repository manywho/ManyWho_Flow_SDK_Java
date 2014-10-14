package manywho.flow.sdk.draw.elements.ui;

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

public class PageOperationAPI extends JSONObject implements Serializable
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

	/** 
	 This object will not e null if we want to perform an assignment to a form element.  This can be everything from changing
	 the value to altering the meta-data of the field.  The only thing the assignment does not include is the application of
	 a filter to the data inside the field.
	*/
	private PageOperationAssignmentAPI privateassignment;
	public final PageOperationAssignmentAPI getAssignment()
	{
		return privateassignment;
	}
	public final void setAssignment(PageOperationAssignmentAPI value)
	{
		privateassignment = value;
	}

	/** 
	 This object will not be null if we want to apply a filter to a field.  We only support simple filtering with 1 where
	 clause for the query.  This is to simplify the UI logic considerably for "in-UI" logic.  For more complex filters, the
	 ObjectDataRequest propety should be used.
	*/
	private PageOperationFilterAPI privatefilter;
	public final PageOperationFilterAPI getFilter()
	{
		return privatefilter;
	}
	public final void setFilter(PageOperationFilterAPI value)
	{
		privatefilter = value;
	}
}