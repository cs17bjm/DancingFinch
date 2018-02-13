import java.awt.Color;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class A2 { // Task 6: Dance	
	static String hex = "", dec = "", bin = "";	
	static int r, g , b, spdVal;

	public static void run (String userInput) {
		hex = userInput;
		decimal();
		binary();
		finchCol();
		speed();
	}
	
	public static void main(String[] args) throws InterruptedException {
		A2_UI ui = new A2_UI();	
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.setSize(340,210);
		ui.setVisible(true);
		ui.setResizable(false);
	}
	
	public static void decimal() {	// Converting hexadecimal to decimal
		int result = 0;
		for (int i = 0; i<hex.length() ;i++) {	// Checks each digit and converts to decimal equivalent 
			int j = hex.length() - i - 1;	// The left digit is 16^1
			
			switch(hex.substring(i, i+1)) {
			case "1" : result += 1*(Math.pow(16, j)); break;
			case "2" : result += 2*(Math.pow(16, j)); break;
			case "3" : result += 3*(Math.pow(16, j)); break;
			case "4" : result += 4*(Math.pow(16, j)); break;
			case "5" : result += 5*(Math.pow(16, j)); break;
			case "6" : result += 6*(Math.pow(16, j)); break;
			case "7" : result += 7*(Math.pow(16, j)); break;
			case "8" : result += 8*(Math.pow(16, j)); break;
			case "9" : result += 9*(Math.pow(16, j)); break;
			case "A" : result += 10*(Math.pow(16, j)); break;
			case "B" : result += 11*(Math.pow(16, j)); break;
			case "C" : result += 12*(Math.pow(16, j)); break;
			case "D" : result += 13*(Math.pow(16, j)); break;
			case "E" : result += 14*(Math.pow(16, j)); break;
			case "F" : result += 15*(Math.pow(16, j)); break;
			}
		}
		dec = Integer.toString(result);
	}
	public static void binary() {  //Converting decimal to binary using division by 2 with remainder method
		int number = Integer.parseInt(dec);
		String x = "";
		String remainder = "";
		while (number>0) {
			if(number%2==0) {remainder +="0";}
			else {remainder +="1";}
			number = (number - (number%2))/2;
		}
		x = strReverse(remainder);
        bin = x;
	}
	static public String strReverse(String y) {	//converts the string to an array of characters 
		char[] charOutput = y.toCharArray();
		String stringOutput = new String();	        
		for (int i = y.length()-1; i>=0; i--) {
			stringOutput += (charOutput[i]);
		}
		return stringOutput;	//returns the array of characters as a string in reverse order
	}
	static public void finchCol()	{
		r = Integer.parseInt(dec);
		g = (Integer.parseInt(dec)%80) + 60;
		b = (r+g)/2;
	}
	static public void speed()	{
		spdVal = Integer.parseInt(dec);	// Converting String to integer
		if (spdVal<80) {spdVal+=30;}	// Speed of Finch is equal to Decimal (if below 80, Decimal+30)
	}
	public static void danceFabulously() {
		Finch Jim = new Finch();
		Jim.setLED(r,g,b);
		for (int i=0; i<bin.length(); i++) { 
			String p = bin.substring(i, i+1);
			int q = Integer.parseInt(p);
			if (q == 1){			// 1 = Forwards (for 2 seconds)		 
				Jim.setWheelVelocities(spdVal,spdVal,2000);	
			}
			else if (q==0) {		//0 = Backwards (for 2 seconds)
				Jim.setWheelVelocities(-spdVal,-spdVal,2000);	
			}
		}
		Jim.quit();
	}
}
