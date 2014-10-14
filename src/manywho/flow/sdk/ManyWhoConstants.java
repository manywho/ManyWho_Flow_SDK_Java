package manywho.flow.sdk;

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

public class ManyWhoConstants
{
	// Engine invoke constants
	public static final String INVOKE_TYPE_FORWARD = "FORWARD";
	// Tells the caller that the flow has completed - no more steps
	public static final String INVOKE_TYPE_DONE = "DONE";
	// Tells the engine we want to join the running flow - this is used internally only - "STATUS" is used externally as we infer a "JOIN" from the GET request
	public static final String INVOKE_TYPE_JOIN = "JOIN";
	// Tells the user we're waiting for something on the system side to complete
	public static final String INVOKE_TYPE_WAIT = "WAIT";
	// Tells the engine that the system didn't let them in for some reason - most likely authentication, but it could be some
	// other reason as we develop out various grouping use-cases.  This basically says: try again if you like!
	public static final String INVOKE_TYPE_STATUS = "STATUS";
	// Tells any calling services that they no longer need to send the message for that token - their message was accepted
	// by the message action
	public static final String INVOKE_TYPE_SUCCESS = "SUCCESS";
	// Tells any calling services that the token has already completed - so they should stop sending messages
	public static final String INVOKE_TYPE_TOKEN_COMPLETED = "TOKEN_COMPLETED";
	// Tells the engine to sync the data, but not to shut down the optimize memory or execute - this brings in the social
	// element to the engine
	public static final String INVOKE_TYPE_SYNC = "SYNC";
	// Tells the engine that the user has clicked on something in the navigation as opposed to an outcome
	public static final String INVOKE_TYPE_NAVIGATE = "NAVIGATE";

	// Engine mode constants
	public static final String MODE_DEFAULT = null;
	public static final String MODE_LOG = "LOG";
	public static final String MODE_DEBUG = "DEBUG";
	public static final String MODE_DEBUG_STEPTHROUGH = "DEBUG_STEPTHROUGH";

	// Reporting mode constants
	public static final String REPORT_NONE = null;
	public static final String REPORT_VALUES = "VALUES";
	public static final String REPORT_PATH = "PATH";
	public static final String REPORT_PATH_AND_VALUES = "PATH_AND_VALUES";

	// Content Value Implementation constants
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_DETACH = "DETACH"; // Removes the external identifier from the root object only
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_EMPTY = "EMPTY"; // blanks out the complex object or table with a null value
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_NEW = "NEW"; // creates a new whole complex object or table
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_UPDATE = "ADD"; // adds a complex object to the table or updates the existing one in the table or adds to a value
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_REMOVE = "REMOVE"; // removes a complex object from the table or from the value (subtract)
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_GET_FIRST = "GET_FIRST"; // getS the first complex object in the table
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_GET_NEXT = "GET_NEXT"; // getS the next complex object in the table
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_FILTER = "FILTER";
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_GET_LENGTH = "GET_LENGTH"; // getS the length of a list, string, content or password

	// These are the command properties associated with the filter
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_PROPERTY_FILTER_COLUMN = "COLUMN";
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_PROPERTY_FILTER_CRITERIA = "CRITERIA";
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_PROPERTY_FILTER_VALUE = "VALUE";
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_PROPERTY_FILTER_CONTENT_TYPE = "CONTENT_TYPE";
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_PROPERTY_FILTER_SHARED_ELEMENT_CONTENT_VALUE_TO_REFERENCE_ID = "SHARED_ELEMENT_CONTENT_VALUE_TO_REFERENCE_ID";
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_PROPERTY_FILTER_SHARED_ELEMENT_CONTENT_VALUE_TO_REFERENCE_TYPE_ELEMENT_ENTRY_ID = "SHARED_ELEMENT_CONTENT_VALUE_TO_REFERENCE_TYPE_ELEMENT_ENTRY_ID";
	public static final String CONTENT_VALUE_IMPLEMENTATION_BASE_COMMAND_PROPERTY_FILTER_SHARED_ELEMENT_CONTENT_VALUE_TO_REFERENCE_COMMAND = "SHARED_ELEMENT_CONTENT_VALUE_TO_REFERENCE_COMMAND";

