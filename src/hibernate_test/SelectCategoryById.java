package hibernate_test;

import com.dao.CategoryDao;

public class SelectCategoryById {

	public static void main(String[] args) {

		CategoryDao categoryDao=new CategoryDao();
		categoryDao.SelectById(1);

	}

}
