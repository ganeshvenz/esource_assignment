package com.esource.assignment;

import com.esource.assignment.exception.InvalidArraySpecException;
import com.esource.assignment.exception.NoPrimesFoundException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {

    @Test
    public void test_mapWithCount_emptyList() {
        List<Integer> lst = new ArrayList<>();
        Map<Integer, Integer> map = Utilities.getMapWithCount(lst);
        assertNotNull(map);
        assertTrue(map.isEmpty());
    }

    @Test
    public void test_mapWithCount_nullList() {
        List<Integer> lst = null;
        Map<Integer, Integer> map = Utilities.getMapWithCount(lst);
        assertNotNull(map);
        assertTrue(map.isEmpty());
    }

    @Test
    public void test_mapWithCount_listWithData() {

        List<Integer> lst = new ArrayList<>();
        lst.add(5);
        lst.add(45);
        lst.add(5);
        lst.add(2);

        Map<Integer, Integer> map = Utilities.getMapWithCount(lst);
        assertNotNull(map);
        assertTrue(map.get(5) == 2);
        assertTrue(map.get(45) == 1);
        assertTrue(map.get(2) == 1);
    }

    @Test
    public void test_isPrimeNumber_Invalid1() {
       boolean isPrime = Utilities.isPrimeNumber(46);
        assertTrue(!isPrime);
    }

    @Test
    public void test_isPrimeNumber_Invalid2() {
        boolean isPrime = Utilities.isPrimeNumber(1);
        assertTrue(!isPrime);
    }

    @Test
    public void test_isPrimeNumber_Valid1() {
        boolean isPrime = Utilities.isPrimeNumber(3);
        assertTrue(isPrime);
    }

    @Test
    public void test_isPrimeNumber_Valid2() {
        boolean isPrime = Utilities.isPrimeNumber(47);
        assertTrue(isPrime);
    }

    @Test
    public void test_generateRandomArray_Valid1() {
        int[] arr = Utilities.generateRandomArray(10, 0, 15);
    }

    @Test
    public void test_generateRandomArray_Valid2() {
        int[] arr = Utilities.generateRandomArray(5, 1, 4);

    }

    @Test
    public void test_generateRandomArray_InValid1() {
        InvalidArraySpecException thrown = assertThrows(
                InvalidArraySpecException.class,
                () -> Utilities.generateRandomArray(0, 1, 4),
                "Input Array Length Invalid"
        );
        assertTrue(thrown.getMessage().contains("Input Array Length Invalid"));
    }

    @Test
    public void test_generateRandomArray_InValid2() {
        InvalidArraySpecException thrown = assertThrows(
                InvalidArraySpecException.class,
                () -> Utilities.generateRandomArray(5, 4, 3),
                "Input Min Range is greater than Max Range"
        );
        assertTrue(thrown.getMessage().contains("Input Min Range is greater than Max Range"));
    }

    @Test
    public void test_generateRandomArray_InValid3() {
        InvalidArraySpecException thrown = assertThrows(
                InvalidArraySpecException.class,
                () -> Utilities.generateRandomArray(5, -8, 3),
                "Input Min Range Invalid"
        );
        assertTrue(thrown.getMessage().contains("Input Min Range Invalid"));
    }

    @Test
    public void test_generateRandomArray_InValid4() {
        InvalidArraySpecException thrown = assertThrows(
                InvalidArraySpecException.class,
                () -> Utilities.generateRandomArray(5, 8, 0),
                "Input Max Range Invalid"
        );
        assertTrue(thrown.getMessage().contains("Input Max Range Invalid"));
    }

    @Test
    public void test_generateRandomArray_Valid() {
        int[] arr = Utilities.generateRandomArray(15, 8, 50);
        assertTrue(arr.length == 15);
    }

    @Test
    public void test_getElementsNotPresentInArrays_Valid1() {
        List<Integer> lst = new ArrayList<>();
        lst.add(5);
        lst.add(45);
        lst.add(5);
        lst.add(2);
        Map<Integer, Integer> map = Utilities.getMapWithCount(lst);

        List<Integer> lstNum = Utilities.getElementsNotPresentInArrays(map, 50,0);
        assertTrue(lstNum.size() == 47);
    }

    @Test
    public void test_getElementsNotPresentInArrays_Valid2() {
        List<Integer> lst = new ArrayList<>();
        Map<Integer, Integer> map = Utilities.getMapWithCount(lst);
        List<Integer> lstNum = Utilities.getElementsNotPresentInArrays(map, 50,0);
        assertTrue(lstNum.size() == 50);
    }
}
