public class BusinessEmployee extends Employee
{
    public double bonusBudget;
    private String details;

    public BusinessEmployee(String name) {
        super(name, 50000);

    }

    public double getBonusBudget()
    {
        return this.bonusBudget;
    }
    public String employeeStatus()
    {
        String strDouble = String.format("%.2f", this.bonusBudget);
        this.details =(this.ID + " " + getName() + " with a Budget of " + strDouble);
        return this.details;
    }
}
