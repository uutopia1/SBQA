<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
div.left{
width:200px;
position:absolute;
}
div.main{
width:80%;
left:200px;
top:20px;
position:relative;
}
</style>
<div class="left">
<ul>
	<li>
		<a href="/">홈</a>
	</li>
	<li>
		<a href="/SBQA/log">로그 목록(TEST)</a>
	</li>

		OAPIS

	<li>
		<a href="/SBQA/OAPIS/get_token">인증토큰 발급</a>
	</li>
	<li>
		<a href="/SBQA/OAPIS/os_dti_list">보관함 조회</a>
	</li>
	<li>
		<a href="/SBQA/OAPIS/os_dti_xml">xml원본 조회</a>
	</li>

		OAPI

	<li>
		<a href="/SBQA/write_xml">xml 작성(매출)</a>
	</li>
	<li>
		<a href="/SBQA/xml_list">xml 관리(매출)</a>
	</li>
	<li>
		<a href="/SBQA/write_xml_ap">xml 작성(매입)</a>
	</li>
	<li>
		<a href="/SBQA/xml_list_ap">xml 관리(매입)</a>
	</li>
	<li>
		<a href="/SBQA/OAPI/dti_status_list">상태 조회</a>
	</li>
	<li>
		<a href="/SBQA/OAPI/dti_status_list_udate">상태 업데이트 조회</a>
	</li>
	<li>
		<a href="/SBQA/OAPI/arap_repo">보관함 조회</a>
	</li>
	<li>
		<a href="/SBQA/OAPI/arap_repo_udate">보관함 업데이트 조회</a>
	</li>
	<li>
		<a href="/SBQA/OAPI/my_list">미처리함 조회</a>
	</li>
	<li>
		<a href="/SBQA/OAPI/dti_status">건별 상세 조회</a>
	</li>
</ul>
</div>
