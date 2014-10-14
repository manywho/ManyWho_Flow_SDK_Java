package manywho.flow.sdk.translate.flow;

import java.io.Serializable;

import org.json.JSONObject;

import manywho.flow.sdk.translate.elements.ui.*;
import manywho.flow.sdk.translate.elements.map.*;
import manywho.flow.sdk.translate.elements.value.*;

public class FlowImageTranslationResponseAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String privateeditingToken;
	public final String getEditingToken()
	{
		return privateeditingToken;
	}
	public final void setEditingToken(String value)
	{
		privateeditingToken = value;
	}

	private String privateid;
	public final String getId()
	{
		return privateid;
	}
	public final void setId(String value)
	{
		privateid = value;
	}

	private String privatedeveloperName;
	public final String getDeveloperName()
	{
		return privatedeveloperName;
	}
	public final void setDeveloperName(String value)
	{
		privatedeveloperName = value;
	}

	private String privatedeveloperSummary;
	public final String getDeveloperSummary()
	{
		return privatedeveloperSummary;
	}
	public final void setDeveloperSummary(String value)
	{
		privatedeveloperSummary = value;
	}

	private String privatestartMapElementId;
	public final String getStartMapElementId()
	{
		return privatestartMapElementId;
	}
	public final void setStartMapElementId(String value)
	{
		privatestartMapElementId = value;
	}

	private java.util.ArrayList<NavigationElementTranslationResponseAPI> privatenavigationElements;
	public final java.util.ArrayList<NavigationElementTranslationResponseAPI> getNavigationElements()
	{
		return privatenavigationElements;
	}
	public final void setNavigationElements(java.util.ArrayList<NavigationElementTranslationResponseAPI> value)
	{
		privatenavigationElements = value;
	}

	private java.util.ArrayList<MapElementTranslationResponseAPI> privatemapElements;
	public final java.util.ArrayList<MapElementTranslationResponseAPI> getMapElements()
	{
		return privatemapElements;
	}
	public final void setMapElements(java.util.ArrayList<MapElementTranslationResponseAPI> value)
	{
		privatemapElements = value;
	}

	private java.util.ArrayList<PageElementTranslationResponseAPI> privatepageElements;
	public final java.util.ArrayList<PageElementTranslationResponseAPI> getPageElements()
	{
		return privatepageElements;
	}
	public final void setPageElements(java.util.ArrayList<PageElementTranslationResponseAPI> value)
	{
		privatepageElements = value;
	}

	private java.util.ArrayList<ValueElementTranslationResponseAPI> privatevalueElements;
	public final java.util.ArrayList<ValueElementTranslationResponseAPI> getValueElements()
	{
		return privatevalueElements;
	}
	public final void setValueElements(java.util.ArrayList<ValueElementTranslationResponseAPI> value)
	{
		privatevalueElements = value;
	}
}