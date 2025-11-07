package forum;

import java.util.Scanner;

public class MainP {

	public static void main(String[] args) {
		Misc m = new Misc();
		Contas c = new Contas();
		m.introducao();
		while (true) {
			cmdInput(null);
		}
	}
	
	static void cmdInput(String comando) {
		Misc m = new Misc();
		Contas c = new Contas();
		Scanner scn = new Scanner(System.in);
		
		if (comando == null) {
			System.out.println("Por favor digite o comando.");
			comando = scn.nextLine();
		}
		
		switch (comando.toLowerCase()) {
		case "cadastro" :
			m.loading();
			c.cadastro();
			return;
		case "login" :
			m.loading();
			c.login();
			return;
		case "sair" :
			System.out.println("Você decidiu sair.");
			System.exit(0);
		default :
			System.out.println("Comando não encontrado.");
		}
	}
}
