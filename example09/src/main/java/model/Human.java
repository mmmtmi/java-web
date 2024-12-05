package model;
//     ￣￣↑②

import java.io.Serializable;

public class Human implements Serializable{
//②				￣￣￣￣￣↑￣￣￣￣￣￣￣
				//マーカー・インターフェース
				//メンバーが一切定義されてない空のインターフェース
				//「～可能である」クラスということを表すための目印
		/*
		 * 		直列化(ファイル化)するためには、その実行クラスが必要！
		 * 		[例]直列化するメソッドを定義する場合
		 * 			　public byte[] serialize(Serializable obj){
		 * 				//直列化するための処理
		 * 				}
		 * 
		 * */
//	フィールド(④ pribate) (※内部向けの情報(私的な情報)：フィールド)
	private String name;
	private int age;

//	コンストラクタ
	public Human() {}		//③ 引数なしの(あるいはデフォルト)コンストラクタ
	public Human(String name, int age) {
		this.name= name;
		this.age = age;
	}
//	④アクセサメソッド		（※外部向けの情報(公的な情報)(プロパティ)が生まれる。
	public String getName() { return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	
	//プロパティ≠フィールドｐ
	public String getNickName() {return this.name;}
	public boolean isAdult() {return this.age >= 18;}
}
