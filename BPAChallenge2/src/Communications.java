import java.io.*;

public class Communications{
	private BufferedReader read;
	private String line;
	private int lineNum;
	private int messageNum;
	private int messageTotal;
	private int messageLetters;
	private String message;
	private int confirmTotal;
	private int confirmLetters;
	private String encoded;
	private String errorType;
	public Communications(BufferedReader read){
		this.read = read;
		errorType ="";
	}
	
	public void interpretLines() {
		try {
			lineNum = Integer.parseInt(read.readLine().substring(0,1));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<lineNum;i++) {
			try {
				line = read.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			messageNum = Integer.parseInt(line.substring(0,3));
			messageTotal = Integer.parseInt(line.substring(4,9));
			messageLetters = Integer.parseInt(line.substring(10,13));
			message = line.substring(14);
			if(!confirmCharNum()) {
				errorType += " length error";
				print();
			}
			else {
				if(!confirmMessageTotal()) {
					errorType += "check total error";
					print();
				}
				else {
					if(!(message.substring(message.length()-4).equals("over"))) {
						System.out.println(message.substring(message.length()-4));
						errorType += " incomplete transmission";
						print();
					}
					else {
						errorType=" confirmed";
						print(true);
					}
				}
			}
		}
	}
	
	public boolean confirmCharNum() {
		confirmLetters = message.length()-5;
		if(confirmLetters == messageLetters) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean confirmMessageTotal() {
		for(int i=0; i<message.length()-5;i++) {
			confirmTotal += (int) message.charAt(i);
		}
		if(confirmTotal == messageTotal) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String encode(){
		for(int i = 0; i<message.length(); i++) {
			if(message.charAt(i) == 'f') {
				message = message.substring(0,i) + "B" + message.substring(i+1);
			}
			else if(message.charAt(i) == 'F') {
				message = message.substring(0,i) + "P" + message.substring(i+1);
			}
			else if(message.charAt(i) == 'e') {
				message = message.substring(0,i) + "A" + message.substring(i+1);
			}
			else if(message.charAt(i) == ' ') {
				message = message.substring(0,i) + "e" + message.substring(i+1);
			}
			else if(message.charAt(i) == 't') {
				message = message.substring(0,i) + ">?/" + message.substring(i+1);
			}
		}
		return message + " over";
	}
	
	public void print() {
		System.out.println("Transmission " + messageNum + errorType);
		errorType =" ";
		System.out.println(encode());
		System.out.println("");
	}
	
	public void print(boolean confirmed) {
		System.out.println("Transmission " + messageNum + errorType);
		encoded = encode();
		System.out.println(encoded);
		System.out.println("");
		errorType=" ";
	}
	
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		String filepath = new File("").getAbsolutePath().concat("//communications.txt");
		BufferedReader read = new BufferedReader(new FileReader(filepath));
		Communications coms = new Communications(read);
		coms.interpretLines();
	}
}
