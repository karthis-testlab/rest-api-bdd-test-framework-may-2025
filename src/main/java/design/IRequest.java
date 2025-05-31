package design;

public interface IRequest {	
	
	public IResponse get(String endPoint);
	public IResponse post(String endPoint, Object requestBody);
	public IResponse put(String endPoint, Object requestBody);
	public IResponse patch(String endPoint, Object requestBody);
	public IResponse delete(String endPoint);

}