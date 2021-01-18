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

public class Xslt {
	
	public String xslt() throws Exception {
		String xsl = "";
		String xml = "";
		String xslt = "";
				
		xsl = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" + 
				"<!-- (인쇄용, 공급받는자용) 매입 세금계산서 -->\r\n" + 
				"<xsl:stylesheet version=\"2.0\"\r\n" + 
				"                xmlns:xhtml=\"http://www.w3.org/1999/xhtml\"\r\n" + 
				"                xmlns=\"http://www.w3.org/1999/xhtml\"\r\n" + 
				"                xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"\r\n" + 
				"                xmlns:dti=\"http://www.kiec.or.kr/kis\"\r\n" + 
				"                xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\"\r\n" + 
				"                xmlns:sb=\"urn:kr:or:kec:standard:Tax:ReusableAggregateBusinessInformationEntitySchemaModule:1:0\">\r\n" + 
				"  <!-- <xsl:output method=\"html\"/> -->\r\n" + 
				"\r\n" + 
				"  <xsl:output method=\"xml\" version=\"1.0\" encoding=\"UTF-8\" doctype-public=\"-//W3C//DTD XHTML 1.1//EN\" doctype-system=\"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\" indent=\"yes\"/>\r\n" + 
				"\r\n" + 
				"  <xsl:template match=\"/\">\r\n" + 
				"\r\n" + 
				"    <html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				"      <head>\r\n" + 
				"        <!-- 헤더 정보 보이기 호출 -->\r\n" + 
				"        <xsl:call-template name=\"DTIHeader\"/>\r\n" + 
				"        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"css/smart_print3.css\" media=\"print,screen\" />-->\r\n" + 
				"        <style type=\"text/css\">\r\n" + 
				"          @charset \"utf-8\";\r\n" + 
				"          /* CSS Document */\r\n" + 
				"\r\n" + 
				"          /* smart clover에쓰인 공통 사항 START*/\r\n" + 
				"          /* Default Type Selector */\r\n" + 
				"          *{margin:0; padding:0; font-size:10px; font-family:NanumGothic;}\r\n" + 
				"          a,img,input {selector-dummy:expression(this.hideFocus=true);}/* 링크점선없애기 */\r\n" + 
				"          caption	{display:none;}\r\n" + 
				"          td,div,table{background:none;}\r\n" + 
				"\r\n" + 
				"          /* 일반적인 텍스트 롤오버및 링크 */\r\n" + 
				"          a:link     {font-family: NanumGothic ; font-size: 12px; color: #666666;	text-decoration: none; line-height:150% ;}\r\n" + 
				"          a:visited  {font-family: NanumGothic ; font-size: 12px; color: #666666;	text-decoration: none; line-height:150%  ;}\r\n" + 
				"          a:hover    {font-family: NanumGothic ; font-size: 12px; color: #2F488A;	text-decoration: underline;line-height:150% ;}\r\n" + 
				"\r\n" + 
				"          /* 테이블에 대한 기본 스타일 정의 */\r\n" + 
				"          td  {font-family: NanumGothic, 돋움, Dotum, 굴림, Gulim, Arial, sans-serif, Verdana, Helvetica, geneva; font-size: 10px; line-height:150% ; color: #666666; padding:0;  word-wrap:break-word;}\r\n" + 
				"          th {font-weight: 300}\r\n" + 
				"          /*// smart clover에쓰인 공통 사항 END */\r\n" + 
				"\r\n" + 
				"          #print_wrap{width:650px; /*margin:0 4px;*/}\r\n" + 
				"\r\n" + 
				"          /* 인쇄 옵션 START*/\r\n" + 
				"          #print_option{width:100%; padding-bottom:10px;}\r\n" + 
				"          #print_option_con{background:url(../image/center/print_bg.gif) repeat-y; padding:13px 0 9px 0;}\r\n" + 
				"          #pOption{width:620px; margin:0 auto; overflow:hidden}\r\n" + 
				"          /* 인쇄옵션 테이블 */\r\n" + 
				"          .pOption_table{width:520px; float:left; border-top:#a6c2de solid 1px; border-left:#a6c2de solid 1px; border-right:#a6c2de solid 1px; line-height:24px;}\r\n" + 
				"          .pOption_table th,.pOption_table th td{height:24px; background:#FFF; padding-top:3px; border-bottom:#a6c2de solid 1px;}\r\n" + 
				"          .pOption_table th{font-weight:normal; border-bottom:#a6c2de solid 1px; border-right:#a6c2de solid 1px; text-align:left; padding-left:20px; background:url(../image/common/bul_blue.gif) 10px 12px no-repeat; background-color:#FFF; color:#000;}\r\n" + 
				"          .pOption_table td{font-weight:normal; padding-left:8px; border-bottom:#a6c2de solid 1px;}\r\n" + 
				"          #pOption_btnPrint{float:left; margin-left:9px; padding-top:4px; height:53px;}\r\n" + 
				"          /* 인쇄옵션 안내 */\r\n" + 
				"          #pOption_info{clear:both; padding:15px 0 0 11px;}\r\n" + 
				"          .pOption_txt01{height:22px; line-height:22px;}\r\n" + 
				"          .pOption_txt01 txt,img{vertical-align:middle;}\r\n" + 
				"          .pOption_txt02{padding:15px 0 10px 0; color:#D93300;}\r\n" + 
				"          .print_blueB{font-weight:bold; color:#2f488a;}\r\n" + 
				"\r\n" + 
				"          #print_bottom{height:2px; background:url(../image/center/print_bottom.gif) no-repeat;}\r\n" + 
				"          /*// 인쇄 옵션 END*/\r\n" + 
				"\r\n" + 
				"          /* 담당자 정보 START */\r\n" + 
				"          .manager{margin-bottom:20px; }\r\n" + 
				"          .table_manager{border-top:#c8dbef solid 1px; border-bottom:#c8dbef solid 1px; border-collapse:collapse; width:100%;}\r\n" + 
				"          .table_manager th,.table_manager td{padding:3px 0 0 8px; border:none; text-align:left; }\r\n" + 
				"          .table_manager th{color:#3f7dc5; font-weight:normal; padding-left:29px; background:url(../image/common/bul_blue.gif) 18px 12px no-repeat; vertical-align:top; padding-top:7px; }\r\n" + 
				"          .table_manager .manager_cell{background:url(../image/common/cell_line.gif) 0 8px no-repeat;}\r\n" + 
				"          .table_manager .th_line{border-bottom:#e9eaea solid 1px;}\r\n" + 
				"          .table_manager .td_line{border-bottom:#e9eaea solid 1px;}\r\n" + 
				"          .table_manager .cell_line{border-bottom:#e9eaea solid 1px; background:url(../image/common/cell_line.gif) 0 8px no-repeat;}\r\n" + 
				"          /*// 담당자 정보 END */\r\n" + 
				"\r\n" + 
				"          /* 파일첨부 START */\r\n" + 
				"          .add_file{margin-bottom:30px;}\r\n" + 
				"          .table_AddFile{border-top:#a6c2de solid 1px; border-bottom:#a6c2de solid 1px; border-collapse:collapse; width:100%;}\r\n" + 
				"          .table_AddFile th,.table_AddFile td{border:none; text-align:left; padding-top:3px;}\r\n" + 
				"          .table_AddFile th{background:#f1f6fa; padding-left:25px; font-weight:normal;}\r\n" + 
				"          .table_AddFile .FileName{font-weight:bold; text-align:center;}\r\n" + 
				"          /*// 파일첨부 END */\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"          /* 전자세금계산서 보기 START */\r\n" + 
				"          .tax_invoice{width:646px; padding:0 2px; margin-top:20px; color: #666;}\r\n" + 
				"\r\n" + 
				"          /* 스탬프 위치 */\r\n" + 
				"          .divStamp{position:absolute; left:364px; top:114px; width:182px; height:131px; z-index:-2;}\r\n" + 
				"          .divStamp2{position:absolute; left:272px; top:65px; width:50px; height:50px; z-index:-2;}\r\n" + 
				"          .divStamp3{position:absolute; left:592px; top:240px; width:50px; height:50px; z-index:-2;}\r\n" + 
				"\r\n" + 
				"          .pinfo{width:646px; height:11px; padding-top:5px;}\r\n" + 
				"          .pinfo ul{padding:0; margin:0;}\r\n" + 
				"          .tli01{display:inline; float:left;}\r\n" + 
				"          .tli02{display:inline; float:right;}\r\n" + 
				"          .tinfo{width:646px; font-size:12px; line-height:18px; padding:0; margin-top:7px; padding-bottom:16px; background:url(../images/bg_dot3.gif) 0 51px repeat-x;}\r\n" + 
				"          .ptxt{font-weight:bold; text-decoration:underline;}\r\n" + 
				"          .ptxt A:link     {color:#666; text-decoration:none;}\r\n" + 
				"          .ptxt A:visited  {color:#666; text-decoration:none;}\r\n" + 
				"          .ptxt A:hover    {color:#666; text-decoration:none;}\r\n" + 
				"\r\n" + 
				"          /******************* Red **********************/\r\n" + 
				"          .tax_table {position:relative; border:#e66464 solid 1px; padding:1px; z-index:99999; width:642px;}\r\n" + 
				"          /* 테이블 헤더 start */\r\n" + 
				"          .tax_invoice01 {border-top:#e66464 solid 1px; border-left:#e66464 solid 1px; border-right:#e66464 solid 1px; border-collapse:collapse; width:100%; table-layout:fixed;  z-index:999; position:relative;}\r\n" + 
				"          .tax_invoice01 td {border-bottom:#e66464 solid 1px; color:#666; padding:2px 0 0 2px; background:none;}\r\n" + 
				"          .tax_invoice01 th{padding:4px 0 1px 0; line-height:150%; color:#fe6d69; font-weight:normal; border-bottom:#e66464 solid 1px;}\r\n" + 
				"          .title{font-size:18px; font-weight:bold; color:#fe6d69; text-align:center;}\r\n" + 
				"          .title_long{font-size:12px; font-weight:bold; color:#fe6d69; text-align:center;}\r\n" + 
				"          .td2{text-align:center; letter-spacing:0.3em;}\r\n" + 
				"          .tax_invoice01 td.td3{color:#666; border-left:#e66464 solid 1px; border-bottom:#e66464 solid 1px;}\r\n" + 
				"          .td4{border-right:#e66464 solid 1px;}\r\n" + 
				"          .cell_right01{text-align:right;}\r\n" + 
				"          /* // 테이블 헤더 end */\r\n" + 
				"\r\n" + 
				"          /* 테이블 start */\r\n" + 
				"          .tax_invoice02 {margin-top:2px; border-top:#e66464 solid 1px; border-right:#e66464 solid 1px; border-collapse:collapse; width:100%;  table-layout:fixed; word-break:break-all; z-index:999; position:relative;}\r\n" + 
				"          .tax_invoice02 td {border-bottom:#e66464 solid 1px; border-left:#e66464 solid 1px; padding:2px 2px 0 2px; color:#666; vertical-align:middle;}\r\n" + 
				"          .tax_invoice02 th{border-bottom:#e66464 solid 1px; border-left:#e66464 solid 1px;  font-weight:normal; color:#fe6d69; text-align:center; padding:4px 0 1px 0; line-height:150%; vertical-align:middle;}\r\n" + 
				"          .tax_invoice02 th .invoice02_th{border:none;  font-weight:normal; color:#fe6d69; text-align:center;}\r\n" + 
				"\r\n" + 
				"          .tax_bold01{font-weight:bold; text-align:center; font-size:13px;}\r\n" + 
				"          .tax_invoice02 .td_chargeL{text-align:left; padding:0; border-bottom:#e66464 solid 1px; border-left:0;}\r\n" + 
				"          .tax_invoice02 .td_chargeR{text-align:right; padding:0; border-left:#e66464 solid 1px; border-bottom:#e66464 solid 1px;}\r\n" + 
				"          .tax_invoice02 .td_chargeC{text-align:center; padding:0; border-left:0; border-top:0;}\r\n" + 
				"          /*.tax_invoice02 .li0201{color:#666; text-decoration:underline;}*/\r\n" + 
				"          .tax_invoice02 .li0202{color:#666; font-weight:bold;}\r\n" + 
				"          .tax_invoice02 .fontB{font-weight:bold;}\r\n" + 
				"          .center{text-align:center;}\r\n" + 
				"          .no_PaddingLR{padding-left:0; padding-right:0;}\r\n" + 
				"\r\n" + 
				"          .tax_invoice02 .BDouble{border-left:#e66464 double 1px; border-left-width:3px;}\r\n" + 
				"          .tax_invoice02 .title02-2{color:#fe6d69; text-align:center; line-height:15px; padding:3px 0 0 0;}\r\n" + 
				"          .tax_invoice02 .td_height01{height:50px;}\r\n" + 
				"\r\n" + 
				"          /* 20140128 추가 */\r\n" + 
				"          .font11{font-size:11px;}\r\n" + 
				"          .td31{height:31px;}\r\n" + 
				"\r\n" + 
				"          /* // 테이블 end */\r\n" + 
				"          /*// 전자세금계산서-공급자용 END */\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"          /******************* Blue **********************/\r\n" + 
				"          .tax_table_Blue {position:relative; border:#666699 solid 1px; padding:1px; z-index:99999; width:642px;}\r\n" + 
				"          /* 테이블 헤더 start */\r\n" + 
				"          .tax_invoice01_Blue {border-top:#666699 solid 1px; border-left:#666699 solid 1px; border-right:#666699 solid 1px; border:#666699 solid 1px; border-collapse:collapse; width:100%; height:auto; table-layout:fixed; z-index:999; position:relative;}\r\n" + 
				"          .tax_invoice01_Blue td {border-bottom:#666699 solid 1px; color:#666; padding:2px 0 0 2px; background:none;}\r\n" + 
				"          .tax_invoice01_Blue th{padding:4px 0 1px 0; line-height:150%; color:#666699; font-weight:normal; border-bottom:#666699 solid 1px;}\r\n" + 
				"          .title_Blue{font-size:18px; font-weight:bold; color:#666699; text-align:center;}\r\n" + 
				"          .title_long_Blue{font-size:12px; font-weight:bold; color:#666699; text-align:center;}\r\n" + 
				"          .tax_invoice01_Blue td.td3_Blue{color:#666; border-left:#666699 solid 1px; border-bottom:#666699 solid 1px;}\r\n" + 
				"          .td4_Blue{border-right:#666699 solid 1px;}\r\n" + 
				"          /* // 테이블 헤더 end */\r\n" + 
				"\r\n" + 
				"          /* 테이블 start */\r\n" + 
				"          .tax_invoice02_Blue {margin-top:2px; border-top:#666699 solid 1px; border-right:#666699 solid 1px; border-collapse:collapse; width:100%; table-layout:fixed; word-break:break-all; z-index:999; position:relative;}\r\n" + 
				"          .tax_invoice02_Blue td {border-bottom:#666699 solid 1px; border-left:#666699 solid 1px; padding:2px 2px 0 2px; color:#666; vertical-align:middle;}\r\n" + 
				"          .tax_invoice02_Blue th{border-bottom:#666699 solid 1px; border-left:#666699 solid 1px;  font-weight:normal; color:#666699; text-align:center; padding:4px 0 1px 0; line-height:150%; vertical-align:middle;}\r\n" + 
				"          .tax_invoice02 th_Blue .invoice02_th_Blue{border:none;  font-weight:normal; color:#666699; text-align:center;}\r\n" + 
				"\r\n" + 
				"          .tax_invoice02_Blue .td_chargeL{text-align:left; padding:0; border-bottom:#666699 solid 1px; border-left:0;}\r\n" + 
				"          .tax_invoice02_Blue .td_chargeR{text-align:right; padding:0; border-left:#666699 solid 1px; border-bottom:#666699 solid 1px;}\r\n" + 
				"          .tax_invoice02_Blue .td_chargeC{text-align:center; padding:0; border-left:0; border-top:0;}\r\n" + 
				"          /*.tax_invoice02_Blue .li0201{color:#666; text-decoration:underline;}*/\r\n" + 
				"          .tax_invoice02_Blue .li0202{color:#666; font-weight:bold;}\r\n" + 
				"          .tax_invoice02_Blue .fontB_Blue{font-weight:bold;}\r\n" + 
				"\r\n" + 
				"          .tax_invoice02_Blue .BDouble_Blue{border-left:#666699 double 1px; border-left-width:3px;}\r\n" + 
				"          .tax_invoice02_Blue .title02-2_Blue{color:#666699; text-align:center; line-height:15px; padding:3px 0 0 0;}\r\n" + 
				"          .tax_invoice02_Blue .td_height01_Blue{height:50px;}\r\n" + 
				"          /* // 테이블 end */\r\n" + 
				"          /*// 전자세금계산서-공급받는자용 END */\r\n" + 
				"\r\n" + 
				"          /******************* Gray **********************/\r\n" + 
				"          .tax_table_Gray {position:relative; border:#666 solid 1px; padding:1px; z-index:99999; width:642px;}\r\n" + 
				"          /* 테이블 헤더 start */\r\n" + 
				"          .tax_invoice01_Gray {border-top:#666 solid 1px; border-left:#666 solid 1px; border-right:#666 solid 1px; border:#666 solid 1px; border-collapse:collapse; width:100%; height:auto; table-layout:fixed; z-index:999; position:relative;}\r\n" + 
				"          .tax_invoice01_Gray td {border-bottom:#666 solid 1px; color:#666; padding:2px 0 0 2px; background:none;}\r\n" + 
				"          .tax_invoice01_Gray th{padding:4px 0 1px 0; line-height:150%; color:#666; font-weight:normal; border-bottom:#666 solid 1px;}\r\n" + 
				"          .title_Gray{font-size:18px; font-weight:bold; color:#666; text-align:center;}\r\n" + 
				"          .title_long_Gray{font-size:12px; font-weight:bold; color:#666; text-align:center;}\r\n" + 
				"          .tax_invoice01_Gray td.td3_Gray{color:#666; border-left:#666 solid 1px; border-bottom:#666 solid 1px;}\r\n" + 
				"          .td4_Gray{border-right:#666 solid 1px;}\r\n" + 
				"          /* // 테이블 헤더 end */\r\n" + 
				"\r\n" + 
				"          /* 테이블 start */\r\n" + 
				"          .tax_invoice02_Gray {margin-top:2px; border-top:#666 solid 1px; border-right:#666 solid 1px; border-collapse:collapse; width:100%; table-layout:fixed; word-break:break-all; z-index:999; position:relative;}\r\n" + 
				"          .tax_invoice02_Gray td {border-bottom:#666 solid 1px; border-left:#666 solid 1px; padding:2px 2px 0 2px; color:#666; vertical-align:middle;}\r\n" + 
				"          .tax_invoice02_Gray th{border-bottom:#666 solid 1px; border-left:#666 solid 1px;  font-weight:normal; color:#666; text-align:center; padding:4px 0 1px 0; line-height:150%; vertical-align:middle;}\r\n" + 
				"          .tax_invoice02 th_Gray .invoice02_th_Gray{border:none;  font-weight:normal; color:#666; text-align:center;}\r\n" + 
				"\r\n" + 
				"          .tax_invoice02_Gray .td_chargeL{text-align:left; padding:0; border-bottom:#666 solid 1px; border-left:0;}\r\n" + 
				"          .tax_invoice02_Gray .td_chargeR{text-align:right; padding:0; border-left:#666 solid 1px; border-bottom:#666 solid 1px;}\r\n" + 
				"          .tax_invoice02_Gray .td_chargeC{text-align:center; padding:0; border-left:0; border-top:0;}\r\n" + 
				"          /*.tax_invoice02_Gray .li0201{color:#666; text-decoration:underline;}*/\r\n" + 
				"          .tax_invoice02_Gray .li0202{color:#666; font-weight:bold;}\r\n" + 
				"          .tax_invoice02_Gray .fontB_Gray{font-weight:bold;}\r\n" + 
				"\r\n" + 
				"          .tax_invoice02_Gray .BDouble_Gray{border-left:#666 double 1px; border-left-width:3px;}\r\n" + 
				"          .tax_invoice02_Gray .title02-2_Gray{color:#666; text-align:center; line-height:15px; padding:3px 0 0 0;}\r\n" + 
				"          .tax_invoice02_Gray .td_height01_Gray{height:50px;}\r\n" + 
				"          /* // 테이블 end */\r\n" + 
				"          /*// 전자세금계산서-거래명세서 END */\r\n" + 
				"\r\n" + 
				"          /* ------------------------------------------------------------------------------------ */\r\n" + 
				"          /*									Print CSS											*/\r\n" + 
				"          /* ------------------------------------------------------------------------------------ */\r\n" + 
				"          @media print {\r\n" + 
				"          div {color:black;}\r\n" + 
				"          td  {font-family:NanumGothic, 돋움, Dotum, 굴림, Gulim, Arial, sans-serif, Verdana, Helvetica, geneva; font-size: 10px; line-height:130%; color:black; padding:0;  height:auto;}\r\n" + 
				"          a:link     {color:black;}\r\n" + 
				"          a:visited  {color:black;}\r\n" + 
				"          #print_wrap{width:100%; margin:0;}\r\n" + 
				"          .page-break  {display: block; page-break-after: always; }\r\n" + 
				"          .page-break_before  {display: block; page-break-before: always; }\r\n" + 
				"\r\n" + 
				"          #print_option {display:none;}\r\n" + 
				"\r\n" + 
				"          /******************* Red *******************/\r\n" + 
				"          .tax_table {border:#d44747 solid 1px; padding:1px; *padding:2px 0 0 2px; /* ie7 */ }\r\n" + 
				"\r\n" + 
				"          .tax_invoice01 {border-top:#d44747 solid 1px; border-left:#d44747 solid 1px; border-right:#d44747 solid 1px; border:#d44747 solid 1px; border-collapse:collapse; line-height:130%;}\r\n" + 
				"          .tax_invoice01 td {border-bottom:#d44747 solid 1px; color:#d44747; padding:2px 0 0 2px; height:auto;}\r\n" + 
				"          .tax_invoice01 th{padding:4px 0 1px 0; line-height:120%; color:#d44747; border-bottom:#d44747 solid 1px;}\r\n" + 
				"          .title{color:#d44747;}\r\n" + 
				"          .title_long{color:#d44747;}\r\n" + 
				"          .tax_invoice01 td.td3{border-left:#d44747 solid 1px; border-bottom:#d44747 solid 1px;}\r\n" + 
				"          .td4{border-right:#d44747 solid 1px;}\r\n" + 
				"\r\n" + 
				"          .tax_invoice02 {border-top:#d44747 solid 1px; border-right:#d44747 solid 1px; border-collapse:collapse; line-height:130%;}\r\n" + 
				"          .tax_invoice02 td {border-bottom:#d44747 solid 1px; border-left:#d44747 solid 1px; color:black; height:auto;}\r\n" + 
				"          .tax_invoice02 th{border-bottom:#d44747 solid 1px; border-left:#d44747 solid 1px; color:#d44747; line-height:120%;}\r\n" + 
				"          .tax_invoice02 .title02-1{color:#d44747; border-left:#d44747 solid 1px;}\r\n" + 
				"          .tax_invoice02 .title02-2{color:#d44747;}\r\n" + 
				"          .tax_invoice02 .BDouble{border-left:#d44747 double 1px; border-left-width:3px;}\r\n" + 
				"\r\n" + 
				"          .tax_invoice02 .td_chargeL{border-bottom:#d44747 solid 1px;}\r\n" + 
				"          .tax_invoice02 .td_chargeR{border-left:#d44747 solid 1px; border-bottom:#d44747 solid 1px;}\r\n" + 
				"          /*.tax_invoice02 .li0201{color:black;}*/\r\n" + 
				"          .tax_invoice02 .li0202{color:black;}\r\n" + 
				"          /*.tax_invoice02 .li0201{color:black;}*/\r\n" + 
				"          .font11{font-size:10px; /*font-size:9px; 20140319 합계금액 테스트*/} /* 20140128 추가 */\r\n" + 
				"\r\n" + 
				"          /******************* Blue *******************/\r\n" + 
				"          .tax_table_Blue {border:#363e86 solid 1px; padding:1px; *padding:2px 0 0 2px; /* ie7 */ }\r\n" + 
				"\r\n" + 
				"          .tax_invoice01_Blue {border-top:#363e86 solid 1px; border-left:#363e86 solid 1px; border-right:#363e86 solid 1px; border:#363e867 solid 1px; border-collapse:collapse; line-height:130%;}\r\n" + 
				"          .tax_invoice01_Blue td {border-bottom:#363e86 solid 1px; color:#363e86; padding:2px 0 0 2px; height:auto;}\r\n" + 
				"          .tax_invoice01_Blue th{padding:4px 0 1px 0; line-height:120%; color:#363e86; border-bottom:#363e86 solid 1px;}\r\n" + 
				"          .title_Blue{color:#363e86;}\r\n" + 
				"          .title_long_Blue{color:#363e86;}\r\n" + 
				"          .tax_invoice01_Blue td.td3_Blue{border-left:#363e86 solid 1px; border-bottom:#363e86 solid 1px;}\r\n" + 
				"          .td4_Blue{border-right:#363e86 solid 1px;}\r\n" + 
				"\r\n" + 
				"          .tax_invoice02_Blue {border-top:#363e86 solid 1px; border-right:#363e86 solid 1px; border-collapse:collapse; line-height:130%;}\r\n" + 
				"          .tax_invoice02_Blue td {border-bottom:#363e86 solid 1px; border-left:#363e86 solid 1px; color:black; height:auto;}\r\n" + 
				"          .tax_invoice02_Blue th{border-bottom:#363e86 solid 1px; border-left:#363e86 solid 1px; color:#363e86; line-height:120%;}\r\n" + 
				"          .tax_invoice02_Blue .title02-1_Blue{color:#363e86; border-left:#363e86 solid 1px;}\r\n" + 
				"          .tax_invoice02_Blue .title02-2_Blue{color:#363e86;}\r\n" + 
				"          .tax_invoice02_Blue .BDouble_Blue{border-left:#363e86 double 1px; border-left-width:3px;}\r\n" + 
				"\r\n" + 
				"          .tax_invoice02_Blue .td_chargeL_Blue{border-bottom:#363e86 solid 1px;}\r\n" + 
				"          .tax_invoice02_Blue .td_chargeR_Blue{border-left:#363e86 solid 1px; border-bottom:#363e86 solid 1px;}\r\n" + 
				"          .tax_invoice02_Blue .li0201{color:black;}\r\n" + 
				"          .tax_invoice02_Blue .li0202{color:black;}\r\n" + 
				"\r\n" + 
				"          /******************* Gray *******************/\r\n" + 
				"          .tax_table_Gray {padding:1px; *padding:2px 0 0 2px; /* ie7 */ }\r\n" + 
				"\r\n" + 
				"          .tax_invoice01_Gray {line-height:130%;}\r\n" + 
				"          .tax_invoice01_Gray td {padding:2px 0 0 2px; height:auto;}\r\n" + 
				"          .tax_invoice01_Gray th{padding:4px 0 1px 0; line-height:120%; color:#666;}\r\n" + 
				"          .title_Gray{color:#666;}\r\n" + 
				"          .title_long_Gray{color:#666;}\r\n" + 
				"\r\n" + 
				"          .tax_invoice02_Gray {line-height:130%;}\r\n" + 
				"          .tax_invoice02_Gray td {color:black; height:auto;}\r\n" + 
				"          .tax_invoice02_Gray th{color:#666; line-height:120%;}\r\n" + 
				"          .tax_invoice02_Gray .title02-1_Gray{color:#666;}\r\n" + 
				"          .tax_invoice02_Gray .title02-2_Gray{color:#666;}\r\n" + 
				"          .tax_invoice02_Gray .BDouble_Gray{border-left:#666 double 1px; border-left-width:3px;}\r\n" + 
				"\r\n" + 
				"          .tax_invoice02_Gray .li0201{color:black;}\r\n" + 
				"          .tax_invoice02_Gray .li0202{color:black;}\r\n" + 
				"          }\r\n" + 
				"        </style>\r\n" + 
				"      </head>\r\n" + 
				"\r\n" + 
				"      <body>\r\n" + 
				"        <div class=\"taxBillDivision\" style=\"padding: 0px 0px 0px 12px\"><!-- DTI Data Area 정보 보이기 호출 -->\r\n" + 
				"          <xsl:call-template name=\"DataArea\"/>\r\n" + 
				"\r\n" + 
				"          <div align=\"left\">\r\n" + 
				"            <br/>\r\n" + 
				"            <!-- 세금계산서/계산서 주의 보이기 Start -->\r\n" + 
				"            <p class=\"taxBillFormAttention\" id=\"taxBillFormAttention01\">\r\n" + 
				"              주의 : 본 세금계산서는 국세청고시 기준에 따라 발행된 전자세금계산서 입니다.\r\n" + 
				"            </p>          \r\n" + 
				"          </div>\r\n" + 
				"          <!-- 세금계산서/계산서 주의 보이기 End -->\r\n" + 
				"        </div>\r\n" + 
				"      </body>\r\n" + 
				"    </html>\r\n" + 
				"  </xsl:template>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"  <!-- 헤더 정보 보이기 Start -->\r\n" + 
				"  <xsl:template name=\"DTIHeader\">\r\n" + 
				"    <title>:: 전자세금계산서 ::</title>\r\n" + 
				"  </xsl:template>\r\n" + 
				"  <!-- 헤더 정보 보이기 End -->\r\n" + 
				"\r\n" + 
				"  <!--  DTI Data Area 정보 보이기 Start -->\r\n" + 
				"  <xsl:template name=\"DataArea\">\r\n" + 
				"    <!--  DTI Data Header 정보 보이기 호출 -->\r\n" + 
				"    <xsl:call-template name=\"DataHeader01\"/>\r\n" + 
				"  </xsl:template>\r\n" + 
				"  <!--  DTI Data Area 정보 보이기 End -->\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"  <!--  DTI Data Header 정보 보이기 Start -->\r\n" + 
				"  <!--  세금계산서 DTI Data Header 정보 보이기 Start -->\r\n" + 
				"  <xsl:template name=\"DataHeader01\">\r\n" + 
				"    <!-- 변수 선언 시작 -->\r\n" + 
				"    <xsl:variable name=\"HeaderDirPath\" select=\"/sb:TaxInvoice/sb:TaxInvoiceDocument\"/>\r\n" + 
				"    <xsl:variable name=\"SupplierPartyDirPath\" select=\"/sb:TaxInvoice/sb:TaxInvoiceTradeSettlement/sb:InvoicerParty\"/>\r\n" + 
				"    <xsl:variable name=\"BuyerPartyDirPath\" select=\"/sb:TaxInvoice/sb:TaxInvoiceTradeSettlement/sb:InvoiceeParty\"/>\r\n" + 
				"    <xsl:variable name=\"BrokerPartyDirPath\" select=\"/sb:TaxInvoice/sb:TaxInvoiceTradeSettlement/sb:BrokerParty\"/>\r\n" + 
				"    <xsl:variable name=\"SmartBillPath\" select=\"/sb:TaxInvoice/dti:SmartBillArea\"/>\r\n" + 
				"    <xsl:variable name=\"LineDirPath\" select=\"/sb:TaxInvoice/sb:TaxInvoiceTradeLineItem\"/>\r\n" + 
				"    <xsl:variable name=\"SummaryDirPath\" select=\"/sb:TaxInvoice/sb:TaxInvoiceTradeSettlement/sb:SpecifiedMonetarySummation\"/>\r\n" + 
				"    <xsl:variable name=\"PaymentMeansDirPath\" select=\"/sb:TaxInvoice/sb:TaxInvoiceTradeSettlement/sb:SpecifiedPaymentMeans\"/>\r\n" + 
				"    <xsl:variable name=\"DescriptionTextDirPath\" select=\"/sb:TaxInvoice/sb:TaxInvoiceDocument/sb:DescriptionText\"/>\r\n" + 
				"    <!-- 변수 선언 종료 -->\r\n" + 
				"\r\n" + 
				"    <div class=\"tax_invoice\">\r\n" + 
				"\r\n" + 
				"      <div class=\"tax_table_Blue\" id=\"dtiTable\" >\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"        <!--당초승인번호 포함 테이블헤더 start -->\r\n" + 
				"        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"  width=\"100%\"  id=\"dti_table01\" class=\"tax_invoice01_Blue\" summary=\"전자세금계산서 승인번호, 관리번호\">\r\n" + 
				"          <caption>전자세금계산서 승인번호, 관리번호</caption>\r\n" + 
				"          <colgroup>\r\n" + 
				"            <col width=\"41%\"/>\r\n" + 
				"            <col width=\"15%\"/>\r\n" + 
				"            <col width=\"5%\"/>\r\n" + 
				"            <col width=\"12%\"/>\r\n" + 
				"            <col width=\"%\"/>\r\n" + 
				"          </colgroup>\r\n" + 
				"          <tr>\r\n" + 
				"            <th rowspan=\"2\">\r\n" + 
				"              <!--2013.11.27 : 수정세금계산서 당초승인번호 추가로 rowspan=2에서3으로 변경-->\r\n" + 
				"              <xsl:if test=\"$HeaderDirPath/sb:OriginalIssueID\">\r\n" + 
				"                <xsl:attribute name=\"rowspan\">\r\n" + 
				"                  3\r\n" + 
				"                </xsl:attribute>\r\n" + 
				"              </xsl:if>\r\n" + 
				"\r\n" + 
				"              <h1 id=\"dti_h1\" class=\"title_Blue\">\r\n" + 
				"                <xsl:choose>\r\n" + 
				"                  <xsl:when test=\"string-length($HeaderDirPath/sb:AmendmentStatusCode) > 0\">\r\n" + 
				"                    수정\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                </xsl:choose>\r\n" + 
				"\r\n" + 
				"                <xsl:choose>\r\n" + 
				"                  <xsl:when test=\"substring($HeaderDirPath/sb:TypeCode,3,2) = '02'\">\r\n" + 
				"                    영세율\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                </xsl:choose>\r\n" + 
				"\r\n" + 
				"                전자세금계산서\r\n" + 
				"              </h1>\r\n" + 
				"            </th>\r\n" + 
				"            <th rowspan=\"2\" class=\"td2\">\r\n" + 
				"              <!--2013.11.27 : 수정세금계산서 당초승인번호 추가로 rowspan=2에서3으로 변경-->\r\n" + 
				"              <xsl:if test=\"$HeaderDirPath/sb:OriginalIssueID\">\r\n" + 
				"                <xsl:attribute name=\"rowspan\">\r\n" + 
				"                  3\r\n" + 
				"                </xsl:attribute>\r\n" + 
				"              </xsl:if>\r\n" + 
				"\r\n" + 
				"              <span id=\"dtiTableTitle\">공급받는자</span><br />(보관용)\r\n" + 
				"            </th>\r\n" + 
				"            <td rowspan=\"2\" id=\"dti_td\" class=\"td4_Blue\">\r\n" + 
				"              <!--2013.11.27 : 수정세금계산서 당초승인번호 추가로 rowspan=2에서3으로 변경-->\r\n" + 
				"              <xsl:if test=\"$HeaderDirPath/sb:OriginalIssueID\">\r\n" + 
				"                <xsl:attribute name=\"rowspan\">\r\n" + 
				"                  3\r\n" + 
				"                </xsl:attribute>\r\n" + 
				"              </xsl:if>\r\n" + 
				"            </td>\r\n" + 
				"            <th>승인번호</th>\r\n" + 
				"            <td class=\"td3\">\r\n" + 
				"              <xsl:choose>\r\n" + 
				"                <xsl:when test=\"string-length($HeaderDirPath/sb:IssueID)=24\">\r\n" + 
				"                  <xsl:value-of select=\"$HeaderDirPath/sb:IssueID\"/>\r\n" + 
				"                </xsl:when>\r\n" + 
				"              </xsl:choose>\r\n" + 
				"            </td>\r\n" + 
				"          </tr>\r\n" + 
				"          <!--당초승인번호 포함 start -->\r\n" + 
				"          <xsl:if test=\"$HeaderDirPath/sb:OriginalIssueID\">\r\n" + 
				"            <tr>\r\n" + 
				"              <th>당초승인번호</th>\r\n" + 
				"              <td class=\"td3\">\r\n" + 
				"                <xsl:value-of select=\"$HeaderDirPath/sb:OriginalIssueID\"/>\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"          </xsl:if>\r\n" + 
				"          <!--당초승인번호 포함 end -->\r\n" + 
				"          <tr>\r\n" + 
				"            <th>관리번호</th>\r\n" + 
				"            <td class=\"td3\">\r\n" + 
				"              <xsl:value-of select=\"/sb:TaxInvoice/sb:ExchangedDocument/sb:ReferencedDocument/sb:ID\"/>\r\n" + 
				"            </td>\r\n" + 
				"          </tr>\r\n" + 
				"        </table>\r\n" + 
				"\r\n" + 
				"        <table id=\"dti_table02\" class=\"tax_invoice02_Blue\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" summary=\"공급자, 공급받는자 정보\">\r\n" + 
				"          <caption>\r\n" + 
				"            공급자, 공급받는자 정보\r\n" + 
				"          </caption>\r\n" + 
				"          <colgroup>\r\n" + 
				"            <col width=\"3%\"/>\r\n" + 
				"            <col width=\"8%\"/>\r\n" + 
				"            <col width=\"17%\"/>\r\n" + 
				"            <col width=\"1%\"/>\r\n" + 
				"            <col width=\"7%\"/>\r\n" + 
				"            <col width=\"\"/>\r\n" + 
				"            <col width=\"3%\"/>\r\n" + 
				"            <col width=\"8%\"/>\r\n" + 
				"            <col width=\"17%\"/>\r\n" + 
				"            <col width=\"1%\"/>\r\n" + 
				"            <col width=\"7%\"/>\r\n" + 
				"            <col width=\"\"/>\r\n" + 
				"          </colgroup>\r\n" + 
				"\r\n" + 
				"          <tr>\r\n" + 
				"            <th class=\"title02-1 fontB\" rowspan=\"4\">공<br />급<br />자<br /></th>\r\n" + 
				"            <th>등록번호</th>\r\n" + 
				"            <td class=\"tax_bold01\" colspan=\"4\">\r\n" + 
				"              <xsl:value-of select=\"substring($SupplierPartyDirPath/sb:ID,1,3)\"/>\r\n" + 
				"              <xsl:value-of select=\"'-'\"/>\r\n" + 
				"              <xsl:value-of select=\"substring($SupplierPartyDirPath/sb:ID,4,2)\"/>\r\n" + 
				"              <xsl:value-of select=\"'-'\"/>\r\n" + 
				"              <xsl:value-of select=\"substring($SupplierPartyDirPath/sb:ID,6,5)\"/>\r\n" + 
				"            </td>\r\n" + 
				"            <th class=\"title02-1 fontB\" rowspan=\"4\">공<br />급<br />받<br />는<br />자<br /></th>\r\n" + 
				"            <th>등록번호</th>\r\n" + 
				"            <td class=\"tax_bold01\" colspan=\"4\">\r\n" + 
				"              <xsl:variable name=\"BuyerPartyID\" select=\"$BuyerPartyDirPath/sb:ID\"/>\r\n" + 
				"              <xsl:choose>\r\n" + 
				"                <xsl:when test=\"string-length($BuyerPartyDirPath/sb:ID)=10\">\r\n" + 
				"                  <xsl:value-of select=\"substring($BuyerPartyDirPath/sb:ID,1,3)\"/>\r\n" + 
				"                  <xsl:value-of select=\"'-'\"/>\r\n" + 
				"                  <xsl:value-of select=\"substring($BuyerPartyDirPath/sb:ID,4,2)\"/>\r\n" + 
				"                  <xsl:value-of select=\"'-'\"/>\r\n" + 
				"                  <xsl:value-of select=\"substring($BuyerPartyDirPath/sb:ID,6,5)\"/>\r\n" + 
				"                </xsl:when>\r\n" + 
				"                <xsl:when test=\"string-length($BuyerPartyDirPath/sb:ID)=13\">\r\n" + 
				"                  <xsl:value-of select=\"substring($BuyerPartyDirPath/sb:ID,1,6)\"/>\r\n" + 
				"                  <xsl:value-of select=\"'-'\"/>\r\n" + 
				"                  <xsl:value-of select=\"substring($BuyerPartyDirPath/sb:ID,7,7)\"/>\r\n" + 
				"                </xsl:when>\r\n" + 
				"              </xsl:choose>\r\n" + 
				"            </td>\r\n" + 
				"          </tr>\r\n" + 
				"          <tr>\r\n" + 
				"            <th>\r\n" + 
				"              상호<br />\r\n" + 
				"              (법인명)\r\n" + 
				"            </th>\r\n" + 
				"            <td colspan=\"2\">\r\n" + 
				"              <xsl:value-of select=\"$SupplierPartyDirPath/sb:NameText\"/>\r\n" + 
				"            </td>\r\n" + 
				"            <th>성명</th>\r\n" + 
				"            <td>\r\n" + 
				"              <xsl:value-of select=\"$SupplierPartyDirPath/sb:SpecifiedPerson/sb:NameText\"/>\r\n" + 
				"            </td>\r\n" + 
				"            <th>\r\n" + 
				"              상호<br />\r\n" + 
				"              (법인명)\r\n" + 
				"            </th>\r\n" + 
				"            <td colspan=\"2\">\r\n" + 
				"              <xsl:value-of select=\"$BuyerPartyDirPath/sb:NameText\"/>\r\n" + 
				"            </td>\r\n" + 
				"            <th>성명</th>\r\n" + 
				"            <td>\r\n" + 
				"              <xsl:value-of select=\"$BuyerPartyDirPath/sb:SpecifiedPerson/sb:NameText\"/>\r\n" + 
				"            </td>\r\n" + 
				"          </tr>\r\n" + 
				"          <tr>\r\n" + 
				"            <th>\r\n" + 
				"              사업장<br />\r\n" + 
				"              주소\r\n" + 
				"            </th>\r\n" + 
				"            <td colspan=\"2\">\r\n" + 
				"              <xsl:value-of select=\"$SupplierPartyDirPath/sb:SpecifiedAddress/sb:LineOneText\"/>\r\n" + 
				"            </td>\r\n" + 
				"            <th>종사업장<br />번호</th>\r\n" + 
				"            <td>\r\n" + 
				"              <xsl:value-of select=\"$SupplierPartyDirPath/sb:SpecifiedOrganization/sb:TaxRegistrationID\"/>\r\n" + 
				"            </td>\r\n" + 
				"            <th>\r\n" + 
				"              사업장<br />\r\n" + 
				"              주소\r\n" + 
				"            </th>\r\n" + 
				"            <td colspan=\"2\">\r\n" + 
				"              <xsl:value-of select=\"$BuyerPartyDirPath/sb:SpecifiedAddress/sb:LineOneText\"/>\r\n" + 
				"            </td>\r\n" + 
				"            <th>종사업장<br />번호</th>\r\n" + 
				"            <td>\r\n" + 
				"              <xsl:value-of select=\"$BuyerPartyDirPath/sb:SpecifiedOrganization/sb:TaxRegistrationID\"/>\r\n" + 
				"            </td>\r\n" + 
				"          </tr>\r\n" + 
				"          <tr>\r\n" + 
				"            <th>업태</th>\r\n" + 
				"            <td colspan=\"2\">\r\n" + 
				"              <xsl:value-of select=\"$SupplierPartyDirPath/sb:TypeCode\"/>\r\n" + 
				"            </td>\r\n" + 
				"            <th>종목</th>\r\n" + 
				"            <td>\r\n" + 
				"              <xsl:value-of select=\"$SupplierPartyDirPath/sb:ClassificationCode\"/>\r\n" + 
				"            </td>\r\n" + 
				"            <th>업태</th>\r\n" + 
				"            <td colspan=\"2\">\r\n" + 
				"              <xsl:value-of select=\"$BuyerPartyDirPath/sb:TypeCode\"/>\r\n" + 
				"            </td>\r\n" + 
				"            <th>종목</th>\r\n" + 
				"            <td>\r\n" + 
				"              <xsl:value-of select=\"$BuyerPartyDirPath/sb:ClassificationCode\"/>\r\n" + 
				"            </td>\r\n" + 
				"          </tr>\r\n" + 
				"        </table>\r\n" + 
				"        <!--//테이블헤더 end -->\r\n" + 
				"\r\n" + 
				"        <!--공급가액 및 세액 start -->\r\n" + 
				"        <table id=\"dti_table03\" class=\"tax_invoice02_Blue\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" summary=\"작성일자, 공급가액, 세액, 수정사유, 비고\">\r\n" + 
				"          <caption>작성일자, 공급가액, 세액, 수정사유, 비고</caption>\r\n" + 
				"          <colgroup>\r\n" + 
				"            <col width=\"11%\"/>\r\n" + 
				"            <col width=\"18%\"/>\r\n" + 
				"            <col width=\"21%\"/>\r\n" + 
				"            <col width=\"50%\"/>\r\n" + 
				"          </colgroup>\r\n" + 
				"          <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"              <th class=\"fontB td31\">작성일자</th>\r\n" + 
				"              <th class=\"fontB td31\">공급가액</th>\r\n" + 
				"              <th class=\"fontB td31\">세 액</th>\r\n" + 
				"              <th class=\"fontB td31\">수정사유</th>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" + 
				"              <td class=\"center td31\" style=\"height:31px\">\r\n" + 
				"                <xsl:value-of select=\"substring($HeaderDirPath/sb:IssueDateTime,1,4)\"/>\r\n" + 
				"                <xsl:value-of select=\"'/'\"/>\r\n" + 
				"                <xsl:value-of select=\"substring($HeaderDirPath/sb:IssueDateTime,5,2)\"/>\r\n" + 
				"                <xsl:value-of select=\"'/'\"/>\r\n" + 
				"                <xsl:value-of select=\"substring($HeaderDirPath/sb:IssueDateTime,7,2)\"/>\r\n" + 
				"              </td>\r\n" + 
				"              <td class=\"cell_right01 td31\">\r\n" + 
				"                <xsl:value-of select=\"format-number($SummaryDirPath/sb:ChargeTotalAmount,'#,##0.####')\"/>\r\n" + 
				"              </td>\r\n" + 
				"              <td class=\"cell_right01 td31\">\r\n" + 
				"                <xsl:value-of select=\"format-number($SummaryDirPath/sb:TaxTotalAmount,'#,##0.####')\"/>\r\n" + 
				"              </td>\r\n" + 
				"              <td class=\"td31\">\r\n" + 
				"                <xsl:variable name=\"AmendCode\" select=\"$HeaderDirPath/sb:AmendmentStatusCode\"/>\r\n" + 
				"                <xsl:choose>\r\n" + 
				"                  <xsl:when test=\"$AmendCode = ''\">\r\n" + 
				"                    <xsl:text>  </xsl:text>\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                  <xsl:when test=\"$AmendCode = '03'\">\r\n" + 
				"                    <xsl:text>환입</xsl:text>\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                  <xsl:when test=\"$AmendCode = '04'\">\r\n" + 
				"                    <xsl:text>계약의 해제</xsl:text>\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                  <xsl:when test=\"$AmendCode = '05'\">\r\n" + 
				"                    <xsl:text>내국신용장 사후 개설</xsl:text>\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                  <xsl:when test=\"$AmendCode = '02'\">\r\n" + 
				"                    <xsl:text>공급가액 변동</xsl:text>\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                  <xsl:when test=\"$AmendCode = '01'\">\r\n" + 
				"                    <xsl:text>기재사항의 착오·정정 등</xsl:text>\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                  <xsl:when test=\"$AmendCode = '06'\">\r\n" + 
				"                    <xsl:text>착오에 의한 이중발급 등</xsl:text>\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                  <xsl:otherwise>\r\n" + 
				"                    <xsl:text></xsl:text>\r\n" + 
				"                  </xsl:otherwise>\r\n" + 
				"                </xsl:choose>\r\n" + 
				"              </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <xsl:for-each select=\"$DescriptionTextDirPath\">\r\n" + 
				"              <xsl:variable name=\"curRow\" select=\"position()\"/>\r\n" + 
				"              <xsl:variable name=\"lastRow\" select=\"last()\"/>\r\n" + 
				"              <tr>\r\n" + 
				"                <th class=\"center fontB\">\r\n" + 
				"                  비 고 <xsl:value-of select=\"$curRow\"/>\r\n" + 
				"                </th>\r\n" + 
				"                <td colspan=\"3\">\r\n" + 
				"                  <xsl:value-of select=\".\"/>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"            </xsl:for-each>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>\r\n" + 
				"        <!--//공급가액 및 세액 end -->\r\n" + 
				"\r\n" + 
				"        <!--품목별 단가 start -->\r\n" + 
				"        <table id=\"dti_table04\" class=\"tax_invoice02_Blue\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" summary=\"월, 일, 품목, 규격, 수량, 단가, 공급가액, 세액, 비고\">\r\n" + 
				"          <caption>월, 일, 품목, 규격, 수량, 단가, 공급가액, 세액, 비고</caption>\r\n" + 
				"          <colgroup>\r\n" + 
				"            <col width=\"3%\"/>\r\n" + 
				"            <col width=\"3%\"/>\r\n" + 
				"            <col width=\"17%\"/>\r\n" + 
				"            <col width=\"8%\"/>\r\n" + 
				"            <col width=\"8%\"/>\r\n" + 
				"            <col width=\"18%\"/>\r\n" + 
				"            <col width=\"18%\"/>\r\n" + 
				"            <col width=\"16%\"/>\r\n" + 
				"            <col width=\"9%\"/>\r\n" + 
				"          </colgroup>\r\n" + 
				"          <thead>\r\n" + 
				"            <tr>\r\n" + 
				"              <th class=\"fontB\">월</th>\r\n" + 
				"              <th class=\"fontB\">일</th>\r\n" + 
				"              <th class=\"fontB\">품 목</th>\r\n" + 
				"              <th class=\"fontB\">규 격</th>\r\n" + 
				"              <th class=\"fontB\">수 량</th>\r\n" + 
				"              <th class=\"fontB\">단가</th>\r\n" + 
				"              <th class=\"fontB\">공 급 가 액</th>\r\n" + 
				"              <th class=\"fontB\">세 액</th>\r\n" + 
				"              <th class=\"fontB\">비고</th>\r\n" + 
				"            </tr>\r\n" + 
				"          </thead>\r\n" + 
				"          <tbody>\r\n" + 
				"            <!-- 품목 리스트 정보 보이기 Start -->\r\n" + 
				"            <xsl:for-each select=\"$LineDirPath\">\r\n" + 
				"              <tr>\r\n" + 
				"                <!-- 품목월 00이거나 null 보이지 않는다 -->\r\n" + 
				"                <xsl:choose>\r\n" + 
				"                  <xsl:when test=\"substring(sb:PurchaseExpiryDateTime,5,2)='00'\">\r\n" + 
				"                    <td class=\"center\"></td>\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                  <xsl:otherwise>\r\n" + 
				"                    <td class=\"center\">\r\n" + 
				"                      <xsl:value-of select=\"substring(sb:PurchaseExpiryDateTime,5,2)\"/>\r\n" + 
				"                    </td>\r\n" + 
				"                  </xsl:otherwise>\r\n" + 
				"                </xsl:choose>\r\n" + 
				"\r\n" + 
				"                <!-- 품목일 00이거나 null 이면 보이지 않는다 -->\r\n" + 
				"                <xsl:choose>\r\n" + 
				"                  <xsl:when test=\"substring(sb:PurchaseExpiryDateTime,7,2)='00'\">\r\n" + 
				"                    <td class=\"center\"></td>\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                  <xsl:otherwise>\r\n" + 
				"                    <td class=\"center\">\r\n" + 
				"                      <xsl:value-of select=\"substring(sb:PurchaseExpiryDateTime,7,2)\"/>\r\n" + 
				"                    </td>\r\n" + 
				"                  </xsl:otherwise>\r\n" + 
				"                </xsl:choose>\r\n" + 
				"\r\n" + 
				"                <!--  ###품목### -->\r\n" + 
				"                <td>\r\n" + 
				"                  <xsl:value-of select=\"sb:NameText\"/>\r\n" + 
				"                </td>\r\n" + 
				"\r\n" + 
				"                <!--  ###규격### -->\r\n" + 
				"                <td class=\"center\">\r\n" + 
				"                  <xsl:value-of select=\"sb:InformationText\"/>\r\n" + 
				"                </td>\r\n" + 
				"\r\n" + 
				"                <!-- 수량 (format:#,###.####) -->\r\n" + 
				"                <xsl:choose>\r\n" + 
				"                  <xsl:when test=\"string-length(sb:ChargeableUnitQuantity)=0\">\r\n" + 
				"                    <td class=\"center\"></td>\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                  <xsl:otherwise>\r\n" + 
				"                    <xsl:choose>\r\n" + 
				"                      <xsl:when test=\"sb:ChargeableUnitQuantity != 0\">\r\n" + 
				"                        <td class=\"center\">\r\n" + 
				"                          <xsl:value-of select=\"format-number(sb:ChargeableUnitQuantity,'#,##0.####')\"/>\r\n" + 
				"                        </td>\r\n" + 
				"                      </xsl:when>\r\n" + 
				"                      <xsl:otherwise>\r\n" + 
				"                        <td class=\"center\">\r\n" + 
				"                          <xsl:value-of select=\"format-number(sb:ChargeableUnitQuantity,'#,###.####')\"/>\r\n" + 
				"                        </td>\r\n" + 
				"                      </xsl:otherwise>\r\n" + 
				"                    </xsl:choose>\r\n" + 
				"                  </xsl:otherwise>\r\n" + 
				"                </xsl:choose>\r\n" + 
				"\r\n" + 
				"                <!-- 단가 (format:#,###.####) -->\r\n" + 
				"                <xsl:choose>\r\n" + 
				"                  <xsl:when test=\"string-length(sb:UnitPrice/sb:UnitAmount)=0\">\r\n" + 
				"                    <td class=\"cell_right01\"></td>\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                  <xsl:otherwise>\r\n" + 
				"                    <xsl:choose>\r\n" + 
				"                      <xsl:when test=\"sb:UnitPrice/sb:UnitAmount != 0\">\r\n" + 
				"                        <td class=\"cell_right01\">\r\n" + 
				"                          <xsl:value-of select=\"format-number(sb:UnitPrice/sb:UnitAmount,'#,##0.####')\"/>\r\n" + 
				"                        </td>\r\n" + 
				"                      </xsl:when>\r\n" + 
				"                      <xsl:otherwise>\r\n" + 
				"                        <td class=\"cell_right01\">\r\n" + 
				"                          <xsl:value-of select=\"format-number(sb:UnitPrice/sb:UnitAmount,'#,###.####')\"/>\r\n" + 
				"                        </td>\r\n" + 
				"                      </xsl:otherwise>\r\n" + 
				"                    </xsl:choose>\r\n" + 
				"                  </xsl:otherwise>\r\n" + 
				"                </xsl:choose>\r\n" + 
				"\r\n" + 
				"                <!-- 공급가액 (format:#,###.####) -->\r\n" + 
				"                <xsl:choose>\r\n" + 
				"                  <xsl:when test=\"string-length(sb:InvoiceAmount)=0\">\r\n" + 
				"                    <td class=\"cell_right01\"></td>\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                  <xsl:otherwise>\r\n" + 
				"                    <td class=\"cell_right01\">\r\n" + 
				"                      <xsl:value-of select=\"format-number(sb:InvoiceAmount,'#,###.####')\"/>\r\n" + 
				"                    </td>\r\n" + 
				"                  </xsl:otherwise>\r\n" + 
				"                </xsl:choose>\r\n" + 
				"\r\n" + 
				"                <!-- 세액 (format:#,###.####) -->\r\n" + 
				"                <xsl:choose>\r\n" + 
				"                  <xsl:when test=\"string-length(sb:TotalTax/sb:CalculatedAmount)=0\">\r\n" + 
				"                    <td class=\"cell_right01\"></td>\r\n" + 
				"                  </xsl:when>\r\n" + 
				"                  <xsl:otherwise>\r\n" + 
				"                    <xsl:choose>\r\n" + 
				"                      <xsl:when test=\"$LineDirPath/TotalTax/CalculatedAmount > 0\">\r\n" + 
				"                        <td class=\"cell_right01\">\r\n" + 
				"                          <xsl:value-of select=\"format-number(sb:TotalTax/sb:CalculatedAmount,'#,##0')\"/>\r\n" + 
				"                        </td>\r\n" + 
				"                      </xsl:when>\r\n" + 
				"                      <xsl:otherwise>\r\n" + 
				"                        <td class=\"cell_right01\">\r\n" + 
				"                          <xsl:value-of select=\"format-number(sb:TotalTax/sb:CalculatedAmount,'#,###')\"/>\r\n" + 
				"                        </td>\r\n" + 
				"                      </xsl:otherwise>\r\n" + 
				"                    </xsl:choose>\r\n" + 
				"                  </xsl:otherwise>\r\n" + 
				"                </xsl:choose>\r\n" + 
				"\r\n" + 
				"                <!-- ###비고### -->\r\n" + 
				"                <td>\r\n" + 
				"                  <xsl:value-of select=\"sb:DescriptionText\"/>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"            </xsl:for-each>\r\n" + 
				"          </tbody>\r\n" + 
				"        </table>\r\n" + 
				"        <!--//품목별 단가 end -->\r\n" + 
				"\r\n" + 
				"        <!--합계 start -->\r\n" + 
				"        <table id=\"dti_table05\" class=\"tax_invoice02_Blue\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" summary=\"합계금액, 현금, 수표, 어음, 외상미수금\">\r\n" + 
				"          <caption>합계금액, 현금, 수표, 어음, 외상미수금</caption>\r\n" + 
				"          <colgroup>\r\n" + 
				"            <col width=\"16%\"/>\r\n" + 
				"            <col width=\"16%\"/>\r\n" + 
				"            <col width=\"16%\"/>\r\n" + 
				"            <col width=\"16%\"/>\r\n" + 
				"            <col width=\"16%\"/>\r\n" + 
				"            <col width=\"9%\"/>\r\n" + 
				"            <col width=\"\"/>\r\n" + 
				"            <col width=\"3%\"/>\r\n" + 
				"          </colgroup>\r\n" + 
				"          <tr>\r\n" + 
				"            <th class=\"fontB\">합계금액</th>\r\n" + 
				"            <th class=\"fontB\">현 금</th>\r\n" + 
				"            <th class=\"fontB\">수 표</th>\r\n" + 
				"            <th class=\"fontB\">어 음</th>\r\n" + 
				"            <th class=\"fontB\">외상미수금</th>\r\n" + 
				"            <td class=\"td_chargeR\" rowspan=\"2\">이 금액을</td>\r\n" + 
				"            <td class=\"td_chargeC\" rowspan=\"2\">\r\n" + 
				"              <!-- 영수/청구 정보 보이기 Start -->\r\n" + 
				"              <xsl:variable name=\"demand\" select=\"/sb:TaxInvoice/sb:TaxInvoiceDocument/sb:PurposeCode\"/>\r\n" + 
				"              <xsl:choose>\r\n" + 
				"                <xsl:when test=\"$demand='1'\">\r\n" + 
				"                  <span class=\"li0202\">[영수]</span>\r\n" + 
				"                  <br />\r\n" + 
				"                  <span class=\"li0201\">청구</span>\r\n" + 
				"                </xsl:when>\r\n" + 
				"                <xsl:when test=\"$demand='01'\">\r\n" + 
				"                  <span class=\"li0202\">[영수]</span>\r\n" + 
				"                  <br />\r\n" + 
				"                  <span class=\"li0201\">청구</span>\r\n" + 
				"                </xsl:when>\r\n" + 
				"                <xsl:when  test=\"$demand='18'\">\r\n" + 
				"                  <span class=\"li0201\">영수</span>\r\n" + 
				"                  <br />\r\n" + 
				"                  <span class=\"li0202\">[청구]</span>\r\n" + 
				"                </xsl:when>\r\n" + 
				"                <xsl:when test=\"$demand='02'\">\r\n" + 
				"                  <span class=\"li0201\">영수</span>\r\n" + 
				"                  <br />\r\n" + 
				"                  <span class=\"li0202\">[청구]</span>\r\n" + 
				"                </xsl:when>\r\n" + 
				"              </xsl:choose>\r\n" + 
				"              <!-- 영수/청구 정보 보이기 End -->\r\n" + 
				"            </td>\r\n" + 
				"            <td class=\"td_chargeL\" rowspan=\"2\">함</td>\r\n" + 
				"          </tr>\r\n" + 
				"          <tr>\r\n" + 
				"            <td class=\"cell_right01 font11\">\r\n" + 
				"              <xsl:value-of select=\"format-number($SummaryDirPath/sb:GrandTotalAmount,'#,##0')\"/>\r\n" + 
				"            </td>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"            <!-- 현금/수표/어음/외상미수금 정보 보이기 Start -->\r\n" + 
				"            <xsl:variable name=\"PaymentCount\" select=\"count($PaymentMeansDirPath)\"/>\r\n" + 
				"            <xsl:choose>\r\n" + 
				"              <xsl:when test=\"$PaymentCount = 4\">\r\n" + 
				"                <xsl:for-each select=\"$PaymentMeansDirPath\">\r\n" + 
				"                  <xsl:sort select=\".\"/>\r\n" + 
				"                  <td class=\"cell_right01 font11\">\r\n" + 
				"                    <xsl:choose>\r\n" + 
				"                      <xsl:when test=\"string-length(sb:PaidAmount)=0\">\r\n" + 
				"                      </xsl:when>\r\n" + 
				"                      <xsl:otherwise>\r\n" + 
				"                        <xsl:value-of select=\"format-number(sb:PaidAmount,'#,##0')\"/>\r\n" + 
				"                      </xsl:otherwise>\r\n" + 
				"                    </xsl:choose>\r\n" + 
				"                  </td>\r\n" + 
				"                </xsl:for-each>\r\n" + 
				"              </xsl:when>\r\n" + 
				"              <xsl:otherwise>\r\n" + 
				"                <td class=\"cell_right01\">\r\n" + 
				"                </td>\r\n" + 
				"                <td class=\"cell_right01\">\r\n" + 
				"                </td>\r\n" + 
				"                <td class=\"cell_right01\">\r\n" + 
				"                </td>\r\n" + 
				"                <td class=\"cell_right01\">\r\n" + 
				"                </td>\r\n" + 
				"              </xsl:otherwise>\r\n" + 
				"            </xsl:choose>\r\n" + 
				"          </tr>\r\n" + 
				"        </table>\r\n" + 
				"        <!--//합계 end -->\r\n" + 
				"\r\n" + 
				"      </div>\r\n" + 
				"      <!--//테이블 div end -->\r\n" + 
				"    </div>\r\n" + 
				"\r\n" + 
				"  </xsl:template>\r\n" + 
				"  <!--  세금계산서 DTI Data Header 정보 보이기 End -->\r\n" + 
				"  <!--  DTI Data Header 정보 보이기 End -->\r\n" + 
				"  <br/><br/>\r\n" + 
				"</xsl:stylesheet>";
		
		xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<TaxInvoice xmlns=\"urn:kr:or:kec:standard:Tax:ReusableAggregateBusinessInformationEntitySchemaModule:1:0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:kr:or:kec:standard:Tax:ReusableAggregateBusinessInformationEntitySchemaModule:1:0 http://www.kec.or.kr/standard/Tax/TaxInvoiceSchemaModule_1.0.xsd\">\r\n" + 
				"	<ExchangedDocument>\r\n" + 
				"		<IssueDateTime>20201110154202</IssueDateTime>\r\n" + 
				"	</ExchangedDocument><ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\">\r\n" + 
				"    <ds:SignedInfo>\r\n" + 
				"      <ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>\r\n" + 
				"      <ds:SignatureMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#rsa-sha256\"/>\r\n" + 
				"      <ds:Reference URI=\"\">\r\n" + 
				"        <ds:Transforms>\r\n" + 
				"          <ds:Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>\r\n" + 
				"	  <ds:Transform Algorithm=\"http://www.w3.org/TR/1999/REC-xpath-19991116\">\r\n" + 
				"	    <ds:XPath>not(self::*[name()='TaxInvoice'] | ancestor-or-self::*[name()='ExchangedDocument'] | ancestor-or-self::ds:Signature)</ds:XPath>\r\n" + 
				"          </ds:Transform>\r\n" + 
				"        </ds:Transforms>\r\n" + 
				"        <ds:DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"/>\r\n" + 
				"        <ds:DigestValue>gyzms832j7/oOQcUYsJK9TKGM2H7lsNSicfHtKDE+64=</ds:DigestValue>\r\n" + 
				"      </ds:Reference>\r\n" + 
				"    </ds:SignedInfo>\r\n" + 
				"    <ds:SignatureValue>gOY41wQWn9HLA9Loe6Ym1bUK6tvSLJdLx3HBE1I7wZITuLFm+Zmk1lmcMUMvA+du\r\n" + 
				"pPtTn1xQci4aBT7Ievq6op/TZyOV9+i8pKpr3Eehk6vz8t4irZNNSim1LQRX/yI8\r\n" + 
				"jKE21aBgYZVNYrofkeOAW/eH8X8GB6UX7GOHY1Ho4ILFuHvwEdsvjK9+F4Qu1Qbm\r\n" + 
				"GSa2P0GeR859JneDR+kHXrjXU+VLVSAuAR1TJ//7KHbhATsSlJZHh8YrTtjCvmOG\r\n" + 
				"18ypQ1O8hY3uvvVf16M4Zw85LyXpC+Ftv5JhARwSA7OEeg9HjvJhNx4XnMQ9lTjS\r\n" + 
				"U1LRuBHQH8hq7YDo8YibNg==</ds:SignatureValue>\r\n" + 
				"    <ds:KeyInfo>\r\n" + 
				"	<ds:X509Data>\r\n" + 
				"	<ds:X509Certificate>MIIFyzCCBLOgAwIBAgIEBVo2njANBgkqhkiG9w0BAQsFADBKMQswCQYDVQQGEwJL\r\n" + 
				"UjENMAsGA1UECgwES0lDQTEVMBMGA1UECwwMQWNjcmVkaXRlZENBMRUwEwYDVQQD\r\n" + 
				"DAxzaWduR0FURSBDQTUwHhcNMjAwNjE3MDAyNDUwWhcNMjEwNzA4MTQ1OTU5WjCB\r\n" + 
				"kjELMAkGA1UEBhMCS1IxDTALBgNVBAoMBEtJQ0ExEzARBgNVBAsMCmxpY2Vuc2Vk\r\n" + 
				"Q0ExFTATBgNVBAsMDOuTseuhneq4sOq0gDEZMBcGA1UECwwQS0lDQeqzoOqwneyE\r\n" + 
				"vO2EsDERMA8GA1UECwwI7IS87YSwUkExGjAYBgNVBAMMEe2VnOygleyduCjrspXs\r\n" + 
				"nbgpMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApmMSooAjrNWZpOWy\r\n" + 
				"olFJBDpSiXTNPmGZxkEyPgnLZPz6vVDJVzrzpJFryAQPu52rwa2+GFxYj+iF3ijy\r\n" + 
				"oKq8WU8XjvAuUjpziTKqVX0l8lNJCPK763K+N0V7H6c3ihO1o3HNFwVpgUKA+Yym\r\n" + 
				"6pBG+tBkJ196jOyGBRgWW85pc8fRGyeRr0qPb/YYguo0ulQi6DjIqpnSxWlWjA2s\r\n" + 
				"7uqFZ3zA6WrYM0ig/lGgmMdP/3tg3ZQHCriXGpbvFvhYCy4LKGarRAEcAdIGir5H\r\n" + 
				"WeWq09mCX2N7nmjL11IgQ8Er1q7UDG0dKgS7Aw7D2/Xse1YsUicqv+yEOn0XtSmP\r\n" + 
				"Kl67iwIDAQABo4ICbjCCAmowgY8GA1UdIwSBhzCBhIAU2L467EWZxZ7jnOqBH9Id\r\n" + 
				"ErA2PoihaKRmMGQxCzAJBgNVBAYTAktSMQ0wCwYDVQQKDARLSVNBMS4wLAYDVQQL\r\n" + 
				"DCVLb3JlYSBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eSBDZW50cmFsMRYwFAYDVQQD\r\n" + 
				"DA1LSVNBIFJvb3RDQSA0ggIQHTAdBgNVHQ4EFgQUWfwgt2VMLMjSVFCUb70DjvXV\r\n" + 
				"p1MwDgYDVR0PAQH/BAQDAgbAMHUGA1UdIARuMGwwagYKKoMajJpEBQIBATBcMCwG\r\n" + 
				"CCsGAQUFBwIBFiBodHRwOi8vd3d3LnNpZ25nYXRlLmNvbS9jcHMuaHRtbDAsBggr\r\n" + 
				"BgEFBQcCAjAgHh7HdAAgx3jJncEcspQAIKz1x3jHeMmdwRzHhbLIsuQwgYgGA1Ud\r\n" + 
				"EQSBgDB+gRVwdXJlMjcxM0BzaWduZ2F0ZS5jb22gZQYJKoMajJpECgEBoFgwVgwR\r\n" + 
				"7ZWc7KCV7J24KOuyleyduCkwQTA/BgoqgxqMmkQKAQEBMDEwCwYJYIZIAWUDBAIB\r\n" + 
				"oCIEIESmzx+n59Ye5KIQwtSxuDVilAyffiLvwQ5L9ziXDPBXMF8GA1UdHwRYMFYw\r\n" + 
				"VKBSoFCGTmxkYXA6Ly9sZGFwLnNpZ25nYXRlLmNvbTozODkvb3U9ZHA3cDIyNzk5\r\n" + 
				"LG91PWNybGRwLG91PUFjY3JlZGl0ZWRDQSxvPUtJQ0EsYz1LUjBEBggrBgEFBQcB\r\n" + 
				"AQQ4MDYwNAYIKwYBBQUHMAGGKGh0dHA6Ly9vY3NwLnNpZ25nYXRlLmNvbTo5MDIw\r\n" + 
				"L09DU1BTZXJ2ZXIwDQYJKoZIhvcNAQELBQADggEBACAHBz9kdNoHdGqvX1dp2b/L\r\n" + 
				"sjBl7OWRhYeDr3EPVwgYr1yAtJshLxMrbXGXGgTVEpnqMkAHT58TGnh5fk7BSrFJ\r\n" + 
				"AtIt8cdBgMzw8p1A4GcR+/dCqOQ+Aa5v0T0wMiJ26gRo/adqHrZqgs/RNf2mBUU5\r\n" + 
				"3Y1KdlqDWl8STqv/I+CkH5UIMabsfkeFv5SPw7reWzGz5WwgKkRkl3T2GeH1Fmp7\r\n" + 
				"op1u74EtYQFt2hHOXco7H1AoVb/my03K2BD6RIooMfklD+0wRhhdN9vayRHXRnKS\r\n" + 
				"JIVz/wMGYgZTkALwuZ7VhIO2qabokAwEQ5RTSpwyakAqozGNq316SMkSvGVsuvg=</ds:X509Certificate>\r\n" + 
				"</ds:X509Data>\r\n" + 
				"    </ds:KeyInfo>\r\n" + 
				"</ds:Signature>\r\n" + 
				"	<TaxInvoiceDocument>\r\n" + 
				"		<IssueID>2020111041000008uup00008</IssueID>\r\n" + 
				"		<TypeCode>0101</TypeCode>\r\n" + 
				"		<DescriptionText/>\r\n" + 
				"		<IssueDateTime>20201110</IssueDateTime>\r\n" + 
				"		<PurposeCode>02</PurposeCode>\r\n" + 
				"	</TaxInvoiceDocument>\r\n" + 
				"	<TaxInvoiceTradeSettlement>\r\n" + 
				"		<InvoicerParty>\r\n" + 
				"			<ID>2020081400</ID>\r\n" + 
				"			<TypeCode>테스트</TypeCode>\r\n" + 
				"			<NameText>한국정보인증_테스트</NameText>\r\n" + 
				"			<ClassificationCode>테스트</ClassificationCode>\r\n" + 
				"			<SpecifiedPerson>\r\n" + 
				"				<NameText>테스트</NameText>\r\n" + 
				"			</SpecifiedPerson>\r\n" + 
				"			<DefinedContact>\r\n" + 
				"				<DepartmentNameText/>\r\n" + 
				"				<PersonNameText>아아앜</PersonNameText>\r\n" + 
				"				<TelephoneCommunication>02-519-3130</TelephoneCommunication>\r\n" + 
				"				<URICommunication>rockpia@gmail.com</URICommunication>\r\n" + 
				"			</DefinedContact>\r\n" + 
				"			<SpecifiedAddress>\r\n" + 
				"				<LineOneText>서울 강남구 역삼동 스타</LineOneText>\r\n" + 
				"			</SpecifiedAddress>\r\n" + 
				"		</InvoicerParty>\r\n" + 
				"		<InvoiceeParty>\r\n" + 
				"			<ID>0000000000</ID>\r\n" + 
				"			<TypeCode>게스트</TypeCode>\r\n" + 
				"			<NameText>(주)신나라</NameText>\r\n" + 
				"			<ClassificationCode>게스트</ClassificationCode>\r\n" + 
				"			<SpecifiedOrganization>\r\n" + 
				"				<BusinessTypeCode>01</BusinessTypeCode>\r\n" + 
				"			</SpecifiedOrganization>\r\n" + 
				"			<SpecifiedPerson>\r\n" + 
				"				<NameText>장진 / 이진성</NameText>\r\n" + 
				"			</SpecifiedPerson>\r\n" + 
				"			<PrimaryDefinedContact>\r\n" + 
				"				<DepartmentNameText/>\r\n" + 
				"				<PersonNameText>억붕이</PersonNameText>\r\n" + 
				"				<TelephoneCommunication>02-519-3130</TelephoneCommunication>\r\n" + 
				"				<URICommunication>rockfia@nate.com</URICommunication>\r\n" + 
				"			</PrimaryDefinedContact>\r\n" + 
				"			<SpecifiedAddress>\r\n" + 
				"				<LineOneText>서울특별시 강남구 강남대로</LineOneText>\r\n" + 
				"			</SpecifiedAddress>\r\n" + 
				"		</InvoiceeParty>\r\n" + 
				"		<SpecifiedPaymentMeans>\r\n" + 
				"			<TypeCode>10</TypeCode>\r\n" + 
				"			<PaidAmount>4000000000000</PaidAmount>\r\n" + 
				"		</SpecifiedPaymentMeans>\r\n" + 
				"		<SpecifiedPaymentMeans>\r\n" + 
				"			<TypeCode>20</TypeCode>\r\n" + 
				"			<PaidAmount>74000000000</PaidAmount>\r\n" + 
				"		</SpecifiedPaymentMeans>\r\n" + 
				"		<SpecifiedPaymentMeans>\r\n" + 
				"			<TypeCode>30</TypeCode>\r\n" + 
				"			<PaidAmount>74037000</PaidAmount>\r\n" + 
				"		</SpecifiedPaymentMeans>\r\n" + 
				"		<SpecifiedPaymentMeans>\r\n" + 
				"			<TypeCode>40</TypeCode>\r\n" + 
				"			<PaidAmount>405</PaidAmount>\r\n" + 
				"		</SpecifiedPaymentMeans>\r\n" + 
				"		<SpecifiedMonetarySummation>\r\n" + 
				"			<ChargeTotalAmount>3703703670369</ChargeTotalAmount>\r\n" + 
				"			<TaxTotalAmount>370370367036</TaxTotalAmount>\r\n" + 
				"			<GrandTotalAmount>4074074037405</GrandTotalAmount>\r\n" + 
				"		</SpecifiedMonetarySummation>\r\n" + 
				"	</TaxInvoiceTradeSettlement>\r\n" + 
				"	<TaxInvoiceTradeLineItem>\r\n" + 
				"		<SequenceNumeric>1</SequenceNumeric>\r\n" + 
				"		<InvoiceAmount>1234567890123</InvoiceAmount>\r\n" + 
				"		<ChargeableUnitQuantity>1</ChargeableUnitQuantity>\r\n" + 
				"		<TotalTax>\r\n" + 
				"			<CalculatedAmount>123456789012</CalculatedAmount>\r\n" + 
				"		</TotalTax>\r\n" + 
				"		<UnitPrice>\r\n" + 
				"			<UnitAmount>1234567890123</UnitAmount>\r\n" + 
				"		</UnitPrice>\r\n" + 
				"	</TaxInvoiceTradeLineItem>\r\n" + 
				"	<TaxInvoiceTradeLineItem>\r\n" + 
				"		<SequenceNumeric>2</SequenceNumeric>\r\n" + 
				"		<InvoiceAmount>2469135780246</InvoiceAmount>\r\n" + 
				"		<ChargeableUnitQuantity>2</ChargeableUnitQuantity>\r\n" + 
				"		<TotalTax>\r\n" + 
				"			<CalculatedAmount>246913578024</CalculatedAmount>\r\n" + 
				"		</TotalTax>\r\n" + 
				"		<UnitPrice>\r\n" + 
				"			<UnitAmount>1234567890123</UnitAmount>\r\n" + 
				"		</UnitPrice>\r\n" + 
				"	</TaxInvoiceTradeLineItem>\r\n" + 
				"</TaxInvoice>\r\n" + 
				"";
		
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
