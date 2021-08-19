package kr.or.ddit.handler.pds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.FileDownloadResolver;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.service.PdsService;
import kr.or.ddit.utils.GetUploadPath;

public class PdsGetFileHandler implements Handler {

	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url= null;
		
		String fileName = pdsService.getAttachByAno(Integer.parseInt(request.getParameter("ano"))).getFileName();
		String savedPath = pdsService.getAttachByAno(Integer.parseInt(request.getParameter("ano"))).getUploadPath();		
		
		
		
		FileDownloadResolver.sendFile(fileName, savedPath, request, response);
		
		
		return url;
	}

}



