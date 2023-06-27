package com.esource.assignment.svc.impl;

import com.esource.assignment.Utilities;
import com.esource.assignment.exception.NoPrimesFoundException;
import com.esource.assignment.svc.ifc.ArrayExtractSvc;

import java.util.*;

public class ArrayDataExtractSvcClassImpl implements ArrayExtractSvc {

    /**
     * Gets the largest prime from a list of Integers
     * @param lst
     * @return largest Prime Number present in list
     */
    @Override
    public int getLargestPrime(List<Integer> lst) {
        //Declarative
        Optional<Integer> optionalELem =
                lst.stream()
                        .filter(Utilities::isPrimeNumber)
                        //.sorted((a, b) -> Integer.compare(b, a))
                        .sorted(Collections.reverseOrder())
                        .findFirst();

        if (optionalELem.isPresent())
            return optionalELem.get();

        throw new NoPrimesFoundException(" No Primes Found in Input ");
    }

    /**
     * Implementation of operation to get elements not present as a list
     * @param minRange (min range of elements)
     * @param maxRange (max range of elements)
     * @param arr (list of integers)
     * @return List of elements not present
     */
    @Override
    public List<Integer> getElementsNotPresentInArrays(int minRange, int maxRange, int[]... arr) {

        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                lst.add(arr[i][j]);

        Map<Integer, Integer> map = Utilities.getMapWithCount(lst);

        return Utilities.getElementsNotPresentInArrays(map, maxRange, minRange);
    }

}
