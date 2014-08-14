package manywho.flow.sdk.utils;

import java.util.UUID;

import manywho.flow.sdk.run.*;
import manywho.flow.sdk.run.elements.type.*;
import manywho.flow.sdk.draw.elements.type.*;
import manywho.flow.sdk.*;

public class ValueUtils
{
	public static String getContentValue(String developerName, java.util.ArrayList<EngineValueAPI> engineValues, boolean required) throws Exception
	{
		String contentValue = null;

		// Get the message input
		if (engineValues != null && engineValues.size() > 0)
		{
			// Go through the inputs to find the message
			for (EngineValueAPI engineValue : engineValues)
			{
				// Check to see if this is the post
				if (engineValue.getDeveloperName().equalsIgnoreCase(developerName) == true)
				{
					// Grab the message
					contentValue = engineValue.getContentValue();

					// Break out of this loop
					break;
				}
			}
		}

		if (required == true && (contentValue == null || contentValue.trim().length() == 0))
		{
			throw new Exception(developerName + " cannot be null or blank.");
		}

		return contentValue;
	}

	public static ObjectAPI getObjectData(String developerName, java.util.ArrayList<EngineValueAPI> engineValues, boolean required) throws Exception
	{
		ObjectAPI objectData = null;

		// Get the message input
		if (engineValues != null && engineValues.size() > 0)
		{
			// Go through the inputs to find the message
			for (EngineValueAPI engineValue : engineValues)
			{
				// Check to see if this is the post
				if (engineValue.getDeveloperName().equalsIgnoreCase(developerName) == true)
				{
					// Grab the message
					if (engineValue.getObjectData() != null && engineValue.getObjectData().size() > 0)
					{
						objectData = engineValue.getObjectData().get(0);
					}

					// Break out of this loop
					break;
				}
			}
		}

		if (required == true && objectData == null)
		{
			throw new Exception(developerName + " cannot be null.");
		}

		return objectData;
	}

	public static java.util.ArrayList<ObjectAPI> getListData(String developerName, java.util.ArrayList<EngineValueAPI> engineValues, boolean required) throws Exception
	{
		java.util.ArrayList<ObjectAPI> objectData = null;

		// Get the message input
		if (engineValues != null && engineValues.size() > 0)
		{
			// Go through the inputs to find the message
			for (EngineValueAPI engineValue : engineValues)
			{
				// Check to see if this is the post
				if (engineValue.getDeveloperName().equalsIgnoreCase(developerName) == true)
				{
					// Grab the message
					objectData = engineValue.getObjectData();

					// Break out of this loop
					break;
				}
			}
		}

		if (required == true && (objectData == null || objectData.isEmpty()))
		{
			throw new Exception(developerName + " cannot be null or blank.");
		}

		return objectData;
	}

	public static String serializeListData(java.util.ArrayList<ObjectAPI> objectAPIs, TypeElementResponseAPI typeElementResponse) throws Exception
	{
		String xml = null;

		if (objectAPIs != null && objectAPIs.size() > 0)
		{
			xml += "<list currentpointer=\"0\">";

			// Go through each object and serialize it into the list
			for (ObjectAPI objectAPI : objectAPIs)
			{
				xml += serializeObjectData(objectAPI, typeElementResponse);
			}

			xml += "</list>";
		}

		return xml;
	}

	public static String serializeObjectData(ObjectAPI objectAPI, TypeElementResponseAPI typeElementResponse) throws Exception
	{
		String xml = null;
		String internalId = null;
		String externalId = null;

		if (objectAPI.getInternalId() != null && objectAPI.getInternalId().trim().length() > 0)
		{
			internalId = objectAPI.getInternalId();
		}
		else
		{
			internalId = UUID.randomUUID().toString();
		}

		if (objectAPI.getExternalId() != null && objectAPI.getExternalId().trim().length() > 0)
		{
			externalId = objectAPI.getExternalId();
		}
		else
		{
			externalId = UUID.randomUUID().toString();
		}

		xml = "";
		xml += "<complextype internalid=\"" + internalId + "\" externalid=\"" + externalId + "\" typeelementid=\"" + typeElementResponse.getId() + "\">";

		if (objectAPI.getProperties() != null && objectAPI.getProperties().size() > 0)
		{
			for (PropertyAPI propertyAPI : objectAPI.getProperties())
			{
				boolean typeElementEntryFound = false;
				String typeElementEntryId = null;
				String contentType = null;

				if (typeElementResponse.getProperties() != null && typeElementResponse.getProperties().size() > 0)
				{
					for (TypeElementPropertyAPI typeElementEntryAPI : typeElementResponse.getProperties())
					{
						if (typeElementEntryAPI.getDeveloperName().equalsIgnoreCase(propertyAPI.getDeveloperName()) == true)
						{
							typeElementEntryId = typeElementEntryAPI.getId();
							contentType = typeElementEntryAPI.getContentType();

							typeElementEntryFound = true;
							break;
						}
					}
				}

				if (typeElementEntryFound == false)
				{
					throw new Exception("Type element entry could not be found.");
				}

				xml += "<complextypeentry typeelemententryid=\"" + typeElementEntryId + "\" contenttype=\"" + contentType + "\">";

				if (contentType.equalsIgnoreCase(ManyWhoConstants.CONTENT_TYPE_OBJECT) == true)
				{
					throw new Exception("Object properties not supported yet.");
				}
				else if (contentType.equalsIgnoreCase(ManyWhoConstants.CONTENT_TYPE_LIST) == true)
				{
					throw new Exception("List properties not supported yet.");
				}
				else
				{
					// Wrap primitive values in cdata so we don't screw up the xml document with invalid markup
					xml += "<![CDATA[" + propertyAPI.getContentValue() + "]]>";
				}

				xml += "</complextypeentry>";
			}
		}

		xml += "</complextype>";

		return xml;
	}
}