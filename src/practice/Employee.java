package practice;

public class Employee
{
    public enum Department {IT, SALES}

    private String name;
    private double salary;
    private Department department;

    public Employee(String name, double salary, Department department)
    {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public double getSalary()
    {
        return salary;
    }


}
