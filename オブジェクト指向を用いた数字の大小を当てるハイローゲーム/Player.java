package オブジェクト指向を用いた数字の大小を当てるハイローゲーム;

import java.util.Scanner;

// プレイヤーの入力内容を管理するクラス

public class Player {

	public int judge;

	Scanner scanner = new Scanner(System.in);

	public int playerChoice() {

	//  次の数字が現在の数字よりも大きいか・小さいか。予測を数字で入力する。　　
	//	形式が異なる時は再入力・範囲が異なる時は再入力


	while(true){
			System.out.print("次の数値はBig or Small? (Big:0 Small:1) ");
		try {
			judge = scanner.nextInt();

			if(judge != 0 && judge != 1) {
				throw new NumberOutOfRange_Exception("範囲が不正です。");
			}

		    if(judge == 0) {
					System.out.println("[あなたの答え]: 大きい");

			}else if(judge == 1) {
					System.out.println("[あなたの予想]: 小さい");
			}
			   return judge;

		    }
		catch (NumberOutOfRange_Exception e) {
			System.out.println("範囲が不正です。0または1で入力してください。" );
			System.out.println("");

		}
		 catch(Exception e) {
			System.out.println("入力形式が不正です。0または1で入力してください。");
			System.out.println("");
			scanner.next();
		}
	}
	}
}








