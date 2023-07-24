■プログラム説明：
このプログラムは、次の機能を備えたシンプルな携帯電話を実装しています。
・連絡先名を保存、変更、削除、検索できる。
・メニューを持ち、以下のオプションが利用可能：終了、連絡先のリストの印刷、新しい連絡先の追加、既存の連絡先の更新、連絡先の削除、連絡先の検索/検索。
・追加または更新するときは、既に連絡先が存在するかどうか（名前を使用）を確認します。
・名前と電話番号を格納するために、プログラムはContactクラスを使用し、MobilePhoneクラスはContactsのArrayListを保持します。MobilePhoneクラスには、上記の機能があります。
・ArrayListの内部動作はMobilePhoneに公開されません。
・MobilePhoneは、連絡先オブジェクトのみを使用してすべてを実行する必要があります。

■Program Description:
This program implements a simple mobile phone with the following capabilities:
・Able to store, modify, remove and query contact names.
・Has a menu of options that are available: Quit, print list of contacts, add new contact, update existing contact, remove contact, and search/find contact.
・When adding or updating, it checks if the contact already exists (use name).
・The program uses the Contact class to store a name and phone number, and the MobilePhone class holds the ArrayList of Contacts. The MobilePhone class has the functionality listed above.
・The inner workings of the ArrayList are not exposed to MobilePhone.
・MobilePhone should do everything with Contact objects only.

■教材
Java Programming Masterclass updated to Java 17
Arrays,-Java-inbuilt-Lists,-Autoboxing-and-Unboxing-ArrayList-Challenge-Part-3

■
	    // Create a program that implements a simple mobile phone with the following capabilities.
        // Able to store, modify, remove and query contact names.
        // You will want to create a separate class for Contacts (name and phone number).
        // Create a master class (MobilePhone) that holds the ArrayList of Contacts
        // The MobilePhone class has the functionality listed above.
        // Add a menu of options that are available.
        // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
        // and search/find contact.
        // When adding or updating be sure to check if the contact already exists (use name)
        // Be sure not to expose the inner workings of the Arraylist to MobilePhone
        // e.g. no ints, no .get(i) etc
        // MobilePhone should do everything with Contact objects only.