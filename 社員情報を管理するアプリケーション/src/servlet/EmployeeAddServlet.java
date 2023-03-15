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
import common.ImageUploadCommon;
import dao.EmployeeDAO;

@WebServlet("/add")
@MultipartConfig
public class EmployeeAddServlet extends HttpServlet {
	private final String UPLOD_DIR = "/uploads";
	private static final long serialVersionUID = 1L;
	HttpSession session = null;

	public EmployeeAddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		EmployeeBean employee = new EmployeeBean();
		request.setAttribute("departments", employee.getDepartments());
		request.getRequestDispatcher("/WEB-INF/jsp/EmployeeAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");// 文字コードの設定
		List<String> errorMessages = new ArrayList<String>();
		List<String> messages = new ArrayList<String>();

		String oldImage = "no_image.png";
		//パラメータactionを取得し、値がaddだったら処理を行う
		String action = request.getParameter("action");
		if (action.equals("add")) {
			EmployeeDAO employeeDAO = new EmployeeDAO();
			ImageUploadCommon upload = new ImageUploadCommon();
			EmployeeBean employee = new EmployeeBean();
			//入力チェック
			employee.itemCheck(errorMessages, request);

			//入力チェックでエラーがないときだけ処理をする
			if (errorMessages.size() == 0) {
				String uploads = getServletContext().getRealPath(UPLOD_DIR);
				String imageName = upload.img_upload(request, uploads, oldImage);
				employee.setRequest(request);
				employee.setImage(imageName);

				if (employeeDAO.insert(employee) == false) { // DAOでデータベースに登録
					upload.img_delete(request, uploads, imageName);

					errorMessages.add("DB更新に失敗しました。"); // エラーメッセージをリクエストスコープに保存
				} else {
					if (!oldImage.equals("no_image.png") && !imageName.equals(oldImage)) {
						upload.img_delete(request, uploads, oldImage);
					}
					messages.add("1件の社員情報を登録しました。");
				}
			}
		}

		request.setAttribute("errorMessages", errorMessages);
		request.setAttribute("messages", messages);

		doGet(request, response);
	}

}