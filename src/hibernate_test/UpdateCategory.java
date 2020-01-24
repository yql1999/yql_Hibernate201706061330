package hibernate_test;

import com.dao.CategoryDao;
import com.entity.Category;

public class UpdateCategory {
	
	public static void main(String[] args) {
		
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.Update(3, "修改后的3号购物车");
		
	}
		
}
