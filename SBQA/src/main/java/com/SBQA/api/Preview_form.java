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

public class Preview_form {
	
	public String preview_form(String xml) throws Exception {
		String xsl = "";
		String xslt = "";
		
		try {
			
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("MessageId", "sbqa-preview_form-0001");
			jsonObj.put("Signal", "PREVIEW_FORM");
			jsonObj.put("RequestTime", "20200707000000");
			jsonObj.put("SendComRegno", "1000000004"); 
			jsonObj.put("AuthToken", "TWRKZUl3NHdrNmVudktoVndkU0VINGQ4WUp1eDZ3VzYvbEVveEI2SngwZDhTNlZ0R2FIU2RoWElyNUVyV21mUwo=");
			jsonObj.put("ServiceCode", "DTI");

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
			
			
			
			BufferedReader br;
			String response = "";
			if(null != conn){    
			    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			    String line = null;
			    while((line = br.readLine()) != null){
			        response += line + "\n";
			    }
			}
			JSONObject jsonResponse = new JSONObject(response);

			if("30000".equalsIgnoreCase(jsonResponse.getString("ResultCode"))){
			    JSONObject jsonResultDataSet = (JSONObject) jsonResponse.get("ResultDataSet");
			    JSONArray jsonArray = (JSONArray) jsonResultDataSet.get("Table1");
			    int totalCount = jsonArray.length();
			    if (0 < totalCount) {
			        JSONObject jsonTable1 = (JSONObject) jsonArray.get(0); //공급받는자용 매입 세금계산서
			        System.out.println(jsonTable1.get("CONTENT").toString());
			        JSONObject jsonTable2 = (JSONObject) jsonArray.get(1); //공급받는자용 매입 계산서
			        System.out.println(jsonTable2.get("CONTENT").toString());
			        JSONObject jsonTable3 = (JSONObject) jsonArray.get(2); //공급받는자용 위수탁 매입 세금계산서
			        System.out.println(jsonTable3.get("CONTENT").toString());
			        JSONObject jsonTable4 = (JSONObject) jsonArray.get(3); //공급받는자용 위수탁 매입 계산서
			        System.out.println(jsonTable4.get("CONTENT").toString());
			        JSONObject jsonTable5 = (JSONObject) jsonArray.get(4); //공급자용 매출 세금계산서
			        System.out.println(jsonTable5.get("CONTENT").toString());
			        JSONObject jsonTable6 = (JSONObject) jsonArray.get(5); //공급자용 매출 계산서
			        System.out.println(jsonTable6.get("CONTENT").toString());
			        JSONObject jsonTable7 = (JSONObject) jsonArray.get(6); //공급자용 위수탁 매출 세금계산서
			        System.out.println(jsonTable7.get("CONTENT").toString());
			        JSONObject jsonTable8 = (JSONObject) jsonArray.get(7); //공급자용 위수탁 매출 계산서
			        System.out.println(jsonTable8.get("CONTENT").toString());
			        JSONObject jsonTable9 = (JSONObject) jsonArray.get(8); //거래명세서(과세)
			        System.out.println(jsonTable8.get("CONTENT").toString());
			        JSONObject jsonTable10 = (JSONObject) jsonArray.get(9); //거래명세서(면세)
			        System.out.println(jsonTable8.get("CONTENT").toString());
			        JSONObject jsonTable11 = (JSONObject) jsonArray.get(10); //위수탁 거래명세서(과세)
			        System.out.println(jsonTable8.get("CONTENT").toString());
			        JSONObject jsonTable12 = (JSONObject) jsonArray.get(11); //위수탁 거래명세서(면세)
			        System.out.println(jsonTable8.get("CONTENT").toString());
			        
			        xsl = jsonTable5.get("CONTENT").toString();

			    }
			    else {
			        System.out.println("데이터가 존재하지 않습니다.");
			    }
			}
			else{
			    System.out.println(jsonResponse.getString("ResultMessage"));
			}
			
		} catch(Exception e) {
			
		}
		
		//xlst
		Source xmlSource = new StreamSource(new StringReader(xml));
		Source xsltSource = new StreamSource(new StringReader(xsl));
		TransformerFactory ft = TransformerFactory.newInstance();

		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);

		Transformer trans = ft.newTransformer(xsltSource);
		trans.transform(xmlSource, result);
						   
		xslt = writer.toString();	
		
		return xslt;		
		
	}
}
