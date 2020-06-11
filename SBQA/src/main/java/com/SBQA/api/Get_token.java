package com.SBQA.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.SBQA.domain.ApiVO;

public class Get_token {
	

	public String[] get_token (ApiVO vo) throws Exception {
		JSONObject jsonObj = new JSONObject();
		String[] result = new String[2];

		try {
			//request
			jsonObj.put("MessageId", vo.getMessageId());
			jsonObj.put("Signal", vo.getSignal());
			jsonObj.put("RequestTime", vo.getRequestTime());
			jsonObj.put("SendComRegno", vo.getSendComRegno());
			jsonObj.put("AuthCode", vo.getAuthCode());
			jsonObj.put("SbId", vo.getSbId());
			jsonObj.put("ExpirationDateCode", vo.getExpirationDateCode());
			jsonObj.put("ExpirationDate", vo.getExpirationDate());
	
			URL url = new URL("http://demoapi.smartbill.co.kr/sb-api/request/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setConnectTimeout(10000);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
	
			DataOutputStream os = new DataOutputStream(conn.getOutputStream());
			os.write(jsonObj.toString().getBytes());
			
			result[0] = jsonObj.toString();
			
			os.flush();
			os.close();
		
			
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
			    //System.out.println(jsonResponse.getString("ResultMessage"));
			    
			    //result = jsonResponse.getString("ResultMessage");
			}

		}catch (Exception e){
			result[1] = e.getMessage();
		}		
		
		return result;
	}

}
