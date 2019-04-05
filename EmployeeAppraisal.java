package appraisal;

import appraisal.LevelEnum.Level;
import appraisal.RoleEnum.Role;

import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class EmployeeAppraisal {

    private static final Logger log = Logger.getLogger(EmployeeAppraisal.class.getName());
    private static Scanner sc = new Scanner(System.in);
    private static String qualityOfWork, quantityOfWork, technicalKnowledge, role;
    private static int testcase, grades;
    static EnumMap<Role, Integer> map = new EnumMap(Role.class);

    public static void main(String[] args) {
        map.put(Role.Manager, 0);
        map.put(Role.Developer, 0);
        map.put(Role.Tester, 0);
        log.info("Enter number of TestCases");
        testcase = sc.nextInt();
        while (testcase-- > 0) {

            log.info("Enter Employee quality of work, quantity of work, job knowledge and grades.");
            try {
                qualityOfWork = sc.next();
                quantityOfWork = sc.next();
                technicalKnowledge = sc.next();
                grades = sc.nextInt();
                assignSuitableRole();
                salaryIncrement();
                countDifferentRoles();
            } catch (Exception e) {
                log. warning("Please ensure that the entered input is in correct format.");
            }
        }
        for (Map.Entry m : map.entrySet()) {
            log.info(m.getKey() + " " + m.getValue());
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
        WorkFactory workFactory = new WorkFactory();
        if (technicalKnowledge.equalsIgnoreCase(String.valueOf(Level.High)) && grades >= 7) {
            role = String.valueOf(Role.Manager);
            log.info("Role can be:" + role);
            JobRole jobRole = workFactory.getWork(role);
            jobRole.welcome();
            jobRole.work();
        } else if (technicalKnowledge.equalsIgnoreCase(String.valueOf(Level.Medium)) && grades >= 7) {
            role = String.valueOf(Role.Developer);
            log.info("Role can be:" + role);
            JobRole jobRole = workFactory.getWork(role);
            jobRole.welcome();
            jobRole.work();
        } else if (technicalKnowledge.equalsIgnoreCase(String.valueOf(Level.Low)) && grades >= 7) {
            role = String.valueOf(Role.Tester);
            log.info("Role can be:" + role);
            JobRole jobRole = workFactory.getWork(role);
            jobRole.welcome();
            jobRole.work();
        } else
            role = null;

    }

    private static void countDifferentRoles() {

        if (role.equals(String.valueOf(Role.Manager))) {
            if (map.containsKey(Role.Manager)) {
                Integer value = map.get(Role.Manager);
                value++;
                map.put(Role.Manager,value);
            }
        }
        else if (role.equals(String.valueOf(Role.Developer))) {
            if (map.containsKey(Role.Developer)) {
                Integer value = map.get(Role.Developer);
                value++;
                map.put(Role.Developer,value);
            }
        }
        else {
            if (map.containsKey(Role.Tester)) {
                Integer value = map.get(Role.Tester);
                value++;
                map.put(Role.Tester,value);
            }
        }


    }
}