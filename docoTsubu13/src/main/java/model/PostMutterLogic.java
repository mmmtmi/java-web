package model;
import dao.MutterDAO;

public class PostMutterLogic {
	public void excute(Mutter mutter) {
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);
		
	}

}
