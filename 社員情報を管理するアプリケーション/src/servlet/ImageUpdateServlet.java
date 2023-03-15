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

import bean.DepartmentBean;
import bean.EmployeeBean;
import common.ImageUploadCommon;
import dao.EmployeeDAO;

@MultipartConfig //jspから画像を受け取るには、@MultipartConfig　
@WebServlet("/imageupdate")
public class ImageUpdateServlet extends HttpServlet {

	private final String UPLOD_DIR = "/uploads";
	private List<String> errorMessages = new ArrayList<String>();
	private List<String> messages = new ArrayList<String>();
	private static final long serialVersionUID = 1L;
	HttpSession session = null;

  public ImageUpdateServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
		  								throws ServletException, IOException {

	  request.setCharacterEncoding("UTF-8");// 文字コードの設定

	  DepartmentBean department = new DepartmentBean();
	  String action = request.getParameter("action");
	  System.out.println(">>" + action);

		  String id = request.getParameter("id");
		  EmployeeDAO employeeDAO = new EmployeeDAO();
		  EmployeeBean employee = employeeDAO.findId(id);

		      if (employee != null) {
			  request.setAttribute("employee", employee);
			  request.setAttribute("departments", employee.getDepartments());
			  errorMessages = new ArrayList<String>();
			  messages = new ArrayList<String>();

			  // フォワード
			  request.getRequestDispatcher("/WEB-INF/jsp/ImageUpdate.jsp").forward(request, response);
		   }else {
		  // リダイレクト
		  response.sendRedirect("./employeelist"); } }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
		  									throws ServletException, IOException {

	  request.setCharacterEncoding("UTF-8"); // 文字コードの設定

	  String action = request.getParameter("action");
	  if (action.equals("update")) {
		  String id = request.getParameter("id");
		  String oldImage = request.getParameter("oldImage");


		  ImageUploadCommon upload = new ImageUploadCommon();
		  EmployeeDAO employeeDAO = new EmployeeDAO();
		  EmployeeBean employee = new EmployeeBean();


		  if (errorMessages.size() == 0) {
			  String uploads = getServletContext().getRealPath(UPLOD_DIR);
			  String imageName = upload.img_upload(request, uploads, oldImage);
			  employee = employeeDAO.findId(id);
			  employee.setImage(imageName);


			  if (employeeDAO.update(employee) == false) { // DAOでデータベースに登録
				  upload.img_delete(request, uploads, imageName);

				  errorMessages.add("DB更新に失敗しました。");// エラーメッセージをリクエストスコープに保存
			  } else {
				  if (!oldImage.equals("no_image.png") && !imageName.equals(oldImage)) {
					  upload.img_delete(request, uploads, oldImage);
				  }
				  messages.add("社員ID=" + id + "を更新しました。"); 	  } 		  }

	  }
	  	request.setAttribute("errorMessages", errorMessages);
	  	request.setAttribute("messages", messages);

	  	doGet(request, response);
  }

}


