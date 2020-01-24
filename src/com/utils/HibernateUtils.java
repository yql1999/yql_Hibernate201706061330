package com.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	static Configuration cfg = null;
	static SessionFactory sessionFactory = null;
	//��̬�����ʵ��
	static {
		//���غ��������ļ�
		cfg = new Configuration();
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
	}
	
	//�ṩ�����뱾���̰߳��session�ķ���
	public static Session getSessionobject() {
		return sessionFactory.getCurrentSession();
	}
	
	//�ṩ��������sessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		
	}
}
