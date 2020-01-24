package hibernate_test;

import com.dao.CategoryDao;
import com.dao.ItemsDao;

public class SelectAll {

	public static void main(String[] args) {

		CategoryDao categoryDao=new CategoryDao();
		ItemsDao itemsDao=new ItemsDao();
		itemsDao.SelectAll();
		categoryDao.SelectAll();
	}

}
