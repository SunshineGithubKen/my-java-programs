SongPlaylist LinkedList

■Program Description:
This is a program that simulates a playlist for songs, implemented in Java. The program consists of two classes, Album and Main.

The Album class contains a list of songs, which is implemented using an ArrayList of Song objects. The Album class has methods to add a song to the list of songs and to add a song to a playlist. 
The addSong() method takes a song title and duration as parameters and returns a boolean value indicating whether the song was successfully added to the album. 
The addToPlayList() method takes either a track number or a song title and adds the corresponding song to a list of songs representing the playlist.

The Main class contains the main() method that creates instances of the Album class and adds songs to them. 
It also creates a list of songs representing the playlist and adds songs from the albums to it using the addToPlayList() method of the Album class. The program then prompts the user to input options to interact with the playlist, such as skipping forward or backward to the next or previous song in the list, replaying the current song, listing the songs in the playlist, removing the current song from the playlist, or quitting the program.

■プログラム説明：
曲のプレイリストをシミュレートするプログラムです。プログラムは、AlbumクラスとMainクラスの2つのクラスで構成しました。

Albumクラスには、SongオブジェクトのArrayListを使用した曲のリストが含まれています。Albumクラスには、曲をアルバムに追加するためのaddSong()メソッドと、プレイリストに曲を追加するためのaddToPlayList()メソッドがあります。addSong()メソッドは、曲のタイトルと再生時間をパラメーターとして受け取り、曲がアルバムに正常に追加されたかどうかを示すブール値を返します。addToPlayList()メソッドは、トラック番号または曲のタイトルを受け取り、対応する曲をプレイリストを表す曲のリストに追加します。

Mainクラスでは、Albumクラスのインスタンスを作成し、曲を追加するmain()メソッドが含まれています。また、アルバムから曲をプレイリストに追加するために、AlbumクラスのaddToPlayList()メソッドを使用して、プレイリストを表す曲のリストを作成します。プログラムは、ユーザーがプレイリストとやり取りするためのオプションを入力するように促します。たとえば、リストの次の曲や前の曲にスキップしたり、現在の曲を再生したり、プレイリストの曲をリストしたり、現在の曲をプレイリストから削除したり、プログラムを終了したりすることができます。

■教材：
Java Programming Masterclass updated to Java 17
Section10 Inner-and-Abstract-Classes-&-Interfaces-Interfaces-Part-2-Source-code