package com.andy.HibernateQuickStart;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.andy.HibernateQuickStart.entities.Employee;

public class QuerySomeColumnDemo {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.getTransaction().begin();
			
			String sql = "Select e.empId, e.empNo, e.empName from " 
					+ Employee.class.getName() + " e ";
			
			Query<Object[]> query = session.createQuery(sql);
			
			List<Object[]> datas = query.getResultList();
			
			for(Object[] employee : datas) {
				System.out.println("Emp Id: " + employee[0]);
				System.out.println("	Emp No: " + employee[1]);
				System.out.println("	Emp Name: " + employee[2]);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
