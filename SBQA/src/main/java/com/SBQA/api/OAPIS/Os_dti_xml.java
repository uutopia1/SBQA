package com.SBQA.api.OAPIS;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import com.SBQA.domain.ApiVO;

public class Os_dti_xml {
	
	public String[] os_dti_xml(ApiVO vo) throws Exception {
		String[] result = new String[2];
	
		try {
			
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("MessageId", vo.getMessageId());
			jsonObj.put("Signal", vo.getSignal());
			jsonObj.put("RequestTime", vo.getRequestTime());
			jsonObj.put("SendComRegno", vo.getSendComRegno()); 
			jsonObj.put("AuthToken", vo.getAuthToken());
			jsonObj.put("ServiceCode", vo.getServiceCode());
			jsonObj.put("AuthCode", vo.getAuthCode());
			jsonObj.put("SupBuy_Type", vo.getSupBuy_Type());
			jsonObj.put("IssueId", vo.getIssueId());

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
			os.flush();
			os.close();

			result[0] = jsonObj.toString();
			
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

			JSONObject jsonResponse = new JSONObject(response);

			if("30000".equalsIgnoreCase(jsonResponse.getString("ResultCode"))){
			    JSONObject jsonResultDataSet = (JSONObject) jsonResponse.get("ResultDataSet");
			    JSONArray jsonArray = (JSONArray) jsonResultDataSet.get("Table");

			    int totalCount = jsonArray.length();

			    if (0 < totalCount) {
			        for (int i = 0; i < totalCount; i++) {
			            JSONObject jsonTable = (JSONObject) jsonArray.get(i);
			                    
			            System.out.println(jsonTable.get("ISSUE_ID").toString());    //승인번호
			            System.out.println(jsonTable.get("DTI_MSG").toString()); 	  //세금계산서 원본
			        }
			    }
			    else {
			        System.out.println("데이터가 존재하지 않습니다.");
			    }
			}
			else{
			    System.out.println(jsonResponse.getString("ResultMessage"));
			}

			
		} catch (Exception e) {
			result[1] = e.getMessage();
		}
		
		return result;
	}

}
