import java.util.*;

public class CarWashUser
{
    public static void main (String[] args)
    {
        new CarWashUser().run();
    } // method main
    
    
    /**
     *  Reads in all of the arrival times, runs the simulation, and calculates the average 
     *  waiting time.
     *
     */ 
    public void run()
    {        
        final int SENTINEL = 999;

        final String INPUT_PROMPT = "\nPlease enter the next arrival time (or " + 
                     SENTINEL + " to quit): ";           

        final String OUT_OF_RANGE = "The input must consist of a non-" +
                                    "negative integer less than the sentinel.";
        int nextArrivalTime =0;
        int meanArrivalTime,mst = 0;
        int maxArrivalTime;
        int nextArrival=0;
        int waiting_time;

        
     
        Scanner sc = new Scanner (System.in);
          
       

        while (true)
        {
            System.out.print (INPUT_PROMPT);
            try
            {     
            	System.out.println("Please enter the mean arrival time");
            	meanArrivalTime = sc.nextInt();
            	if (meanArrivalTime < 0 || meanArrivalTime > SENTINEL)
                    throw new NumberFormatException (OUT_OF_RANGE);
            	System.out.println("Enter the mean servive time");
            	mst =sc.nextInt();
            	if (mst < 0 || mst > SENTINEL)
                    throw new NumberFormatException (OUT_OF_RANGE);
            	System.out.println("Enter the maximum arrival time");
            	maxArrivalTime = sc.nextInt();
            	if (maxArrivalTime < 0 || maxArrivalTime > SENTINEL)
                    throw new NumberFormatException (OUT_OF_RANGE);
            	//waiting_time = getTime(meanArrivalTime);
            	CarWash carWash = new CarWash(mst);
    			//nextArrivalTime += waiting_time;
    			if (nextArrivalTime > maxArrivalTime)
    				break;
    			carWash.process(nextArrivalTime);
            	
                /*nextArrivalTime = sc.nextInt();
                if (nextArrivalTime == SENTINEL)
                    break;
                if (nextArrivalTime < 0 || nextArrivalTime > SENTINEL)
                    throw new NumberFormatException (OUT_OF_RANGE);*/
                carWash.process (nextArrivalTime);
            } // try
            catch (Exception e)
            {
                System.out.println(e);
                //sc.nextLine();
            } // catch                               
        } // while
        CarWash carWash = new CarWash(mst);
        
        //carWash.finishUp();
		//printResults(carWash);
    } // method run
    Random random;
    /*public int getTime (int meanTime){
        double randomDouble = random.nextDouble();
        return (int)Math.round ((-meanTime*Math.log (1 - randomDouble)));
    }
*/
    /**
     *  Prints the results of the simulation.
     *
     */
    public void printResults (CarWash carWash)
    {
        final String RESULTS_HEADING =
            "\nHere are the results of the simulation:\n";

        LinkedList<String> results = carWash.getResults();
        System.out.println (RESULTS_HEADING);
        for (String s : results)
            System.out.print (s);
        System.out.println();
    } // method printResults

} // class CarWashUser
