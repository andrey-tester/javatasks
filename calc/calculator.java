import java.util.Scanner;
import java.util.Arrays;

class Calculator {

		int setFirstNum() {
			System.out.println("Enter the first number:");		
			Scanner in = new Scanner(System.in);
			int x = in.nextInt();
			return x;
		}
		
		int setAction() {
			System.out.println("Choose your operation:");
			System.out.println("Enter 1 to add.");
			System.out.println("Enter 2 to substract.");
			System.out.println("Enter 3 to multiply.");
			System.out.println("Enter 4 to divide.");
			int operation = 0;
			while (operation == 0) {
				operation = setOperation();
			}
			return operation;
		}

		int setOperation(){
			Scanner in1 = new Scanner(System.in);
			String action = in1.nextLine();
			int operand = 0;
			String[] array = {"1", "2", "3", "4"};
			if (Arrays.asList(array).contains(action)) {
				operand = Integer.parseInt(action);
				
			} else {
			System.out.println("Invalid operation. Please try again:");
			}	
			return operand;	
		}

		int setSecondNum() {
			System.out.println("Enter the second number:");		
			Scanner in = new Scanner(System.in);
			int y = in.nextInt();
			return y;
		}

		void calculate(int operation, int x, int y) {
			if (operation == 1) {
				add (x, y);
			} else
			if (operation == 2) {
				substract (x, y);
			} else
			if (operation == 3) {
				multiply (x, y);
			} else 
			if (operation == 4) {
				divide (x, y);
			}
		}
		
		public static void add(int a, int b){
			int res = a + b;
			System.out.println(a + " + " + b + " = " + res);
		};
		public static void substract(int a, int b){
			int res = a - b;
			System.out.println(a + " - " + b + " = " + res);
		};
		public static void multiply(int a, int b){
			int res = a * b;
			System.out.println(a + " * " + b + " = " + res);
		};
		public static void divide(int a, int b){
			while (b == 0) {
				System.out.println("You can't divide by zero. Please change the number:");
				Scanner in2 = new Scanner(System.in);
			    b = in2.nextInt();
			}

			double res = (double)a / b;
			System.out.println(a + " / " + b + " = " + Double.toString(res));
		};
}

class MyCalc {
		public static void main(String[] args) {
			Calculator calc = new Calculator();
			System.out.println("This is a simple calculator. Please use integers.");
			int x = calc.setFirstNum();
			int operation = calc.setAction();
			int y = calc.setSecondNum();
			calc.calculate(operation, x, y);
		}
}