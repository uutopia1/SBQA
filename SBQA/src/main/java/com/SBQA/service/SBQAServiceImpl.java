package com.SBQA.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.SBQA.dao.SBQADAO;
import com.SBQA.domain.ApiVO;
import com.SBQA.domain.DBXmlVO;
import com.SBQA.domain.SBQAVO;
import com.SBQA.domain.XmlVO;

@Service
public class SBQAServiceImpl implements SBQAService {

 @Inject
 private SBQADAO dao;
 
 //로그 목록
 @Override
 public List<SBQAVO> log() throws Exception {

	 return dao.log();
 }
 
 //인증토큰 발급
 @Override
 public void get_token(ApiVO vo) throws Exception{
	 
	 dao.get_token(vo);
 }
 
//xml 저장
@Override
public void save_xml(HashMap<String, Object> data) throws Exception {
	
	dao.save_xml(data);
}

//xml 목록(매출)
@Override
public List<DBXmlVO> xml_list() throws Exception {
	
	return dao.xml_list();
}

//xml 목록(매입)
@Override
public List<DBXmlVO> xml_list_ap() throws Exception {
	
	return dao.xml_list_ap();
}

//xml 조회
@Override
public DBXmlVO xml_view(int bno) throws Exception {
	
	return dao.xml_view(bno);
}

//xml 삭제
@Override
public void delete(int bno) throws Exception {
	
	dao.delete(bno);
}


}