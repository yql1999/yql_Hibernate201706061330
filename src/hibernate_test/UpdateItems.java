package hibernate_test;

import com.dao.ItemsDao;
import com.entity.Items;

public class UpdateItems {

	public static void main(String[] args) {

		ItemsDao itemsDao = new ItemsDao();
		Items items=new Items();
		items.setItems_id(3);
		items.setItems_name("《数据库第三版》");
		items.setItems_price(25.0);
		items.setItems_amount(1);
		items.setItems_total(25.0);
		itemsDao.UpdateById(items);
	}
}
