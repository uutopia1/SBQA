package com.SBQA.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.json.JSONArray;
import org.json.JSONObject;

import com.SBQA.domain.ApiVO;

public class DetailArissue {
	
	public String[] detailarissue(ApiVO vo) throws Exception {
		String[] result = new String[2];
		
		try {
			
			String[] arrConvId = {vo.getConversationId()};
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("MessageId", vo.getMessageId());
			jsonObj.put("Signal", vo.getSignal());
			jsonObj.put("RequestTime", vo.getRequestTime());
			jsonObj.put("SendComRegno", vo.getSendComRegno()); 
			jsonObj.put("ReceiveComRegno", vo.getReceiveComRegno());
			jsonObj.put("AuthToken", vo.getAuthToken());
			jsonObj.put("ServiceCode", vo.getServiceCode());
			jsonObj.put("SystemType", vo.getSystemType());
			jsonObj.put("ConversationId", arrConvId); 
			jsonObj.put("SMTPEmail", vo.getSMTPEmail()); 
			jsonObj.put("RValue", vo.getRValue()); // 서명모듈 이용해서 발행할 경우에만 필요
			jsonObj.put("CertPassword", vo.getCertPassword()); // 암호화된 인증서의 비밀번호
			jsonObj.put("SystemId", vo.getSystemId());
			jsonObj.put("PlatformCode", vo.getPlatformCode()); // 허브업체의 구분코드
			jsonObj.put("SignedXML", vo.getSignedXML());  // 서명정보가 있는 세금계산서 xml
			jsonObj.put("UnSignedXML", vo.getSignedXML());  // 서명정보가 있는 세금계산서 xml

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
			    System.out.println(jsonResponse.getString("ResultMessage"));
			}
			else{
			    System.out.println(jsonResponse.getString("ResultMessage"));
			}

			
		} catch(Exception e) {
			result[0] = e.getMessage();
			result[1] = e.getMessage();
		}
		
		
		return result;		
		
	}
}