	// Criteria for content values
	public static final String CONTENT_VALUE_IMPLEMENTATION_CRITERIA_TYPE_EQUAL = "EQUAL";
	public static final String CONTENT_VALUE_IMPLEMENTATION_CRITERIA_TYPE_NOT_EQUAL = "NOT_EQUAL";
	public static final String CONTENT_VALUE_IMPLEMENTATION_CRITERIA_TYPE_GREATER_THAN = "GREATER_THAN";
	public static final String CONTENT_VALUE_IMPLEMENTATION_CRITERIA_TYPE_GREATER_THAN_OR_EQUAL = "GREATER_THAN_OR_EQUAL";
	public static final String CONTENT_VALUE_IMPLEMENTATION_CRITERIA_TYPE_LESS_THAN = "LESS_THAN";
	public static final String CONTENT_VALUE_IMPLEMENTATION_CRITERIA_TYPE_LESS_THAN_OR_EQUAL = "LESS_THAN_OR_EQUAL";
	public static final String CONTENT_VALUE_IMPLEMENTATION_CRITERIA_TYPE_CONTAINS = "CONTAINS";
	public static final String CONTENT_VALUE_IMPLEMENTATION_CRITERIA_TYPE_STARTS_WITH = "STARTS_WITH";
	public static final String CONTENT_VALUE_IMPLEMENTATION_CRITERIA_TYPE_ENDS_WITH = "ENDS_WITH";
	public static final String CONTENT_VALUE_IMPLEMENTATION_CRITERIA_TYPE_IS_EMPTY = "IS_EMPTY";

	// Constants for the various content types
	public static final String CONTENT_TYPE_DATETIME = "ContentDateTime";
	public static final String CONTENT_TYPE_NUMBER = "ContentNumber";
	public static final String CONTENT_TYPE_OBJECT = "ContentObject";
	public static final String CONTENT_TYPE_PASSWORD = "ContentPassword";
	public static final String CONTENT_TYPE_STRING = "ContentString";
	public static final String CONTENT_TYPE_LIST = "ContentList";
	public static final String CONTENT_TYPE_BOOLEAN = "ContentBoolean";
	public static final String CONTENT_TYPE_CONTENT = "ContentContent";

	// Content parser strings
	public static final String EMBEDDED_KEY_START_INTERNAL = "flowkey___";
	public static final String EMBEDDED_KEY_FINISH_INTERNAL = "___flowkey";
	public static final String EMBEDDED_KEY_START_EXTERNAL = "{!";
	public static final String EMBEDDED_KEY_FINISH_EXTERNAL = "}";
	public static final String EMBEDDED_KEY_ELEMENT_PART_WITH_SPACE_START_EXTERNAL = "[";
	public static final String EMBEDDED_KEY_ELEMENT_PART_WITH_SPACE_FINISH_EXTERNAL = "]";
	public static final String EMBEDDED_KEY_ELEMENT_PART_SEPARATOR = "].[";

	// Authenticated User constants
	public static final String AUTHENTICATED_USER_STATUS_ACCESS_DENIED = "ACCESS_DENIED";
	public static final String AUTHENTICATED_USER_STATUS_AUTHENTICATED = "AUTHENTICATED";
	public static final String AUTHENTICATED_USER_KEY_TOKEN = "TOKEN";
	public static final String AUTHENTICATED_USER_KEY_DIRECTORY_ID = "DIRECTORY_ID";
	public static final String AUTHENTICATED_USER_PUBLIC_DIRECTORY_ID = "UNAUTHENTICATED";
	public static final String AUTHENTICATED_USER_PUBLIC_DIRECTORY_NAME = "UNKNOWN";
	public static final String AUTHENTICATED_USER_PUBLIC_EMAIL = "admin@manywho.com";
	public static final String AUTHENTICATED_USER_PUBLIC_TENANT_NAME = "UNKNOWN";
	public static final String AUTHENTICATED_USER_PUBLIC_USER_ID = "PUBLIC_USER";
	public static final String AUTHENTICATED_USER_PUBLIC_IDENTITY_PROVIDER = "NONE";
	public static final String AUTHENTICATED_USER_PUBLIC_STATUS = "UKNOWN";
	public static final String AUTHENTICATED_USER_PUBLIC_TOKEN = "NONE";

