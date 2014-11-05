package com.manywho.sdk.old.utils;

public class RunUtils
{
	public static String completeJoinUrl(String url, String stateId)
	{
		if (url.indexOf('?') > 0)
		{
			url += "&join=" + stateId;
		}
		else
		{
			url += "?join=" + stateId;
		}

		return url;
	}

	public static String completeRunUrl(String url, String flowId)
	{
		if (url.indexOf('?') > 0)
		{
			url += "&flow-id=" + flowId;
		}
		else
		{
			url += "?flow-id=" + flowId;
		}

		return url;
	}
}