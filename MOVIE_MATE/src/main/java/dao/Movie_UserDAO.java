package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MovieMate_MovieVO;
import vo.Movie_UserVO;

public class Movie_UserDAO {

	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int selectOne(Movie_UserVO vo) {

		int count = sqlSession.selectOne("muser.selectOne", vo);

		return count;

	}

	public int initialize(Movie_UserVO vo) {

		int result = sqlSession.insert("muser.initialize", vo);

		return result;
	}

	public String change(Movie_UserVO vo) {

		String want_view = sqlSession.selectOne("muser.want", vo);

		if (want_view.equals("no")) {
			want_view = "yes";
		} else {
			want_view = "no";
		}

		vo.setWant_view(want_view);

		sqlSession.update("muser.change", vo);

		return want_view;
	}
	
	public Movie_UserVO selectInfo(Movie_UserVO vo) {
		
		Movie_UserVO res = sqlSession.selectOne("muser.info", vo);
		
		return res;
	}
	
	public int update_starScore(Movie_UserVO vo) {
		
		int res = sqlSession.update("muser.update_starScore", vo);
		
		return res;
	}		
}






















