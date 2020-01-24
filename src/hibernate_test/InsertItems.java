package hibernate_test;

import com.dao.ItemsDao;
import com.entity.Items;

public class InsertItems {
	public static void main(String[] args) {

		ItemsDao itemsDao = new ItemsDao();

		// 添加商品,一对多关系要先insert商品
		Items item1 = new Items();
		item1.setItems_id(1);
		item1.setItems_name("《JavaEE教程》");
		item1.setItems_price(29.0);
		item1.setItems_amount(2);
		item1.setItems_total(58.0);
		itemsDao.Insert(item1);
		
		Items item2 = new Items();
		item2.setItems_id(2);
		item2.setItems_name("《JavaEE实验指导》");
		item2.setItems_price(20.0);
		item2.setItems_amount(1);
		item2.setItems_total(20.0);
		itemsDao.Insert(item2);
		
		Items item3 = new Items();
		item3.setItems_id(3);
		item3.setItems_name("《数据库》");
		item3.setItems_price(25.0);
		item3.setItems_amount(1);
		item3.setItems_total(25.0);
		itemsDao.Insert(item3);
	}
}
