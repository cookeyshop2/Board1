package com.cookey.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cookey.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;
	
	static final String NAMESPACE="com.cookey.mapper.MemberMapper";

	@Override
	public void insertMember(MemberVO vo) throws Exception {
		
		System.out.println(" DAO : 회원가입 실행");
		logger.info(" 회원가입 실행! ");

		// insert SQL구문 호출
		sqlSession.insert(NAMESPACE + ".insertMember", vo);

		System.out.println(" DAO : 회원가입 완료 ");
		logger.info(" 회원가입 완료!!! ");

	}

	@Override
	public MemberVO getLogin(MemberVO vo) throws Exception {
		logger.info(" loginMember() 동작 호출 ");

		MemberVO resultVO = sqlSession.selectOne(NAMESPACE + ".getLogin", vo);

		logger.info(" 로그인 체크완료, " + resultVO);

		return resultVO;
	}

	@Override
	public MemberVO getMember(String id) throws Exception {

		logger.info(" getMember(id) ");

		MemberVO vo = sqlSession.selectOne(NAMESPACE + ".getMember", id);

		return vo;
	}

	@Override
	public Integer updateMember(MemberVO vo) throws Exception {
		logger.info(" 수정 정보를 전달받아서 sql 호출 ");

		int resultCnt = sqlSession.update(NAMESPACE + ".updateMember", vo);

		return resultCnt;
	}

	@Override
	public void deleteMember(MemberVO vo) throws Exception {
		
		sqlSession.delete(NAMESPACE + ".deleteMember", vo);

	}

	@Override
	public List<MemberVO> getMemberList(String adminID) throws Exception {
		
		logger.info(" getMemberList(String adminID) 호출 ");

		return sqlSession.selectList(NAMESPACE + ".getMemberList", adminID);
	}

}
