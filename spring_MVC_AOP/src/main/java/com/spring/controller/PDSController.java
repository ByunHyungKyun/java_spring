package com.spring.controller;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.command.PdsModifyCommand;
import com.spring.command.PdsRegistCommand;
import com.spring.command.SearchCriteria;
import com.spring.dto.AttachVO;
import com.spring.dto.PdsVO;
import com.spring.service.PdsService;
import com.spring.utils.GetAttachesAsMultipartFiles;

@Controller
@RequestMapping("/pds")
public class PDSController {

	
	@Autowired
	private PdsService sevice;
	
	
	@RequestMapping("/main")
	public void main()throws Exception {}
	
	@Resource(name="fileUploadPath")
	private String fileUploadPath;
	
	
	@RequestMapping("/list")
	public ModelAndView list(SearchCriteria cri,ModelAndView mnv)throws Exception {
		
		String url="pds/list";
		
		Map<String,Object> dataMap = sevice.getPdsList(cri);
		
		mnv.addObject("dataMap",dataMap);
		mnv.setViewName(url);
		
		return mnv;
		
	}
	
	
	
	
	@RequestMapping("/detail")
	public ModelAndView detail(int pno,@RequestParam(defaultValue="")String from,
													ModelAndView mnv)throws SQLException{
			String url="pds/detail";
			
			PdsVO pds = null;

			if(from != null &&from.equals("modify")) {
				pds = sevice.getPds(pno);
			}else {
				pds = sevice.read(pno);
			}
			
			
			List<AttachVO> attachList = pds.getAttachList();
			if(attachList != null) {
				for(AttachVO attach : attachList) {
					String fileName = attach.getFileName().split("\\$\\$")[1];
					attach.setFileName(fileName);
				}
			}
			
			mnv.addObject("pds",pds);
			mnv.setViewName(url);
			
			return mnv;
				
		}

	
	
	@RequestMapping("/modifyForm")
	public ModelAndView modifyForm(int pno,ModelAndView mnv)throws Exception{
		String url = "pds/modify";
		
		PdsVO pds = sevice.getPds(pno);
		
		List<AttachVO> attachList = pds.getAttachList();
		if(attachList != null) {
			for(AttachVO attach : attachList) {
				String fileName = attach.getFileName().split("\\$\\$")[1];
				attach.setFileName(fileName);
			}
		}
		
		mnv.addObject("pds",pds);
		mnv.setViewName(url);
		
		return mnv;
		
	}
	
	
	
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ModelAndView modifyPost(PdsModifyCommand reqReq,HttpServletRequest request,ModelAndView mnv)throws Exception {
		String url = "pds/modify_success";
	
		if(reqReq.getDeleteFile() != null && reqReq.getDeleteFile().length > 0) {
			for(int ano : reqReq.getDeleteFile()) {
				String fileName = sevice.getAttachByAno(ano).getFileName();
				File deleteFile = new File(fileUploadPath,fileName);
				sevice.removeAttachByAno(ano);
				if(deleteFile.exists()) {
					deleteFile.delete();
				}
			}
		}
		
		List<AttachVO> attachList=GetAttachesAsMultipartFiles.save(reqReq.getUploadFile(),fileUploadPath);
		
		PdsVO pds = reqReq.toPdsVO();
		pds.setAttachList(attachList);
		pds.setTitle((String)request.getAttribute("XSStitle"));

		sevice.update(pds);
		mnv.addObject("pds",pds);
		mnv.setViewName(url);
		return mnv;
	}

	
	
	@RequestMapping("/registForm")
	public ModelAndView registForm(ModelAndView mnv) throws Exception{
		String url="pds/regist";
		
		mnv.setViewName(url);
		return mnv;
	}
	
	
	
	@RequestMapping(value="/regist",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
	public String regist(PdsRegistCommand reqReq,HttpServletRequest request)throws Exception {
		String url="pds/regist_success";
		
		PdsVO pds = reqReq.toPdsVO();
		
		
		List<AttachVO> attachList=GetAttachesAsMultipartFiles.save(reqReq.getUploadFile(),fileUploadPath);
		pds.setTitle((String)request.getAttribute("XSStitle"));
		pds.setAttachList(attachList);
		
		sevice.regist(pds);
		
		return url;
	}
	
	
	@RequestMapping("/remove")
	public String remove(int pno)throws Exception{
		
		String url = "pds/remove_success";
		
		List<AttachVO> attachList = sevice.getPds(pno).getAttachList();
		if(attachList != null) {
			for(AttachVO attach : attachList) {
				File target = new File(attach.getUploadPath(),attach.getFileName());
				if(target.exists()) {
					target.delete();
				}
			}
		}
		
		sevice.delete(pno);
		
		return url;
		
	}
	
	
	@RequestMapping("getFile")
	public String getFile(int ano,Model model)throws Exception{
		String url = "downloadFile";  //servlet-context.xml에서 쓸 아이디값
		
		AttachVO attach = sevice.getAttachByAno(ano);
		
		model.addAttribute("savePath",attach.getUploadPath());
		model.addAttribute("fileName",attach.getFileName());
		
		
		return url;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
