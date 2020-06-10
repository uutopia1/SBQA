package com.SBQA.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.SBQA.dao.SBQADAO;
import com.SBQA.domain.ApiVO;
import com.SBQA.domain.SBQAVO;

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

}