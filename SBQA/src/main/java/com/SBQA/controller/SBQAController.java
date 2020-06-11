package com.SBQA.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SBQA.api.Get_token;
import com.SBQA.api.Os_dti_list;
import com.SBQA.api.Os_dti_xml;
import com.SBQA.domain.ApiVO;
import com.SBQA.domain.SBQAVO;
import com.SBQA.service.SBQAService;

@Controller
@RequestMapping("/SBQA/*")
public class SBQAController {
	
	@Inject
	SBQAService service;
	
	//날짜포맷
	SimpleDateFormat format14 = new SimpleDateFormat("yyyyMMddhhmmss");
	SimpleDateFormat format_8 = new SimpleDateFormat("yyyy-MM-dd");

	
	//로그 목록
	@RequestMapping(value="/log", method=RequestMethod.GET)
	public void getLog(Model model) throws Exception {
		
		//log DB 조회
		List<SBQAVO> log = null;
		log = service.log();
		
		model.addAttribute("log", log);
		
	}
	
	//인증토큰 발급 get
	@RequestMapping(value="/get_token", method=RequestMethod.GET)
	public void getGet_token(Model model) throws Exception {	
		
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time_8 = format_8.format(time);
		
		model.addAttribute("time_8", time_8);
		model.addAttribute("time14", time14);
		
	}
	
	//인증토큰 발급 post
	@RequestMapping(value="/get_token", method=RequestMethod.POST)
	public void postGet_token(Model model, ApiVO vo) throws Exception{
		
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time_8 = format_8.format(time);
		
		model.addAttribute("time_8", time_8);
		model.addAttribute("time14", time14);
		
		//api호출			
		Get_token gt = new Get_token();
		String[] result = null;
		result = gt.get_token(vo);	
		
		model.addAttribute("result0", result[0]);
		model.addAttribute("result1", result[1]);
		
	}
	
	//보관함 조회 get
	@RequestMapping(value="/os_dti_list", method=RequestMethod.GET)
	public void getOs_dti_list(Model model) throws Exception {
		
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time_8 = format_8.format(time);
		
		model.addAttribute("time_8", time_8);
		model.addAttribute("time14", time14);
	}
	
	//보관함 조회 post
	@RequestMapping(value="/os_dti_list", method=RequestMethod.POST)
	public void postOs_dti_list(Model model, ApiVO vo) throws Exception {
		
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time_8 = format_8.format(time);
		
		model.addAttribute("time_8", time_8);
		model.addAttribute("time14", time14);
		
		//api호출
		Os_dti_list odl = new Os_dti_list();
		String[] result = null;
		result = odl.os_dti_list(vo);
		
		model.addAttribute("result0", result[0]);
		model.addAttribute("result1", result[1]);
		
	}
	
	//원본 조회 get
	@RequestMapping(value="/os_dti_xml", method=RequestMethod.GET)
	public void getOs_dti_xml(Model model) throws Exception {
		
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time_8 = format_8.format(time);
		
		model.addAttribute("time_8", time_8);
		model.addAttribute("time14", time14);
	}
	
	//원본 조회 post
		@RequestMapping(value="/os_dti_xml", method=RequestMethod.POST)
		public void postOs_dti_xml(Model model, ApiVO vo) throws Exception {
			
			//현재시간 설정
			Date time = new Date();
			String time14 = format14.format(time);
			String time_8 = format_8.format(time);
			
			model.addAttribute("time_8", time_8);
			model.addAttribute("time14", time14);
			
			//api호출
			Os_dti_xml odx = new Os_dti_xml();
			String[] result = null;
			result = odx.os_dti_xml(vo);
			
			model.addAttribute("result0", result[0]);
			model.addAttribute("result1", result[1]);
		}

}
