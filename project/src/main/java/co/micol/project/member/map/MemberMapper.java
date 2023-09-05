package co.micol.project.member.map;

import java.util.List;

import co.micol.project.member.service.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdat(MemberVO vo);
	int memberDelete(MemberVO vo);
}
