package UsingJavaNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ApiAutomate 
{
	public void GetRequestExample() throws IOException
	{
		URL url=new URL("https://reqres.in/api/users/2");
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		
		
		System.out.println("Response code is : "+connection.getResponseCode());
		System.out.println("Response Message is : "+connection.getResponseMessage());
		
		InputStream inputStream= connection.getInputStream();
		InputStreamReader reader=new InputStreamReader(inputStream);
		
		BufferedReader bufferedReader=new BufferedReader(reader);
		String line;
		StringBuffer buffer=new StringBuffer();
		while((line=bufferedReader.readLine())!=null)
		{
			buffer.append(line);
		}
		System.out.println(buffer);
	}
	
	public void postRequestExample() throws IOException
	{
		URL url=new URL("https://reqres.in/api/users");
		HttpURLConnection connection= (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type","application/json");
		connection.setDoOutput(true);
		
		String JsonBody="{\"name\": \"Sastra\",\"job\": \"leader\"}";
		byte[] jsonInput=JsonBody.getBytes();
		OutputStream stream=connection.getOutputStream();
		stream.write(jsonInput);
		

		System.out.println("Response code is : "+connection.getResponseCode());
		System.out.println("Response Message is : "+connection.getResponseMessage());
		
		InputStream inputStream= connection.getInputStream();
		InputStreamReader reader=new InputStreamReader(inputStream);
		
		BufferedReader bufferedReader=new BufferedReader(reader);
		String line;
		StringBuffer buffer=new StringBuffer();
		while((line=bufferedReader.readLine())!=null)
		{
			buffer.append(line);
		}
		System.out.println(buffer);
	}
	public void putRequestExample() throws IOException
	{
		URL url=new URL("https://reqres.in/api/users/251");
		HttpsURLConnection connection= (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type","application/json");
		connection.setDoOutput(true);
		
		String jsonBody="{\"name\": \"Sastra\",\"job\": \"zion resident\"}";
		byte[] inputJson=jsonBody.getBytes();
		OutputStream stream=connection.getOutputStream();
		stream.write(inputJson);
		
		InputStream inputStream= connection.getInputStream();
		InputStreamReader reader=new InputStreamReader(inputStream);
		
		BufferedReader bufferedReader=new BufferedReader(reader);
		String line;
		StringBuffer buffer=new StringBuffer();
		while((line=bufferedReader.readLine())!=null)
		{
			buffer.append(line);
		}
		System.out.println(buffer);
		
		
		
	}
	
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		ApiAutomate automate=new ApiAutomate();
		//automate.GetRequestExample();
		//automate.postRequestExample();
		automate.putRequestExample();
	}
}
