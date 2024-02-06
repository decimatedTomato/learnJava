# Sorting Tasks

1. Take an array of ints, sort it in ascending order
1. Make an interface `SortingAlgorithm` that contains the method: `public void sort(int[])`
1. Add a second parameter that decides where the array should be sorted in ascending/descending order
1. Change the type of the array to a generic type T

    ```java
    public interface SortingAlgorithm<T> {
        public void sort(T[])
    }
    ```

    In order to sort the elements you need to be able to tell whether the elements are sortable, you need to add a restriction to the type parameter that allows you sort between two objects of type T
1. Add a second Sorting algorithm implementation and show that you can sort two different arrays using two different implementations of the SortingAlgorithm class.

    ```java
    Integer[] arr1 = {1, 5, 2, 7, 8, 2, 3, 4, 0};
    Integer[] arr2 = {8, 3, 3, 3, 4, 2, 2, 6, 6};
    SortingAlgorithm sorter1 = new [INSERT_SORTINGALGORITHM_IMPLEMENTATION_HERE];
    SortingAlgorithm sorter2 = new [INSERT_SORTINGALGORITHM_IMPLEMENTATION_HERE];
    sorter1.sort(arr1);
    sorter2.sort(arr2);
    System.out.println(arr1);
    System.out.println(arr2);
    ```
1. Add a timer before and after sorting, write a data generation function to make an array of any length, run the different sorts and time them

    ```java
    Integer[] arr1 = generateInts(10);
    Integer[] arr2 = generateInts(100);
    Integer[] arr3 = generateInts(1000);
    Integer[] arr4 = generateInts(10000);

    long start = System.nanoTime();
    arr1.sort();
    long end = System.nanoTime();
    System.out.println(end - start);
    ```

1. Write a script that will generate datasets of several orders of magnitudes, record the time taken by each sorting algorithm, repeat several times and report the average time taken per input size per algorithm in a table (printed nicely) like this:

    |alg|10|100|1000|10000|
    |-|-|-|-|-|
    |s1|0.2|0.31|0.9|2.3|
    |s2|0.1|0.3|1.2|5.1|

    (I made the numbers up)