# Java RMI Compute Engine

A distributed computing system built with Java RMI that allows clients to submit executable tasks to a remote server. Tasks encapsulate their own logic and are executed on the server, with results returned to the client.

## Project Structure
engine/
ComputeEngine.java
client/
ComputePrime.java
Prime.java
compute/
Compute.java
Task.java

markdown
Copy code

## Features
- Java RMI-based client/server architecture
- Generic task execution using interfaces and generics
- Serializable tasks executed remotely
- Example implementation for computing the largest prime in a range

## Requirements
- Java JDK 8 or higher
- RMI registry running (default port 1099)

## Compiling
From the project root:
```bash
javac compute/*.java engine/*.java client/*.java
Running the RMI Server
Start the RMI registry:

bash
Copy code
rmiregistry
Then run the server:

bash
Copy code
java engine.ComputeEngine
Running the Client
bash
Copy code
java client.ComputePrime localhost 1 100000
How It Works
The server starts and registers ComputeEngine with the RMI registry.

The client looks up the remote Compute service.

The client sends a serialized task object.

The server executes the task and returns the result.

The client displays the output.

Example Output
go
Copy code
Largest prime in range: 99991
Author
Dylan Phillips
