import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicLabelUI;

public class Main {

	public static void main(String[] args) {
		try {
			Socket echoSocket = new Socket("localhost", 7000);
			BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);

			String[] logs = new String[4];

			Scanner eingabe = new Scanner(System.in);
			String [] ballDetails = new String [5];
			while (true) {
				for (int i = 0; i < 4; i++) {
					logs[i] = in.readLine();
					System.out.println(logs[i]);
					// ball == 2

					if (i == 2) {
						 ballDetails = logs[i].split(" ");
						System.out.println(logs[2]);
					}
					
				}
				// System.out.println("Bitte MOVE COMMAND eingeben");
				//int moveTO = Integer.parseInt(eingabe.nextLine());
				//out.println("move " + moveTO);
				movePaddle(eingabe, out, ballDetails);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void movePaddle(Scanner eingabe, PrintWriter out, String[] ballData) {
		System.out.println("Ball x-Position" + ballData[1]);
		System.out.println("Ball y-Position" + ballData[2]);
		System.out.println("Ball x-Speed" + ballData[3]);
		System.out.println("Ball y-Speed" + ballData[4]);
		int xSpeed = (int) Double.parseDouble(ballData[3]);
		int ySpeed = (int) Double.parseDouble(ballData[4]);

		int moveTo = 0;
		if (xSpeed > 0) {
			moveTo = 36;

		} else {
			if (ySpeed == 0) {
				moveTo = 0;

			} else if (ySpeed > 0) {
				moveTo = 36;

			} else {
				moveTo = -36;
			}
			
		}
		out.println("move " + moveTo);
	}
}