	public static final String AUTHENTICATED_WHO_TOKEN_MANYWHO_TENANT_ID = "ManyWhoTenantId";
	public static final String AUTHENTICATED_WHO_TOKEN_MANYWHO_USER_ID = "ManyWhoUserId";
	public static final String AUTHENTICATED_WHO_TOKEN_MANYWHO_TOKEN = "ManyWhoToken";
	public static final String AUTHENTICATED_WHO_TOKEN_DIRECTORY_ID = "DirectoryId";
	public static final String AUTHENTICATED_WHO_TOKEN_DIRECTORY_NAME = "DirectoryName";
	public static final String AUTHENTICATED_WHO_TOKEN_EMAIL = "Email";
	public static final String AUTHENTICATED_WHO_TOKEN_IDENTITY_PROVIDER = "IdentityProvider";
	public static final String AUTHENTICATED_WHO_TOKEN_TENANT_NAME = "TenantName";
	public static final String AUTHENTICATED_WHO_TOKEN_TOKEN = "Token";
	public static final String AUTHENTICATED_WHO_TOKEN_USER_ID = "UserId";
	public static final String AUTHENTICATED_WHO_TOKEN_USERNAME = "Username";
	public static final String AUTHENTICATED_WHO_TOKEN_FIRST_NAME = "FirstName";
	public static final String AUTHENTICATED_WHO_TOKEN_LAST_NAME = "LastName";

	public static final char SERIALIZATION_DELIMITER_DELIMITER = '=';

	public static final String CULTURE_TOKEN_BRAND = "Brand";
	public static final String CULTURE_TOKEN_COUNTRY = "Country";
	public static final String CULTURE_TOKEN_LANGUAGE = "Language";
	public static final String CULTURE_TOKEN_VARIANT = "Variant";

	public static final String MANYWHO_JOIN_URI_VALUE_ID = "E2063196-3C75-4388-8B00-1005B8CD59AD";
	public static final String MANYWHO_JOIN_URI_DEVELOPER_NAME = "$JoinUri";

	public static final String MANYWHO_USER_VALUE_ID = "03DC41DD-1C6B-4B33-BF61-CBD1D0778FFF";
	public static final String MANYWHO_USER_VALUE_DEVELOPER_NAME = "$RunningUser";

	public static final String MANYWHO_USER_TYPE_ELEMENT_ID = "2674CE95-DD99-42C6-96FC-AD12E1B48A69";
	public static final String MANYWHO_USER_PROPERTY_ID_USER_ID = "90262141-02B2-4F2C-8107-B14CF859DE4D";
	public static final String MANYWHO_USER_PROPERTY_ID_USERNAME = "D8839B46-C43B-4435-9395-BD00491DA16E";
	public static final String MANYWHO_USER_PROPERTY_ID_EMAIL = "601DDC6A-FFF4-478B-ABE4-C4E65BC901C6";
	public static final String MANYWHO_USER_PROPERTY_ID_FIRST_NAME = "6E1D4D49-AB0D-4475-9488-CF4A71D36BEB";
	public static final String MANYWHO_USER_PROPERTY_ID_LAST_NAME = "E525AAAE-C900-47FC-9A20-D10C52CFC203";
	public static final String MANYWHO_USER_PROPERTY_ID_LANGUAGE = "88EC74A3-B75D-4C1C-89E4-D142159FD5E4";
	public static final String MANYWHO_USER_PROPERTY_ID_BRAND = "641F4870-8BF6-4CD9-9654-2AA04C542F43";
	public static final String MANYWHO_USER_PROPERTY_ID_VARIANT = "A20A1786-7318-4688-81EC-738337442C56";
	public static final String MANYWHO_USER_PROPERTY_ID_COUNTRY = "4FB64B42-A370-455E-85ED-D9A0A8723A43";
	public static final String MANYWHO_USER_PROPERTY_ID_LOCATION = "4FA61B42-A370-455E-85ED-D9A0A8723A43";
	public static final String MANYWHO_USER_PROPERTY_ID_DIRECTORY_ID = "4FA61B52-A370-455E-85ED-D9A0A8723A43";
	public static final String MANYWHO_USER_PROPERTY_ID_DIRECTORY_NAME = "4FA61B45-A370-455E-85ED-D9A0A8723A43";
	public static final String MANYWHO_USER_PROPERTY_ID_STATUS = "4FA61B46-A370-455E-85ED-D9A0A8723A43";
	public static final String MANYWHO_USER_PROPERTY_ID_AUTHENTICATION_TYPE = "4FA61B47-A370-455E-85ED-D9A0A8723A43";
	public static final String MANYWHO_USER_PROPERTY_ID_LOGIN_URL = "4FA61B48-A370-455E-85ED-D9A0A8723A43";

