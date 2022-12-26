package com.cookey.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cookey.domain.MemberVO;
import com.cookey.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	// DAO 객체 주입
	@Inject
	private MemberDAO dao;

	@Override
	public void insertMember(MemberVO vo) throws Exception {
		
		log.info(" memberInsert(vo) 호출 ");
		
		dao.insertMember(vo);

	}

	@Override
	public MemberVO loginCheck(MemberVO vo) throws Exception {
		
		MemberVO loginResultVO = dao.getLogin(vo);

		log.info(loginResultVO + "");

		return loginResultVO;
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		
		log.info("getMember(id) 호출");

		MemberVO vo = dao.getMember(id);

		return vo;
	}

	@Override
	public Integer updateMember(MemberVO vo) throws Exception {
		log.info("updateMember(vo)");

		int resultCnt = dao.updateMember(vo);

		return resultCnt;
	}

	@Override
	public void deleteMember(MemberVO vo) throws Exception {
		
		log.info(" deleteMember(vo) 호출 ");

		dao.deleteMember(vo);

	}

	@Override
	public List<MemberVO> getMemberList(String id) throws Exception {
		
		log.info("getMemberList(String id) 호출");

		return dao.getMemberList(id);
	}
	

}
