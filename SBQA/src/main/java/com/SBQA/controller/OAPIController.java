package com.SBQA.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.SBQA.api.AesCrypto;
import com.SBQA.api.Write_xml;
import com.SBQA.api.OAPI.Arap_repo;
import com.SBQA.api.OAPI.Arap_repo_udate;
import com.SBQA.api.OAPI.Arissue;
import com.SBQA.api.OAPI.DetailArissue;
import com.SBQA.api.OAPI.Dti_save;
import com.SBQA.api.OAPI.Dti_status;
import com.SBQA.api.OAPI.Dti_status_list;
import com.SBQA.api.OAPI.Dti_status_list_udate;
import com.SBQA.api.OAPI.My_list;
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
@RequestMapping("/SBQA/OAPI/*")
public class OAPIController {
	


	
	@Inject
	SBQAService service;
		
	//날짜포맷
	SimpleDateFormat format14 = new SimpleDateFormat("yyyyMMddhhmmss");
	SimpleDateFormat format_8 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat format8 = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat format4_ = new SimpleDateFormat("hhmm");
	SimpleDateFormat format10 = new SimpleDateFormat("MMddhhmmss");
	
//OAPI	
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
		
		//인증서비밀번호 암호화
		String CertPassword = vo.getCertPassword();
		AesCrypto ac = new AesCrypto();
		String CertPassword_AesCrypto = ac.Encrypt(CertPassword);
		vo.setCertPassword(CertPassword_AesCrypto);
		
		//발행 api
		result= ai.arissue(vo);
			
