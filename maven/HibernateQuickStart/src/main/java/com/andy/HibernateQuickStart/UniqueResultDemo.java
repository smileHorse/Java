package com.andy.HibernateQuickStart;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.andy.HibernateQuickStart.entities.Department;
import com.andy.HibernateQuickStart.entities.Employee;

public class UniqueResultDemo {

	public static Department getDepartment(Session session, String deptNo) {
		String sql = "Select d from " + Department.class.getName() + " d " 
				+ " where d.deptNo = :deptNo";
		Query<Department> query = session.createQuery(sql);
		query.setParameter("deptNo", deptNo);
		return (Department)query.getSingleResult();
	}
	
	public static Employee getEmployee(Session session, Long empId) {
		String sql = "Select e from " + Employee.class.getName() + " e " 
				+ " where e.empId = :empId";
		Query<Employee> query = session.createQuery(sql);
		query.setParameter("empId", empId);
		return (Employee)query.getSingleResult();
	}
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.getTransaction().begin();
			
			Department department = getDepartment(session, "D10");
			Set<Employee> employees = department.getEmpolyees();
			
			System.out.println("Dept name: " + department.getDeptName());
			for (Employee employee : employees) {
				System.out.println(" Emp name: " + employee.getEmpName());
			}
			
			Employee employee = getEmployee(session, 7839L);
			System.out.println("Emp Name: " + employee.getEmpName());
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
