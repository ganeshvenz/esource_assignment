package com.esource.assignment;

import com.esource.assignment.svc.ifc.ArrayExtractSvc;
import com.esource.assignment.svc.impl.ArrayDataExtractSvcClassImpl;

import java.util.List;



public class ESourceAssignment {

    //private static Logger logger = LoggerFactory.getLogger(ESourceAssignment.class);

    /**
     * Utility method to print list contents
     * @param lst
     */
    public static void printArray(List<Integer> lst) {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        Integer[] arr = new Integer[lst.size()];
        lst.toArray(arr);
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            sb.append(arr[i]);
            if (i != len-1)
                sb.append(" , ");
        }
        sb.append(" }");

        System.out.println(" List of elements not present -> " + sb.toString());
    }

    public static void main(String[] args) {

        //Generate Random Arrays
        int[] arr1 = Utilities.generateRandomArray(15, 0, 50);
        int[] arr2 = Utilities.generateRandomArray(15, 0, 50);
        int[] arr3 = Utilities.generateRandomArray(15, 0, 50);

        //Instantiate Service
        ArrayExtractSvc svc = new ArrayDataExtractSvcClassImpl();

        //Get List of numbers not present in arrays
        List<Integer> lst = svc.getElementsNotPresentInArrays(0,50, arr1, arr2, arr3);

        //Print List
        printArray(lst);

        //Print Largest Prime
        System.out.println(" Largest Prime " + svc.getLargestPrime(lst));

    }

}