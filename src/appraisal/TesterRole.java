package appraisal;
import java.util.logging.Logger;

public class TesterRole extends JobRole {

    private static final Logger log = Logger.getLogger(TesterRole.class.getName());
    TesterRole(){
        log.info("You will be soon Working as a Tester");
    }
    @Override
    void work() {
        log.info("Your job is to test the working of the project.");
    }
}
