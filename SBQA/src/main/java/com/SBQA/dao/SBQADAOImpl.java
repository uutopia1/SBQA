package com.SBQA.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.SBQA.domain.ApiVO;
import com.SBQA.domain.SBQAVO;

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

	public void get_token(ApiVO vo) throws Exception {
		
		
	}
	
}
