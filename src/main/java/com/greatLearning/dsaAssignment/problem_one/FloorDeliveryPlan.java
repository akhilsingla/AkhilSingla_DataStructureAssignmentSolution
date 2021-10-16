package com.greatLearning.dsaAssignment.problem_one;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class FloorDeliveryPlan {
    //total number of floors present in building
    private int numberOfFloors;

    //get number of floors as i/p from User
    private void provideNumberOfFloors(Scanner scanner) {
        try {
            scanner = new Scanner(System.in);
            System.out.println("Enter the total no of floors in the building : ");
            numberOfFloors = scanner.nextInt();
        }//if user enters value other then int, quit
        catch (NumberFormatException e) {
            System.out.println("Expected integer value, quitting, Bye!!!");
            System.exit(0);
        }//if exception occurs, quit
        catch (Exception e) {
            System.out.println("Exception found, quitting, Bye!! : \n" + e.getMessage());
            System.exit(0);
        }
    }

    //get floor delivery plan from User, and return delivery plan in Queue
    public Queue<Integer> getFloorsDeliveryTimeTable(Scanner scanner) {
        provideNumberOfFloors(scanner);

        Queue<Integer> floorSizeDelivery = new ArrayDeque<Integer>();

        //initialize first day
        int dayNumber = 1;
        int floorSizeProvidedOnParticularDay;

        try {
            //loop through all days
            while (dayNumber <= numberOfFloors) {

                //get floors size on particular day
                System.out.println("Enter the floor size given on day : " + dayNumber);
                floorSizeProvidedOnParticularDay = scanner.nextInt();

                //if user enters floor size greater then number of floors, ask to enter correct value
                // floorSizeProvidedOnParticularDay = 7 and numberOfFloors = 5
                if (floorSizeProvidedOnParticularDay > numberOfFloors) {
                    System.out.println("Floor Size given is greater then max floor size, please enter different size");
                    continue;
                }

                //if user enters duplicate value then ask to re-enter
                if (floorSizeDelivery.contains(floorSizeProvidedOnParticularDay)) {
                    System.out.println("Floor Size, already provided previously, please enter different one");
                    continue;
                }

                floorSizeDelivery.offer(floorSizeProvidedOnParticularDay);
                ++dayNumber;
            }
        }//if provided non-integer value, quit
        catch (NumberFormatException e) {
            System.out.println("Expected integer value, quitting, Bye!!!");
            System.exit(0);
        }//if exception occurs, quit
        catch (Exception e) {
            System.out.println("Exception found, quitting, Bye!! : \n" + e.getMessage());
            System.exit(0);
        }

        return floorSizeDelivery;
    }
}
