package CSVファイルの読み込みと書き出し;
//Program To Read And Write CSV Files

public class Practice {

	//Pathを指定
	private static final String path1 = "c:\\users\\kenji\\Desktop\\game_csv_utf_8.csv";
	private static final String path2 = "c:\\users\\kenji\\Desktop\\output.csv";

	public static void main(String[] args) {

		//文字コードを指定
		Charset charset = Charset.forName("UTF-8");

		//Pathを読み込む
		Path path3 = Paths.get(path1);
		Path path4 = Paths.get(path2);
		boolean k = false;

		while (k == false) {
			try { //エラーが発生しうるブロック

				List<String> linesList = Files.readAllLines(path3, charset);
				String x = ""; //読み込んだデータの格納用

				//1行ずつデータを取り出す
				for (String s : linesList) {

					String[] linesStr = s.split(",");
					/*　処理文　*/

					//レベルが1のプレイヤーに、「応援旗」を追加する。
					if (linesStr[3] == "1" && linesStr[10] == "") {
						boolean c = true;
						while (c == true) {
							int a = 0;
							if (linesStr[a] == "") {
								linesStr[a] = "応援旗";
								c = false;
							}
							a++;
						}
					//すでにアイテムを4個所持していたら、所持金を100G加算する。
					} else if (linesStr[3] == "1" && linesStr[10] != "") {
						String d = linesStr[4];
						int e = Integer.parseInt(d);
						e += 100;
						Integer f = Integer.valueOf(e);
						String g = f.toString();
						linesStr[4] = g;
					}
					String a = linesStr[3];
					int b = Integer.parseInt(a);

					//プレイヤーのレベルが10以下の時、所持金を100G加算する。
					if (b <= 10) {
						String d = linesStr[4];
						int e = Integer.parseInt(d);
						e += 100;
						Integer f = Integer.valueOf(e);
						String g = f.toString();
						linesStr[4] = g;
					}
					//アイテム「鋼玉」は、「スペシャルソード」に交換する。
					for (int h = 0; h < linesStr.length; h++) {
						if (linesStr[h].equals("鋼玉")) {
							linesStr[h] = "スペシャルソード";
						}
					}
					s = String.join(",", linesStr);
					a = s;
				}
				//追加
				linesList.add(x);

				//ファイルが存在する時、
				if (Files.exists(path4, java.nio.file.LinkOption.NOFOLLOW_LINKS)) {
					System.out.println("ファイルを上書きしますか? [y/n]");
					Scanner t = new Scanner(System.in);
					String q = t.next();
					if (q.equals("y")) {
						Files.write(path4, linesList, charset, StandardOpenOption.TRUNCATE_EXISTING);
						k = true;
						System.out.println("作業終了");
					    }
						else if (q.equals("n")) {
						System.out.println("作業を中断します");
						k = true;
					    }
						else {
						throw new InputMismatchException();
					    }
				 } else {
					//書き込み
					Files.write(path4, linesList, charset, StandardOpenOption.TRUNCATE_EXISTING); //書き込み
					System.out.println("書込み作業終了");
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("n, yで入力");
				continue;
			} catch (NoSuchFileException e) {
				System.out.println("ファイルが見つかりません");
				e.printStackTrace();
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}

		}
	}
}
