package forum;

import java.text.Normalizer;
import java.util.Scanner;

public class MainP {
	
	public static void main(String[] args) {
		Misc m = new Misc();
		m.introducao();
		while (true) {
			cmdInput(null);
			
		}
	}
	
	static void cmdInput(String comando) {
		
		Misc m = new Misc();
		Contas c = new Contas();
		
		if (comando == null) {
			Scanner scn = new Scanner(System.in);
			System.out.println("Por favor digite o comando.");
			comando = scn.nextLine();
		}
		
		comando = Normalizer.normalize(comando, Normalizer.Form.NFD);
	    comando = comando.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    
		switch (comando.toLowerCase()) {
		case "cadastro" :
			m.loading();
			c.cadastro();
			System.out.println();
			return;
		case "login" :
			m.loading();
			// c.login();
			return;
		case "sair" :
			System.out.println("Você decidiu sair.");
			System.exit(0);
		case "introdução", "intro" :
			m.introducao();
			return;
		case "comando", "comandos", "cmd" :
			m.comandos();
			return;
		case "test" :
			System.out.println(c.isCadastrado());
			return;
		default :
			System.out.println("Comando não encontrado.");
		}
	}
	
}
