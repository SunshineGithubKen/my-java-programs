package Comparatorインターフェースを用いて指定したキーと順番で並び変え;
//Object-Oriented High & Low Game To Guess Number Size

import java.util.Comparator;

public class MyStaff {

	//フ
	private int id;
	private String name;
	private String nameKana;
	private int age;

	//コ
	public MyStaff(int id, String name, String nameKana, int age) {
		this.id = id;
		this.name = name;
		this.nameKana = nameKana;
		this.age = age;
	}

	@Override
	public String toString() {
		return "社員id: " + id + ", 社員name: " + name + ", 社員age: " + age  ;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String getNameKana() {
		return nameKana;
	}

	public int getAge() {
		return age;
	}
}
//id Ascend
class MyIdAscend implements Comparator <MyStaff>{
	@Override
	public int compare(MyStaff o1, MyStaff o2) {
		return o1.getId() - o2.getId();
	}
}
//name Ascend
class MynameAscend implements Comparator<MyStaff>{
	@Override
	public int compare(MyStaff o1, MyStaff o2) {
		return o1.getNameKana().compareTo(o2.getNameKana());
	}
}
//id Descend
class MyIdDescend implements Comparator <MyStaff>{
	@Override
	public int compare(MyStaff o1, MyStaff o2) {
		return o2.getId() - o1.getId();
	}
}






