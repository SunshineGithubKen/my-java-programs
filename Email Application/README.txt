■プログラムの概要：
Javaで電子メール管理アプリケーションを作成するプログラムです。
ITサポート管理者スペシャリストが新しい従業員のために電子メールアカウントを作成するために使用するアプリケーションを作成することが求められるというシナリオに基づいています。ユーザーの名前と姓、部署、ランダムなパスワード、メールボックス容量、代替メールアドレス、および電子メールアドレスを生成するように作成しました。

■プログラムの説明：
Scannerを使用して、ユーザーに部署を選択するように促します。
1から3までの数字を入力すると、それぞれSales、Development、Accountingに対応する部署名が返されます。
ユーザーが0を入力すると、部署は空の文字列に設定されます。
ランダムなパスワードを生成するために、ランダムな整数値を生成し、その値に基づいてパスワードセットから文字を選択します。
選択された文字は、パスワード文字数に基づいてパスワードの配列に追加されます。
setMailboxCapacityメソッドを使用して、メールボックスの容量を設定します。
setAlternateEmailメソッドを使用して、代替メールアドレスを設定します。
showInfoメソッドを使用して、ユーザーの名前、部署、メールボックス容量、代替メールアドレス、および電子メールアドレスを含む、電子メール情報が表示されます。
配列内のすべての文字を文字列に連結して、ランダムなパスワードが生成されます。

■Program Overview:
This is a program to create an email management application using Java.
It simulates an IT support administrator's task of creating email accounts for new hires. We have created the user's first name, last name, department, random password, mailbox capacity, alternate email, and email address.


■Program Description:
Using Scanner, the user is prompted to select a department. 
When the user enters a number from 1 to 3, the corresponding department name for Sales, Development, and Accounting is returned. 
If the user enters 0, the department is set to an empty string.
To generate a random password, a random integer value is generated and a character is selected from the password set based on that value. 
The selected character is added to the password array based on the password length.
The setMailboxCapacity method is used to set the capacity of the mailbox. The setAlternateEmail method is used to set the alternate email address.
The showInfo method displays email information including the user's name, department, mailbox capacity, alternate email address, and email address.
All characters in the array are concatenated into a string to generate a random password.


■教材：
Udemy Practice Java by Building Projects