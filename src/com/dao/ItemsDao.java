package com.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Category;
import com.entity.Items;
import com.utils.HibernateUtils;

public class ItemsDao {

	// ��
	public void Insert(Items items) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {

			// �õ�sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			// �õ�session
			session = sessionFactory.openSession();
			// ��������
			tx = session.beginTransaction();

			session.saveOrUpdate(items);
			session.flush();
			System.out.println("��Ʒ����ɹ�!");

			// �ύ����
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	// ɾ
	public void Delete(Integer items_id) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			// �õ�sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			// �õ�session
			session = sessionFactory.openSession();
			// ��������
			tx = session.beginTransaction();

			String hql = "delete from Items where items_id=:items_id";
			Query query = session.createQuery(hql);
			query.setInteger("items_id", items_id);
			query.executeUpdate();

			tx.commit();
			System.out.println("�h����Ʒ�ɹ�!");

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	// ��
	public void UpdateById(Items items) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {

			sessionFactory = HibernateUtils.getSessionFactory();

			session = sessionFactory.openSession();

			tx = session.beginTransaction();

			String hql = "update Items i set i.items_name=:items_name,i.items_price=:items_price,i.items_total=:items_total"
					+ " where i.items_id=" + items.getItems_id();
			Query query = session.createQuery(hql);
			query.setString("items_name", items.getItems_name());
			query.setDouble("items_price", items.getItems_price());
			query.setDouble("items_total", items.getItems_total());
			query.executeUpdate();

			tx.commit();
			System.out.println("���³ɹ������º����Ʒ��Ϊ" + items.getItems_name() + "���۸�Ϊ" + items.getItems_price() + "���ܼ�Ϊ"
					+ items.getItems_total());

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	// ��
	public void SelectAll() {
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();

		String hql = "from Items";
		Query query = session.createQuery(hql);

		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Items items = (Items) iterator.next();
			System.out.println("��Ʒ���ƣ�" + items.getItems_name());
		}

		session.close();
		sessionFactory.close();
	}

	public void SelectById(Integer items_id) {
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Items where items_id=:items_id");
		query.setInteger("items_id", items_id);

		List list = query.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Items items = (Items) iterator.next();
			System.out.println("��Ʒ���ƣ�" + items.getItems_name() + "����Ʒ�۸�" + items.getItems_price() + "����Ʒ������"
					+ items.getItems_amount() + "����Ʒ�ܼۣ�" + items.getItems_total());
		}

		session.close();
		sessionFactory.close();
	}

}
