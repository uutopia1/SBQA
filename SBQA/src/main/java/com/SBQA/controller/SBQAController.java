package com.SBQA.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.SBQA.api.Arissue;
import com.SBQA.api.Get_token;
import com.SBQA.api.Os_dti_list;
import com.SBQA.api.Os_dti_xml;
import com.SBQA.api.Preview_form;
import com.SBQA.api.Write_xml;
import com.SBQA.domain.ApiVO;
import com.SBQA.domain.DBXmlVO;
import com.SBQA.domain.SBQAVO;
import com.SBQA.domain.XmlVO;
import com.SBQA.service.SBQAService;

@Controller
@RequestMapping("/SBQA/*")
public class SBQAController {
	
	@Inject
	SBQAService service;
	
	//날짜포맷
	SimpleDateFormat format14 = new SimpleDateFormat("yyyyMMddhhmmss");
	SimpleDateFormat format_8 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat format8 = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat format4_ = new SimpleDateFormat("hhmm");
	SimpleDateFormat format10 = new SimpleDateFormat("MMddhhmmss");

	
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
	
	//xml원본 작성 get
	@RequestMapping(value="/write_xml", method=RequestMethod.GET)
	public void getWrite_xml(Model model) throws Exception {
		
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time8 = format8.format(time);
		String time4_ = format4_.format(time);
		
		model.addAttribute("time8", time8);
		model.addAttribute("time14", time14);
		model.addAttribute("time4_", time4_);
	}
	
	//xml원본 작성 post
	@RequestMapping(value="/write_xml", method=RequestMethod.POST)
	public String postWrite_xml(Model model, XmlVO vo) throws Exception {
			
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time8 = format8.format(time);
		String time4_ = format4_.format(time);
					
		model.addAttribute("time8", time8);
		model.addAttribute("time14", time14);
		model.addAttribute("time4_", time4_);
					
		//xml생성
		Write_xml wx = new Write_xml();
		HashMap<String, Object> data = new HashMap<String, Object>();
		data = wx.write_xml(vo);			
			
		//DB저장
		service.save_xml(data);
		
		model.addAttribute("msg", "저장 완료");
		model.addAttribute("url", "xml_list");
		
		return "redirect";
			
		}
	
	//xml원본 목록 get
	@RequestMapping(value="/xml_list", method=RequestMethod.GET)
	public void getXml_list(Model model) throws Exception {
		
		List<DBXmlVO> xml_list = null;
		xml_list = service.xml_list();
		
		model.addAttribute("xml_list", xml_list);
		
	}
	
	//xml원본 조회 get
	@RequestMapping(value="/xml_view", method=RequestMethod.GET)
	public void getXml_view(Model model, @RequestParam("bno") int bno) throws Exception {
		
		//xml DB 조회
		DBXmlVO xml_list = service.xml_view(bno);
		
		String xml = xml_list.getXml();
		
		//미리보기 양식 조회 + xslt 처리
		Preview_form pf = new Preview_form();
		String xslt = pf.preview_form(xml);
		
		model.addAttribute("xslt", xslt);
	}
	
	//xml원본 삭제
	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public String getDelete(Model model, @RequestParam("bno") int bno) throws Exception {
		
		service.delete(bno);
		
		model.addAttribute("msg", "삭제 완료");
		model.addAttribute("url", "xml_list");
		
		return "redirect";
	}

	//발행 get
	@RequestMapping(value = "/arissue", method=RequestMethod.GET)
	public void getArissue(Model model, @RequestParam("bno") int bno) throws Exception {
		
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time10 = format10.format(time);

		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
				
		DBXmlVO xml_list = service.xml_view(bno);
		
		model.addAttribute("xml", xml_list.getXml());
		
	}
	
	//발행 post
		@RequestMapping(value = "/arissue", method=RequestMethod.POST)
		public void postArissue(Model model, ApiVO vo) throws Exception {
			
			//현재시간 설정
			Date time = new Date();
			String time14 = format14.format(time);
			String time10 = format10.format(time);

			model.addAttribute("time14", time14);
			model.addAttribute("time10", time10);
			
			Arissue ai = new Arissue();
			String[] result = null;
			
			result= ai.arissue(vo);
			
			model.addAttribute("result0", result[0]);
			model.addAttribute("result1", result[1]);

		}


	
}