	public static final String MANYWHO_LOCATION_TYPE_ELEMENT_ID = "7834CE95-DD99-42C6-96FC-AD12E1B48A69";
	public static final String MANYWHO_LOCATION_PROPERTY_ID_TIMESTAMP = "FFC4CBD6-FA28-4141-95A4-DA9BACDB0203";
	public static final String MANYWHO_LOCATION_PROPERTY_ID_LATITUDE = "9270A449-9AD5-4C57-B952-DC4551210ABA";
	public static final String MANYWHO_LOCATION_PROPERTY_ID_LONGITUDE = "0A198B4B-1890-4B3B-B09C-E215C7C1458B";
	public static final String MANYWHO_LOCATION_PROPERTY_ID_ACCURACY = "4DB3CE7A-E758-4202-B2E5-E2A21C2A25FD";
	public static final String MANYWHO_LOCATION_PROPERTY_ID_ALTITUDE = "6242AA3F-2796-42ED-9262-EF77EE7405E2";
	public static final String MANYWHO_LOCATION_PROPERTY_ID_ALTITUDE_ACCURACY = "A68965D6-0461-4EFE-8F63-F05C406E6F2B";
	public static final String MANYWHO_LOCATION_PROPERTY_ID_HEADING = "6F0BEE99-ECFB-4B63-A034-F7807244C2B8";
	public static final String MANYWHO_LOCATION_PROPERTY_ID_SPEED = "22C772BF-7BC2-4EC3-A44A-F8387751D32C";

	public static final String MANYWHO_FILE_TYPE_ELEMENT_ID = "AF48E652-7DEC-4739-9C98-586318E0AD7D";
	public static final String MANYWHO_FILE_PROPERTY_ID_KIND = "71D7AAC8-B7E5-4256-9798-103A1E52A12E";
	public static final String MANYWHO_FILE_PROPERTY_ID_ID = "DC10DDB5-2215-45AE-8DED-18C698B01FF3";
	public static final String MANYWHO_FILE_PROPERTY_ID_MIME_TYPE = "F92D410D-7F94-4995-A20E-1A58791D0D65";
	public static final String MANYWHO_FILE_PROPERTY_ID_NAME = "CC134A57-EB16-47C0-A455-22CA0D1581F9";
	public static final String MANYWHO_FILE_PROPERTY_ID_DESCRIPTION = "7E57D810-F4E0-4D54-8066-2C017180E0FF";
	public static final String MANYWHO_FILE_PROPERTY_ID_DATE_CREATED = "82D5584D-0B6B-4D30-85E0-2F4A947324E7";
	public static final String MANYWHO_FILE_PROPERTY_ID_DATE_MODIFIED = "A942BC5C-D59D-4010-86D0-31F23F822855";
	public static final String MANYWHO_FILE_PROPERTY_ID_DOWNLOAD_URI = "6611067A-7C86-4696-8845-3CDC79C73289";
	public static final String MANYWHO_FILE_PROPERTY_ID_EMBED_URI = "C063EC28-9053-4D0B-A93B-4470F6CE4B8C";
	public static final String MANYWHO_FILE_PROPERTY_ID_ICON_URI = "DC906ACB-A270-4E95-9118-463FA8B5726C";

