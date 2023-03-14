package オブジェクト指向を用いた数字の大小を当てるハイローゲーム;
//Object-Oriented High & Low Game To Guess Number Size

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BigOrSmall {

	public int firstNumber;
	public int nowNumber;
	public int choice;

	RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

	Player player = new Player();

	final String Big = "大きい";
	final String Small = "小さい";
	final String Draw = "引き分け";

	int resultNumber = 0;
	String result;
	int correctCuntNumber = 0;
	String finalLog; // ログファイルの内容

	int playNumber = 10;// 残りプレイ回数10回からスタート
	int score = 0; //スコア0からスタートする

	private static final String OUTPUT_FILE = "c:\\users\\kenji\\Desktop\\log.txt";

	public void play() {

		boolean isContinue = true;

		try {
			while (isContinue) {
				System.out.println("[ Big Or Small をプレイします。]");

				System.out.println("残りプレイ回数: " + playNumber);
				System.out.println("スコア: " + score);

				firstNumber = randomNumberGenerator.randomNumber();
				System.out.println("現在の数値: " + firstNumber);

				choice = player.playerChoice();

				nowNumber = randomNumberGenerator.randomNumber();
				System.out.println("次の数字: " + nowNumber);
				System.out.println("");

				if (firstNumber < nowNumber) {
					result = Big;
					resultNumber = 0;
				} else if (firstNumber > nowNumber) {
					result = Small;
					resultNumber = 1;
				} else {
					result = Draw;
				}

				System.out.println(" 現在の数字: " + firstNumber + " 次の数字: " + nowNumber);
				System.out.println("[実際の答え]: " + result);

				if (result == Draw) {
					System.out.println(">>>>>引き分け");
					System.out.println("");
				} else if (resultNumber == choice) {
					playNumber -= 1;
					correctCuntNumber++;
					score += 100 * correctCuntNumber;
					System.out.println(">>>>>当たり！");
					System.out.println("");
				} else {
					playNumber -= 1;
					correctCuntNumber = 0;
					System.out.println(">>>>>はずれ！");
					System.out.println("");
				}

				if (playNumber == 0) {
					System.out.println("ゲームオーバー");
					System.out.println("現在のスコア:　" + score);
					isContinue = false;
					break;
				}

			}

			//例外

			PrintWriter out = null;
			LocalDateTime localDateTime = LocalDateTime.now(); // 現在日時の取得 // GAME OVER時点で、スコアと日時を log.txt に記録
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // 年/月/日 時:分:秒 の形式
			dateTimeFormatter.format(localDateTime);
			finalLog = "スコア: " + score + " " + dateTimeFormatter.format(localDateTime);

			//
			FileWriter fw = new FileWriter(OUTPUT_FILE, true);
			BufferedWriter bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);

			out.printf(finalLog);

			if (out != null) {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
}
