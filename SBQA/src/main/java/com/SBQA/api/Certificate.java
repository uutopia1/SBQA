package com.SBQA.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.SBQA.domain.ApiVO;

public class Certificate {
	

	public String[] certificate(String corpRegNo, String password, MultipartFile signCertPrivate, MultipartFile signCertPublic) throws Exception {
		String boundary = "^-----^";
		String LINE_FEED = "\r\n";
		OutputStream outputStream;
		PrintWriter writer;
		String[] result = new String[2];

		try {
			
			URL url = new URL("http://49.50.165.210:30000/dti/api/v1/certificate/1111111119");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setConnectTimeout(10000);
			conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			conn.setRequestProperty("Accept", "application/json");
	
			outputStream = conn.getOutputStream();
			writer = new PrintWriter(new OutputStreamWriter(outputStream, "utf-8"), true);
			
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"데이터 키값\"").append(LINE_FEED);
            writer.append("Content-Type: text/plain; charset=" + "utf-8").append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.append("데이터값").append(LINE_FEED);
            writer.flush();
			
			
			//response		
			BufferedReader br;
			String response = "";

			if(null != conn){    
			    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			    String line = null;

			    while((line = br.readLine()) != null){
			        response += line + "\n";
			    }
			}
			
			result[1] = response;

			//String strAuthToken = "";
			JSONObject jsonResponse = new JSONObject(response);

			if("30000".equalsIgnoreCase(jsonResponse.getString("ResultCode"))){
			    JSONObject jsonResultDataSet = (JSONObject) jsonResponse.get("ResultDataSet");
			    JSONArray jsonArray = (JSONArray) jsonResultDataSet.get("Table1");
			            
			    JSONObject jsonTable = (JSONObject)jsonArray.get(0);
			            
			    //result = jsonTable.toString();  // 인증토큰 추출
			    //System.out.println(strAuthToken);
			}
			else{
			    System.out.println(jsonResponse.getString("ResultMessage"));
			    
			    //result = jsonResponse.getString("ResultMessage");
			}

		}catch (Exception e){
			result[1] = e.getMessage();
		}		
		
		return result;
	}

}