	public static final String MANYWHO_GROUP_TYPE_ELEMENT_ID = "82DE6847-03D6-4ACE-91CC-26CD80AEA9FC";
	public static final String MANYWHO_GROUP_PROPERTY_ID_GROUP_ID = "1CADAB68-658C-4F52-972E-FAB83F168D87";
	public static final String MANYWHO_GROUP_PROPERTY_ID_GROUP_NAME = "D04652C0-B87C-400D-BEAC-FBC2420774BC";
	public static final String MANYWHO_GROUP_PROPERTY_ID_GROUP_OWNER_USER_ID = "3B74EB51-74A8-43B3-96EF-FEEB938D35D2";

	public static final String MANYWHO_GROUP_DEVELOPER_NAME = "$Group";
	public static final String MANYWHO_GROUP_PROPERTY_GROUP_ID = "Group ID";
	public static final String MANYWHO_GROUP_PROPERTY_GROUP_NAME = "Group Name";
	public static final String MANYWHO_GROUP_PROPERTY_GROUP_OWNER_USER_ID = "Group Owner User ID";

	// Service description constants
	public static final String SERVICE_DESCRIPTION_VALUE_TABLE_NAME = "TableName";

	// Plugin constants
	public static final String SERVICE_REQUEST_FORM_POST_KEY = "ServiceRequest";
	public static final String FILE_DATA_REQUEST_FORM_POST_KEY = "FileDataRequest";

	// Authentication constants
	//public const String OBJECT_TYPE_GROUP_AUTHORIZATION_GROUP = "GroupAuthorizationGroup";
	public static final String AUTHENTICATION_GROUP_AUTHORIZATION_GROUP_OBJECT_DEVELOPER_NAME = "GroupAuthorizationGroup";
	public static final String AUTHENTICATION_GROUP_AUTHORIZATION_USER_OBJECT_DEVELOPER_NAME = "GroupAuthorizationUser";
	//public const String SERVICE_VALUE_AUTHENTICATION_ID = "AuthenticationId";
	public static final String AUTHENTICATION_OBJECT_AUTHENTICATION_ID = "AuthenticationId";
	//public const String SERVICE_VALUE_FRIENDLY_NAME = "FriendlyName";
	public static final String AUTHENTICATION_OBJECT_FRIENDLY_NAME = "FriendlyName";
	public static final String AUTHENTICATION_OBJECT_DEVELOPER_SUMMARY = "DeveloperSummary";

	public static final String AUTHENTICATION_ATTRIBUTE_LABEL = "Label";
	public static final String AUTHENTICATION_ATTRIBUTE_VALUE = "Value";
	public static final String AUTHENTICATION_AUTHENTICATION_ATTRIBUTE_OBJECT_DEVELOPER_NAME = "AuthenticationAttribute";

	// Group Authorization constants
	public static final String GROUP_AUTHORIZATION_GLOBAL_AUTHENTICATION_TYPE_PUBIC = "PUBLIC";
	public static final String GROUP_AUTHORIZATION_GLOBAL_AUTHENTICATION_TYPE_ALL_USERS = "ALL_USERS";
	public static final String GROUP_AUTHORIZATION_GLOBAL_AUTHENTICATION_TYPE_SPECIFIED = "SPECIFIED";
	public static final String GROUP_AUTHORIZATION_STREAM_BEHAVIOUR_USE_EXISTING = "USE_EXISTING";
	public static final String GROUP_AUTHORIZATION_STREAM_BEHAVIOUR_CREATE_NEW = "CREATE_NEW";
	public static final String GROUP_AUTHORIZATION_STREAM_BEHAVIOUR_NONE = "NONE";
	public static final String GROUP_AUTHORIZATION_USER = "USER";

