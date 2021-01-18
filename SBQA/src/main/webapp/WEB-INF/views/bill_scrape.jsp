<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.lang.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.DataOutputStream"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>
<%@ page import="java.io.StringReader"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="org.json.JSONObject"%>
<%@ page import="org.json.JSONArray"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.net.URLEncoder" %>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("pragma", "no-cache");
%>
<%
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 오픈스크랩 서비스를 통해 수집된 세금계산서 리스트를 조회한다.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Request
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 메시지ID        MessageId      : 트랜잭션 식별자
// 요청시그널      Signal         : 고정 값: OS_DTI_LIST
// 요청시간        RequestTime    : 포맷: YYYYMMDDHH24MISS
// 송신사업자번호  SendComRegno   : 송신자 사업자번호
// 인증토큰        AuthToken      : 스마트빌에서 발급받은 인증토큰
// 서비스코드      ServiceCode    : 고정 값: DTI
// 검색일자 종류   SearchDate     : 작성일자: W, 발행일자: I, 전송일자: S
// 검색 시작일자   SearchFromDate : 시작일자: 2019-08-01
// 검색 종료일자   SearchToDate   : 종료일자: 2019-08-15 (검색기간은 최대 30일)
// 검색 사업자번호 SearchComRegno : 검색하려는 사업자번호
// 매출/매입 구분  SupBuy_Type    : 매출: AR, 매입: AP
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Date now = new Date();
// 오늘, yyyy-mm-dd
String toDay = new SimpleDateFormat("yyyy-MM-dd").format(now);
// 오늘, yyyymmddhhmmss
String toDayTime = new SimpleDateFormat("yyyyMMddHHmmss").format(now);
// 30일 전
Calendar today = Calendar.getInstance();
today.add(Calendar.DATE , -30);
String beforeDate = new SimpleDateFormat("yyyy-MM-dd").format(today.getTime());
//
JSONObject jsonObj = new JSONObject();
//
jsonObj.put("MessageId", "MBC-COM1-3ea6-4aa6-b988-7d27d6d5ad97");
jsonObj.put("Signal", "OS_DTI_LIST");
jsonObj.put("RequestTime", toDayTime);
jsonObj.put("SendComRegno", "1078674544");
jsonObj.put("AuthToken", "UWhpQzFpU3FOSTVaT0VQQy9OZHFkd2IwMHBPeXJ0bjl5OUtxZnFMTzVnND0K");
jsonObj.put("ServiceCode", "DTI");
jsonObj.put("SearchDate", "W");
jsonObj.put("SearchFromDate", beforeDate);
jsonObj.put("SearchToDate", toDay);
jsonObj.put("SearchComRegno", "4108106350");
jsonObj.put("SupBuy_Type", "AP");
//
URL url = new URL("http://demoapi.smartbill.co.kr/sb-api/request/");
//
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
conn.setRequestMethod("POST");
conn.setUseCaches(false);
conn.setDoInput(true);
conn.setDoOutput(true);
conn.setConnectTimeout(10000);
conn.setRequestProperty("Content-Type", "application/json");
conn.setRequestProperty("Accept", "application/json");
//
DataOutputStream os = new DataOutputStream(conn.getOutputStream());
//
os.write(jsonObj.toString().getBytes());
os.flush();
os.close();
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Response
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 메시지ID   MessageId     : 요청 한 트랜잭션 식별자
// 요청시그널 Signal        : 고정 값: DOC_TRANSMIT
// 응답시간   ResponseTime  : YYYYMMDDHH24MISS
// 처리코드   ResultCode    : 처리 결과 코드
// 처리메시지 ResultMessage : 처리 결과 상세 내역
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
BufferedReader br = null;
String res = "";
//
if(null != conn){   
  br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
  String line = null;
  		  
  while((line = br.readLine()) != null){
    res += line + "\n";
  }
}
String res_escape = URLEncoder.encode(res, "UTF-8");

%>
<script>
	alert("test");
	alert('<%=res_escape%>');
</script>
<%

//
/*
JSONObject jsonResponse = new JSONObject(res);
//
if("30000".equalsIgnoreCase(jsonResponse.getString("ResultCode"))){
  JSONObject jsonResultDataSet = (JSONObject) jsonResponse.get("ResultDataSet");
  JSONArray jsonArray = (JSONArray) jsonResultDataSet.get("Table");
  //
  int totalCount = jsonArray.length();
  //
  if (0 < totalCount) {
    for (int i = 0; i < totalCount; i++) {
      JSONObject jsonTable = (JSONObject) jsonArray.get(i);
      System.out.println(jsonTable.get("ISSUE_ID").toString()); // 승인번호
      System.out.println(jsonTable.get("SUPBUY_TYPE").toString()); // 매출AR/매입AP 구분
      System.out.println(jsonTable.get("DTI_WDATE").toString()); // 작성일자
      System.out.println(jsonTable.get("DTI_IDATE").toString()); // 발행일자
      System.out.println(jsonTable.get("DTI_SDATE").toString()); // 전송일자
      System.out.println(jsonTable.get("TYPE_CODE").toString()); // 세금계산서 종류 구분
      System.out.println(jsonTable.get("DTI_TYPE").toString()); // 세금계산서 코드
      System.out.println(jsonTable.get("TAX_DEMAND").toString()); // 영수01/청구02 구분
      System.out.println(jsonTable.get("SEQ_ID").toString()); // 세금계산서 문서번호
      System.out.println(jsonTable.get("SUP_COM_REGNO").toString()); // 공급자 사업자번호
      System.out.println(jsonTable.get("SUP_REP_NAME").toString()); // 공급자 대표자명
      System.out.println(jsonTable.get("SUP_COM_NAME").toString()); // 공급자 회사명
      System.out.println(jsonTable.get("SUP_EMAIL").toString()); // 공급자 이메일
      System.out.println(jsonTable.get("BYR_COM_REGNO").toString()); // 공급받는자 사업자번호
      System.out.println(jsonTable.get("BYR_REP_NAME").toString()); // 공급받는자 대표자명
      System.out.println(jsonTable.get("BYR_COM_NAME").toString()); // 공급받는자 회사명
      System.out.println(jsonTable.get("BYR_EMAIL").toString()); // 공급받는자 이메일
      System.out.println(jsonTable.get("SUP_AMOUNT").toString()); // 공급가액합계
      System.out.println(jsonTable.get("TAX_AMOUNT").toString()); // 세액합계
      System.out.println(jsonTable.get("TOTAL_AMOUNT").toString()); // 총금액
      System.out.println(jsonTable.get("TOTAL_CNT").toString()); // 데이터 총건수
    }
  } else {
    System.out.println("데이터가 존재하지 않습니다.");
  }
}else{
  System.out.println(jsonResponse.getString("ResultMessage"));
}
*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title></title>
<style></style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
</body>
</html>