import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee {
    private String manager;
    private int headcount;
    private double salary;
    private int report;
    private String details;
    private ArrayList<Accountant> team = new ArrayList<>();


    public BusinessLead(String name) {
        super(name);
       //BusinessEmployee Manager = new BusinessEmployee(name);
        //this.Manager=name;
        this.headcount=2;
        salary = getBaseSalary()*2;

    }

    public boolean hasHeadCount()
    {
        if(report<headcount)
        {
            return true;

        }
        else
        {
            return false;
        }
    }
    public boolean addReport(Accountant e, TechnicalLead supportTeam)
    {
        if (hasHeadCount() == true) {
            this.team.add(e);
            super.bonusBudget += e.getBaseSalary()+e.getBaseSalary() *1.1;
            e.supportTeam(supportTeam);
            return true;
        } else {
            return false;
        }

    }
    public boolean requestBonus(Employee e,double bonus)
    {

        return requestBonus(e,bonus);
    }
    public boolean approveBonus(Employee e,double bonus)
    {
        return approveBonus(e,bonus);
    }

    public String getTeamStatus() {
        this.details = employeeStatus() + " and is managing : \n" ;
        for(Accountant e:this.team) {
            //this.Details = employeeStatus() + "and is managing : \n" ;
            details += e.employeeStatus();
        }

        return this.details;
    }
}
