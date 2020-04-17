import java.util.ArrayList;

public class fibonnacci {

	public static void main(String[] args) {

		ArrayList<Integer> fibonacci = new ArrayList();

		int number1 = 0;
		fibonacci.add(number1);
		
		int number2 = 1;
		fibonacci.add(number2);
		
		int fiboNumb = 0;

		// int i = 0;
		int limite = 350;
		
		while((fiboNumb = number1 + number2) <= limite) {
			number1 = number2;
			number2 = fiboNumb;
			fibonacci.add(fiboNumb);
		}
		
		System.out.println(fibonacci);
		
		
		/*
		for (i = 0; i <= limite; i++) {
			if (fiboNumb <= 1) {
				fibonacci.add(fiboNumb);
			}
			
			fiboNumb = number1 + number2;
			fibonacci.add(fiboNumb);
			number1 = number2;
			number2 = fiboNumb;
			
		}*/
		
		

	}

}
