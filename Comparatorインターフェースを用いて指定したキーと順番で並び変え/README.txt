プログラム説明：
このプログラムは、Comparatorインターフェースを使用して、指定されたキーと順序でMyStaffオブジェクトをソートするJavaプログラムです。

MyStaffクラスは、社員の情報を表すフィールドを持ち、それぞれのフィールドに対するgetterメソッドを定義しています。
また、toStringメソッドをオーバーライドして、社員の情報を出力しています。
ソートには、MyIdAscend、MynameAscend、MyIdDescendの3つのComparatorクラスを使用しています。
それぞれ、社員IDの昇順、社員名の昇順、社員IDの降順でソートするように定義しています。

プログラムは、ArrayListを使用してMyStaffオブジェクトのリストを作成し、ソート前にリストを出力します。
次に、ユーザーに対してソートの基準を選択するように求め、選択された基準に応じてリストをソートして出力します。
また、ユーザーが9を選択すると、プログラムが終了します。

Program Outline:
This is a Java program that uses the Comparator interface to sort an ArrayList of 
MyStaff objects based on specified keys and orders. 
The MyStaff class represents a staff member with four attributes: id, name, nameKana, and age. 
The program provides three different Comparator implementations: 
MyIdAscend for sorting by id in ascending order, MynameAscend for sorting by name in ascending order 
based on the nameKana attribute, and MyIdDescend for sorting by id in descending order.

The main method initializes an ArrayList of MyStaff objects, adds some sample data, 
and then provides a menu for the user to select the sorting criteria. 
Based on the user's input, the program calls the appropriate Comparator implementation 
to sort the ArrayList and then prints the sorted list to the console.