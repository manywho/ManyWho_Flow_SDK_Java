package manywho.flow.sdk.run.state;

public class UserInteractionAPI extends GeoLocationAPI
{
	private static final long serialVersionUID = 1L;

	private String privatemanywhoUserId;
	public final String getManyWhoUserId()
	{
		return privatemanywhoUserId;
	}
	public final void setManyWhoUserId(String value)
	{
		privatemanywhoUserId = value;
	}
}