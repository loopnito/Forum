package forum;

import java.util.Scanner;

public class Contas {

	String[] contas = {
			"vinicius2011x",
			"admin"
	};
	String[] senhas = {
			"senha2011x",
			"sys4dmin"
	};
	
	boolean cadastrado = false;
	
	public boolean cadastro() {
		Misc m = new Misc();
		Scanner scn = new Scanner(System.in);
		
		Misc.linha();
		System.out.println("\r\n"
				+ "  ░██████                    ░██                          ░██                        \r\n"
				+ " ░██   ░██                   ░██                          ░██                        \r\n"
				+ "░██         ░██████    ░████████  ░██████    ░███████  ░████████ ░██░████  ░███████  \r\n"
				+ "░██              ░██  ░██    ░██       ░██  ░██           ░██    ░███     ░██    ░██ \r\n"
				+ "░██         ░███████  ░██    ░██  ░███████   ░███████     ░██    ░██      ░██    ░██ \r\n"
				+ " ░██   ░██ ░██   ░██  ░██   ░███ ░██   ░██         ░██    ░██    ░██      ░██    ░██ \r\n"
				+ "  ░██████   ░█████░██  ░█████░██  ░█████░██  ░███████      ░████ ░██       ░███████  \r\n");
		Misc.linha();
		
		System.out.println("Bem vindo(a) a pagina de cadastro.\r\n"
				+ "Se deseja sair, digite 'SAIR'.\r\n"
				+ "Digite o seu desejado nome de usuario:");
		String potentialUser = scn.nextLine();;
		
		if (potentialUser.equalsIgnoreCase("sair")) {
			System.out.println("Você decidiu sair.");
			return false;
		}
		
		cadastrado = m.verificacao(potentialUser);

		while (!cadastrado) {
			System.out.println("Nome de usuario invalido, veja se ele tem algum desses requisitos\r\n"
					+ "- Tem mais de ou tem três letras e menos de vinte letras.\r\n"
					+ "- Sem espaços ou characteres especiais (com exceção do '_').\r\n"
					+ "Tente novamente.");
			potentialUser = scn.nextLine();
			
			if (potentialUser.equalsIgnoreCase("sair")) {
				System.out.println("Você decidiu sair.");
				return false;
			}
			
			cadastrado = m.verificacao(potentialUser);
		}
		
		System.out.println("Digite sua senha.");

		return cadastrado;
	}
	
	public boolean login() {
		/* isso não funciona muito bem em grande escala,
		 mas isso devia ser feito no sql né então*/		
		Misc m = new Misc();

		if (this.cadastrado) {
			System.out.println("Usuario ja esta logado.");
			return false;
		}
		Misc.linha();
		System.out.println(""
				+ "░██                               ░██           \r\n"
				+ "░██                                             \r\n"
				+ "░██          ░███████   ░████████ ░██░████████  \r\n"
				+ "░██         ░██    ░██ ░██    ░██ ░██░██    ░██ \r\n"
				+ "░██         ░██    ░██ ░██    ░██ ░██░██    ░██ \r\n"
				+ "░██         ░██    ░██ ░██   ░███ ░██░██    ░██ \r\n"
				+ "░██████████  ░███████   ░█████░██ ░██░██    ░██ \r\n"
				+ "                              ░██               \r\n"
				+ "                        ░███████                \r\n");
		Misc.linha();

		return true;
	}
}
