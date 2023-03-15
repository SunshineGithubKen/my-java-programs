package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.EmployeeBean;
import dao.EmployeeDAO;

@MultipartConfig
@WebServlet("/edit")

public class EmployeeEditServlet extends HttpServlet {
	private final String UPLOD_DIR = "/uploads";
	private static final long serialVersionUID = 1L;
	HttpSession session = null;

	public EmployeeEditServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // 文字コードの設定

		String action = request.getParameter("action");
		System.out.println(">>" + action);
		String id = request.getParameter("id");
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeBean employee = employeeDAO.findId(id);
		//従業員が見つかった場合は編集画面へ
		if (employee != null) {
			request.setAttribute("employee", employee);
			request.setAttribute("departments", employee.getDepartments());
			// フォワード
			request.getRequestDispatcher("/WEB-INF/jsp/EmployeeEdit.jsp").forward(request, response);
		} else {
			// リダイレクト
			response.sendRedirect("./employeelist");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // 文字コードの設定
		List<String> errorMessages = new ArrayList<String>();
		List<String> messages = new ArrayList<String>();

		//パラメータactionを取得し、値がeditだったら処理を行う
		String action = request.getParameter("action");
		if (action.equals("edit")) {
			String id = request.getParameter("id");

			EmployeeDAO employeeDAO = new EmployeeDAO();
			EmployeeBean employee = new EmployeeBean();
			//入力チェック
			employee.itemCheck(errorMessages, request);
			employee.intCheck(errorMessages, id, "社員ID");

			//エラーがないときだけ処理を行う
			if (errorMessages.size() == 0) {

				employee.setRequest(request);
				employee.setId(Integer.parseInt(id));

				if (employeeDAO.update(employee) == false) { // DAOでデータベースに登録

					errorMessages.add("DB更新に失敗しました。"); // エラーメッセージをリクエストスコープに保存
				} else {
					messages.add("社員ID=" + id + "を更新しました。");
				}
			}
		}

		request.setAttribute("errorMessages", errorMessages);
		request.setAttribute("messages", messages);

		doGet(request, response);
	}

}
