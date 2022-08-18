package UsingJavaNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
Steps to GET request:  
1. Create Object for URL class  
2. Open the URL connection and store it in its parent 
3. Set the Request Type
4. Connect 
5. Get status code from the connection object and print  
6. Get the response message and print  
7. read the response using getInputStream 
8. Create an input stream reader for reading the response body 
9. Create a buffered reader and pass the input stream reader  
10. read the lines using readline ()  
11. So how long do we have to read the lines? 
		As long as the lines are available in the response. 
		So loop the read line action  
12. Create a String buffer and store the lines read inside the loop 
13. Finally print the buffer.*/

public class HttpURLConnectionExample 
{
	public void GetURLConnection() throws IOException
	{
		
	URL url=new URL("https://dummy.restapiexample.com/api/v1/employees");
	HttpURLConnection connection=(HttpURLConnection)url.openConnection();
	connection.setRequestMethod("GET");
	connection.connect();
	
	int StatusCode=connection.getResponseCode();
	System.out.println("Status code is : "+StatusCode);
	
	String Response=connection.getResponseMessage();
	System.out.println("Response message is "+Response);
	
	InputStream inputStream =connection.getInputStream();
	InputStreamReader reader=new InputStreamReader(inputStream);
	
	BufferedReader bufferedReader=new BufferedReader(reader);
	String line;
	StringBuffer buffer = new StringBuffer();
	while((line=bufferedReader.readLine())!=null)
	{
		buffer.append(line);
	}
	System.out.println(buffer);
	}
	public static void main(String[] args)  throws IOException
	{
		HttpURLConnectionExample example=new HttpURLConnectionExample();
		example.GetURLConnection();
	}
}
