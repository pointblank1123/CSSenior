import java.io.IOException;

public class sortRunner {
	public static void main(String[] args) {
		try {
			sort sr = new sort();
			sr.bubbleSort();
			sr.selectionSort();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
