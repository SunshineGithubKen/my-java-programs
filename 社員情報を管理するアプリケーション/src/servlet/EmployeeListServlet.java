package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.EmployeeBean;
import dao.EmployeeDAO;

@WebServlet("/employeelist")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;

	public EmployeeListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");// 文字コードの設定

		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<EmployeeBean> employees = employeeDAO.findAll();
		request.setAttribute("employees", employees);

		// フォワード　　　　　　　　　　　　　　　　　　　　　　　
		request.getRequestDispatcher("/WEB-INF/jsp/EmployeeList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");

		doGet(request, response);
	}

}


