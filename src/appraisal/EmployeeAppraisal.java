package appraisal;

import appraisal.LevelEnum.Level;
import appraisal.RoleEnum.Role;
import java.util.Scanner;
import java.util.logging.Logger;

public class EmployeeAppraisal {

    private static final Logger log = Logger.getLogger(EmployeeAppraisal.class.getName());
    private static Scanner sc = new Scanner(System.in);
    private static String qualityOfWork, quantityOfWork, technicalKnowledge, role;
    private static int grades;

    public static void main(String[] args) {
        log.info("Enter Employee quality of work, quantity of work, job knowledge and grades.");
        try {
            qualityOfWork = sc.next();
            quantityOfWork = sc.next();
            technicalKnowledge = sc.next();
            grades = sc.nextInt();
            if(grades >= 9) {
                assignSuitableRole();
            }
            salaryIncrement();
        }
            catch (Exception e) {
            log.warning("Please ensure that the entered input is in correct format.");
        }
    }

    private static void salaryIncrement() {
        if (qualityOfWork.equalsIgnoreCase(String.valueOf(Level.High)) && quantityOfWork.equalsIgnoreCase(String.valueOf(Level.High))) {
            log.info("Salary increment is upto 80%");
        } else if (qualityOfWork.equalsIgnoreCase(String.valueOf(Level.High)) && quantityOfWork.equalsIgnoreCase(String.valueOf(Level.Medium))) {
            log.info("Salary increment is upto 70%");
        } else if (qualityOfWork.equalsIgnoreCase(String.valueOf(Level.Medium)) && quantityOfWork.equalsIgnoreCase(String.valueOf(Level.High))) {
            log.info("Salary increment is upto 60%");
        } else if (qualityOfWork.equalsIgnoreCase(String.valueOf(Level.Medium)) && quantityOfWork.equalsIgnoreCase(String.valueOf(Level.Medium))) {
            log.info("Salary increment is upto 50%");
        } else if (qualityOfWork.equalsIgnoreCase(String.valueOf(Level.High)) && quantityOfWork.equalsIgnoreCase(String.valueOf(Level.Low))) {
            log.info("Salary increment is upto 40%");
        } else if (qualityOfWork.equalsIgnoreCase(String.valueOf(Level.Low)) && quantityOfWork.equalsIgnoreCase(String.valueOf(Level.High))) {
            log.info("Salary increment is upto 30%");
        } else if (qualityOfWork.equalsIgnoreCase(String.valueOf(Level.Medium)) && quantityOfWork.equalsIgnoreCase(String.valueOf(Level.Low))) {
            log.info("Salary increment is upto 20%");
        } else if (qualityOfWork.equalsIgnoreCase(String.valueOf(Level.Low)) && quantityOfWork.equalsIgnoreCase(String.valueOf(Level.Medium))) {
            log.info("Salary increment is upto 10%");
        } else if (qualityOfWork.equalsIgnoreCase(String.valueOf(Level.Low)) && quantityOfWork.equalsIgnoreCase(String.valueOf(Level.Low))) {
            log.info("No increment in salary");
        }
    }

    private static void assignSuitableRole() {
        if (technicalKnowledge.equalsIgnoreCase(String.valueOf(Level.High))) {
             role= String.valueOf(Role.Manager);
            log.info("Role can be:"+role);
             JobRole managerRole = new ManagerRole();
             managerRole.jobRole();
             managerRole.work();
        }

        else if(technicalKnowledge.equalsIgnoreCase(String.valueOf(Level.Medium))) {
            role = String.valueOf(Role.Developer);
            log.info("Role can be:"+ role);
            JobRole developerRole = new DeveloperRole();
            developerRole.jobRole();
            developerRole.work();
        }

        else {
            role = String.valueOf(Role.Tester);
            log.info("Role can be:" + role);
            TesterRole testerRole = new TesterRole();
            testerRole.jobRole();
            testerRole.work();
        }

    }

}