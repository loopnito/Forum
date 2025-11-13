package forum;

import java.util.Scanner;

public class Contas {
	
	private boolean cadastrado;
	
	public boolean isCadastrado() {
		return cadastrado;
	}
	public void setCadastrado(boolean bool) {
		cadastrado = bool;
	}
	
	public void cadastro() {
		if (cadastrado) {
			System.out.println("Usuário ja esta cadastrado.");
			return;
		}
		String potentialUser = "";
		String potentialPass = "";
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
		
		while (cadastrado == false) {
			potentialUser = scn.nextLine();
			
			if (potentialUser.equalsIgnoreCase("sair")) {
				System.out.println("Você decidiu sair.");
				return;
			}
			
			cadastrado = m.verificacao(potentialUser);
			System.out.println( m.verificacao(potentialUser));
			if (cadastrado  == false) {
				System.out.println("Nome de usuario invalido, veja se ele tem algum desses requisitos\r\n"
						+ "- Tem mais de ou tem três letras e menos de vinte letras.\r\n"
						+ "- Sem espaços ou characteres especiais (com exceção do '_').\r\n"
						+ "Tente novamente.");
			} else {
				System.out.println("Nome de usuário compatível, deseja ter o username '" + potentialUser + "'?"
						+ "\r\nPor favor digite 'sim' se quiser.");
				if (scn.nextLine().equalsIgnoreCase("sim")) {
					System.out.println("Username escolhido.");
				} else {
					cadastrado = false;
					System.out.println("Por favor escolha outro username.");
				}
			}
		}
		cadastrado = false;
		System.out.println("Digite sua senha.");
		while (cadastrado  == false) {
			potentialPass = scn.nextLine();
			
			if (potentialPass.equalsIgnoreCase("sair")) {
				System.out.println("Você decidiu sair.");
				return;
			}
			
			cadastrado = m.verificacao(potentialPass);
			if (cadastrado  == false) {
				System.out.println("Senha invalida, veja se ela tem algum desses requisitos\r\n"
						+ "- Tem mais de ou tem três letras e menos de vinte letras.\r\n"
						+ "- Sem espaços ou characteres especiais (com exceção do '_').\r\n"
						+ "Tente novamente.");
			} else {
				System.out.println("Senha compatível, deseja ter a senha '" + potentialPass + "'?"
						+ "\r\nPor favor digite 'sim' se quiser.");
				if (scn.nextLine().equalsIgnoreCase("sim")) {
					System.out.println("Username escolhido.");
				} else {
					cadastrado = false;
					System.out.println("Por favor escolha outra senha.");
				}
			}
		}
		String user = potentialUser + " " + potentialPass;
		System.out.println(user);
		System.out.println("Usuário cadastrado com sucesso.");
		System.out.println(cadastrado);
		setCadastrado(true);
		return;
	}
	
	public boolean login() {
		/* isso não funciona muito bem em grande escala,
		 mas isso devia ser feito no sql né então*/		
		if (cadastrado) {
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
