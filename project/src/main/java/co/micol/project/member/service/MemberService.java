package co.micol.project.member.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdat(MemberVO vo);
	int memberDelete(MemberVO vo);
}
