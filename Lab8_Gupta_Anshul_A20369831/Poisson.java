import java.util.Random;

/**
 * Poisson process.  Generates times for an arrival process given a mean.
 * Note that in your laboratory problem, the service time is also being 
 * drawn from the same RNG as the arrival time; this will skew the 
 * distribution such that the sequence shown in the book occurs.  Here, all
 * numbers drawn are for arrival, so the numbers shown by this program will
 * not match all the arrival times shown in your laboratory assignment.
 * However, once you do your laboratory successfully, the numbers drawn
 * in it using the code below will match. */

public class Poisson  {

   protected Random random;

   public static void main(String args[])  {
      new Poisson().run();
   }

   public void run()  {
      int time_till_next_arrival, current_time = 0;

      random = new Random(100);

      while(true)  {
         time_till_next_arrival = getTime(3);

         System.out.print("Time to next arrival is " + time_till_next_arrival +
                          ". ");
         current_time += time_till_next_arrival;
         System.out.print("Next arrival will occur at " + current_time + " ");

         if (current_time >= 26)  {
             System.out.println("(Out of bounds)");
             break;
         }
         else
            System.out.print("\n");
      }
   }

   protected int getTime (int meanTime) 
   {  
      double randomDouble = random.nextDouble();
      return (int)Math.round (-meanTime*Math.log(1 - randomDouble)); 
   } // getTime
}
