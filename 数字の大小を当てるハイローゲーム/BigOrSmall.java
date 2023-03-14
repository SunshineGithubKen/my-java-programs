package 数字の大小を当てるハイローゲーム;
//High & Low Game To Guess Number Size

import java.util.Random;
import java.util.Scanner;

public class BigOrSmall {

	public static void main(String[] args) {

		// 準備
		Scanner scanner = new Scanner(System.in);
		//ランダム準備
		Random random1 = new Random();


		//プレーを継続したい時に、以下を実行する
		boolean isContinue = true;
		int count = 0; //プレー回数
		while(isContinue) {

			count = count + 1;

            //それぞれの手
			int myHand = (random1.nextInt(9)+1); //1-9の範囲
			int comHand = (random1.nextInt(7)+2);  //2-8の範囲

			//COMの数字を出力
			System.out.println("出た数字（COM） ： "+comHand);

			//予想する
			System.out.print("あなたの選択は？  (0: Small 1: Big): ");
			int userSelectNum = scanner.nextInt();

			System.out.println("あなたの数字： "+ myHand);

			//引き分け
		   if(comHand == myHand) {
			   System.out.println("Draw");
		   }
		   //予想とあっていれば勝ち
		   else if(comHand < myHand && userSelectNum ==1 ||
				    comHand > myHand && userSelectNum == 0 ) {
			   System.out.println("Win!");
		   }

		   //予想と違っていれば負け
		   else {
			   System.out.println("Lose..");
		   }
		   //3回未満の時
		   //ゲームを続けるかきく
		   if(count < 3) {
		   System.out.print("もう一度プレイしますか ? (0: No  1: Yes): ");
		   userSelectNum = scanner.nextInt();  //読み込む
		   if(userSelectNum == 1) {
			   isContinue = true;}
		   if(userSelectNum == 0) {
			   isContinue = false;}

		   }
		   //3回目になった時の終了
		   if(count == 3) {
			   System.out.println("3回に達しました。");
			   isContinue = false;
		}

	}
		//続けるを選ばなかった時の終了
		System.out.println("プレイを終了します");
		scanner.close();
		}
}