	// List Filter Config constants
	public static final String LIST_FILTER_CONFIG_ORDER_BY_ASCENDING = "ASC";
	public static final String LIST_FILTER_CONFIG_ORDER_BY_DESCENDING = "DESC";
	public static final String LIST_FILTER_CONFIG_COMPARISON_TYPE_AND = "AND";
	public static final String LIST_FILTER_CONFIG_COMPARISON_TYPE_OR = "OR";

	// Page Container constants
	public static final String PAGE_CONTAINER_CONTAINER_TYPE_VERTICAL_FLOW = "VERTICAL_FLOW";
	public static final String PAGE_CONTAINER_CONTAINER_TYPE_HORIZONTAL_FLOW = "HORIZONTAL_FLOW";
	public static final String PAGE_CONTAINER_CONTAINER_TYPE_GROUP = "GROUP";

	// Constants for property names for objects being returned for user context
	public static final String MANYWHO_USER_DEVELOPER_NAME = "$User";

	public static final String MANYWHO_USER_PROPERTY_USER_ID = "User ID";
	public static final String MANYWHO_USER_PROPERTY_USERNAME = "Username";
	public static final String MANYWHO_USER_PROPERTY_EMAIL = "Email";
	public static final String MANYWHO_USER_PROPERTY_FIRST_NAME = "First Name";
	public static final String MANYWHO_USER_PROPERTY_LAST_NAME = "Last Name";
	public static final String MANYWHO_USER_PROPERTY_LANGUAGE = "Language";
	public static final String MANYWHO_USER_PROPERTY_COUNTRY = "Country";
	public static final String MANYWHO_USER_PROPERTY_BRAND = "Brand";
	public static final String MANYWHO_USER_PROPERTY_VARIANT = "Variant";
	public static final String MANYWHO_USER_PROPERTY_LOCATION = "Location";
	public static final String MANYWHO_USER_PROPERTY_DIRECTORY_ID = "Directory Id";
	public static final String MANYWHO_USER_PROPERTY_DIRECTORY_NAME = "Directory Name";
	public static final String MANYWHO_USER_PROPERTY_STATUS = "Status";
	public static final String MANYWHO_USER_PROPERTY_AUTHENTICATION_TYPE = "AuthenticationType";
	public static final String MANYWHO_USER_PROPERTY_LOGIN_URL = "LoginUrl";

	public static final String MANYWHO_LOCATION_DEVELOPER_NAME = "$Location";

	public static final String MANYWHO_LOCATION_PROPERTY_TIMESTAMP = "Location Timestamp";
	public static final String MANYWHO_LOCATION_PROPERTY_LATITUDE = "Current Latitude";
	public static final String MANYWHO_LOCATION_PROPERTY_LONGITUDE = "Current Longitude";
	public static final String MANYWHO_LOCATION_PROPERTY_ACCURACY = "Location Accuracy";
	public static final String MANYWHO_LOCATION_PROPERTY_ALTITUDE = "Current Altitude";
	public static final String MANYWHO_LOCATION_PROPERTY_ALTITUDE_ACCURACY = "Altitude Accuracy";
	public static final String MANYWHO_LOCATION_PROPERTY_HEADING = "Current Heading";
	public static final String MANYWHO_LOCATION_PROPERTY_SPEED = "Current Speed";

	public static final String MANYWHO_FILE_DEVELOPER_NAME = "$File";

	public static final String MANYWHO_FILE_PROPERTY_KIND = "Kind";
	public static final String MANYWHO_FILE_PROPERTY_ID = "Id";
	public static final String MANYWHO_FILE_PROPERTY_MIME_TYPE = "Mime Type";
	public static final String MANYWHO_FILE_PROPERTY_NAME = "Name";
	public static final String MANYWHO_FILE_PROPERTY_DESCRIPTION = "Description";
	public static final String MANYWHO_FILE_PROPERTY_DATE_CREATED = "Date Created";
	public static final String MANYWHO_FILE_PROPERTY_DATE_MODIFIED = "Date Modified";
	public static final String MANYWHO_FILE_PROPERTY_DOWNLOAD_URI = "Download Uri";
	public static final String MANYWHO_FILE_PROPERTY_EMBED_URI = "Embed Uri";
	public static final String MANYWHO_FILE_PROPERTY_ICON_URI = "Icon Uri";

