//Creating a Cricket Scoreboard for t20 format.


import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Hashtable;

public class Main {

	public static void main(String[] args) {
		
		Scanner inp = new Scanner(System.in);		
		System.out.println("** Hello and Welcome to the Scoreboard for a T20 **");
		try {
		    TimeUnit.SECONDS.sleep(2);  // Wait 2 seconds    
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		System.out.println("Please enter name of a Batsman 1: ");
		String batsman1 = inp.nextLine();
		Boolean onStrike = true; // true if batsman1 on strike or else batsman2 on strike. 
		
		System.out.println("Please enter name of a Batsman 2: ");		
		String batsman2 = inp.nextLine();
		
		System.out.println("Perfect...! All set to start the match.");
		
		Hashtable<Integer, String> catalog = new Hashtable<>();
		catalog.put(0, "Wide");
		catalog.put(1, "1 run");
		catalog.put(2, "2 run");
		catalog.put(3, "3 run");
		catalog.put(4, "Boundary");
		catalog.put(5, "5 run");
		catalog.put(6, "Six");
		catalog.put(7, "No Ball");
		catalog.put(8, "Wicket");
		
		int[] balls = new int[120];	
		Hashtable<String, Integer> batsman = new Hashtable<>();
		int currentBall=0, ballsPlayed = 120, extras=0, wides=0, noBall=0, legBy=0;	
		int totalRuns = 0, runs1=0, runs2=0;
		
		System.out.println("Enter one of the following");
		
		while(currentBall<=ballsPlayed) {
			for(int k=0; k<=7; k++)
				System.out.print(k+": "+catalog.get(k)+", ");
			
			
			/*System.out.println("ScoreCard looks like this...");
			System.out.println("Total: "+totalRuns+" BallsPlayed: "+currentBall);
			System.out.println(batsman1+": "+runs1+" runs"+", "+batsman2+": "+runs2+" runs");
			*/
			System.out.println();
			int temp = inp.nextInt();
			switch(temp) {
			case 0: totalRuns += 1;
			        extras += 1;
			        wides += 1;
			        break;
			case 1: totalRuns += 1;
					balls[currentBall] = 1;
	        		currentBall += 1;
	        		if(onStrike==true) {
	        			runs1 += 1;
	        			onStrike = false;
	        		}
	        		else {
	        			runs2 += 1;
	        			onStrike = true;
	        		}
	        		break;
			case 2: totalRuns += 2;
					balls[currentBall] = 2;
    				currentBall += 1;
    				if(onStrike==true) {
	        			runs1 += 2;
	        		}
	        		else {
	        			runs2 += 2;
	        		}
    				break;
			case 3: totalRuns += 3;
					balls[currentBall] = 3;
    				currentBall += 1;
    				if(onStrike==true) {
    					runs1 += 3;
    					onStrike = false;
	        		}
	        		else {
	        			runs2 += 3;
	        			onStrike = true;
	        		}
    				break;
			case 4: totalRuns += 4;
					balls[currentBall] = 4;
    				currentBall += 1;
    				if(onStrike==true) {
	        			runs1 += 4;
	        		}
	        		else {
	        			runs2 += 4;
	        		}
    				break;
			case 5: totalRuns += 5;
					balls[currentBall] = 5;
    				currentBall += 1;
    				if(onStrike==true) {
    					runs1 += 5;
    					onStrike = false;
	        		}
	        		else {
	        			runs2 += 5;
	        			onStrike = true;
	        		}
    				break;
			case 6: totalRuns += 6;
					balls[currentBall] = 1;
					currentBall += 1;
					if(onStrike==true) {
	        			runs1 += 6;
	        		}
	        		else {
	        			runs2 += 6;
	        		}
					break;
			case 7: totalRuns += 1;
					System.out.println("Free Hit...!");
					System.out.println("Enter how many runs next ball?");
					int temp1 = inp.nextInt();
					totalRuns += temp1;
					break;
			case 8: balls[currentBall] = -1;
					currentBall += 1;
					System.out.println("Who?? "+batsman1+" or "+batsman2);
					inp.nextLine();
					String wkt = inp.nextLine();
					System.out.println("Next Batsman: ");
					String newBatsman = inp.nextLine();
					if(wkt==batsman1) {
						batsman.put(batsman1, runs1);
						runs1 = 0;
						batsman1 = newBatsman;						
					}
					else {
						batsman.put(batsman2, runs2);
						runs2 = 0;
						batsman2 = newBatsman;
					}

					
			default: System.out.println("ScoreCard looks like this...");
			System.out.println("Total: "+totalRuns+" BallsPlayed: "+currentBall);
			System.out.print(batsman1+": "+runs1+" runs"+", "+batsman2+": "+runs2+" runs ");
			if(onStrike==true)
				System.out.println("Strike: "+batsman1);
			else
				System.out.println("Strike: "+batsman2);
			}			
		}	
	}

}
