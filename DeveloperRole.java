package appraisal;
import java.util.logging.Logger;

public class DeveloperRole extends JobRole {

    private static final Logger log = Logger.getLogger(DeveloperRole.class.getName());
    public DeveloperRole(){
        log.info("You will be soon working as a Developer");
    }
    @Override
    public void work() {
        log.info("Your job is to develop projects");
    }
}
