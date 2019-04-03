package appraisal;

import java.util.logging.Logger;

abstract public class JobRole {

    private static final Logger log = Logger.getLogger(JobRole.class.getName());
    public void  jobRole(){
        log.info("Hai, We are glad that you are working in ZeMoSo Technologies.");
    }
    abstract void work();
}
