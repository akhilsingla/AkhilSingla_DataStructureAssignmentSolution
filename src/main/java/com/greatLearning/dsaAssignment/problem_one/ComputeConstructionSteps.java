package com.greatLearning.dsaAssignment.problem_one;

import java.util.Iterator;
import java.util.Queue;

/*
Algo Used :-
a) Going to store floor delivery plan in Queue i.e FIFO order
b) Create a temp array for each day as per formula :- Number of floor Used - Day Number
    e.g if on 4th Day we already have 2 floors used then max number of floors that can be used on that day is
        Number of floor Used - Day Number = 4 -2 = 2 (since 2 floors already used so we have 2 empty slot for 4th day)
c) Now on a given day we should have floor size > max floor size - day number
   e.g On 4th day (for max floor size = 6) we can have any floor size > 2 i.e either 6,5,4,3 (max floor size - day number (6-4 = 2) )
d) Now we store value in temp array as per formula :-
   tempArray[maxFloorSize - numberOfFloorsUsed - dequedFloorSize] = dequedFloorSize;
   e.g assume on 4th day we already used 2 floors on previous day so the tempArray will be of size 2, as explained in step b)
   now assume 6,5 already consumed for maxfloorsize = 6 and numberOfFloorsUsed = 2
   now we have 3,4 as next available floors for 4th day
   now temp[1] => temp[6-2-3] = temp[1] = 3
       temp[0] => temp[6-2-4] = temp[0] = 4

       so available floors for day 4 are temp[0] = 4, temp[1] = 3

  Please note if temp[0] comes 0 then we will skip for that day since we don't have larger floor available for that day
        e.g for above e.g if 3,2 are available as next floors for 4th day, then
        temp[1] => temp[6-2-3] = temp[1] = 3

        And for floor size 2, as per step c) our floor size should be greater then 2, we will skip entering temp[0], so
        temp[0] = 0

        since temp[0] = 0, so will skip for that day, since we don't have larger floor size available till now i.e 4.

 */
public class ComputeConstructionSteps {
    public void printConstructionSteps(Queue<Integer> floorDeliveryPlan) {
        //declare variables
        //whatever the size of queue that will be max floor size
        int maxFloorSize = floorDeliveryPlan.size();
        int dayNumber = 1;
        int[] tempArray;
        int tempArraySize;
        int numberOfFloorsUsed = 0;
        int floorSizeShouldBeGreaterThen;
        int dequedFloorSize;
        int k = 0;

        //if maxFloorSize is 0, print appropriate message
        if(maxFloorSize == 0)
        {
            System.out.println("Total number of floors are Zero, there is no plan to print.");
            return;
        }

        //loop till max floor size
        while (dayNumber <= maxFloorSize) {
            System.out.println("\nDay : " + dayNumber);
            //create temp array for the day
            tempArraySize = dayNumber - numberOfFloorsUsed;
            tempArray = new int[tempArraySize];
            //floor size should be greater then for that particular day
            floorSizeShouldBeGreaterThen = maxFloorSize - dayNumber;
            //iterate through queue till the length of array
            Iterator<Integer> iterator = floorDeliveryPlan.iterator();
            while (iterator.hasNext() && k < tempArraySize) {
                //dequeue element and fill in array if dequedFloorSize > floorSizeShouldBeGreaterThen
                dequedFloorSize = iterator.next();
                if (dequedFloorSize > floorSizeShouldBeGreaterThen) {
                    tempArray[maxFloorSize - numberOfFloorsUsed - dequedFloorSize] = dequedFloorSize;
                }
                ++k;
            }
            k = 0;

            //loop through array and print
            for (int floorSize : tempArray) {
                //if first element of array is 0, skip for day, since large floor size still not available
                if (floorSize == 0)
                    break;
                System.out.print(floorSize + " ");
                floorDeliveryPlan.remove(floorSize);
                ++numberOfFloorsUsed;
            }
            ++dayNumber;
        }
    }
}
