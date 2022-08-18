package UsingJavaNet;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApiAutomationUsingUniRest 
{
	public void getRequestMethodExample() throws UnirestException
	{
		HttpResponse<JsonNode> JsonResponse=Unirest.get("https://reqres.in/api/users/2").asJson();
		
		System.out.println("Status Code is : "+JsonResponse.getStatus());
		System.out.println("Status Message is : "+JsonResponse.getStatusText());
		System.out.println("Response Body is : "+JsonResponse.getBody());
		
	}
	
	public void postMethodExample() throws UnirestException
	{
		HttpResponse<JsonNode> jsonResponse=Unirest.post("https://reqres.in/api/users").body("{\"name\": \"Ferb\",\"job\": \"Team leader\"}").asJson();
		
		System.out.println("Status Code is : "+jsonResponse.getStatus());
		System.out.println("Status Message is : "+jsonResponse.getStatusText());
		System.out.println("Response Body is : "+jsonResponse.getBody());
		
	
	}
	public void putRequestExample() throws UnirestException
	{
		HttpResponse<JsonNode> jsonResponse= Unirest.put("https://reqres.in/api/users/727").body("{\"name\": \"Srie\",\"job\": \"Team leader\"}").asJson();
	
		System.out.println("Status Code is : "+jsonResponse.getStatus());
		System.out.println("Status Message is : "+jsonResponse.getStatusText());
		System.out.println("Response Body is : "+jsonResponse.getBody());
		
	}
	public static void main(String[] args) throws UnirestException  
	{
		// TODO Auto-generated method stub
		ApiAutomationUsingUniRest uniRest1=new ApiAutomationUsingUniRest();
		//uniRest1.getRequestMethodExample();
		//uniRest1.postMethodExample();
		uniRest1.putRequestExample();
	}
}
