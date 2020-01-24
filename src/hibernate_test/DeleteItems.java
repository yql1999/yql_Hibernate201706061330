package hibernate_test;

import com.dao.ItemsDao;

public class DeleteItems {
	
	public static void main(String[] args) {
		ItemsDao itemsDao = new ItemsDao();
		itemsDao.Delete(3);
	}
}
