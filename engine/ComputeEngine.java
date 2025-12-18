/**
 * title: ComputeEngine.java
 * description: Implementation of the Compute remote interface that executes generic tasks via Java RMI.
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
 * <H1>ComputeEngine Class</H1>
 *
 * <H3>Purpose and Description</H3>
 *
 * <P>
 * This class implements the <code>Compute</code> remote interface,
 * providing a server-side engine that can execute generic computation tasks submitted by clients.
 * Each task implements the <code>Task</code> interface and encapsulates its own computation logic.
 * </P>
 *
 * <P>
 * The engine exports itself as a remote object and binds to the local RMI registry under the name "Compute",
 * allowing clients to lookup the service and submit tasks for execution.
 * </P>
 *
 * <H3>Classes</H3>
 * 
 * <UL>
 *   <LI><b>ComputeEngine</b>: Main server class implementing <code>Compute</code> to execute tasks remotely.</LI>
 * </UL>
 *
 * <H3>Key Methods</H3>
 *
 * <UL>
 *   <LI><b>&lt;T&gt; T executeTask(Task&lt;T&gt; t)</b> - Executes the given task by invoking its <code>execute()</code> method and returns the result.</LI>
 *   <LI><b>public static void main(String[] args)</b> - Starts the RMI server, exports the ComputeEngine instance, and binds it in the RMI registry.</LI>
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
 * Run this class to start the RMI server. It registers an instance of ComputeEngine with the RMI registry,
 * allowing clients to remotely execute arbitrary tasks that implement the Task interface.
 * Clients obtain a stub from the registry under the name "Compute" and invoke <code>executeTask()</code>.
 * </P>
 *
 */

package engine;

import compute.Compute;
import compute.Task;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ComputeEngine implements Compute {

     // Constructor
    public ComputeEngine() {
        super();
    }

    // Executes the given task by calling its execute method.
    public <T> T executeTask(Task<T> t) {
        return t.execute();
    }

    // Main method to start the RMI server, bind the ComputeEngine
    // instance to the RMI registry under the name "Compute".
    public static void main(String[] args) {
        try {
            String name = "Compute";
            Compute engine = new ComputeEngine();

            // Export the remote object to receive calls
            Compute stub =
                (Compute) UnicastRemoteObject.exportObject(engine, 0);

            // Get the RMI registry running on localhost
            Registry registry = LocateRegistry.getRegistry();

            // Bind the stub with the registry so clients can look it up
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}

