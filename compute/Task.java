/**
 * title: Task.java
 * description: A generic interface representing a computation task that can be executed.
 * date: July 8, 2025
 * author: Dylan Phillips
 * student id: 3753433
 * version: 1.0
 * Question 2
 * copyright: 2025 Dylan Phillips
 */

/**
 * I declare that this assignment is my own work and that all material previously written or published
 * in any source by any other person has been duly acknowledged in the assignment.
 * I have not submitted this work, or a significant part thereof, previously as part of any academic program.
 * In submitting this assignment I give permission to copy it for assessment purposes only.
 *
 * <H1>Task Interface</H1>
 *
 * <H3>Purpose and Description</H3>
 *
 * <P>
 * This interface represents a generic task that performs a computation when executed.
 * It defines a single method <code>execute()</code> that returns a result of type <code>T</code>.
 * Implementations of this interface encapsulate the logic of the computation to be performed.
 * </P>
 *
 * <P>
 * This interface is typically used in distributed computing environments, such as Java RMI,
 * where tasks can be sent to a remote server for execution, and the result returned to the client.
 * </P>
 *
 * <H3>Key Methods</H3>
 *
 * <UL>
 *   <LI><b>T execute()</b> - Performs the task's computation and returns the result.</LI>
 * </UL>
 * 
 ** <H3>Compiling and Running</H3>
 * IS LOCATED IN ComputePrime.java docs
 * 
 ** <H3>Test Plan</H3>
 * IS LOCATED IN ComputePrime.java docs
 *
 * <H3>Usage</H3>
 *
 * <P>
 * Clients or servers implement this interface to define specific tasks.
 * The <code>execute()</code> method encapsulates the computation logic.
 * Such task objects are then passed to a remote executor (such as a compute engine)
 * that calls <code>execute()</code> and returns the result.
 * </P>
 *
 */
package compute;

//  Executes the task and returns the result.
public interface Task<T> {
    T execute();
}
