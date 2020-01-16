import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptionhandle {
	private int[] array = {1,2,3,4,5,6};
	private boolean retry = true;
	private int selection;
	private int data;
	Scanner key = new Scanner(System.in);
	
	
	public int select() {
		while(retry == true) {
			try {
				System.out.println("Input a index to read from the array: ");
				selection = key.nextInt();
				data = array[selection];
				break;
			}catch (ArrayIndexOutOfBoundsException f) {
				System.out.println("The input value is out of the bounds of the array, try again:");
			}catch (InputMismatchException h) {
				System.out.println("The input value is not a number, try again: ");
				key.next();
			}catch (Exception g) {
				System.out.println("Another error has occured, try again: ");
			}
		}
		return data;
	}
	public static void main(String[] args) {
		Exceptionhandle exh = new Exceptionhandle();
		System.out.println("Selection value: "+ exh.select());
	}
}
