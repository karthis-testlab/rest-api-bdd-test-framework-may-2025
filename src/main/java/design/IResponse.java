package design;

public interface IResponse {
	
	public int getStatusCode();
	public String getStatusMesssage();
	public String getContentType();
	public String getResponseBody();	

}