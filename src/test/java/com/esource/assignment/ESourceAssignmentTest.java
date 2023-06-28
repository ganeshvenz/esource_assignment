package com.esource.assignment;

import com.esource.assignment.svc.ifc.ArrayExtractSvc;
import com.esource.assignment.svc.impl.ArrayDataExtractSvcClassImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//@slf4j
public class ESourceAssignmentTest {

    private ESourceAssignment objImpl = new ESourceAssignment();





    @Test
    public void test_Integration1() {
        //Generate Random Arrays
        int[] arr1 = Utilities.generateRandomArray(15, 0, 50);
        int[] arr2 = Utilities.generateRandomArray(15, 0, 50);
        int[] arr3 = Utilities.generateRandomArray(15, 0, 50);

        //Instantiate Service
        ArrayExtractSvc svc = new ArrayDataExtractSvcClassImpl();

        //Get List of numbers not present in arrays
        List<Integer> lst = svc.getElementsNotPresentInArrays(0,50, arr1, arr2, arr3);

        int primeNum = svc.getLargestPrime(lst);

        assertTrue(!lst.isEmpty());
        assertTrue(primeNum >= 0 && primeNum <= 50);

    }

    @Test
    public void test_Integration2() {
        String args[] = {"SOme ARgs"};
        //ESourceAssignment.main(args);
        assertDoesNotThrow(() -> ESourceAssignment.main(args));
    }



}
