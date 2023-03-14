package Comparatorインターフェースを用いて指定したキーと順番で並び変え;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


             //Staffs
public class Practice {

	public static void main(String[] args) {
		
		ArrayList <MyStaff> staffs = new ArrayList<>();
		
		staffs.add(new MyStaff(1, "田中太郎", "たなか　たろう",20));
		staffs.add(new MyStaff(2, "鈴木二郎", "すずき　じろう", 40));
		staffs.add(new MyStaff(3, "山田花子", "やまだ　はなこ", 19));
		staffs.add(new MyStaff(4, "橋本士郎", "はしもと　しろう", 31));
		staffs.add(new MyStaff(5, "高橋吾朗","たかはし　ごろう", 54));
		staffs.add(new MyStaff(6, "吉田歩", "よしだ　あゆむ", 22));
		staffs.add(new MyStaff(7, "和田花", "わだ　はな", 30));
		staffs.add(new MyStaff(8, "山崎蓮", "やまざき　れん", 28));
		staffs.add(new MyStaff(9, "三浦一美", "みうら　かずみ", 33));
		
		
		ArrayList<String> list = new ArrayList<>();
		list.add("1:社員id 昇順"); 
		list.add("2:社員name 昇順");
		list.add("3:社員id 降順");
		list.add("9:終了end　戻る");
		
		//ソート前　出力
		System.out.println("************並び替え前");
		for (MyStaff mystaff : staffs) {
			System.out.println(mystaff.toString());
		}

		boolean isContinue = true;
		while(isContinue) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ソートする基準を選んで下さい。" + list + ">");
	    int num = scanner.nextInt();
	    
	    switch(num) {
	    case 1: //id 昇順
	    	Collections.sort(staffs, new MyIdAscend());
	    	System.out.println("************社員id 昇順で並び替え");
			break;
		case 2: //name 昇順
			Collections.sort(staffs, new MynameAscend());
			System.out.println("************社員name 昇順で並び替え");
			break;
		case 3: //id 降順
			Collections.sort(staffs, new MyIdDescend());
			System.out.println("************社員id 降順で並び替え");
			break;
		case 9: //終了させない
			System.out.println("終了せず戻ります。");
			continue;
		default: 
	    	System.out.println("不正な入力です。");
	    	continue;
		}
		if(isContinue) {
			for (MyStaff mystaff : staffs) {
				System.out.println(mystaff.toString());	
			}

		}
			}
	    }
}

	


		


		
		
		

