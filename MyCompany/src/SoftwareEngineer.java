public class SoftwareEngineer extends TechnicalEmployee
{
    private boolean codeAccess;
    private boolean access;


    public SoftwareEngineer(String name) {

        super(name);
        codeAccess=false;

    }

    public boolean getCodeAccess()
    {
        return this.codeAccess;
    }

    public void setCodeAccess(boolean access)
    {
        codeAccess = access;
        /*
        if(access) {
            codeAccess=true;
        }
        else {
            codeAccess=false;
        }*/
    }

    public int getSuccesfulCheckIns()
    {
        this.checkins++;
        return this.checkins;

    }

    public boolean checkInCode()
    {
        TechnicalLead manager = (TechnicalLead)this.manager;
        if(manager.approveCheckIn(this)) {
            super.checkins++;
            return true;
        }
        else
        {
            this.codeAccess=false;
            return false;
        }
    }

}
