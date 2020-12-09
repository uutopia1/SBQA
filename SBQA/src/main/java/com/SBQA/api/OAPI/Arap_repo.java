package com.SBQA.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;

import com.SBQA.domain.ApiVO;

public class Arap_repo {
	
	public String[] arap_repo(ApiVO vo) throws Exception {
		
		String[] result = new String[2];
	
		try {
			
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("MessageId", vo.getMessageId());
			jsonObj.put("Signal", vo.getSignal());
			jsonObj.put("RequestTime", vo.getRequestTime());
			jsonObj.put("SendComRegno", vo.getSendComRegno());
			jsonObj.put("AuthToken", vo.getAuthToken());
			jsonObj.put("ServiceCode", vo.getServiceCode());
			jsonObj.put("SearchFromDate", vo.getSearchFromDate());
			jsonObj.put("SearchToDate", vo.getSearchToDate());
			jsonObj.put("RepoTypeCode", vo.getRepoTypeCode());

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
			    String strRepoTypeCode = jsonObj.get("RepoTypeCode").toString();
			    int totalCount = jsonArray.length();
			    if (0 < totalCount) {
			        if ("AR" == strRepoTypeCode) {  //매출 보관함
			            for (int i = 0; i < totalCount; i++) {
			                JSONObject jsonTable = (JSONObject) jsonArray.get(i);
			                System.out.println(jsonTable.get("BYR_COM_NAME").toString());    //공급받는자 회사명
			                System.out.println(jsonTable.get("BYR_COM_REGNO").toString());   //공급받는자 사업자번호
			                System.out.println(jsonTable.get("DIRECTION").toString());       //세금계산서 정/역 구분
			                System.out.println(jsonTable.get("DTI_STATUS").toString());      //세금계산서 상태
			                System.out.println(jsonTable.get("DTI_TYPE").toString());        //세금계산서 종류
			                System.out.println(jsonTable.get("DTI_WDAY").toString());        //세금계산서 작성일자
			                System.out.println(jsonTable.get("ETC_PCS_NO").toString());      //세금계산서 참조번호
			                System.out.println(jsonTable.get("ISSUE_ID").toString());        //세금계산서 승인번호
			                System.out.println(jsonTable.get("NTS_SEND_STATUS").toString()); //세금계산서 국세청 전송상태
			                System.out.println(jsonTable.get("SUP_AMT").toString());         //세금계산서 공급가액
			System.out.println(jsonTable.get("SUP_EMAIL").toString());       //담당자 이메일
			            }
			        } else if ("AP" == strRepoTypeCode) {  //매입 보관함
			            for (int i = 0; i < totalCount; i++) {
			                JSONObject jsonTable = (JSONObject) jsonArray.get(i);
			                System.out.println(jsonTable.get("DIRECTION").toString());       //세금계산서 정/역 구분
			                System.out.println(jsonTable.get("DTI_STATUS").toString());      //세금계산서 상태
			                System.out.println(jsonTable.get("DTI_TYPE").toString());        //세금계산서 종류
			                System.out.println(jsonTable.get("DTI_WDAY").toString());        //세금계산서 작성일자
			                System.out.println(jsonTable.get("ETC_PCS_NO").toString());      //세금계산서 참조번호
			                System.out.println(jsonTable.get("ISSUE_ID").toString());        //세금계산서 승인번호
			                System.out.println(jsonTable.get("NTS_SEND_STATUS").toString()); //세금계산서 국세청 전송상태
			                System.out.println(jsonTable.get("SUP_AMT").toString());         //세금계산서 공급가액
			                System.out.println(jsonTable.get("SUP_COM_NAME").toString());    //공급자 회사명
			                System.out.println(jsonTable.get("SUP_COM_REGNO").toString());   //공급자 사업자번호
			System.out.println(jsonTable.get("BYR_EMAIL").toString());       //담당자 이메일
			            }
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
