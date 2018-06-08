package com.andy.HibernateQuickStart;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.andy.HibernateQuickStart.entities.Employee;

public class QueryObjectDemo {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction
			session.getTransaction().begin();
			
			// create an HQL statement, query the object.
			// Equivalent to the SQL statement.
			// select e.* from EMPLOYEE e order by e.EMP_NAME, e.EMP_NO
			String sql = "Select e from " + Employee.class.getName() + " e " + 
					" order by e.empName, e.empNo ";
			
			// create query object
			Query<Employee> query = session.createQuery(sql);
			
			// Execute query
			List<Employee> employees = query.getResultList();
			
			for(Employee employee : employees) {
				System.out.println("Emp: " + employee.getEmpNo() + " : " + employee.getEmpName());
			}
			
			// commit data
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			// Rollback in case of an error occurred	
			session.getTransaction().rollback();
		}
	}
}
