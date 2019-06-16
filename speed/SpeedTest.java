import java.util.*;

class SpeedTest {
		public static void main(String[] args) {

			ArrayList<Integer> myArrayList = new ArrayList<Integer>();
			LinkedList<Integer> myLinkedList = new LinkedList<Integer>();

			HashSet<Integer> myHashSet = new HashSet<Integer>();
			TreeSet<Integer> myTreeSet = new TreeSet<Integer>();

			HashMap<Integer, Integer> myHashMap = new HashMap<Integer, Integer>();
			TreeMap<Integer, Integer> myTreeMap = new TreeMap<Integer, Integer>();


			for (int i = 0; i < 200000; i++) {
				int x = (int)(Math.random()*100000000);
				myArrayList.add(x);
				myLinkedList.add(x);
				myHashSet.add(x);
				myTreeSet.add(x);
				myHashMap.put(i, x);
				myTreeMap.put(i, x);
			}


			//System.out.println(myArrayList);
			//System.out.println(myLinkedList);
			//System.out.println(myHashSet);
			//System.out.println(myTreeSet);
			//System.out.println(myHashMap);
			//System.out.println(myTreeMap);
			long startTime = 0;
			long endTime = 0;
			double duration = 0;

			// adding an item
			startTime = System.nanoTime();
			myArrayList.add(100,55555555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Adding item into ArrayList  took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myLinkedList.add(100,55555555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Adding item into LinkedList took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myHashSet.add(55555555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Adding item into HashSet took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myTreeSet.add(55555555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Adding item into TreeSet took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myHashMap.put(100, 55555555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Adding item into HashMap took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myTreeMap.put(100, 55555555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Adding item into TreeMap took " + duration + " milliseconds");
			
			// search an item
			startTime = System.nanoTime();
			myArrayList.get(5);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Getting item by index from ArrayList  took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myLinkedList.get(5);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Getting item by index from LinkedList took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myArrayList.contains(55555555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Checking if item is found in ArrayList  took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myLinkedList.contains(55555555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Checking if item is found in LinkedList took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myArrayList.contains(555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Checking if missing item is found in ArrayList  took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myLinkedList.contains(555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Checking if missing item is found in LinkedList took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myHashSet.contains(55555555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Checking if item is found in HashSet took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myTreeSet.contains(55555555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Checking if item is found in TreeSet took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myHashSet.contains(555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Checking if missing item is found in HashSet took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myTreeSet.contains(555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Checking if missing item is found in TreeSet took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myHashMap.get(5);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Getting item by index from HashMap took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myTreeMap.get(5);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Getting item by index from TreeMap took " + duration + " milliseconds");


			startTime = System.nanoTime();
			myHashMap.containsKey(5);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Checking if item is found by key in HashMap took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myTreeMap.containsKey(5);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Checking if item is found by key in TreeMap took " + duration + " milliseconds");


			startTime = System.nanoTime();
			myHashMap.containsKey(9999999);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Checking if missing item is found by key in HashMap took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myTreeMap.containsKey(9999999);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Checking if missing item is found by key in TreeMap took " + duration + " milliseconds");

			// remove an item

			startTime = System.nanoTime();
			myArrayList.remove(50);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Removing item from ArrayList took  " + duration + " milliseconds");

			startTime = System.nanoTime();
			myLinkedList.remove(50);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Removing item from LinkedList took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myHashSet.remove(55555555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Removing item from HashSet took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myTreeSet.remove(55555555);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Removing item from TreeSet took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myHashMap.remove(50);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Removing item from HashMap took " + duration + " milliseconds");

			startTime = System.nanoTime();
			myTreeMap.remove(50);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000.0;
			System.out.println("Removing item from TreeMap took " + duration + " milliseconds");
			

		}	
}