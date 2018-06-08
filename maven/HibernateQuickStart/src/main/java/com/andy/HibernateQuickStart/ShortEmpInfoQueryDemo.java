package com.andy.HibernateQuickStart;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.andy.HibernateQuickStart.entities.Employee;

public class ShortEmpInfoQueryDemo {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.getTransaction().begin();
			
			// Using constructor of ShortEmpInfo
			String sql = "Select new " + ShortEmpInfo.class.getName() + "(e.empId, e.empNo, e.empName) " 
					+ " from " + Employee.class.getName() + " e ";
			
			Query<ShortEmpInfo> query = session.createQuery(sql);
			
			List<ShortEmpInfo> datas = query.getResultList();
			
			for(ShortEmpInfo employee : datas) {
				System.out.println("Emp Id: " + employee.getEmpId());
				System.out.println("	Emp No: " + employee.getEmpNo());
				System.out.println("	Emp Name: " + employee.getEmpName());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
