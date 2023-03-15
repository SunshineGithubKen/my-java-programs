package bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class EmployeeBean implements Serializable {

	// フィールド
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int age;
	private String gender;
	private String image;
	private String address;
	private String department;
	private String[] departments = { "総務部", "営業部", "開発部", "企画課" };

	// コンストラクタ（引数なし）
	public EmployeeBean() {
	}

	// コンストラクタ（引数あり）
	public EmployeeBean(int id) {
		this.id = id;
	}

	public EmployeeBean(int id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public EmployeeBean(int id, String name, String department, String image) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.department = department;
	}

	public EmployeeBean(ResultSet resultSet) throws SQLException {
		//DBの取得結果をフィールドに設定
		this.name = resultSet.getString("name");
		this.age = resultSet.getInt("age");
		this.gender = resultSet.getString("gender");
		this.address = resultSet.getString("address");
		this.image = resultSet.getString("image");
		this.department = resultSet.getString("department");
	}

	//setter
	public void setId(int id) {
		this.id = id;
	}

	public void setImage(String imageName) {
		this.image = imageName;
	}

	//getter
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public String getGender() {
		return this.gender;
	}

	public String getAddress() {
		return this.address;
	}

	public String getImage() {
		return this.image;
	}

	public String getDepartment() {
		return this.department;
	}

	public List<String> getDepartments() {
		return Arrays.asList(this.departments);
	}

	//入力項目のチェック
	public void itemCheck(List<String> errorMessages, HttpServletRequest request) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String department = request.getParameter("department");
		emptyCheck(errorMessages, name, "名前");
		intCheck(errorMessages, age, "年齢");
		emptyCheck(errorMessages, gender, "性別");
		emptyCheck(errorMessages, address, "住所");
		emptyCheck(errorMessages, department, "部署名");
	}

	public void emptyCheck(List<String> errorMessages, String value, String itemName) {
		//未入力チェック
		if (value == null || value.length() == 0) {
			errorMessages.add(itemName + "を入力してください。");
		}
	}

	public void intCheck(List<String> errorMessages, String value, String itemName) {
		//未入力チェック
		if (value == null || value.length() == 0) {
			errorMessages.add(itemName + "を入力してください。");
		} else {
			try {
	            //数値チェック
	            int number = Integer.parseInt(value);
	        } catch (NumberFormatException e) {
	            errorMessages.add(itemName + "は整数を入力してください。");
	            return;
	        } catch (InputMismatchException e) {
	            errorMessages.add(itemName + "に不正な値が入力されました。");
	            return;
	        }
	    }
	}

	public void setRequest(HttpServletRequest request) {
		//リクエストパラメータから値を取得してフィールドに設定
		this.name = request.getParameter("name");
		this.age = Integer.parseInt(request.getParameter("age"));
		this.gender = request.getParameter("gender");
		this.address = request.getParameter("address");
		this.department = request.getParameter("department");
	}

	public void setDepartments(String[] departments) {
		this.departments = departments;
	}

}