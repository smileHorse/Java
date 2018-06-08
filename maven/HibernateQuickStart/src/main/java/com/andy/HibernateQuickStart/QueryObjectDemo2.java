package com.andy.HibernateQuickStart;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.andy.HibernateQuickStart.entities.Employee;

public class QueryObjectDemo2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.getTransaction().begin();
			
			String sql = "Select e from " + Employee.class.getName() + " e " + "where e.department.deptNo=:deptNo";
			
			Query<Employee> query = session.createQuery(sql);
			query.setParameter("deptNo", "D10");
			
			List<Employee> employees = query.getResultList();
			
			for(Employee employee : employees) {
				System.out.println("Emp: " + employee.getEmpNo() + " : " + employee.getEmpName());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