	public static final String AUTHORIZATION_STATUS_NOT_AUTHORIZED = "401";
	public static final String AUTHORIZATION_STATUS_AUTHORIZED = "200";

	// The API name for service elements
	public static final String SERVICE_ELEMENT_TYPE_IMPLEMENTATION_SERVICE = "SERVICE";

	// The API name for shared elements
	public static final String SHARED_ELEMENT_TYPE_IMPLEMENTATION_VALUE = "VALUE";
	public static final String SHARED_ELEMENT_TYPE_IMPLEMENTATION_VARIABLE = "VARIABLE";
	public static final String SHARED_ELEMENT_TYPE_IMPLEMENTATION_CONSTANT = "CONSTANT";
	public static final String SHARED_ELEMENT_TYPE_IMPLEMENTATION_RESOURCE = "RESOURCE";
	public static final String SHARED_ELEMENT_TYPE_IMPLEMENTATION_FUNCTION = "FUNCTION";
	public static final String SHARED_ELEMENT_TYPE_IMPLEMENTATION_TABLE = "TABLE";
	public static final String SHARED_ELEMENT_TYPE_IMPLEMENTATION_CONNECTION = "CONNECTION";
	public static final String SHARED_ELEMENT_TYPE_IMPLEMENTATION_MACRO = "MACRO";

	// Access values for shared elements
	public static final String ACCESS_PRIVATE = "PRIVATE";
	public static final String ACCESS_INPUT = "INPUT";
	public static final String ACCESS_OUTPUT = "OUTPUT";
	public static final String ACCESS_INPUT_OUTPUT = "INPUT_OUTPUT";

	// Component types for pages
	public static final String COMPONENT_TYPE_CONTENT = "CONTENT";
	public static final String COMPONENT_TYPE_INPUTBOX = "INPUT";
	public static final String COMPONENT_TYPE_TEXTBOX = "TEXTAREA";
	public static final String COMPONENT_TYPE_COMBOBOX = "SELECT";
	public static final String COMPONENT_TYPE_CHECKBOX = "CHECKBOX";
	public static final String COMPONENT_TYPE_TABLE = "TABLE";
	public static final String COMPONENT_TYPE_PRESENTATION = "PRESENTATION";
	public static final String COMPONENT_TYPE_TAG = "TAG";
	public static final String COMPONENT_TYPE_IMAGE = "IMAGE";
	public static final String COMPONENT_TYPE_FILES = "FILES";

	// Container types for pages
	public static final String CONTAINER_TYPE_VERTICAL_FLOW = "VERTICAL_FLOW";
	public static final String CONTAINER_TYPE_HORIZONTAL_FLOW = "HORIZONTAL_FLOW";
	public static final String CONTAINER_TYPE_INLINE_FLOW = "INLINE_FLOW";
	public static final String CONTAINER_TYPE_GROUP = "GROUP";

	// Action bindings for map elements
	public static final String ACTION_BINDING_SAVE = "SAVE";
	public static final String ACTION_BINDING_NO_SAVE = "NO_SAVE";

