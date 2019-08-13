public class CompanyStructure
{
    public static void main(String[] args) {

        TechnicalLead CTO = new TechnicalLead("Izzul");
        SoftwareEngineer seA = new SoftwareEngineer("Kasey");
        SoftwareEngineer seB = new SoftwareEngineer("Breana");
        SoftwareEngineer seC = new SoftwareEngineer("Eric");


        CTO.addReport(seA);
        CTO.addReport(seB);
        CTO.addReport(seC);

        //System.out.println(CTO.checkins);
        //System.out.println(seA.checkins);
        seA.setCodeAccess(true);
        seB.setCodeAccess(true);
        seC.setCodeAccess(true);

        seA.checkInCode();
        seB.checkInCode();
        seC.checkInCode();
        //System.out.println(seA.checkins);
        //System.out.println(CTO.checkins);

        /*seA.getSuccesfulCheckIns();
        seB.getSuccesfulCheckIns();
        seC.getSuccesfulCheckIns();*/


        System.out.println(CTO.getTeamStatus());

        TechnicalLead VPofENG = new TechnicalLead("Nasrullah");
        SoftwareEngineer seD = new SoftwareEngineer("Winter");
        SoftwareEngineer seE = new SoftwareEngineer("Libby");
        SoftwareEngineer seF = new SoftwareEngineer("Gizan");
        SoftwareEngineer seG = new SoftwareEngineer("Zaynah");

        VPofENG.addReport(seD);
        VPofENG.addReport(seE);
        VPofENG.addReport(seF);
        VPofENG.addReport(seG);

        seD.setCodeAccess(true);
        seE.setCodeAccess(true);
        seF.setCodeAccess(true);
        seG.setCodeAccess(true);

        seD.checkInCode();
        seE.checkInCode();
        seF.checkInCode();
        seG.checkInCode();



        /*seD.getSuccesfulCheckIns();
        seE.getSuccesfulCheckIns();
        seF.getSuccesfulCheckIns();
        seG.getSuccesfulCheckIns();*/

        System.out.println(VPofENG.getTeamStatus());

        BusinessLead CFO = new BusinessLead("Riyah");
        Accountant actA = new Accountant("Niky");
        Accountant actB = new Accountant("Andrew");

        CFO.addReport(actA, CTO);
        CFO.addReport(actB, VPofENG);

        System.out.println(CFO.getTeamStatus());
    }
}


