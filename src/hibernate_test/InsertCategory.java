package hibernate_test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.dao.CategoryDao;
import com.entity.Category;
import com.entity.Items;

public class InsertCategory {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		CategoryDao categoryDao = new CategoryDao();
		
		// 添加购物车
		Category category1 = new Category();
		category1.setCategory_id(1);
		category1.setCategory_name("1号购物车");
		Category category2 = new Category();
		category2.setCategory_id(2);
		category2.setCategory_name("2号购物车");
		Category category3 = new Category();
		category3.setCategory_id(3);
		category3.setCategory_name("3号购物车");	
		
		Items item1= (Items) session.get(Items.class, 1);
		Items item2= (Items) session.get(Items.class, 2);
		
		// 向购物车中添加商品
		category1.getItems().add(item1);
		category2.getItems().add(item2);
		// 把商品放入购物车
		item1.setCategory(category1);
		item2.setCategory(category2);

		categoryDao.Insert(category1);
		categoryDao.Insert(category2);
		categoryDao.Insert(category3);
		
	}
}
