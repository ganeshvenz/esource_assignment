package com.esource.assignment;

import com.esource.assignment.exception.InvalidArraySpecException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utilities {

    /**
     * Returns a map whose key is the element of the array and the value - the cumulative number of occurrences
     * @param lst - the list of integer elements
     * @return - the map having the count as mentioned above
     *
     */
    public static Map<Integer, Integer> getMapWithCount(List<Integer> lst) {
        Map<Integer, Integer> map = new HashMap<>();
        if (lst != null && !lst.isEmpty()) {
            //for (int i: lst)
            lst.stream().forEach(i -> {;
                map.compute(i, (k, v) -> (v == null ? 1 : ++v));
            });
        }
        return map;
    }

    /**
     * Returns boolean if the element passed is a prime
     * @param elem
     * @return boolean
     */
    public static boolean isPrimeNumber(int elem) {
        if (elem <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(elem); i++) {
            if ((elem % i) == 0)
                return false;
        }
        return true;
    }

    /**
     * Implementation of operation to get elements not present as a list
     * @param map
     * @param maxRange
     * @param minRange
     * @return List of elements not present
     */
    public static List<Integer> getElementsNotPresentInArrays(Map<Integer, Integer> map, int maxRange, int minRange) {
        return IntStream.range(minRange, maxRange).boxed()
                .filter(c -> !map.containsKey(c)).collect(Collectors.toList());
    }

    /**
     * Utility method that generates a random array containing integers as specified by the startRange and endRange values
     * @param arrLength - length of array)
     * @param startRange - min range
     * @param endRange - max range
     * @return Array of Ints (with specified length and range)
     * @throws InvalidArraySpecException - if inputs have issues
     */
    public static int[] generateRandomArray(int arrLength, int startRange, int endRange) {

        if (arrLength <= 0)
            throw new InvalidArraySpecException(" Input Array Length Invalid ");
        else if (endRange <= 0)
            throw new InvalidArraySpecException(" Input Max Range Invalid ");
        else if (startRange < 0)
            throw new InvalidArraySpecException(" Input Min Range Invalid ");
        else if (startRange > endRange)
            throw new InvalidArraySpecException(" Input Min Range is greater than Max Range ");


        int[] arr = new int[arrLength];

        for (int i = 0; i < arrLength; i++) {
            arr[i] = new Random().nextInt(startRange, endRange);
        }

        return arr;
    }

}
