package com.SBQA.api.OAPIS;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.*;

import com.SBQA.domain.ApiVO;

public class Os_dti_list {
	
	public String[] os_dti_list(ApiVO vo) throws Exception {
		String[] result = new String[2];
		
		try {
			
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("MessageId", vo.getMessageId());
			jsonObj.put("Signal", vo.getSignal());
			jsonObj.put("RequestTime", vo.getRequestTime());
			jsonObj.put("SendComRegno", vo.getSendComRegno());
			jsonObj.put("AuthToken", vo.getAuthToken());
			jsonObj.put("ServiceCode", vo.getServiceCode());
			jsonObj.put("SearchDate", vo.getSearchDate());
			jsonObj.put("SearchFromDate", vo.getSearchFromDate());
			jsonObj.put("SearchToDate", vo.getSearchToDate());
			jsonObj.put("SearchComRegno", vo.getSearchComRegno());
			jsonObj.put("SupBuy_Type", vo.getSupBuy_Type());

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
				   System.out.println(jsonTable.get("ISSUE_ID").toString());       // 승인번호
				   System.out.println(jsonTable.get("SUPBUY_TYPE").toString());    // 매출AR/매입AP 구분
				   System.out.println(jsonTable.get("DTI_WDATE").toString());      // 작성일자
				   System.out.println(jsonTable.get("DTI_IDATE").toString());      // 발행일자
				   System.out.println(jsonTable.get("DTI_SDATE").toString());      // 전송일자
				   System.out.println(jsonTable.get("TYPE_CODE").toString());      // 세금계산서 종류 구분
				   System.out.println(jsonTable.get("DTI_TYPE").toString());       // 세금계산서 코드
				   System.out.println(jsonTable.get("TAX_DEMAND").toString());     // 영수01/청구02 구분
				   System.out.println(jsonTable.get("SEQ_ID").toString());         // 세금계산서 문서번호
				   System.out.println(jsonTable.get("SUP_COM_REGNO").toString());  // 공급자 사업자번호
				   System.out.println(jsonTable.get("SUP_REP_NAME").toString());   // 공급자 대표자명
				   System.out.println(jsonTable.get("SUP_COM_NAME").toString());   // 공급자 회사명
				   System.out.println(jsonTable.get("SUP_EMAIL").toString());      // 공급자 이메일
				   System.out.println(jsonTable.get("BYR_COM_REGNO").toString());  // 공급받는자 사업자번호
				   System.out.println(jsonTable.get("BYR_REP_NAME").toString());   // 공급받는자 대표자명
				   System.out.println(jsonTable.get("BYR_COM_NAME").toString());   // 공급받는자 회사명
				   System.out.println(jsonTable.get("BYR_EMAIL").toString());      // 공급받는자 이메일
				   System.out.println(jsonTable.get("SUP_AMOUNT").toString());     // 공급가액합계
				   System.out.println(jsonTable.get("TAX_AMOUNT").toString());     // 세액합계
				   System.out.println(jsonTable.get("TOTAL_AMOUNT").toString());   // 총금액
				   System.out.println(jsonTable.get("TOTAL_CNT").toString());      // 데이터 총건수
				   
				   //result += jsonTable.toString();

			        }
			    }
			    else {
			        System.out.println("데이터가 존재하지 않습니다.");
			        //result = "데이터가 존재하지 않습니다.";
			    }
			}
			else{
			    System.out.println(jsonResponse.getString("ResultMessage"));
			    //result = jsonResponse.getString("ResultMessage");
			}

			
		} catch (Exception e) {
			//result[1] = e.getMessage();
		}
		
		return result;
	}

}