	// Action types for map elements
	public static final String ACTION_TYPE_NEW = "NEW";
	public static final String ACTION_TYPE_QUERY = "QUERY";
	public static final String ACTION_TYPE_INSERT = "INSERT";
	public static final String ACTION_TYPE_UPDATE = "UPDATE";
	public static final String ACTION_TYPE_UPSERT = "UPSERT";
	public static final String ACTION_TYPE_DELETE = "DELETE";
	public static final String ACTION_TYPE_REMOVE = "REMOVE";
	public static final String ACTION_TYPE_ADD = "ADD";
	public static final String ACTION_TYPE_EDIT = "EDIT";
	public static final String ACTION_TYPE_NEXT = "NEXT";
	public static final String ACTION_TYPE_BACK = "BACK";
	public static final String ACTION_TYPE_DONE = "DONE";
	public static final String ACTION_TYPE_SAVE = "SAVE";
	public static final String ACTION_TYPE_CANCEL = "CANCEL";
	public static final String ACTION_TYPE_APPLY = "APPLY";
	public static final String ACTION_TYPE_IMPORT = "IMPORT";
	public static final String ACTION_TYPE_CLOSE = "CLOSE";
	public static final String ACTION_TYPE_OPEN = "OPEN";
	public static final String ACTION_TYPE_SUBMIT = "SUBMIT";
	public static final String ACTION_TYPE_ESCALATE = "ESCALATE";
	public static final String ACTION_TYPE_REJECT = "REJECT";
	public static final String ACTION_TYPE_DELEGATE = "DELEGATE";

	// The API name for page layouts
	public static final String UI_ELEMENT_TYPE_IMPLEMENTATION_PAGE_LAYOUT = "PAGE_LAYOUT";

	// The API name for navigations
	public static final String UI_ELEMENT_TYPE_IMPLEMENTATION_NAVIGATION = "NAVIGATION";

	// The API name for map elements
	public static final String MAP_ELEMENT_TYPE_IMPLEMENTATION_START = "START";
	public static final String MAP_ELEMENT_TYPE_IMPLEMENTATION_STEP = "STEP";
	public static final String MAP_ELEMENT_TYPE_IMPLEMENTATION_INPUT = "INPUT";
	public static final String MAP_ELEMENT_TYPE_IMPLEMENTATION_DECISION = "DECISION";
	public static final String MAP_ELEMENT_TYPE_IMPLEMENTATION_OPERATOR = "OPERATOR";
	public static final String MAP_ELEMENT_TYPE_IMPLEMENTATION_SUB_FLOW = "SUB_FLOW";
	public static final String MAP_ELEMENT_TYPE_IMPLEMENTATION_DATABASE_LOAD = "DATABASE_LOAD";
	public static final String MAP_ELEMENT_TYPE_IMPLEMENTATION_DATABASE_SAVE = "DATABASE_SAVE";
	public static final String MAP_ELEMENT_TYPE_IMPLEMENTATION_DATABASE_DELETE = "DATABASE_DELETE";
	public static final String MAP_ELEMENT_TYPE_IMPLEMENTATION_MESSAGE = "MESSAGE";
	public static final String MAP_ELEMENT_TYPE_IMPLEMENTATION_PAGE = "PAGE";

	// The API name for group elements
	public static final String GROUP_ELEMENT_TYPE_IMPLEMENTATION_SWIMLANE = "SWIMLANE";

	// The API name for tags
	public static final String UI_ELEMENT_TYPE_IMPLEMENTATION_TAG = "TAG";

	// The API name for types
	public static final String TYPE_ELEMENT_TYPE_IMPLEMENTATION_TYPE = "TYPE";

	// Post update types
	public static final String POST_UPDATE_WHEN_ON_LOAD = "ON_LOAD";
	public static final String POST_UPDATE_WHEN_ON_EXIT = "ON_EXIT";

	// Guids for the reserved outcomes for faults and debug
	public static final String DEBUG_GUID = "EE6C8827-11E2-486D-B5FA-4D1A0CBB77A3";
	public static final String FAULT_GUID = "318B0F3A-A570-4C5D-835C-21C1EEB17787";

	// Outcomes with a fault
	public static final String FAULT_DEVELOPER_NAME = "FAULT";

	// The authentication types that are currently supported
	public static final String AUTHENTICATION_TYPE_USERNAME_PASSWORD = "USERNAME_PASSWORD";
	public static final String AUTHENTICATION_TYPE_OAUTH2 = "OAUTH2";

	public static final String PROPERTY_SEARCH = "PROPERTY:";
	public static final String EXACT_SEARCH = "EXACT:";
}