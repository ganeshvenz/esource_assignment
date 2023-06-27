package com.esource.assignment.svc.ifc;

import java.util.List;

/**
 * ArrayDataExtractSvc - Interface containing operations for the assignment
 * where the operations maps one to one to each of the stories (mentioned in the doc)
 *
 * Operation 1: getElementsNotPresentInArrays(int maxRange, Series of integer arrays)
 * @return List of numbers not present in any of the arrays
 *
 * Operation 2: getLargestPrime(List)
 * @return The largest prime given a list of integer elements
 *
 */
public interface ArrayExtractSvc {
    List<Integer> getElementsNotPresentInArrays(int minRange, int maxRange, int[]... arr);
    int getLargestPrime(List<Integer> lst);
}
