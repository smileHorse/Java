package session;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.andy.HibernateQuickStart.HibernateUtils;
import com.andy.HibernateQuickStart.ShortEmpInfo;
import com.andy.HibernateQuickStart.entities.Department;
import com.andy.HibernateQuickStart.entities.Employee;

public class PersistDemo {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		
		Session session = factory.getCurrentSession();
		Department department = null;
		Employee employee = null;
		
		try {
			session.getTransaction().begin();
			
			Long maxEmpId = DataUtils.getMaxEmpId(session);
			Long empId = maxEmpId + 1;
			
			// Get Persistent object
			department = DataUtils.findDepartment(session, "D10");
			
			// create transient object
			employee = new Employee();
			employee.setEmpId(empId);
			employee.setEmpNo("E" + empId);
			employee.setEmpName("Name " + empId);
			employee.setJob("Coder");
			employee.setSalary(1000f);
			employee.setManager(null);
			employee.setHireDate(new Date());
			employee.setDepartment(department);
			
			// Using persist(...)
			// Now 'emp' is managed by Hibernate
			// it has persistent status
			// No action at this time with DB
			session.persist(employee);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		// After the session is closed (commit, rollback, close)
	    // Objects 'employee', 'department' became the Detached objects.
	    // It is no longer in the control of the session.        
	    System.out.println("Emp No: " + employee.getEmpNo());
	}
}
