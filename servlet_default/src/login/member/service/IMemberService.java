package login.member.service;

import java.util.List;

import login.member.vo.memberVO;

public interface IMemberService {
	
	
	public String loginMember(memberVO memberVo);
	
	public int signupMember(memberVO memberVo);
	
	public List<memberVO> getAllMemberList();
	
	
}
