/**
 * title: Prime.java
 * description: A serializable task class implementing a prime number search within a specified range.
 *              This task is designed to be executed remotely via Java RMI to find the largest prime
 *              number within a user-defined range.
 * date: July 8, 2025
 * author: Dylan Phillips
 * copyright: 2025 Dylan Phillips
 */

/**
 * I declare that this assignment is my own work and that all material previously written or published
 * in any source by any other person has been duly acknowledged in the assignment.
 * I have not submitted this work, or a significant part thereof, previously as part of any academic program.
 * In submitting this assignment I give permission to copy it for assessment purposes only.
 *
 * <H1>Prime Task</H1>
 *
 * <H3>Purpose and Description</H3>
 *
 * <P>
 * This class implements the <code>Task</code> interface and defines a computation task that searches
 * for the largest prime number within a given integer range.
 * It is serializable so that it can be sent as a task to a remote Java RMI server,
 * which will execute the <code>execute()</code> method and return the result.
 * </P>
 *
 * <P>
 * The prime search is performed by iterating backward from the upper bound to the lower bound,
 * checking each number for primality using an optimized primality test.
 * If no prime number is found within the range, the task returns -1.
 * </P>
 *
 * <H3>Classes and Interfaces</H3>
 *
 * <UL>
 *   <LI><b>Prime</b>: The task class containing the range bounds and the logic to find the largest prime number.</LI>
 *   <LI><b>Task&lt;Integer&gt;</b>: The generic task interface implemented for RMI execution.</LI>
 * </UL>
 *
 * <H3>Key Methods</H3>
 *
 * <UL>
 *   <LI><b>public Integer execute()</b> - The method executed remotely by the server; finds and returns the largest prime number in the specified range.</LI>
 *   <LI><b>private int findLargestPrime(int low, int high)</b> - Helper method that iterates from high to low to find the largest prime.</LI>
 *   <LI><b>private boolean isPrime(int n)</b> - Efficient primality test used by <code>findLargestPrime</code>.</LI>
 * </UL>
 * 
 ** <H3>Compiling and Running</H3>
 * IS LOCATED IN ComputePrime.java docs
 * 
 ** <H3>Test Plan</H3>
 * IS LOCATED IN ComputePrime.java docs
 * 
 * 
 * <H3>Usage</H3>
 *
 * <P>
 * An instance of this class is created by passing the lower and upper bounds of the search range.
 * The instance is then sent to a remote Compute server via RMI, which executes the task and returns the result.
 * </P>
 *
 */

package client;

import compute.Task;
import java.io.Serializable;

public class Prime implements Task<Integer>, Serializable {

    private static final long serialVersionUID = 227L;

     // Range limits
    private final int lowerBound;
    private final int upperBound;

     // Constructor: saves the bounds for the prime search
    public Prime(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    // Runs the task when called by the server
    @Override
    public Integer execute() {
        return findLargestPrime(lowerBound, upperBound);
    }

    // Searches for the largest prime number in the range
    private int findLargestPrime(int low, int high) {
        for (int i = high; i >= low; i--) {
            if (isPrime(i)) {
                return i; // found a prime, return it
            }
        }
        return -1; // no prime found
    }

    // Checks if a given number is prime
    private boolean isPrime(int n) {
        if (n <= 1) return false; // 0 and 1 are not prime
        if (n <= 3) return true; // 2 and 3 are prime
        if (n % 2 == 0 || n % 3 == 0) return false; // multiples of 2 or 3 are not prime

        // Check possible factors up to sqrt(n)
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        // no factors found, so it's prime
        return true;
    }
}


