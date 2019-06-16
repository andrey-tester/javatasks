import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;

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
		System.out.println("All tools sorted by power usage");
		for (Tools too : theTools){
			System.out.println(too.powerUsage + "  " +(too.getClass().toString()).substring(6));
		}
		System.out.println("");

		myTVset.turnOn();
		turnOnSomeTools(theTools);
		checkRange(theTools);

		try {
			totalPower(theTools);
		} catch (PowerException pe) {
			System.out.println("Exception: Recommended power usage (600) exceeded!");
		}

		try {
			myWashingMachine.wash();
		} catch (WashingException we) {
			System.out.println("Exception: Washing Machine is not turned on!");
		}		

		try {
			myVacuum.changeBag();
		} catch (VacuumException ve) {
			System.out.println("Exception: You can't change your vacuum cleaner bag when it's turned on!");
		}
		try {
		myToaster.toast();
		} catch (NumberFormatException nfe) {
			System.out.println(nfe);
		}

		try {
			File myFile = new File("range.txt");
			FileReader fileReader = new FileReader(myFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String range = null;
			while ((range = reader.readLine()) != null ) {
				String[] limits = range.split(";");
				int range1 = Integer.parseInt(limits[0]);
				int range2 = Integer.parseInt(limits[1]);
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			borrow();
		} catch (Exception exe) {
			exe.printStackTrace();
		}		
	}

	static void turnOnSomeTools(ArrayList<Tools> tooo) {
		System.out.println("You have turned on:");
		for (Tools too : tooo){
			Random rnd = new Random();
			boolean rand = rnd.nextBoolean();
			if (rand == true) {
				too.turnOn();
				System.out.println(" - " +(too.getClass().toString()).substring(6));
			}
		}
		System.out.println("");
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

	static void	checkRange(ArrayList<Tools> tools){
		int range1 = 0;
		int range2 = 0;
		try {
			File myFile = new File("range.txt");
			FileReader fileReader = new FileReader(myFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String range = null;
			while ((range = reader.readLine()) != null ) {
				String[] limits = range.split(";");
				range1 = Integer.parseInt(limits[0]);
				range2 = Integer.parseInt(limits[1]);
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			File myFile2 = new File("rangeCheck.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(myFile2));
			writer.write("The following tools use more than " + range1 + " and less than " + range2 + " power:");
			for (Tools too : tools){
				if (too.powerUsage > range1 && too.powerUsage < range2) {
					writer.newLine();
					writer.write(" - " +(too.getClass().toString()).substring(6) + " (" + too.powerUsage + ")" );
				}
			}
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Power usage range check results saved in rangeCheck.txt");
		System.out.println("");
	}

	@SuppressWarnings("unchecked")
	static void borrow() throws Exception {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("borrow.json");
		Object obj = jsonParser.parse(reader);
		JSONArray borrowList = (JSONArray) obj;	
		System.out.println("Your friend wants to borrow:");
		borrowList.forEach( borr -> parseBorrowObject( (JSONObject) borr ) );
		System.out.println("");
	}

	private static void parseBorrowObject(JSONObject borrow) {
		JSONObject borrowObject = (JSONObject) borrow.get("tool");
		String toolName = (String) borrowObject.get("toolName");
		String borrowLength = (String) borrowObject.get("length");
		System.out.println(toolName + " for " + borrowLength);
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
		System.out.println("");
		System.out.println("Let's toast. One or two slices of bread?");
		Scanner in = new Scanner(System.in);
		int bread = Integer.parseInt(in.nextLine());
		System.out.println("Toasting " + bread + " slice(s) of bread will only take a few minutes!");
		System.out.println("");
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