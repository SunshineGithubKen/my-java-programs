package bean;

import java.io.Serializable;

public class DepartmentBean implements Serializable {

	// フィールド
	private String[] departments = {"総務部", "営業部", "開発部", "企画課"};

	// コンストラクタ（引数なし）
	public DepartmentBean(){ }

	//getter
	public String[] getDepartments() {
		return this.departments; }

}