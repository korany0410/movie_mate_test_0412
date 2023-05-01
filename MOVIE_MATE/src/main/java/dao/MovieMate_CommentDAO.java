package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.CommentList_ViewVO;
import vo.MovieMate_CommentVO;
import vo.MovieMate_MovieVO;
import vo.Movie_CommentVO;

public class MovieMate_CommentDAO {

	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<CommentList_ViewVO> selectList(MovieMate_MovieVO movievo) {

		List<CommentList_ViewVO> comment_list = sqlSession.selectList("mmcomment.selectList", movievo);

		return comment_list;
	}

	public MovieMate_CommentVO my_comment(MovieMate_CommentVO commentvo) {

		MovieMate_CommentVO vo = sqlSession.selectOne("mmcomment.myComment", commentvo);

		return vo;
	}

	public int insert_comment(MovieMate_CommentVO commentvo) {

		int res = sqlSession.insert("mmcomment.insert", commentvo);

		return res;
	}

	public int update_comment(MovieMate_CommentVO commentvo) {

		int res = sqlSession.update("mmcomment.update", commentvo);
		
		return res;
	}
	
	public List<CommentList_ViewVO> selectCommentList(Movie_CommentVO vo){
		
		List<CommentList_ViewVO> comment_list = sqlSession.selectList("mmcomment.commentList", vo);
		return comment_list;
	}
}
