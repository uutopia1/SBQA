<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>원본 조회</title>
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
</head>
<body>

<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

<form method="post">
	<label>메시지ID</label>
	<input type="text" name="MessageId" value="sbqa-${time14}" /><br/>
	
	<label>요청시그널</label>
	<input type="text" name="Signal" value="OS_DTI_XML" /><br/>
	
	<label>요청시간</label>
	<input type="text" name="RequestTime" value="${time14}" /><br/>
	
	<label>송신사업자번호</label>
	<input type="text" name="SendComRegno" value="1000000004" /><br/>
	
	<label>인증토큰</label>
	<input type="text" name="AuthToken" value="TWRKZUl3NHdrNmVudktoVndkU0VINGQ4WUp1eDZ3VzYvbEVveEI2SngwZDhTNlZ0R2FIU2RoWElyNUVyV21mUwo=" /><br/>
	
	<label>서비스코드</label>
	<input type="text" name="ServiceCode" value="DTI" /><br/>
	
	<label>인증코드</label>
	<input type="text" name="AuthCode" value="E0F3A017681940C8B2BD9B4AED8D05D0" /><br/>

	
	<label>매출/매입 구분</label>
	<select name="SupBuy_Type">
		<option value="AR">매출</option>
		<option value="AP">매입</option>
	</select><br/>

	<label>승인번호(최대 100건)</label><br />
	<div class="buttons">
	<!-- 승인번호 다중건 처리를 위해서 input 추가, 삭제 기능  -->
	<input type="text" name="IssueId" value="" /> <input type="button" class="btnAdd" value="+"><br/>
	</div>
	
	<button type="submit">조회</button><br /><br />
	
	<label>request</label>
	<br />${result0}<br /><br />
	
	<label>response</label>
	<br /><c:out value="${result1}" escapeXml="true" /><br />
	
</form>

</body>
</html>	
