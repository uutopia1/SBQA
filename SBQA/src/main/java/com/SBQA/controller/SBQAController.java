package com.SBQA.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SBQA.api.AesCrypto;
import com.SBQA.api.Write_xml;
import com.SBQA.api.OAPI.Arap_repo;
import com.SBQA.api.OAPI.Arissue;
import com.SBQA.api.OAPI.DetailArissue;
import com.SBQA.api.OAPI.Dti_save;
import com.SBQA.api.OAPI.Dti_status_list;
import com.SBQA.api.OAPI.Preview_form;
import com.SBQA.api.OAPI.Rarrequest;
import com.SBQA.api.OAPI.Rdetailrequest;
import com.SBQA.api.OAPIS.Get_token;
import com.SBQA.api.OAPIS.Os_dti_list;
import com.SBQA.api.OAPIS.Os_dti_xml;
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


//xml원본 관리	
	//xml원본(매출) 작성 get
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
	
	//xml원본(매출) 작성 post
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
	
	//xml원본(매출) 목록 get
	@RequestMapping(value="/xml_list", method=RequestMethod.GET)
	public void getXml_list(Model model) throws Exception {
		
		List<DBXmlVO> xml_list = null;
		xml_list = service.xml_list();
		
		model.addAttribute("xml_list", xml_list);
		
	}
	
	//xml원본 상세보기(매출) get
	@RequestMapping(value="/xml_view", method=RequestMethod.GET)
	public void getXml_view(Model model, @RequestParam("bno") int bno) throws Exception {
		
		//xml DB 조회
		DBXmlVO xml_list = service.xml_view(bno);
		
		String xml = xml_list.getXml();
		
		//미리보기 양식 조회 + xslt 처리
		Preview_form pf = new Preview_form();
		String xslt = pf.preview_form(xml, "ar");
		
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
	
	//xml원본(매입) 작성 get
	@RequestMapping(value="/write_xml_ap", method=RequestMethod.GET)
	public void getWrite_xml_ap(Model model) throws Exception {
			
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time8 = format8.format(time);
		String time4_ = format4_.format(time);
			
		model.addAttribute("time8", time8);
		model.addAttribute("time14", time14);
		model.addAttribute("time4_", time4_);
	}
		
	//xml원본(매입) 작성 post
	@RequestMapping(value="/write_xml_ap", method=RequestMethod.POST)
	public String postWrite_xml_ap(Model model, XmlVO vo) throws Exception {
				
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
		model.addAttribute("url", "xml_list_ap");
			
		return "redirect";
				
		}
		
	//xml원본(매입) 목록 get
	@RequestMapping(value="/xml_list_ap", method=RequestMethod.GET)
	public void getXml_list_ap(Model model) throws Exception {
			
		List<DBXmlVO> xml_list_ap = null;
		xml_list_ap = service.xml_list_ap();
			
		model.addAttribute("xml_list_ap", xml_list_ap);
			
	}	
	
	//xml원본 상세보기(매입) get
	@RequestMapping(value="/xml_view_ap", method=RequestMethod.GET)
	public void getXml_view_ap(Model model, @RequestParam("bno") int bno) throws Exception {
		
		//xml DB 조회
		DBXmlVO xml_list = service.xml_view(bno);
		
		String xml = xml_list.getXml();
		
		//미리보기 양식 조회 + xslt 처리
		Preview_form pf = new Preview_form();
		String xslt = pf.preview_form(xml, "ap");
		
		model.addAttribute("xslt", xslt);
	}
	
	//xml원본 삭제(매입) get
	@RequestMapping(value = "/delete_ap", method=RequestMethod.GET)
	public String getDelete_ap(Model model, @RequestParam("bno") int bno) throws Exception {
		
		service.delete(bno);
		
		model.addAttribute("msg", "삭제 완료");
		model.addAttribute("url", "xml_list_ap");
		
		return "redirect";
	}
	
	//간편회원가입 call back URL
//	@RequestMapping(value = "/call_back", method=RequestMethod.GET)
//	public void getCall_back(Model model, @RequestParam("SBID") String SBID) throws Exception {
//		
//		//service.call_back(SBID);
//		
//		model.addAttribute("Method", "GET");
//		model.addAttribute("SBID", SBID);
		
		
//	}
	
	//간편회원가입 call back URL
	@RequestMapping(value = "/call_back", method=RequestMethod.POST, produces="application/json; charset=utf8")
	public void postCall_back(Model model, @RequestBody HashMap<String, String> param) throws Exception {

		//String SBID = param.get("SBID");
		String jsonParam = param.toString();
		
		//model.addAttribute("Method", "POST");
		//model.addAttribute("SBID", SBID);
		
		//System.out.println(SBID);
		System.out.println(jsonParam);
		
		service.call_back(jsonParam);
		
		//service.call_back(SBID);

		
	}
	
}
