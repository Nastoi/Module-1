
public class Employee
{
    public static int EmployeeID;
    public int ID;
    private Double Salary;
    private String Name;
    private String Status;
    private String Rep;
    private double budget;
    public Employee manager;


    public Employee(String name,double BaseSalary)
    {
        Name=name;
        this.Salary=BaseSalary;
        this.EmployeeID++;
        this.ID=this.EmployeeID;
        //System.out.println(ID + name + "-----" + BaseSalary);
    }


    public double getBaseSalary()
    {

        return Salary;

    }


    public String getName()
    {
        return Name;
    }


    public int getEmployeeID()
    {
        this.ID=this.EmployeeID;
        return this.ID;
    }


    public boolean equals(Employee Other) {
        if (this.ID == Other.ID) {
            return true;
        } else {
            return false;
        }
    }


    public String toString()
    {
        Rep = (ID + " " + Name);
        return Rep;
    }


    public String employeeStatus()
    {
        String Details = this.ID+ this.Name + " with a budget of " + budget + " is supporting " + getManager();
        return Details;
    }


    public Employee getManager()
    {
        return manager;
    }


}
