package com.SBQA.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.SBQA.domain.ApiVO;
import com.SBQA.domain.DBXmlVO;
import com.SBQA.domain.SBQAVO;
import com.SBQA.domain.XmlVO;

@Repository
public class SBQADAOImpl implements SBQADAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.SBQA.mappers.SBQA";
	
	//로그 목록
	@Override
	public List<SBQAVO> log() throws Exception {

		return sql.selectList(namespace + ".log");
	}
	
	//인증토큰 발급
	@Override
	public void get_token(ApiVO vo) throws Exception {
		
		
	}
	
	//xml 저장
	@Override
	public void save_xml(HashMap<String, Object> data) throws Exception{
		
		sql.insert(namespace + ".save_xml", data);
	}
	
	//xml 목록(매출)
	@Override
	public List<DBXmlVO> xml_list() throws Exception {
		
		return sql.selectList(namespace + ".xml_list");
	}
	
	//xml 목록(매입)
	@Override
	public List<DBXmlVO> xml_list_ap() throws Exception {
		
		return sql.selectList(namespace + ".xml_list_ap");
	}
	
	//xml 조회
	@Override
	public DBXmlVO xml_view(int bno) throws Exception {
		
		return sql.selectOne(namespace + ".xml_view", bno);
		
	}
		
	//xml 삭제
	@Override
	public void delete(int bno) throws Exception {
		
		sql.delete(namespace + ".delete", bno);
	}
		
	//callback 저장
	@Override
	public void call_back(String jsonParam) throws Exception {
		sql.insert(namespace + ".call_back", jsonParam);
	}
}
