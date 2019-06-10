import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.io.*;

class MyTools {
		public static void main(String[] args) {
			Toaster myToaster = new Toaster();
			myToaster.powerUsage = 11;
			Microwave myMicrowave = new Microwave();
			myMicrowave.powerUsage = 111;
			Stove myStove = new Stove();
			myStove.powerUsage = 22;
			Refregirator myRefregirator = new Refregirator();
			myRefregirator.powerUsage = 222;
			Vacuum myVacuum = new Vacuum();
			myVacuum.powerUsage = 100;
			ExhaustHood myExhaustHood = new ExhaustHood();
			myExhaustHood.powerUsage = 101;
			Humidifier myHumidifier = new Humidifier();
			myHumidifier.powerUsage = 67;
			WashingMachine myWashingMachine = new WashingMachine();
			myWashingMachine.powerUsage = 211;
			TVset myTVset = new TVset();
			myTVset.powerUsage = 400;
			Laptop myLaptop = new Laptop();
			myLaptop.powerUsage = 81;

			ArrayList<Tools> theTools = new ArrayList<Tools>();
			theTools.add(myToaster);
			theTools.add(myMicrowave);
			theTools.add(myStove);
			theTools.add(myRefregirator);
			theTools.add(myVacuum);
			theTools.add(myExhaustHood);
			theTools.add(myHumidifier);
			theTools.add(myWashingMachine);
			theTools.add(myTVset);
			theTools.add(myLaptop);
			
			Collections.sort(theTools); 
			System.out.println("All tools sorted by power usage"); //here
			for (Tools too : theTools){
				System.out.println(too.powerUsage + "  " +(too.getClass().toString()).substring(6));					
			}			

			myTVset.turnOn();
			turnOnSomeTools(theTools);
			try {
				totalPower(theTools);
			} catch (PowerException pe) {
				System.out.println("Exception: Recommended power usage exceeded!");
			}

			try {
				myWashingMachine.wash();
			} catch (WashingException we) {
				System.out.println("Exception: Washing Machine is not turned on!");
			}		

			try {
				myVacuum.changeBag();
			} catch (VacuumException ve) {
				System.out.println("Exception: You can't change you vacuum cleaner bug when it's turned on!");
			}
			try {
			myToaster.toast();
			} catch (NumberFormatException nfe) {
				System.out.println(nfe);
			}

			try {
				File myFile = new File("ololo.txt");
				FileReader fileReader = new FileReader(myFile);
				BufferedReader reader = new BufferedReader(fileReader);
				String line = null;
				while ((line = reader.readLine()) != null ) {
					System.out.println(line);
				}
				reader.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			try {
				String asasa = "asasa";
				File myFile2 = new File("saveme.txt");
				BufferedWriter writer = new BufferedWriter(new FileWriter(myFile2));
				writer.write("kokoko");
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		static void turnOnSomeTools(ArrayList<Tools> tooo) {
			System.out.println("You have turned on:");
			for (Tools too : tooo){
				Random rnd = new Random();
				boolean rand = rnd.nextBoolean();
				//System.out.println(too.powerUsage);
				if (rand == true) {
					too.turnOn();
					System.out.println(" - " +(too.getClass().toString()).substring(6));					
				}

			}
		}

		static void totalPower(ArrayList<Tools> tooo) throws PowerException {
			int totPow = 1;
			for (Tools too : tooo){
				
				if (too.isOn == true) {
					totPow = totPow + too.powerUsage;					
				}
			}	
			System.out.println("Total power used: " + totPow );	
			if (totPow > 600)	{
				throw new PowerException();
			}
		}


}


abstract public class Tools implements Comparable<Tools>{
	boolean isOn = false;
	int powerUsage;
	void turnOn(){
		isOn = true;
	}
	void turnOff(){
		isOn = false;
	}
	@Override
    public int compareTo(Tools otherTool) {
        return (this.powerUsage - otherTool.powerUsage);
    }
} 


abstract class CookingMachine extends Tools {
	int temp = 0;
	void setTemp(int tempo){
		temp = tempo;
	}
	void cook(){
		System.out.println("What are we cooking today?");
		Scanner in = new Scanner(System.in);
		String meal = in.nextLine();
		System.out.println("Cooking " + meal + " will take only a few minutes!");
	}
}

abstract class MultiMedia extends Tools implements Wifi {
	int volumeLevel = 0;
	void setVolume(int vol){
		volumeLevel = vol;
	}
	void showMovie(){
		System.out.println("What are we watching today?");
		Scanner in = new Scanner(System.in);
		String movie = in.nextLine();
		System.out.println(movie + " is a strange choice, but OK.");
	}

}

class Toaster extends CookingMachine {
	
	void toast(){

		System.out.println("One or two slices of bread?");
		Scanner in = new Scanner(System.in);
		int bread = Integer.parseInt(in.nextLine());
		System.out.println("Toasting " + bread + " slice(s) of bread will only take a few minutes!");
	}
}

class Microwave extends CookingMachine implements Wifi {
	void reheat(){
		System.out.println("For how long do you wnat to reheat? (minutes)");
		Scanner in = new Scanner(System.in);
		int period = Integer.parseInt(in.nextLine());
		System.out.println("Reheating for  " + period + " minutes has started.");
	}
	public void useWifi(){
		//something something with Wifi
	}	
}

class Stove extends CookingMachine {
	void cook(){
		System.out.println("What are we cooking today?");
		Scanner in = new Scanner(System.in);
		String meal = in.nextLine();
		System.out.println("How many hotplates to use?");
		Scanner in1 = new Scanner(System.in);
		String hotplates = in1.nextLine();		
		System.out.println("Ok, we'll be cooking " + meal + " on " + hotplates + " hotplates.");
	}
}

class Refregirator extends Tools {
	int temp;
	void addToFreezer(){
		System.out.println("What do you want to put in a freezer?");
		Scanner in = new Scanner(System.in);
		String freeze = in.nextLine();	
		System.out.println(freeze + " is added to freezer");		
	}
	void setTemperature(int tempo){
		temp = tempo;
	}
}

class Vacuum extends Tools {
	void changeBag() throws VacuumException {
		if (this.isOn == true) {
			throw new VacuumException();
		} else {
			System.out.println("Vacum cleaner bag was replaced. Enjoy your cleaning!");	
		}
	
	}
}

class ExhaustHood extends Tools {
	void turnLightOn(){
		System.out.println("The light is on.");
	}
}

class Humidifier extends Tools implements Wifi {
	void addAroma(){
		System.out.println("What do you want to put in a freezer?");
		Scanner in = new Scanner(System.in);
		String freeze = in.nextLine();	
		System.out.println(freeze + " is added to freezer");
	}
		public void useWifi(){
		
	}
}

class WashingMachine extends Tools {
	void wash() throws WashingException {
		
		if (this.isOn == false){
			throw new WashingException();
		} else {
			System.out.println("Washing has started");
		}
	}
	void dry(){
		System.out.println("Drying has started");
	}	
}

class TVset extends MultiMedia {
	void playNews(){

	}
	public void useWifi(){
		
	}	
}

class Laptop extends MultiMedia {
	void downloadMoviw(){
		
	}
	void browseWeb(){
		
	}
	void playVideoGame(){
		
	}
	public void useWifi(){
		
	}		
}

class PowerException extends Exception {
}

class WashingException extends Exception {
}

class VacuumException extends Exception {
}

