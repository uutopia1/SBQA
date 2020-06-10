package com.SBQA.service;

import java.util.List;

import com.SBQA.domain.ApiVO;
import com.SBQA.domain.SBQAVO;

public interface SBQAService {
	
	//로그 목록
	public List<SBQAVO> log() throws Exception;
	
	//인증토큰 발급
	public void get_token(ApiVO vo) throws Exception;

}
