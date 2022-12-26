package com.cookey.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cookey.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;
	
	static final String Namespace="com.cookey.mapper.replyMapper";

	// 댓글 조회
	@Override
	public List<ReplyVO> list(int bno) throws Exception {
	    return sqlSession.selectList(Namespace + ".replyList", bno);
	}

	// 댓글 작성
	@Override
	public void write(ReplyVO vo) throws Exception {
	    sqlSession.insert(Namespace + ".replyWrite", vo);
	}

	// 댓글 수정
	@Override
	public void modify(ReplyVO vo) throws Exception {
	    sqlSession.update(Namespace + ".replyModify", vo);
	}

	// 댓글 삭제
	@Override
	public void delete(ReplyVO vo) throws Exception {
	    sqlSession.delete(Namespace + ".replyDelete", vo);
	}

}
