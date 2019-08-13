public class Accountant extends BusinessEmployee {
    private double bonusBudget;
    private TechnicalLead Support;

    public Accountant(String name) {

        super(name);
        //Team = "not supporting any Team";
        //this.bonusbudget= this.getBaseSalary();

    }

    public TechnicalLead getTeamSupported() {
        //this.TechnicalLeadSupport = getName();

        return Support;
    }

    public void supportTeam(TechnicalLead lead) {

        this.Support = lead;
        super.bonusBudget += lead.team.size()*(lead.getBaseSalary()/1.3) * 1.1;

    }

    public boolean approveBonus(double bonus) {
        if (bonus > super.bonusBudget) {
            super.bonusBudget -= bonus;
            return false;
        } else {

            return true;
        }
    }

   public String employeeStatus() {
        {
            String InfoSup = super.employeeStatus()+" is supporting "+ Support.getName() + "\n";
            return InfoSup;

        }
    }
}
