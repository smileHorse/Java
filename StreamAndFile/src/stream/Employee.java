package stream;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    public static int RECORD_SIZE = 100;
    public static int NAME_SIZE = 40;

    public Employee() {}

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.hireDay = calendar.getTime();
    }

    @Override
    public String toString() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getHireDay());
        return getName() + ", " + getSalary() + ", " + calendar.get(Calendar.YEAR) + ", "
            + (calendar.get(Calendar.MONTH) + 1) + ", " + calendar.get(Calendar.DAY_OF_MONTH);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }
}
