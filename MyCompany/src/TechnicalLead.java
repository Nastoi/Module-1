
import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    private int headcount;
    private double salary;
    private int report;
    private String teamDetails;
    public ArrayList<SoftwareEngineer> team = new ArrayList<>();



    public TechnicalLead(String name) {
        super(name);
        salary = super.getBaseSalary() * 1.3;
        this.headcount=4;

    }

    @Override
    public double getBaseSalary()
    {
        return this.salary;
    }

   /* public double getSalaries()
    {
        double salary=0;
        for(int i=0;i<this.team.size();i++)
        {
            salary += team.get(i).getBaseSalary();
        }
        return salary;
    }*/


    public boolean hasHeadCount() {
        if (report < headcount) {
            return true;

        } else {
            return false;
        }

    }

    public boolean addReport(SoftwareEngineer e) {
        if (hasHeadCount()) {
            team.add(e);
            //e.setManager(this);
            e.manager = this;
            return true;
        } else {
            return false;
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        if (team.contains(e)  && e.getCodeAccess()) {
            super.checkins++;
            return true;
        } else {
            return false;
        }
    }

    public boolean requestBonus(Employee e, double bonus) {
          this.salary = getBaseSalary()+bonus;
            return true;
    }

    public String getTeamStatus() {
        this.teamDetails = employeeStatus() + "and is managing : \n" ;
        for(SoftwareEngineer e:this.team) {
            //this.teamDetails = employeeStatus() + "and is managing : \n" ;
            teamDetails += e.employeeStatus();

        }

        return this.teamDetails;
    }

}

