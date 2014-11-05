package com.manywho.sdk.old.draw.elements.group;

import com.manywho.sdk.old.draw.elements.*;

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

public class GroupElementAPI extends ElementAPI
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

	private String privategroupElementId;
	public final String getGroupElementId()
	{
		return privategroupElementId;
	}
	public final void setGroupElementId(String value)
	{
		privategroupElementId = value;
	}

	private int privatex;
	public final int getX()
	{
		return privatex;
	}
	public final void setX(int value)
	{
		privatex = value;
	}

	private int privatey;
	public final int getY()
	{
		return privatey;
	}
	public final void setY(int value)
	{
		privatey = value;
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

	private GroupAuthorizationAPI privateauthorization;
	public final GroupAuthorizationAPI getAuthorization()
	{
		return privateauthorization;
	}
	public final void setAuthorization(GroupAuthorizationAPI value)
	{
		privateauthorization = value;
	}
}