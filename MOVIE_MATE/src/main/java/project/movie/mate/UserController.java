package project.movie.mate;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MovieMate_UserDAO;
import vo.MovieMate_UserVO;

@Controller
public class UserController {

	MovieMate_UserDAO moviemate_userdao;

	@Autowired
	HttpServletRequest request;

	@Autowired
	ServletContext app;

	public UserController(MovieMate_UserDAO moviemate_userdao) {
		this.moviemate_userdao = moviemate_userdao;
	}

	@RequestMapping("/movie_mate_signUp_screen.do")
	public String movie_mate_signUp_screen() {

		return "/WEB-INF/views/userInfo/movie_mate_signUp_screen.jsp";
	}

	@RequestMapping("/signUp.do")
	@ResponseBody
	public String signUp(MovieMate_UserVO moviemate_uservo) {

		int res = moviemate_userdao.signUp(moviemate_uservo);

		if (res < 1) {
			return "fail";
		}

		return "success";
	}

	@RequestMapping("/double_check.do")
	@ResponseBody
	public String double_check(MovieMate_UserVO moviemate_uservo) {

		int count = moviemate_userdao.double_check(moviemate_uservo);

		System.out.println("double_check.do -> count : " + count);

		if (count < 1) {
			return "possible";
		}

		return "imposiible";
	}

	@RequestMapping("/movie_mate_login_screen.do")
	public String movie_mate_login_screen(Model model, String pathname) {

		model.addAttribute("pathname", pathname);
		return "/WEB-INF/views/userInfo/movie_mate_login_screen.jsp";
	}

	@RequestMapping("/login.do")
	@ResponseBody
	public String login(MovieMate_UserVO moviemate_uservo, String pathname) {

		MovieMate_UserVO user_info = moviemate_userdao.login(moviemate_uservo);
		if (user_info == null) {
			return "fail";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", "yes");
			session.setAttribute("userName", user_info.getUsername());
			session.setAttribute("userIdx", user_info.getUser_idx());
			session.setAttribute("userImg", user_info.getProfile_img());
			System.out.println("로그인 성공");
			System.out.println("---유저 정보---");
			System.out.println("이메일 : " + user_info.getEmail());
			System.out.println("이름 : " + user_info.getUsername());
			System.out.println("비밀번호 : " + user_info.getPwd());
			return pathname;
		}
	}

	@RequestMapping("/logout.do")
	public String logout() {
		HttpSession session = request.getSession();

		session.setAttribute("isLogin", "no");
		session.setAttribute("userName", null);
		session.setAttribute("userIdx", null);
		session.setAttribute("userImg", null);

		return "movie_mate_main_screen.do";
	}

	@RequestMapping("/movie_mate_mypage_screen.do")
	public String mypage(Model model, MovieMate_UserVO vo) {

		MovieMate_UserVO userInfo = moviemate_userdao.userInfo(vo);

		model.addAttribute("userInfo", userInfo);
		return "/WEB-INF/views/userInfo/movie_mate_mypage_screen.jsp";
	}

	@RequestMapping("/mymovie.do")
	public String mymovie() {

		return "/WEB-INF/views/userInfo/movie_mate_myChoice.jsp";
	}

<<<<<<< HEAD

	@RequestMapping("/movie_mate_modify_screen.do")
	public String movie_mate_modify_screen(Model model) {

		HttpSession session = request.getSession();

		int user_idx = (int) session.getAttribute("userIdx");
		MovieMate_UserVO user_info = moviemate_userdao.userInfo(user_idx);
		System.out.println("수정페이지 로그인 정보 : " + user_idx);
		model.addAttribute("userInfo", user_info);
		return "/WEB-INF/views/userInfo/movie_mate_modify_screen.jsp";
	}

	/*
	 * @RequestMapping("/movie_mate_modify_screen.do")
	 * 
	 * @ResponseBody public String modify(MovieMate_UserVO vo) { MovieMate_UserDAO
	 * dao = new MovieMate_UserDAO(); int res = dao.modify(vo); String result =
	 * "수정 성공";
	 * 
	 * if (res == 0) { result = "수정 실패"; }
	 * 
	 * return result; }
	 */



}
=======
	@RequestMapping("/movie_mate_modify_screen.do")
	public String movie_mate_modify_screen(Model model, MovieMate_UserVO uservo) {
>>>>>>> f1c11b04dd6cd6b883082ff67fe283686ed4682e

		MovieMate_UserVO userInfo = moviemate_userdao.userInfo(uservo);

		model.addAttribute("userInfo", userInfo);
		return "/WEB-INF/views/userInfo/movie_mate_modify_screen.jsp";
	}

	@RequestMapping("/modify_userInfo.do")
	public String modify_userInfo() {

		return "/WEB-INF/views/userInfo/movie_mate_mypage_screen.jsp";
	}
}
