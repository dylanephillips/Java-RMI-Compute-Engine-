/**
 * title: ComputePrime.java
 * description: A Java RMI client program that connects to a remote Compute server to find
 *              the largest prime number within a user-specified range.
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
 * <H1>ComputePrime Client</H1>
 *
 * <H3>Purpose and Description</H3>
 *
 * <P>
 * This program acts as a client in a Java RMI system. It connects to a remote Compute server,
 * sends a task to find the largest prime number in a given integer range,
 * and receives and displays the result.
 * </P>
 *
 * <P>
 * The client takes three command-line arguments: the server address, the lower bound,
 * and the upper bound of the range to search for the largest prime number.
 * </P>
 *
 * <H3>Classes</H3>
 *
 * <UL>
 *   <LI><b>ComputePrime</b>: The client class that looks up the remote Compute object,
 *   creates a Prime task with the specified range, sends the task, and prints the result.</LI>
 * </UL>
 *
 * <H3>Key Methods</H3>
 *
 * <UL>
 *   <LI><b>public static void main(String[] args)</b> - Parses input arguments,
 *       connects to the server, sends the prime-finding task, and displays the response.</LI>
 * </UL>
 *
 * <H3>Compiling and Running</H3>
 *
 * <DL>
 *   <DT>Step 1: Compile Compute interfaces</DT>
 *   <DD><code>javac compute/Compute.java compute/Task.java</code></DD>
 *
 *   <DT>Step 2: Create compute.jar for shared interfaces</DT>
 *   <DD><code>jar cvf compute.jar compute/*.class</code></DD>
 *
 *   <DT>Step 3: Compile the server code</DT>
 *   <DD><code>javac -cp compute.jar engine/ComputeEngine.java</code></DD>
 *
 *   <DT>Step 4: Compile the client code</DT>
 *   <DD><code>javac -cp compute.jar client/ComputePrime.java client/Prime.java</code></DD>
 *
 *   <DT>Step 5: Start the RMI registry</DT>
 *   <DD>
 *     Open a new terminal and run:<br/>
 *     <code>rmiregistry</code><br/>
 *     <em>Keep this terminal open while the server and client run.</em>
 *   </DD>
 *
 *   <DT>Step 6: Run the server</DT>
 *   <DD><code>java -cp .:compute.jar engine.ComputeEngine</code></DD>
 *
 *   <DT>Step 7: Run the client</DT>
 *   <DD><code>java -cp .:compute.jar client.ComputePrime &lt;server&gt; &lt;lowerBound&gt; &lt;upperBound&gt;</code><br/>
 *       Example:<br/>
 *       <code>java -cp .:compute.jar client.ComputePrime localhost 10 100</code>
 *   </DD>
 * </DL>
 *
 * <H3>Test Plan</H3>
 *
 * <P>
 * 1. Start the ComputeEngine server.<br/>
 * 2. Run the client with a valid server address and number range, e.g.:<br/>
 *    <code>java -cp .:compute.jar client.ComputePrime localhost 10 100</code><br/>
 *    EXPECTED: The client prints the largest prime number in the range 10 to 100.<br/>
 *
 * 3. Run the client with a range that contains no primes, e.g.:<br/>
 *    <code>java -cp .:compute.jar client.ComputePrime localhost 90 92</code><br/>
 *    EXPECTED: The client prints "No prime found in the given range."<br/>
 *
 * 4. Run the client with invalid or missing arguments.<br/>
 *    EXPECTED: The client prints usage instructions.<br/>
 *
 * 5. Run multiple clients simultaneously connecting to the server.<br/>
 *    EXPECTED: Each client receives correct results independently.
 * </P>
 */

package client;

import compute.Compute;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ComputePrime {
    public static void main(String args[]) {
        // Make sure the user provided server address and range bounds
        if (args.length < 3) {
            System.out.println("Usage: java client.ComputePrime <server> <lowerBound> <upperBound>");
            return;
        }
        try {
            // Name of the remote object to look up
            String name = "Compute";
            
            // Get the RMI registry on the specified server (args[0])
            Registry registry = LocateRegistry.getRegistry(args[0]);
            
            // Look up the remote Compute object
            Compute comp = (Compute) registry.lookup(name);
            
            // Parse lower and upper bounds for the prime search
            int lower = Integer.parseInt(args[1]);
            int upper = Integer.parseInt(args[2]);

            // Create a Prime task with the given bounds
            Prime task = new Prime(lower, upper);

            // Execute the task on the server
            Integer largestPrime = comp.executeTask(task);

             // Display the result
            if (largestPrime == -1) {
                System.out.println("No prime found in the given range.");
            } else {
                System.out.println("Largest prime in range: " + largestPrime);
            }
        } catch (Exception e) {

            // Print any errors if something goes wrong
            System.err.println("ComputePrime exception:");
            e.printStackTrace();
        }
    }
}