		model.addAttribute("result0", result[0]);
		model.addAttribute("result1", result[1]);

	}
	
	//저장 get
	@RequestMapping(value = "/dti_save", method=RequestMethod.GET)
	public void getDti_save(Model model, @RequestParam("bno") int bno) throws Exception {
		
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time10 = format10.format(time);

		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
				
		DBXmlVO xml_list = service.xml_view(bno);
		
		model.addAttribute("xml", xml_list.getXml());
			
	}	
	
	//저장 post
	@RequestMapping(value = "/dti_save", method=RequestMethod.POST)
	public void postDti_save(Model model, ApiVO vo) throws Exception {
				
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time10 = format10.format(time);

		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
				
		Dti_save ds = new Dti_save();
		String[] result = null;
				
		result= ds.dti_save(vo);
				
		model.addAttribute("result0", result[0]);
		model.addAttribute("result1", result[1]);

	}		

	//역발행요청 get
	@RequestMapping(value = "/rarrequest", method=RequestMethod.GET)
	public void getRarrequest(Model model, @RequestParam("bno") int bno) throws Exception {
		
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time10 = format10.format(time);

		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
				
		DBXmlVO xml_list = service.xml_view(bno);
		
		model.addAttribute("xml", xml_list.getXml());
			
	}	
	
	//역발행요청 post
	@RequestMapping(value = "/rarrequest", method=RequestMethod.POST)
	public void postRarrequest(Model model, ApiVO vo) throws Exception {
				
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time10 = format10.format(time);

		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
		
		//변수 선언
		Rarrequest rr = new Rarrequest();
		String[] result = null;
		
		//api 호출
		result= rr.rarrequest(vo);
				
		model.addAttribute("result0", result[0]);
		model.addAttribute("result1", result[1]);

	}
	
	//발행+거래명세서 get
	@RequestMapping(value = "/detailarissue", method=RequestMethod.GET)
	public void getDetailArissue(Model model, @RequestParam("bno") int bno) throws Exception {
			
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time10 = format10.format(time);

		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
					
		DBXmlVO xml_list = service.xml_view(bno);
			
		model.addAttribute("xml", xml_list.getXml());
			
	}
		
	//발행+거래명세서 post
	@RequestMapping(value = "/detailarissue", method=RequestMethod.POST)
	public void postDetailArissue(Model model, ApiVO vo) throws Exception {
				
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time10 = format10.format(time);

		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
				
		DetailArissue da = new DetailArissue();
		String[] result = null;
			
		//인증서비밀번호 암호화
		String CertPassword = vo.getCertPassword();
		AesCrypto ac = new AesCrypto();
		String CertPassword_AesCrypto = ac.Encrypt(CertPassword);
		vo.setCertPassword(CertPassword_AesCrypto);
			
		//발행 api
		result= da.detailarissue(vo);
				
		model.addAttribute("result0", result[0]);
		model.addAttribute("result1", result[1]);

	}
	
	//역발행요청+거래명세서 get
	@RequestMapping(value = "/rdetailrequest", method=RequestMethod.GET)
	public void getRdetailrequest(Model model, @RequestParam("bno") int bno) throws Exception {
		
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time10 = format10.format(time);

		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
				
		DBXmlVO xml_list = service.xml_view(bno);
		
		model.addAttribute("xml", xml_list.getXml());
			
	}	
	
	//역발행요청+거래명세서 post
	@RequestMapping(value = "/rdetailrequest", method=RequestMethod.POST)
	public void postRdetailrequest(Model model, ApiVO vo) throws Exception {
				
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		String time10 = format10.format(time);

		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
		
		//변수 선언
		Rdetailrequest rdr = new Rdetailrequest();
		String[] result = null;
		
		//api 호출
		result= rdr.rdetailrequest(vo);
				
		model.addAttribute("result0", result[0]);
		model.addAttribute("result1", result[1]);

	}
	
	//세금계산서 상태 조회 get
	@RequestMapping(value="/dti_status_list", method=RequestMethod.GET)
	public void getDti_status_list(Model model, ApiVO vo) throws Exception {
				
		//현재시간 설정
		Date time = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.DAY_OF_YEAR, -7);
		
		String time14 = format14.format(time);
		String time10 = format10.format(time);
		String time_8 = format_8.format(time);
		String time_8_7 = format_8.format(cal.getTime());		
		


		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
		model.addAttribute("time_8", time_8);
		model.addAttribute("time_8_7", time_8_7);
		
	}
	
	//세금계산서 상태 조회 post
	@RequestMapping(value="/dti_status_list", method=RequestMethod.POST)
	public void postDti_status_list(Model model, ApiVO vo) throws Exception {
		
		//현재시간 설정
		Date time = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.DAY_OF_YEAR, -7);
		
		String time14 = format14.format(time);
		String time10 = format10.format(time);
		String time_8 = format_8.format(time);
		String time_8_7 = format_8.format(cal.getTime());

		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
		model.addAttribute("time_8", time_8);
		model.addAttribute("time_8_7", time_8_7);
		
		//api호출
		Dti_status_list dtl = new Dti_status_list();
		String[] result = null;
		result = dtl.dti_status_list(vo);
			
		model.addAttribute("result0", result[0]);
		model.addAttribute("result1", result[1]);
	}
	
	//보관함 조회 get
	@RequestMapping(value="/arap_repo", method=RequestMethod.GET)
	public void getArap_repo(Model model, ApiVO vo) throws Exception {
				
		//현재시간 설정
		Date time = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.DAY_OF_YEAR, -7);
		
		String time14 = format14.format(time);
		String time10 = format10.format(time);
		String time_8 = format_8.format(time);
		String time_8_7 = format_8.format(cal.getTime());		
		


		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
		model.addAttribute("time_8", time_8);
		model.addAttribute("time_8_7", time_8_7);
		
	}
	
	//보관함 조회 post
	@RequestMapping(value="/arap_repo", method=RequestMethod.POST)
	public void postArap_repo(Model model, ApiVO vo) throws Exception {
		
		//현재시간 설정
		Date time = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.DAY_OF_YEAR, -7);
		
		String time14 = format14.format(time);
		String time10 = format10.format(time);
		String time_8 = format_8.format(time);
		String time_8_7 = format_8.format(cal.getTime());

		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
		model.addAttribute("time_8", time_8);
		model.addAttribute("time_8_7", time_8_7);
		
		//api호출
		Arap_repo ar = new Arap_repo();
		String[] result = null;
		result = ar.arap_repo(vo);
			
		model.addAttribute("result0", result[0]);
		model.addAttribute("result1", result[1]);
	}
	
	//미처리함 조회 get
	@RequestMapping(value="/my_list", method=RequestMethod.GET)
	public void getMy_list(Model model, ApiVO vo) throws Exception {
				
		//현재시간 설정
		Date time = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.DAY_OF_YEAR, -7);
		
		String time14 = format14.format(time);
		String time_8 = format_8.format(time);
		String time_8_7 = format_8.format(cal.getTime());		
		


		model.addAttribute("time14", time14);
		model.addAttribute("time_8", time_8);
		model.addAttribute("time_8_7", time_8_7);
		
	}
	
	//미처리함 조회 post
	@RequestMapping(value="/my_list", method=RequestMethod.POST)
	public void postMy_list(Model model, ApiVO vo) throws Exception {
		
		//현재시간 설정
		Date time = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.DAY_OF_YEAR, -7);
		
		String time14 = format14.format(time);
		String time_8 = format_8.format(time);
		String time_8_7 = format_8.format(cal.getTime());

		model.addAttribute("time14", time14);
		model.addAttribute("time_8", time_8);
		model.addAttribute("time_8_7", time_8_7);
		
		//api호출
		My_list ml = new My_list();
		String[] result = null;
		result = ml.my_list(vo);
			
		model.addAttribute("result0", result[0]);
		model.addAttribute("result1", result[1]);
	}
	
	//건별 상세 조회 get
	@RequestMapping(value="/dti_status", method=RequestMethod.GET)
	public void getDti_status(Model model, ApiVO vo) throws Exception {
				
		//현재시간 설정
		Date time = new Date();
		String time14 = format14.format(time);
		model.addAttribute("time14", time14);
		
	}
	
	//건별 상세 조회 post
	@RequestMapping(value="/dti_status", method=RequestMethod.POST)
	public void postDti_status(Model model, ApiVO vo) throws Exception {
		
		//현재시간 설정
		Date time = new Date();	
		String time14 = format14.format(time);
		model.addAttribute("time14", time14);

		
		//api호출
		Dti_status ds = new Dti_status();
		String[] result = null;
		result = ds.dti_status(vo);
			
		model.addAttribute("result0", result[0]);
		model.addAttribute("result1", result[1]);
	}

	//보관함 업데이트 조회 get
	@RequestMapping(value="/arap_repo_udate", method=RequestMethod.GET)
	public void getArap_repo_udate(Model model, ApiVO vo) throws Exception {
				
		//현재시간 설정
		Date time = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.DAY_OF_YEAR, -7);
		
		String time14 = format14.format(time);
		String time10 = format10.format(time);
		String time_8 = format_8.format(time);
		String time_8_7 = format_8.format(cal.getTime());		
		
	
	
		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
		model.addAttribute("time_8", time_8);
		model.addAttribute("time_8_7", time_8_7);
		
	}

	//보관함 조회 post
	@RequestMapping(value="/arap_repo_udate", method=RequestMethod.POST)
	public void postArap_repo_udate(Model model, ApiVO vo) throws Exception {
		
		//현재시간 설정
		Date time = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.DAY_OF_YEAR, -7);
		
		String time14 = format14.format(time);
		String time10 = format10.format(time);
		String time_8 = format_8.format(time);
		String time_8_7 = format_8.format(cal.getTime());
	
		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
		model.addAttribute("time_8", time_8);
		model.addAttribute("time_8_7", time_8_7);
		
		//api호출
		Arap_repo_udate ar = new Arap_repo_udate();
		String[] result = null;
		result = ar.arap_repo_udate(vo);
			
		model.addAttribute("result0", result[0]);
		model.addAttribute("result1", result[1]);
		model.addAttribute("result2", result[2]);
	}

	//세금계산서 상태 조회 get
	@RequestMapping(value="/dti_status_list_udate", method=RequestMethod.GET)
	public void getDti_status_list_udate(Model model, ApiVO vo) throws Exception {
				
		//현재시간 설정
		Date time = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.DAY_OF_YEAR, -7);
		
		String time14 = format14.format(time);
		String time10 = format10.format(time);
		String time_8 = format_8.format(time);
		String time_8_7 = format_8.format(cal.getTime());		
		
	
	
		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
		model.addAttribute("time_8", time_8);
		model.addAttribute("time_8_7", time_8_7);
		
	}

	//세금계산서 상태 조회 post
	@RequestMapping(value="/dti_status_list_udate", method=RequestMethod.POST)
	public void postDti_status_list_udate(Model model, ApiVO vo) throws Exception {
		
		//현재시간 설정
		Date time = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.DAY_OF_YEAR, -7);
		
		String time14 = format14.format(time);
		String time10 = format10.format(time);
		String time_8 = format_8.format(time);
		String time_8_7 = format_8.format(cal.getTime());
	
		model.addAttribute("time14", time14);
		model.addAttribute("time10", time10);
		model.addAttribute("time_8", time_8);
		model.addAttribute("time_8_7", time_8_7);
		
		//api호출
		Dti_status_list_udate dtl = new Dti_status_list_udate();
		String[] result = null;
		result = dtl.dti_status_list_udate(vo);
			
		model.addAttribute("result0", result[0]);
		model.addAttribute("result1", result[1]);
		model.addAttribute("result2", result[2]);
	}
}
