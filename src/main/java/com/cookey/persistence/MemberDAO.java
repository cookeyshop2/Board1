package com.cookey.persistence;

import java.util.List;

import com.cookey.domain.MemberVO;

public interface MemberDAO {

	///////////// 일반 //////////////
	
	// 회원가입
	public void insertMember(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO getLogin(MemberVO vo) throws Exception;
	
	// 회원정보조회
	public MemberVO getMember(String id) throws Exception;
	
	// 회원정보수정
	public Integer updateMember(MemberVO vo) throws Exception;
	
	// 탈퇴
	public void deleteMember(MemberVO vo) throws Exception;
	
	///////////// 관리자 //////////////
	
	// 전체 회원정보 조회
	public List<MemberVO> getMemberList(String adminID) throws Exception;

}
