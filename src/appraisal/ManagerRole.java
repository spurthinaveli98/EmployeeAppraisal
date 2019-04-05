package appraisal;
import java.util.logging.Logger;

public class ManagerRole extends JobRole {

    private static final Logger log = Logger.getLogger(ManagerRole.class.getName());
    ManagerRole(){
        log.info("You will be soon Working as a Manager");
    }
    @Override
    public void work() {
       log.info("Your job is to assign work to employees");
    }
}
