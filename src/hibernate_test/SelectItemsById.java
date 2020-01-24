package hibernate_test;

import com.dao.ItemsDao;

public class SelectItemsById {

	public static void main(String[] args) {
		ItemsDao itemsDao=new ItemsDao();
		itemsDao.SelectById(1);
	}
}
