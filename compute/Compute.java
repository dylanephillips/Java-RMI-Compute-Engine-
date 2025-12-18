/**
 * title: Compute.java
 * description: Remote interface defining a compute service for executing generic tasks via Java RMI.
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
 * <H1>Compute Remote Interface</H1>
 *
 * <H3>Purpose and Description</H3>
 *
 * <P>
 * This interface declares a remote service for executing generic tasks on a server.
 * It extends <code>java.rmi.Remote</code>, enabling clients to invoke the <code>executeTask</code> method remotely.
 * The method takes a <code>Task</code> object representing a unit of work and returns the computed result.
 * </P>
 *
 * <P>
 * This interface supports generic task execution allowing for flexibility in defining different computation jobs,
 * such as mathematical calculations or data processing, to be sent to and executed by the server.
 * </P>
 *
 * <H3>Key Methods</H3>
 *
 * <UL>
 *   <LI><b>&lt;T&gt; T executeTask(Task&lt;T&gt; t) throws RemoteException</b> - Executes the given task on the remote server and returns the result.</LI>
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
 * Clients lookup an implementation of this interface in the RMI registry and invoke <code>executeTask</code>
 * to submit a task for remote execution. The server executes the task’s <code>execute()</code> method and returns the result.
 * </P>
 *
 *
 */

package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

//Executes a given task on the server.
public interface Compute extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}

