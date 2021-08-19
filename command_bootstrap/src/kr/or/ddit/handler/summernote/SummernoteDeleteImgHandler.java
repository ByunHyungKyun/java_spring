package kr.or.ddit.handler.summernote;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.command.SummernoteDeleteImgCommand;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.utils.GetUploadPath;

public class SummernoteDeleteImgHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		SummernoteDeleteImgCommand delreq = mapper.readValue(request.getReader(), SummernoteDeleteImgCommand.class);
		
		String fileName = delreq.getFileName();
		//실제 저장 경로를 설정
		String savedPath = GetUploadPath.getUploadPath("summernote.img");
		
		File target = new File(savedPath+File.separator +fileName);
		
		response.setContentType("text/plain;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		if(!target.exists()) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}else {
			target.delete();
			out.print(fileName+"이미지를 삭제했습니다.");
		}
		
		return url;
	}

}
