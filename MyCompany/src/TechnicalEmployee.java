public class TechnicalEmployee extends Employee
{
    public int checkins;
    private String Details;
    public int TotalCount;

    public TechnicalEmployee(String name) {
        super(name, 75000);
    }

    public String employeeStatus()
    {/*
        if(this.TotalCount==3 || this.TotalCount==4)
        {
            this.Details=(this.ID + " " + getName() + " has " + this.TotalCount + " successful check ins \n");
            return this.Details;
        }
        else {*/
            this.Details = (this.ID + " " + getName() + " has " + this.checkins + " successful check ins \n");
            return this.Details;
        //}
    }
}
