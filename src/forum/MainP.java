package forum;

import java.util.Scanner;

public class MainP {
	
	public static void main(String[] args) {
		Misc m = new Misc();
		Contas c = new Contas();
		Forums f = new Forums();
		m.introducao();
		while (true) {
			Scanner scn = new Scanner(System.in);
			System.out.println("Por favor digite o comando.");
			String comando = scn.nextLine();
			
			comando = m.normalizar(comando);
		    
			switch (comando.toLowerCase()) {
			case "cadastro" :
				m.loading();
				c.cadastro();
				break;
			case "login" :
				m.loading();
				c.login();
				break;
			case "profile", "perfil", "p" :
				m.loading();
				c.profile();
				break;
			case "terminar" :
				System.out.println("Você decidiu sair.");
				System.exit(0);
			case "introdução", "intro" :
				m.introducao();
				break;
			case "comando", "comandos", "cmd", "docs", "doc", "documentacao" :
				m.comandos();
				break;
			case "ver", "forum" :
				f.overviewPost();
				break;
			default :
				System.out.println("Comando não encontrado.");
			//TODO: Colocar todos os comandos.
		}
	}
	
	}
	
}
