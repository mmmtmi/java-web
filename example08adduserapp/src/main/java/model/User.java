package model;

import java.io.Serializable;

public class User implements Serializable{
	
	private String id;
	private String name;
	private String pass;
	
	public User() {} //javabeansの作成ルールに従い、引数のないコンストラクターも用意。
	public User(String id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
	
	public String getId() {return id;}
	public String getPass() {return pass;}
	public String getName() {return name;}
	
	/*セッターの必要性
	 * Healthのアプリでは、インスタンス生成時に登録する情報がすべてそろっていなく、
	 * 処理を介してルド登録しているためにセッターが必要だった。
	 * 
	 * 今回は登録に必要な情報がすべてそろっている。のでセッターは必要ない。
	 * ただし、登録後に修正機能を設ける予定であればあったほうがいいかも。
	 * 
	 * */
}
