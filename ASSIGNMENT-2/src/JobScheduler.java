// Java program for implementation of FCFS  
// scheduling with different arrival time
import java.util.Scanner;
public class JobScheduler {

	private static Scanner sc;
	// main method to receive the processes arrival and burst time
public static void main(String args[]) {  
sc = new Scanner(System.in);
System.out.println("Enter number of processes");
int noOfProcess = sc.nextInt();
int jobs[][] = new int[noOfProcess][2] ;
System.out.println("Enter arrival time and burst time Of Processes \n"+"Arrival Time"+"         "+"Burst Time");
for(int i=0 ; i<noOfProcess ; i++)
{
		jobs[i][0]=sc.nextInt();
		jobs[i][1]=sc.nextInt();
}
//Menu to select an operation to be performed on Processes
System.out.println("Select an option to perform following tasks:");
int choice;
do {

	System.out.println("1.Calculate completion time for each process.");
System.out.println("2.Calculate waiting time for each process.");
System.out.println("3.Calculate turn around time for each process.");
System.out.println("4.Average waiting time of processes.");
System.out.println("5.Maximum waiting time period for a process in queue.");

sc = new Scanner(System.in);
choice = sc.nextInt();
switch(choice) {
case 1:
	int[] completionList=findCompletionTime(jobs,noOfProcess);
	System.out.println("Processes " + " Completion Time");
    for(int i=0;i<noOfProcess;i++){
     System.out.println("   "+(i+1)+"             "+completionList[i]);
	}
	break;
case 2:
	findWaitingTime(jobs,noOfProcess);
	break;
case 3:
	findTurnAroundTime(jobs,noOfProcess);
	break;
case 4:
	findAvgWaitingTime(jobs,noOfProcess);
	break;
case 5:
	findMaxWaitingTime(jobs,noOfProcess);
	break;
case 6:
	System.exit(0);
	break;
default:
	System.out.println("Invalid Number");
	}

}while(choice!=7);
}  

//Function to find Maximum waiting time of a process from a queue
private static void findMaxWaitingTime(int[][] jobs,int noOfProcess) {
	int waitingTime[]=findWaitingTime(jobs, noOfProcess); 
	double maxWaitingTime=waitingTime[0];
	for(int i=0;i<noOfProcess;i++){
		if(waitingTime[i]>maxWaitingTime)
			maxWaitingTime=waitingTime[i];

	}
	System.out.println("Maximum waiting time is = "+maxWaitingTime);

}

// Function to find the waiting time for all processes 
public static int[] findWaitingTime(int jobs[][],int noOfProcess)  
{  
	int[] waitingTime=new int[noOfProcess];
	int serviceTime[] = new int[noOfProcess];  
	serviceTime[0] = 0; 
	// calculating waiting time 
for (int i = 1; i < noOfProcess ; i++)  
{  
	// Add burst time of previous processes  
serviceTime[i] = serviceTime[i-1] + jobs[i-1][1];
// Find waiting time for current process =  sum - arrival time of the process  
	waitingTime[i] = serviceTime[i] - jobs[i][0];  
	if (waitingTime[i] < 0)  
		waitingTime[i] = 0;  
}
System.out.println("Processes " + " Waiting Time ");
for (int i = 0; i < noOfProcess ; i++) 
	System.out.println("   "+(i+1)+"             "+waitingTime[i]);
	return waitingTime;
}  


// Function to calculate turn around time 
public static int[] findTurnAroundTime(int jobs[][], int noOfProcess)  
{  
	int turnAroundTime[]=new int[noOfProcess];
	int waitingTime[]=findWaitingTime(jobs, noOfProcess);
	// Calculating turn Around time by adding burst time and waiting time 
for (int i = 0; i < noOfProcess ; i++)  
	turnAroundTime[i] = jobs[i][1] + waitingTime[i];  
System.out.println("Process" + "   " + "TurnAround Time");
for (int i = 0; i < noOfProcess ; i++)
	System.out.println("    "+ (i+1) + "          " +turnAroundTime[i]);
	return turnAroundTime;

}  
//Function to calculate Completion time for each process
public static int[] findCompletionTime(int jobs[][],int noOfProcess){
	int[] completionTime=new int[noOfProcess];
	completionTime[0]=jobs[0][1]-jobs[0][0];

	for (int i = 1 ; i < noOfProcess ; i++) // Display process along with completion time   
	{  
		if(jobs[i-1][1]>jobs[i][0])
			completionTime[i]=jobs[i-1][1]+jobs[i][1];
		else
			completionTime[i]=jobs[i][0]+jobs[i][1];
	}
	return completionTime;
}

//Function to calculate average waiting 4
public static void findAvgWaitingTime(int jobs[][], int noOfProcess)  
{  
//get the waiting time for each process
int waitingTime[]=findWaitingTime(jobs, noOfProcess);
double totalWaitingTime = 0;
for (int i = 0 ; i < noOfProcess ; i++)  
{  
	totalWaitingTime = totalWaitingTime + waitingTime[i];
}  	  
System.out.print("Average waiting time = "+ (double)totalWaitingTime / (double)noOfProcess);  
	}
}


