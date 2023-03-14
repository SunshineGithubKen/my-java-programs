プログラム説明：
このJavaプログラムは、CSVファイルを読み込み、特定のルールに従ってデータを処理し、
更新されたデータを新しいCSVファイルに書き込むプログラムです。
プログラムは、パスとファイルクラスを使用してファイルシステムにアクセスし、文字エンコーディングを指定するためにCharsetクラスを使用します。
また、入力CSVファイルを1行ずつ読み込み、カンマを区切り文字として使用して各行を値の配列に分割します。
その後、特定の条件に基づいてデータにさまざまな操作を実行します。
たとえば、プレイヤーのレベルが10以下の場合、そのゴールドの金額を100G増やします。
プレイヤーのレベルが1で、特定のアイテムを持っていない場合、「応援旗」という新しいアイテムが彼らのインベントリに追加されます。
また、プログラムは、行内に「鋼玉」というアイテムがある場合、それを「スペシャルソード」に置き換えます。

すべての行を処理した後、プログラムは更新されたデータを新しいCSVファイルに書き込みます。
出力ファイルがすでに存在する場合、プログラムはユーザーに上書きするかどうかを確認するプロンプトを表示します。

Program Outline:
This Java program is designed to read a CSV file, process the data according to specific rules, 
and then write the updated data to a new CSV file. 
The program uses the Paths and Files classes to access the file system and the Charset class 
to specify the file's character encoding.

The program reads the input CSV file line by line and splits each line into an array of values 
using the comma as the delimiter. 
Then, it performs various operations on the data based on specific conditions. For example, 
if a player's level is less than or equal to 10, their gold amount is increased by 100G. 
If a player's level is 1 and they don't have a specific item, a new item called "Support Flag" is added to their inventory. 
The program also replaces the item "Steel Ball" with "Special Sword" whenever it appears in a line.

After processing all the lines, the program writes the updated data to a new CSV file. 
If the output file already exists, the program prompts the user to confirm whether they want to overwrite it or not.