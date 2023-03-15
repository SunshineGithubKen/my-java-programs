package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.EmployeeBean;
import common.ImageUploadCommon;
import dao.EmployeeDAO;

@WebServlet("/delete")
public class EmployeeDeleteServlet extends HttpServlet {
	private final String UPLOD_DIR = "/uploads";
	private static final long serialVersionUID = 1L;
	HttpSession session = null;

	public EmployeeDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");// 文字コードの設定

		String action = request.getParameter("action");
		System.out.println(">>" + action);

		// forward
		request.getRequestDispatcher("/WEB-INF/jsp/EmployeeList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");// 文字コードの設定
		List<String> errorMessages = new ArrayList<String>();
		List<String> messages = new ArrayList<String>();

		String action = request.getParameter("action");
		if (action.equals("delete")) {
			String id = request.getParameter("id");

			ImageUploadCommon upload = new ImageUploadCommon();
			EmployeeDAO employeeDAO = new EmployeeDAO();
			EmployeeBean employee = new EmployeeBean();
			employee.intCheck(errorMessages, id, "社員ID");

			if (errorMessages.size() == 0) {
				String uploads = getServletContext().getRealPath(UPLOD_DIR);
				employee = employeeDAO.findId(id);
				if (employee != null) {
					employee.setId(Integer.parseInt(id));

					if (employeeDAO.delete(employee) == false) {// DAOでデータベースに登録
						errorMessages.add("DB削除に失敗しました。"); // エラーメッセージをリクエストスコープに保存
					} else {
						String oldImage = employee.getImage();
						if (oldImage != null && !oldImage.equals("no_image.png")) {
							upload.img_delete(request, uploads, oldImage);
						}
						messages.add("社員ID=" + id + "を削除しました。");
					}
				} else {
					errorMessages.add("該当データがありません。");
				}
			}
		} // エラーメッセージをリクエストスコープに保存

		request.setAttribute("errorMessages", errorMessages);
		request.setAttribute("messages", messages);

		doGet(request, response);
	}

}