package com.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Category;
import com.utils.HibernateUtils;
import org.hibernate.cfg.Configuration;

public class CategoryDao {

	// 增
	public void Insert(Category category) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			// 得到sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			// 得到session
			session = sessionFactory.openSession();
			// 开启事务
			tx = session.beginTransaction();

			session.saveOrUpdate(category);
			session.flush();
			System.out.println("购物车插入成功");

			// 提交事务
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	// 改
	public void Update(Integer category_id, String category_name) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {

			sessionFactory = HibernateUtils.getSessionFactory();

			session = sessionFactory.openSession();

			tx = session.beginTransaction();

			String hql = "update Category set category_name=:category_name where category_id=:category_id";
			Query query = session.createQuery(hql);
			query.setString("category_name", category_name);
			query.setDouble("category_id", category_id);
			query.executeUpdate();

			System.out.println("更新成功，更新后的购物车id为" + category_id + ",购物车名为" + category_name);

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	// 查
	public void SelectAll() {
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();

		String hql = "from Category";
		Query query = session.createQuery(hql);

		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Category category = (Category) iterator.next();
			System.out.println("购物车名称：" + category.getCategory_name());
		}

		session.close();
		sessionFactory.close();
	}

	public void SelectById(Integer category_id) {
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Category where category_id=:category_id");
		query.setInteger("category_id", category_id);

		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Category category = (Category) iterator.next();
			System.out.println("购物车名称：" + category.getCategory_name());
		}

		session.close();
		sessionFactory.close();
	}

}
