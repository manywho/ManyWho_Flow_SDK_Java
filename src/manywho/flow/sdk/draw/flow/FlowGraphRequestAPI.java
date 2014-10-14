package manywho.flow.sdk.draw.flow;

import manywho.flow.sdk.draw.elements.map.*;
import manywho.flow.sdk.draw.elements.group.*;

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

public class FlowGraphRequestAPI extends FlowRequestAPI
{
	private static final long serialVersionUID = 1L;

	private java.util.ArrayList<MapElementAPI> privatemapElements;
	public final java.util.ArrayList<MapElementAPI> getMapElements()
	{
		return privatemapElements;
	}
	public final void setMapElements(java.util.ArrayList<MapElementAPI> value)
	{
		privatemapElements = value;
	}

	public final void removeMapElement(String id)
	{
		boolean found = false;
		int index = 0;

		// Search the list to see if this map element exists already
		for (MapElementAPI mapElementEntry : this.getMapElements())
		{
			if (mapElementEntry.getId().equals(id))
			{
				found = true;
				break;
			}

			index++;
		}

		// If the entry is found, remove it
		if (found == true)
		{
			this.getMapElements().remove(index);
		}
	}

	public final void removeMapElement(MapElementAPI mapElement)
	{
		removeMapElement(mapElement.getId());
	}

	public final void upsertMapElement(MapElementAPI mapElement)
	{
		MapElementAPI reducedMapElement = new MapElementAPI();

		if (this.getMapElements() == null)
		{
			this.setMapElements(new java.util.ArrayList<MapElementAPI>());
		}

		// We convert the map element back to a map element api object to stop WCF from breaking
		reducedMapElement.setDeveloperName(mapElement.getDeveloperName());
		reducedMapElement.setDeveloperSummary(mapElement.getDeveloperSummary());
		reducedMapElement.setElementType(mapElement.getElementType());
		reducedMapElement.setId(mapElement.getId());
		reducedMapElement.setOutcomes(mapElement.getOutcomes());
		reducedMapElement.setX(mapElement.getX());
		reducedMapElement.setY(mapElement.getY());
		reducedMapElement.setGroupElementId(mapElement.getGroupElementId());

		// Remove the existing entry
		removeMapElement(reducedMapElement);

		// Finally, add the map element to the list
		this.getMapElements().add(reducedMapElement);
	}

	private java.util.ArrayList<GroupElementAPI> privategroupElements;
	public final java.util.ArrayList<GroupElementAPI> getGroupElements()
	{
		return privategroupElements;
	}
	public final void setGroupElements(java.util.ArrayList<GroupElementAPI> value)
	{
		privategroupElements = value;
	}

	public final void removeGroupElement(String id)
	{
		boolean found = false;
		int index = 0;

		// Search the list to see if this group element exists already
		for (GroupElementAPI groupElementEntry : this.getGroupElements())
		{
			if (groupElementEntry.getId().equals(id))
			{
				found = true;
				break;
			}

			index++;
		}

		// If the entry is found, remove it
		if (found == true)
		{
			this.getGroupElements().remove(index);
		}
	}

	public final void removeGroupElement(GroupElementAPI groupElement)
	{
		removeGroupElement(groupElement.getId());
	}

	public final void upsertGroupElement(GroupElementAPI groupElement)
	{
		GroupElementAPI reducedGroupElement = new GroupElementAPI();

		if (this.getGroupElements() == null)
		{
			this.setGroupElements(new java.util.ArrayList<GroupElementAPI>());
		}

		// We convert the group element back to a group element api object to stop WCF from breaking
		reducedGroupElement.setDeveloperName(groupElement.getDeveloperName());
		reducedGroupElement.setDeveloperSummary(groupElement.getDeveloperSummary());
		reducedGroupElement.setElementType(groupElement.getElementType());
		reducedGroupElement.setId(groupElement.getId());
		reducedGroupElement.setGroupElementId(groupElement.getGroupElementId());
		reducedGroupElement.setX(groupElement.getX());
		reducedGroupElement.setY(groupElement.getY());
		reducedGroupElement.setHeight(groupElement.getHeight());
		reducedGroupElement.setWidth(groupElement.getWidth());

		// Remove the existing entry
		removeGroupElement(reducedGroupElement);

		// Finally, add the group element to the list
		this.getGroupElements().add(reducedGroupElement);
	}
}