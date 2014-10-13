package manywho.flow.sdk.security;

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

public interface IGeoLocation
{
	java.util.Date getTimeStamp();
	void setTimeStamp(java.util.Date value);

	java.math.BigDecimal getLatitude();
	void setLatitude(java.math.BigDecimal value);

	java.math.BigDecimal getLongitude();
	void setLongitude(java.math.BigDecimal value);

	java.math.BigDecimal getAccuracy();
	void setAccuracy(java.math.BigDecimal value);

	java.math.BigDecimal getAltitude();
	void setAltitude(java.math.BigDecimal value);

	java.math.BigDecimal getAltitudeAccuracy();
	void setAltitudeAccuracy(java.math.BigDecimal value);

	java.math.BigDecimal getHeading();
	void setHeading(java.math.BigDecimal value);

	java.math.BigDecimal getSpeed();
	void setSpeed(java.math.BigDecimal value);
}