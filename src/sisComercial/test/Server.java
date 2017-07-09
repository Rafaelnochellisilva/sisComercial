package sisComercial.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public Server() {
		try {
			ServerSocket Servidor = new ServerSocket(5560);

			while (true) {
				Socket C = Servidor.accept();
				Scanner s = new Scanner(C.getInputStream());
				System.out.println(s.nextLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
