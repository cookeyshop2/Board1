package com.cookey.service;

import java.util.List;

import com.cookey.domain.MemberVO;

public interface MemberService {
	
	// 회원가입
	public void insertMember(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO loginCheck(MemberVO vo) throws Exception;
	
	// 회원정보 조회
	public MemberVO getMember(String id) throws Exception;
	
	// 회원정보 수정
	public Integer updateMember(MemberVO vo) throws Exception;
	
	// 회원정보 삭제
	public void deleteMember(MemberVO vo) throws Exception;
	
	// 회원목록 조회
	public List<MemberVO> getMemberList(String id) throws Exception;

}
