package com.SBQA.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SBQA.domain.Get_token;
import com.SBQA.domain.ApiVO;
import com.SBQA.domain.SBQAVO;
import com.SBQA.service.SBQAService;

@Controller
@RequestMapping("/SBQA/*")
public class SBQAController {
	
	@Inject
	SBQAService service;
	
	//로그 목록
	@RequestMapping(value="/log", method=RequestMethod.GET)
	public void getLog(Model model) throws Exception {
		
		List<SBQAVO> log = null;
		log = service.log();
		
		model.addAttribute("log", log);
		
	}
	
	//인증토큰 발급
	@RequestMapping(value="/get_token", method=RequestMethod.GET)
	public void getGet_token(Model model) throws Exception {
		
		SimpleDateFormat format14 = new SimpleDateFormat("yyyyMMddhhmmss");
		Date time = new Date();
		
		String time14 = format14.format(time);
		
		model.addAttribute("time14", time14);
		
	}
	
	//인증토큰 발급
	@RequestMapping(value="/get_token", method=RequestMethod.POST)
	public void postGet_token(Model model, ApiVO vo) throws Exception{
		
		SimpleDateFormat format14 = new SimpleDateFormat("yyyyMMddhhmmss");
		Date time = new Date();
		
		String time14 = format14.format(time);
		
		model.addAttribute("time14", time14);
		
		Get_token get_token = new Get_token();
		
		String token = get_token.get_token(vo);
		
		model.addAttribute("token", token);
		
	}

}
