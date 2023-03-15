package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EmployeeBean;

public class EmployeeDAO {
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:~/codecamp";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<EmployeeBean> findAll() {
		List<EmployeeBean> employees = new ArrayList<EmployeeBean>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			//ドライバの読み込み
			Class.forName(DRIVER_NAME);
			//コネクションの取得
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "SELECT id, name, department, image FROM employees ORDER BY id";
			//PreparedStatementの生成
			statement = conn.prepareStatement(sql);
			//SQL実行
			resultSet = statement.executeQuery();
			//1行ずつ取り出して処理
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String department = resultSet.getString("department");
				String image = resultSet.getString("image");
				EmployeeBean employee = new EmployeeBean(id, name, department, image);
				employees.add(employee);
			}

		} catch (SQLException e) { // データベース接続やSQL実行失敗時の処理
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) { // JDBCドライバが見つからなかったときの処理
			e.printStackTrace();
			return null;

		} finally { // PrepareStatementインスタンス、ResultSetインスタンスのクローズ処理
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) { // クローズ処理失敗時の処理
					e.printStackTrace();
					return null;
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) { // クローズ処理失敗時の処理
					e.printStackTrace();
					return null;
				}
			}

			if (conn != null) { // データベース切断
				try {
					conn.close();
				} catch (SQLException e) {// データベース切断失敗時の処理
					e.printStackTrace();
					return null;
				}
			}
		}
		return employees;
	}

	public EmployeeBean findId(String id) {
		EmployeeBean employee = new EmployeeBean();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			//findAllと同様
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "SELECT id, name, age, gender, address, image, department FROM employees WHERE id = ?";
			statement = conn.prepareStatement(sql);
			//パラメータのセット
			statement.setString(1, id);

			resultSet = statement.executeQuery();
			employee = null;
			while (resultSet.next()) {
				employee = new EmployeeBean(resultSet);
				employee.setId(Integer.parseInt(id));
			}

		} catch (SQLException e) { // データベース接続やSQL実行失敗時の処理
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {// JDBCドライバが見つからなかったときの処理
			e.printStackTrace();
			return null;

		} finally {// PrepareStatementインスタンス、ResultSetインスタンスのクローズ処理

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) { // クローズ処理失敗時の処理
					e.printStackTrace();
					return null;
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {// クローズ処理失敗時の処理
					e.printStackTrace();
					return null;
				}
			}

			if (conn != null) { // データベース切断
				try {
					conn.close();
				} catch (SQLException e) {// データベース切断失敗時の処理
					e.printStackTrace();
					return null;
				}
			}
		}
		return employee;
	}

	public boolean insert(EmployeeBean employee) {
		System.out.printf("insert処理開始\n");

		try {
			Class.forName("org.h2.Driver");// JDBCドライバのロード
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);// DBMSとの接続
			String sql = "INSERT INTO employees (name, age, gender, image, address, department)"// 実行するSQL文の作成
					+ " VALUES (?,?,?,?,?,?)";

			PreparedStatement statement = conn.prepareStatement(sql);// PreparedStatementを使ってSQLの準備

			statement.setString(1, employee.getName());// 準備したSQLにパラメータをセット
			statement.setInt(2, employee.getAge());
			statement.setString(3, employee.getGender());
			statement.setString(4, employee.getImage());
			statement.setString(5, employee.getAddress());
			statement.setString(6, employee.getDepartment());

			int cnt = statement.executeUpdate();// executeUpdate()でSQLを実行
			System.out.printf("%d件のデータを登録しました。\n", cnt);
		} catch (SQLException e) {// データベース接続やSQL実行失敗時の処理
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(EmployeeBean employee) {

		try {
			Class.forName("org.h2.Driver");// JDBCドライバのロード
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS); // DBMSとの接続
			String sql = "UPDATE employees SET" // 実行するSQL文の作成
					+ "  name = ?"
					+ ", age = ?"
					+ ", gender = ?"
					+ ", address = ?"
					+ ", department = ?"
					+ ", image = ?"
					+ "  WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql); // PreparedStatementを使ってSQLの準備

			statement.setString(1, employee.getName()); // 準備したSQLにパラメータをセット
			statement.setInt(2, employee.getAge());
			statement.setString(3, employee.getGender());
			statement.setString(4, employee.getAddress());
			statement.setString(5, employee.getDepartment());
			statement.setString(6, employee.getImage());
			statement.setInt(7, employee.getId());

			int cnt = statement.executeUpdate();// executeUpdate()でSQLを実行
			System.out.printf("%d件のデータを更新しました。\n", cnt);
		} catch (SQLException e) {// データベース接続やSQL実行失敗時の処理
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean delete(EmployeeBean employee) {

		try {
			Class.forName("org.h2.Driver"); // JDBCドライバのロード
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);// DBMSとの接続

			String sql = "DELETE FROM employees WHERE id = ?"; // 実行するSQL文の作成

			PreparedStatement statement = conn.prepareStatement(sql); // PreparedStatementを使ってSQLの準備

			statement.setInt(1, employee.getId());// 準備したSQLにパラメータをセット

			int cnt = statement.executeUpdate();// executeUpdate()でSQLを実行
			System.out.printf("%d件のデータを削除しました。\n", cnt);

		} catch (SQLException e) {// データベース接続やSQL実行失敗時の処理
			e.printStackTrace();
			return false;
		}

		return true;
	}

}