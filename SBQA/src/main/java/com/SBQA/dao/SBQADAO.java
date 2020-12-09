package com.SBQA.dao;

import java.util.HashMap;
import java.util.List;

import com.SBQA.domain.ApiVO;
import com.SBQA.domain.DBXmlVO;
import com.SBQA.domain.SBQAVO;
import com.SBQA.domain.XmlVO;

public interface SBQADAO {
	
	//로그 목록
	public List<SBQAVO> log() throws Exception;
	
	//인증토큰 발급	
	public void get_token(ApiVO vo) throws Exception;
	
	//xml 저장
	public void save_xml(HashMap<String, Object> data) throws Exception;
	
	//xml 목록(매출)
	public List<DBXmlVO> xml_list() throws Exception; 
	
	//xml 목록(매입
	public List<DBXmlVO> xml_list_ap() throws Exception; 
	
	//xml 조회
	public DBXmlVO xml_view(int bno) throws Exception;
	
	//xml 삭제
	public void delete(int bno) throws Exception;

	public void call_back(String jsonParam) throws Exception;
	
}
