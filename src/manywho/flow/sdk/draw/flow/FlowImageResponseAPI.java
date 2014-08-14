package manywho.flow.sdk.draw.flow;

import manywho.flow.sdk.draw.elements.config.*;
import manywho.flow.sdk.draw.elements.group.*;
import manywho.flow.sdk.draw.elements.map.*;
import manywho.flow.sdk.draw.elements.type.*;
import manywho.flow.sdk.draw.elements.ui.*;
import manywho.flow.sdk.draw.elements.value.*;

public class FlowImageResponseAPI extends FlowResponseAPI
{
	private static final long serialVersionUID = 1L;

	private java.util.ArrayList<NavigationElementResponseAPI> privatenavigationElements;
	public final java.util.ArrayList<NavigationElementResponseAPI> getNavigationElements()
	{
		return privatenavigationElements;
	}
	public final void setNavigationElements(java.util.ArrayList<NavigationElementResponseAPI> value)
	{
		privatenavigationElements = value;
	}

	private java.util.ArrayList<MapElementResponseAPI> privatemapElements;
	public final java.util.ArrayList<MapElementResponseAPI> getMapElements()
	{
		return privatemapElements;
	}
	public final void setMapElements(java.util.ArrayList<MapElementResponseAPI> value)
	{
		privatemapElements = value;
	}

	private java.util.ArrayList<GroupElementResponseAPI> privategroupElements;
	public final java.util.ArrayList<GroupElementResponseAPI> getGroupElements()
	{
		return privategroupElements;
	}
	public final void setGroupElements(java.util.ArrayList<GroupElementResponseAPI> value)
	{
		privategroupElements = value;
	}

	private java.util.ArrayList<PageElementResponseAPI> privatepageElements;
	public final java.util.ArrayList<PageElementResponseAPI> getPageElements()
	{
		return privatepageElements;
	}
	public final void setPageElements(java.util.ArrayList<PageElementResponseAPI> value)
	{
		privatepageElements = value;
	}

	private java.util.ArrayList<ValueElementResponseAPI> privatevalueElements;
	public final java.util.ArrayList<ValueElementResponseAPI> getValueElements()
	{
		return privatevalueElements;
	}
	public final void setValueElements(java.util.ArrayList<ValueElementResponseAPI> value)
	{
		privatevalueElements = value;
	}

	private java.util.ArrayList<MacroElementResponseAPI> privatemacroElements;
	public final java.util.ArrayList<MacroElementResponseAPI> getMacroElements()
	{
		return privatemacroElements;
	}
	public final void setMacroElements(java.util.ArrayList<MacroElementResponseAPI> value)
	{
		privatemacroElements = value;
	}

	private java.util.ArrayList<ServiceElementResponseAPI> privateserviceElements;
	public final java.util.ArrayList<ServiceElementResponseAPI> getServiceElements()
	{
		return privateserviceElements;
	}
	public final void setServiceElements(java.util.ArrayList<ServiceElementResponseAPI> value)
	{
		privateserviceElements = value;
	}

	private java.util.ArrayList<TypeElementResponseAPI> privatetypeElements;
	public final java.util.ArrayList<TypeElementResponseAPI> getTypeElements()
	{
		return privatetypeElements;
	}
	public final void setTypeElements(java.util.ArrayList<TypeElementResponseAPI> value)
	{
		privatetypeElements = value;
	}

	private java.util.ArrayList<TagElementResponseAPI> privatetagElements;
	public final java.util.ArrayList<TagElementResponseAPI> getTagElements()
	{
		return privatetagElements;
	}
	public final void setTagElements(java.util.ArrayList<TagElementResponseAPI> value)
	{
		privatetagElements = value;
	}
}