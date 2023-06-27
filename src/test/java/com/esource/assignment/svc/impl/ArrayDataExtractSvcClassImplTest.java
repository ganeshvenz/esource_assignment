package com.esource.assignment.svc.impl;

import com.esource.assignment.Utilities;
import com.esource.assignment.exception.NoPrimesFoundException;
import com.esource.assignment.svc.ifc.ArrayExtractSvc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayDataExtractSvcClassImplTest {

    private ArrayExtractSvc svc;

    @Test
    public void test_getLargestPrime_Valid1() {
        svc = new ArrayDataExtractSvcClassImpl();
        List<Integer> lst = new ArrayList<>();
        lst.add(5);
        lst.add(47);
        lst.add(49);
        int prime = svc.getLargestPrime(lst);
        assertTrue(prime == 47);
    }

    @Test
    public void test_getLargestPrime_InValid1() {
        svc = new ArrayDataExtractSvcClassImpl();
        List<Integer> lst = new ArrayList<>();
        NoPrimesFoundException thrown = assertThrows(
                NoPrimesFoundException.class,
                () -> svc.getLargestPrime(lst),
                "Input list was empty"
        );
        assertTrue(thrown.getMessage().contains("No Primes Found in Input"));
    }

    @Test
    public void test_getLargestPrime_InValid2() {
        svc = new ArrayDataExtractSvcClassImpl();
        List<Integer> lst = new ArrayList<>();
        lst.add(6);
        lst.add(42);
        lst.add(49);
        NoPrimesFoundException thrown = assertThrows(
                NoPrimesFoundException.class,
                () -> svc.getLargestPrime(lst),
                "Input list did not contain any Primes"
        );
        assertTrue(thrown.getMessage().contains("No Primes Found in Input"));
    }

    @Test
    public void test_getElementsNotPresentInArrays_Valid1() {
        svc = new ArrayDataExtractSvcClassImpl();
        int[] arr1 = Utilities.generateRandomArray(15, 0, 50);
        int[] arr2 = Utilities.generateRandomArray(15, 0, 50);
        int[] arr3 = Utilities.generateRandomArray(15, 0, 50);

        List<Integer> lst = svc.getElementsNotPresentInArrays(0, 50, arr1, arr2, arr3);
        assertTrue(!lst.isEmpty());
    }


}
