package com.demo.cartisan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;


@SuppressWarnings("serial")
@WebServlet("*.do")
public class Controller extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println(uri);
		System.out.println(uri.endsWith("getFuelPrice.do"));
		if (uri.endsWith("getFuelPrice.do")) {
			System.out.println("Entered");
			String result = httpGetReq("https://fuelpriceindia.herokuapp.com/price/?city=Delhi&fuel_type=petrol");
			resp.setContentType("application/json");
//			System.out.println(result);
			resp.addHeader("Access-Control-Allow-Origin", "*");
			resp.addHeader("Access-Control-Allow-Credentials", "true");
			resp.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,OPTIONS");
			resp.addHeader("Access-Control-Allow-Headers", "Origin,Content-Type,Accept,Authorization,X-Ellucian-Media-Type");
			resp.getWriter().flush();
			resp.getWriter().write(result);
		}
	}
	
	public String httpGetReq(String url) throws IOException {
		HttpClient client = HttpClients.createDefault();	
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = client.execute(httpGet);
		String inputLine ;
		StringBuffer response1 = new StringBuffer();
		 BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		 try {
		       while ((inputLine = br.readLine()) != null) {
		             
		              response1.append(inputLine);
		       }
		       br.close();
		  } catch (IOException e) {
		       e.printStackTrace();
		  }
		
		 if (response.getStatusLine().getStatusCode()!=200) {
			return null;
		}
		 return response1.toString();
		
	}
}
