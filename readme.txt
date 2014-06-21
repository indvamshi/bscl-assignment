1. MessageQueueService keeps track of messages and puts them in a priorityblockingqueue which is global.
2. Do mvn install do execute the test cases.

Test cases are written for following scenarios,

● Prioritises InstructionMessages according to the table below
● Has a method that returns the number of InstructionMessages on it
● Has a method for placing InstructionMessages onto the queue
● Has a method for removing InstructionMessages from the queue
● Has a method for retrieving the InstructionMessage at the front of the queue
● Has a method for determining if the queue is empty
● Throws an InvalidMessageException if an invalid InstructionMessage is placed on it