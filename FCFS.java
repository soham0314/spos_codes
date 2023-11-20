//FCFS Scheduling Algorithm:
 import java.util.*;

public class Main {
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.println("Enter no of process: "); int n = sc.nextInt();
int pid[] = new int[n]; // process ids 
int ar[] = new int[n]; // arrival times
int bt[] = new int[n]; // burst or execution times 
int ct[] = new int[n]; // completion times
int ta[] = new int[n]; // turn around times 
int wt[] = new int[n]; // waiting times
int temp;
float avgwt=0,avgta=0;

for(int i = 0; i < n; i++)
{
System.out.println("Enter process " + (i+1) + " arrival time: "); 
ar[i] = sc.nextInt();
System.out.println("Enter process " + (i+1) + " burst time: "); 
bt[i] = sc.nextInt();
pid[i] = i+1;
}

//sorting according to arrival times 
for(int i = 0 ; i <n; i++)
{
for(int j=0; j < n-(i+1) ; j++)
{
 if( ar[j] > ar[j+1] )//if arrival time of current procees is greater than nxt process swap
 {
temp = ar[j]; ar[j] = ar[j+1]; ar[j+1] = temp; 
temp = bt[j]; bt[j] = bt[j+1]; bt[j+1] = temp; //swapping
temp = pid[j]; pid[j] = pid[j+1]; pid[j+1] = temp;
}
}
}
// finding completion times 
for(int i = 0 ; i < n; i++)
{
if( i == 0)//for first process calculating complition time
{
ct[i] = ar[i] + bt[i];
}
else     
{
if( ar[i] > ct[i-1])//if ar time of another process is greater than ct of prev process ,it means the current process arrives after the previous one finishes
{
ct[i] = ar[i] + bt[i];
}
else
ct[i] = ct[i-1] + bt[i];//else if current process arrives before complition of last process add ct of prev process and then bt of nxt process 
}

ta[i] = ct[i] - ar[i] ; // turnaround time= completion time- arrival time 
wt[i] = ta[i] - bt[i] ; // waiting time= turnaround time- burst time 
avgwt += wt[i] ; // total waiting time
avgta += ta[i] ; // total turnaround time
}
System.out.println("\n	------ FCFS ------	\n");

System.out.println("==========================================================================================");
System.out.println("\nProcess\t\tArrivalT\tBurstT\t\tCompleteT\tTurnT\t\tWaitingT"); 
System.out.println("==========================================================================================");
 
for(int i = 0 ; i< n; i++)
{
System.out.println(pid[i] + "\t\t" + ar[i] + "\t\t" + bt[i] + "\t\t" + ct[i] +"\t\t" + ta[i] + "\t\t" + wt[i] ) ;
}
sc.close();
System.out.println("\nAverage waiting time: "+ (avgwt/n)); // printing average waiting time. 
System.out.println("Average turnaround time:"+(avgta/n)); // printing average turnaround time.
}
}
