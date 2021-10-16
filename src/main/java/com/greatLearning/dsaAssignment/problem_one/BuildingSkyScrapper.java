package com.greatLearning.dsaAssignment.problem_one;

import java.util.Scanner;

public class BuildingSkyScrapper {
    public static void main(String[] args) {
        //create scanner and take user i/p and compute floor plan
        Scanner scanner = new Scanner(System.in);
        String cond = "Y";
        try {
            do {
                new ComputeConstructionSteps().printConstructionSteps(new FloorDeliveryPlan().getFloorsDeliveryTimeTable(scanner));

                System.out.println("\n\nDo you want to continue, press 'Y' to confirm : ");
                //if user i/p "Y", continue, else exit
                cond = scanner.next();
            } while (cond.equalsIgnoreCase("Y"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close scanner
            scanner.close();
        }
    }
}
