■プログラム概要：
複数の学生情報を管理するためのデータベースプログラムです。StudentクラスとStudentDatabaseAppクラスの2つのクラス構成で作成しました。

■プログラム説明：
Studentクラスを使って、各学生の情報を表すフィールドとメソッドを定義し、複数の学生情報を管理します。
StudentDatabaseAppクラスを使って、ユーザーからの入力を受け取ります。ユーザーは、追加する学生の数を入力し、各学生の情報を入力します。各学生は、学生の名前、学年、学生ID、履修科目、学費の残高の情報を持ちます。各学生は、履修する科目を入力し、科目ごとに定義された学費を支払うことができます。また、学生の情報を表示することもできます。

■教材：
UdemyのPractice Java by Building Projectsコース

■Program Outline:
This is a Java program for managing student information in a database. The program allows users to add new students and enroll them in courses. 

■Program Description:
・Student class:
The class contains several private fields, including the student's first and last name, grade year, student ID, courses enrolled, and tuition balance.
The class also contains several methods, including a constructor, a method to generate a student ID, a method to enroll in courses, a method to view the tuition balance, a method to pay tuition, and a method to show the student's status.

・StudentDatabaseApp class:
The class is the main class of the program and contains the "main" method.
The class prompts the user to enter the number of new students to enroll.
The class creates an array of "Student" objects based on the number of new students to enroll.The class then prompts the user to enter each new student's information, enroll them in courses, and pay their tuition.
The class displays each student's information, including their name, grade level, student ID, courses enrolled, and tuition balance.
