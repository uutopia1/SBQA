<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>xml원본 작성</title>

<!-- 승인번호 다중건 처리를 위해서 input 추가, 삭제 기능  -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>        
    <script>            
        $(document).ready (function () {                
            $('.btnAdd').click (function () {                                        
                $('.buttons').append (                        
                    '<input type="text" name="IssueId" values=""> <input type="button" class="btnRemove" value="- "><br>'                    
                ); // end append                            
                $('.btnRemove').on('click', function () { 
                    $(this).prev().remove (); // remove the textbox
                    $(this).next ().remove (); // remove the <br>
                    $(this).remove (); // remove the button
                });
            }); // end click                                            
        }); // end ready        
</script>
<!-- //승인번호 다중건 처리를 위해서 input 추가, 삭제 기능  -->

</head>
<body>

<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

<form method="post">
	
	<label>관리정보</label><br/>	
	<label>서비스 관리 번호</label>
	<input type="text" name="ExchangedDocument_ID" value="" /><br/>	
	<label>발행일시(서명일시)</label>
	<input type="text" name="ExchangedDocument_IssueDateTime" value="${time14}" /><br/>
	<label>사업자 관리 번호</label>
	<input type="text" name="ExchangedDocument_ReferencedDocument_ID" value="" /><br/>	
	
	
	<br/><label>기본정보</label><br/>	
	<label>승인번호</label>
	<input type="text" name="TaxInvoiceDocument_IssueID" value="${time8}41000008urk${time4_}1" /><br/>	
	<label>세금계산서종류</label>
	<input type="text" name="TaxInvoiceDocument_TypeCode" value="0101" /><br/>	
	<label>비고</label>
	<input type="text" name="TaxInvoiceDocument_DescriptionText" value="" /><br/>	
	<label>작성일자</label>
	<input type="text" name="TaxInvoiceDocument_IssueDateTime" value="${time8}" /><br/>	
	<label>수정코드</label>
	<select name="TaxInvoiceDocument_AmendmentStatusCode">
		<option value="">선택없음</option>
		<option value="01">기재사항의 착오정정</option>
		<option value="02">공급가액 변동</option>
		<option value="03">환입</option>
		<option value="04">계약의 해제</option>
		<option value="05">내국신용장 사후 개설</option>
		<option value="06">착오에 의한 이중발행</option>
	</select><br/>	
	<label>영수/청구구분</label>
	<select name="TaxInvoiceDocument_PurposeCode">
		<option value="01">영수</option>
		<option value="02">청구</option>
	</select><br/>	
	<label>당초승인번호</label>
	<input type="text" name="TaxInvoiceDocument_OriginalIssueID" value="" /><br/>
	
	
	<br/><label>수입세금계산서관련정보</label>
	<label>수입신고번호</label>
	<input type="text" name="TaxInvoiceDocument_ReferencedImportDocument_ID" value="" /><br/>	
	<label>수입총건</label>
	<input type="text" name="TaxInvoiceDocument_ReferencedImportDocument_ItemQuantity" value="" /><br/>	
	<label>일괄발급시작일</label>
	<input type="text" name="TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_StartDateTime" value="" /><br/>	
	<label>일괄발급종료일</label>
	<input type="text" name="TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_EndDateTime" value="" /><br/>
	 
	
	
	<br/><label>공급자정보</label><br/>	
	<label>사업자등록번호</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoicerParty_ID" value="1000000004" /><br/>	
	<label>업태</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoicerParty_TypeCode" value="" /><br/>	
	<label>상호</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoicerParty_NameText" value="상호" /><br/>
	<label>업종</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoicerParty_ClassificationCode" value="" /><br/>
	<label>종사업장번호</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization_TaxRegistrationID" value="" /><br/>
	<label>대표자성명</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson_NameText" value="대표자성명" /><br/>	
	<label>담당부서명</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_DepartmentNameText" value="" /><br/>	
	<label>담당자명</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_PersonNameText" value="" /><br/>	
	<label>담당자전화번호</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_TelephoneCommunication" value="" /><br/>	
	<label>담당자이메일</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_URICommunication" value="" /><br/>	
	<label>주소</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress_LineOneText" value="" /><br/>	
	
	
	<br/><label>공급받는자정보</label><br/>	
	<label>사업자등록번호</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_ID" value="1000000005" /><br/>	
	<label>업태</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_TypeCode" value="" /><br/>	
	<label>상호</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_NameText" value="상호" /><br/>	
	<label>업종</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_ClassificationCode" value="" /><br/>	
	<label>종사업장번호</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_TaxRegistrationID" value="" /><br/>
	<label>사업자등록번호 구분코드</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_BusinessTypeCode" value="01" /><br />
	<label>대표자성명</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson_NameText" value="대표자성명" /><br/>	
	<label>담당부서명1</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_DepartmentNameText" value="" /><br/>	
	<label>담당자명1</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_PersonNameText" value="" /><br/>	
	<label>담당자전화번호1</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_TelephoneCommunication" value="" /><br/>	
	<label>담당자이메일1</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_URICommunication" value="" /><br/>	
	<label>담당부서명2</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_DepartmentNameText" value="" /><br/>	
	<label>담당자명2</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_PersonNameText" value="" /><br/>	
	<label>담당자전화번호2</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_TelephoneCommunication" value="" /><br/>	
	<label>담당자이메일2</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_URICommunication" value="" /><br/>	
	<label>주소</label>
	<input type="text" name="TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress_LineOneText" value="" /><br/>
		
	
	<br/><label>수탁사업자정보</label><br/>	
	<label>사업자등록번호</label>
	<input type="text" name="TaxInvoiceTradeSettlement_BrokerParty_ID" value="" /><br/>	
	<label>업태</label>
	<input type="text" name="TaxInvoiceTradeSettlement_BrokerParty_TypeCode" value="" /><br/>	
	<label>상호</label>
	<input type="text" name="TaxInvoiceTradeSettlement_BrokerParty_NameText" value="" /><br/>	
	<label>업종</label>
	<input type="text" name="TaxInvoiceTradeSettlement_BrokerParty_ClassificationCode" value="" /><br/>	
	<label>종사업장번호</label>
	<input type="text" name="TaxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization_TaxRegistrationID" value="" /><br/>	
	<label>대표자성명</label>
	<input type="text" name="TaxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson_NameText" value="" /><br/>	
	<label>담당부서명</label>
	<input type="text" name="TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_DepartmentNameText" value="" /><br/>	
	<label>담당자명</label>
	<input type="text" name="TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_PersonNameText" value="" /><br/>	
	<label>담당자전화번호</label>
	<input type="text" name="TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_TelephoneCommunication" value="" /><br/>	
	<label>담당자이메일</label>
	<input type="text" name="TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_URICommunication" value="" /><br/>	
	<label>주소</label>
	<input type="text" name="TaxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress_LineOneText" value="" /><br/>
	
	
	<br/><label>결제방법별금액</label><br/>	
	<label>현금</label>
	<input type="text" name="TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode" value="10" /><br/>
	<label>금액</label>
	<input type="text" name="TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount" value="" /><br/>
	<label>수표</label>
	<input type="text" name="TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode" value="20" /><br/>
	<label>금액</label>
	<input type="text" name="TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount" value="" /><br/>	
	<label>어음</label>
	<input type="text" name="TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode" value="30" /><br/>
	<label>금액</label>
	<input type="text" name="TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount" value="" /><br/>	
	<label>외상</label>
	<input type="text" name="TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode" value="40" /><br/>
	<label>금액</label>
	<input type="text" name="TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount" value="" /><br/>
	
	
	<br/><label>Summary</label><br/>	
	<label>공급가액합계</label>
	<input type="text" name="TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_ChargeTotalAmount" value="10" /><br/>	
	<label>세액합계</label>
	<input type="text" name="TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_TaxTotalAmount" value="1" /><br/>	
	<label>총금액</label>
	<input type="text" name="TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_GrandTotalAmount" value="11" /><br/>
	

	<br/><label>상품정보</label><br/>		
	<label>일련번호</label>
	<input type="text" name="TaxInvoiceTradeLineItem_SequenceNumeric" value="1" /><br/>	
	<label>비고</label>
	<input type="text" name="TaxInvoiceTradeLineItem_DescriptionText" value="" /><br/>	
	<label>공급가액</label>
	<input type="text" name="TaxInvoiceTradeLineItem_InvoiceAmount" value="10" /><br/>	
	<label>수량</label>
	<input type="text" name="TaxInvoiceTradeLineItem_ChargeableUnitQuantity" value="" /><br/>	
	<label>규격</label>
	<input type="text" name="TaxInvoiceTradeLineItem_InformationText" value="" /><br/>	
	<label>품목명</label>
	<input type="text" name="TaxInvoiceTradeLineItem_NameText" value="" /><br/>	
	<label>공급년월일</label>
	<input type="text" name="TaxInvoiceTradeLineItem_PurchaseExpiryDateTime" value="" /><br/>	
	<label>세액</label>
	<input type="text" name="TaxInvoiceTradeLineItem_TotalTax_CalculatedAmount" value="1" /><br/>	
	<label>단가</label>
	<input type="text" name="TaxInvoiceTradeLineItem_UnitPrice_UnitAmount" value="10" /><br/>
		
	
	<br /><button type="submit">저장</button><br />
	
	
	
</form>

</body>
</html>	
