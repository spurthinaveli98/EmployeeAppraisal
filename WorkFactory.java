package appraisal;

public class WorkFactory {
    public JobRole getWork(String role){
      if(role.equals("Manager")){
          return new ManagerRole();
        }
        else if(role.equals("Developer")){
            return new DeveloperRole();
      }
        else if(role.equals("Tester")){
            return new TesterRole();
      }
        else
            return null;
    }
}
