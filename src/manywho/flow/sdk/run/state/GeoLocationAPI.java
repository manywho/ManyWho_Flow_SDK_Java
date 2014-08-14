package manywho.flow.sdk.run.state;

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

public class GeoLocationAPI extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 1L;

	private java.math.BigDecimal privatelatitude = new java.math.BigDecimal(0);
	public final java.math.BigDecimal getLatitude()
	{
		return privatelatitude;
	}
	public final void setLatitude(java.math.BigDecimal value)
	{
		privatelatitude = value;
	}

	private java.math.BigDecimal privatelongitude = new java.math.BigDecimal(0);
	public final java.math.BigDecimal getLongitude()
	{
		return privatelongitude;
	}
	public final void setLongitude(java.math.BigDecimal value)
	{
		privatelongitude = value;
	}

	private java.math.BigDecimal privateaccuracy = new java.math.BigDecimal(0);
	public final java.math.BigDecimal getAccuracy()
	{
		return privateaccuracy;
	}
	public final void setAccuracy(java.math.BigDecimal value)
	{
		privateaccuracy = value;
	}

	private java.math.BigDecimal privatealtitude = new java.math.BigDecimal(0);
	public final java.math.BigDecimal getAltitude()
	{
		return privatealtitude;
	}
	public final void setAltitude(java.math.BigDecimal value)
	{
		privatealtitude = value;
	}

	private java.math.BigDecimal privatealtitudeAccuracy = new java.math.BigDecimal(0);
	public final java.math.BigDecimal getAltitudeAccuracy()
	{
		return privatealtitudeAccuracy;
	}
	public final void setAltitudeAccuracy(java.math.BigDecimal value)
	{
		privatealtitudeAccuracy = value;
	}

	private java.math.BigDecimal privateheading = new java.math.BigDecimal(0);
	public final java.math.BigDecimal getHeading()
	{
		return privateheading;
	}
	public final void setHeading(java.math.BigDecimal value)
	{
		privateheading = value;
	}

	private java.math.BigDecimal privatespeed = new java.math.BigDecimal(0);
	public final java.math.BigDecimal getSpeed()
	{
		return privatespeed;
	}
	public final void setSpeed(java.math.BigDecimal value)
	{
		privatespeed = value;
	}

	private java.util.Date privatetime = new java.util.Date(0);
	public final java.util.Date getTime()
	{
		return privatetime;
	}
	public final void setTime(java.util.Date value)
	{
		privatetime = value;
	}
}