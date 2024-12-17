package model;

public class LoginLogic {
	public boolean execute(User user) {
	//String pass = user.getPass();
	//if (pass.equals("1234")){
		if (user.getPass().equals("1234")) {return true;}
		
//		else {
		return false;
//		}
	}
}


// 上記は早期リターン。
// 通常、早期リターンのコードは異常系の処理をできるだけ早くリターンする。
// 逆に、正常系の処理が最後に残るようにしたほうが、慣例的にわかりやすい。

/*
 * if(! user.getPass().equals("1234")){return false;}
 * パスワードが一致していなければ認証は「失敗」
 * return true;
 * パスワード・チェックに問題がなければ、認証は「成功」とする。
 *
 * 三項条件演算子の活用。
 * 	boolean judge = user.getPass().equals("1234")?true : false;
 *  return judge;
 *  
 *  return user.getPass().equals("1234") ? true : false;
 *
 *
 * */