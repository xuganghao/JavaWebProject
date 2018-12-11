package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EmailIdDao;
import Dao.SelfInfoDao;
import domain.EmailId;
import domain.SelfInfo;

/**
 * Servlet implementation class RegisterEmailServlet
 */
@WebServlet("/RegisterEmailServlet")
public class RegisterEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// 进行数据库操作
		EmailIdDao dao = new EmailIdDao();
		EmailId id = new EmailId();
		SelfInfoDao dao1 = new SelfInfoDao();
		SelfInfo info = new SelfInfo();
		ArrayList<EmailId> list = dao.findAll();
		for(int i = 0;i < list.size();i++) {
			if(email.equals(list.get(i).getEmail())) {
				request.setAttribute("msg", "用户名已存在");
				RequestDispatcher rd = request.getRequestDispatcher("/registerEmail.jsp");
				rd.forward(request, response);
				return;
			}
		}
		// 向emailid表中添加用户
		id.setEmail(email);
		id.setName(name);
		id.setPassword(password);
		boolean b = dao.insert(id);
	//	System.out.println(b);
		// 向selfinfo 表中添加用户
		info.setAccount(email);
		boolean b1 = dao1.insert(info);
	//	System.out.println(b1);
		response.sendRedirect("/Training/reSuccess.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
