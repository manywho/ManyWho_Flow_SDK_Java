package com.manywho.sdk.old.security;

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

public interface IAuthenticatedWho
{
	/** 
	 The unique identifier for the user in ManyWho.
	*/
	String getManyWhoUserId();
	void setManyWhoUserId(String value);

	/** 
	 The unique identifier for the tenant in ManyWho.  If logging in as a runtime user, this will be blank.  This field is only required for users
	 logging in to build flows as it will be used for all filtering of elements.
	*/
	String getManyWhoTenantId();
	void setManyWhoTenantId(String value);

	/** 
	 The authentication token used by ManyWho.
	*/
	String getManyWhoToken();
	void setManyWhoToken(String value);

	/** 
	 The current geo location of the user making the request.  This object can be null depending on the permissions accepted by the end user.
	*/
	IGeoLocation getGeoLocation();
	void setGeoLocation(IGeoLocation value);

	/** 
	 The user identifier as provided post authentication and authorization with the service.
	*/
	String getUserId();
	void setUserId(String value);

	/** 
	 The username provided at login with the service.
	*/
	String getUsername();
	void setUsername(String value);

	/** 
	 The identifier provider as provided post authentication and authorization with the service.
	*/
	String getIdentityProvider();
	void setIdentityProvider(String value);

	/** 
	 The token as provided post authentication and authorization with the service.
	*/
	String getToken();
	void setToken(String value);

	/** 
	 The name of the tenant being logged into.
	*/
	String getTenantName();
	void setTenantName(String value);

	/** 
	 The name of the remote directory that was used to perform the login.
	*/
	String getDirectoryName();
	void setDirectoryName(String value);

	/** 
	 The unique identifier for the directory.
	*/
	String getDirectoryId();
	void setDirectoryId(String value);

	/** 
	 The validated email address for this user.
	*/
	String getEmail();
	void setEmail(String value);

	/** 
	 The first name for this user.
	*/
	String getFirstName();
	void setFirstName(String value);

	/** 
	 The last name for this user.
	*/
	String getLastName();
	void setLastName(String value);
}