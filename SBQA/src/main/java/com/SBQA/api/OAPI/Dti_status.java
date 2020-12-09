package com.SBQA.api.OAPI;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;

import com.SBQA.domain.ApiVO;

public class Dti_status {
	
	public String[] dti_status(ApiVO vo) throws Exception {
		
		String[] result = new String[2];
	
		try {
			
			String[] arrConvId = {vo.getConversationId()};
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("MessageId", vo.getMessageId());
			jsonObj.put("Signal", vo.getSignal());
			jsonObj.put("RequestTime", vo.getRequestTime());
			jsonObj.put("SendComRegno", vo.getSendComRegno());
			jsonObj.put("AuthToken", vo.getAuthToken());
			jsonObj.put("ServiceCode", vo.getServiceCode());
			jsonObj.put("ConversationId", arrConvId);

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
			        JSONObject jsonTable = (JSONObject) jsonArray.get(0); 

			        System.out.println(jsonTable.get("AMEND_CODE").toString());      //수정코드
			        System.out.println(jsonTable.get("DTI_ISSUEDATE").toString());   //세금계산서 발행일자
			        System.out.println(jsonTable.get("DTI_STATUS").toString());      //세금계산서 상태
			        System.out.println(jsonTable.get("DTI_WDAY").toString());        //세금계산서 작성일자
			        System.out.println(jsonTable.get("ETC_PCS_NO").toString());      //세금계산서 참조번호
			        System.out.println(jsonTable.get("ISSUE_ID").toString());        //세금계산서 승인번호
			        System.out.println(jsonTable.get("NTS_RESULT_CODE").toString()); //세금계산서 국세청 전송결과
			        System.out.println(jsonTable.get("NTS_SEND_DATE").toString());   //세금계산서 국세청 전송일자
			        System.out.println(jsonTable.get("NTS_SEND_STATUS").toString()); //세금계산서 국세청 전송상태
			        System.out.println(jsonTable.get("ORI_ISSUE_ID").toString());    //원본 세금계산서 승인번호
			        System.out.println(jsonTable.get("SUP_AMT").toString());         //세금계산서 공급가액
			        System.out.println(jsonTable.get("TAX_AMT").toString());         //세금계산서 세액
			        System.out.println(jsonTable.get("TOT_AMT").toString());         //세금계산서 합계금액
			        System.out.println(jsonTable.get("IS_ARAP").toString());         //매출, 매입 구분
			        System.out.println(jsonTable.get("DTI_TYPE").toString());        //세금계산서 유형
			        System.out.println(jsonTable.get("DTT_LINK_TYPE").toString());   //거래명세서 포함 여부
			        System.out.println(jsonTable.get("DIRECTION").toString());       //정, 역 구분
			        System.out.println(jsonTable.get("BYR_TYPE").toString());        //공급받는자 회원 구분
			        System.out.println(jsonTable.get("TAX_DEMAND").toString());      //영수, 청구 구분
			        System.out.println(jsonTable.get("SUP_COM_NAME").toString());    //공급자 회사명
			        System.out.println(jsonTable.get("SUP_COM_REGNO").toString());   //공급자 사업자번호
			        System.out.println(jsonTable.get("BYR_COM_NAME").toString());    //공급받는자 회사명
			        System.out.println(jsonTable.get("BYR_COM_REGNO").toString());   //공급받는자 사업자번호
			        System.out.println(jsonTable.get("BRK_COM_NAME").toString());    //수탁자 회사명
			        System.out.println(jsonTable.get("BRK_COM_REGNO").toString());   //수탁자 사업자번호
			        System.out.println(jsonTable.get("BRK_DTI_YN").toString());      //위수탁 여부
			        System.out.println(jsonTable.get("AMEND_DTI_YN").toString());    //수정세금계산서 여부
			        System.out.println(jsonTable.get("SUP_EMAIL").toString());       //공급자 이메일
			        System.out.println(jsonTable.get("BYR_EMAIL").toString());       //공급받는자 이메일
			        System.out.println(jsonTable.get("BRK_EMAIL").toString());       //수탁자 이메일
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
