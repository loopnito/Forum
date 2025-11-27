package forum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Contas {
	//TODO: Completar profile
	private boolean cadastrado;
	private String contaCadastrada; //esse é o user
	private String[] contasinfo = {
			//primeiro é user segundo é senha :)
			"admin 123admin",
			"contatest 321test"
	};
	ArrayList<String> contas = new ArrayList<>(Arrays.asList(contasinfo));
	
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
		contas.add(potentialUser + " " + potentialPass);
		System.out.println("Usuário cadastrado com sucesso.");
		
		cadastrado = true;
		return;
	}
	
	public void login() {
		/* isso não funciona muito bem em grande escala,
		 mas isso devia ser feito no sql né então*/		
		Scanner scn = new Scanner(System.in);
		if (cadastrado) {
			System.out.println("Usuario ja esta logado.");
			return;
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
		
		boolean success = false;
		System.out.println("Digite seu nome de usuário.");
		String[] conta;
		String searchUser = scn.next() + " ";
		while(!success) { //verificação do user
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i).contains(searchUser)) {
					success = true;
					i = contas.size();
					System.out.println("Usuário encontrado, por favor digite a senha");
				}
			}
			if (!success) {
				System.out.println("Usuário não encontrado, por favor tente novamente.");
				searchUser = scn.next() + " ";
			}
		}
		System.out.println("Escreva sua senha.");
		success = false;
		String searchPass = " " + scn.next();
		while(!success) { //verificação do user
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i).contains(searchPass)) {
					success = true;
					conta = contas.get(i).split(" ");
					contaCadastrada = conta[0];
					i = contas.size();
					System.out.println("Senha compativel!");
				}
			}
			if (!success) {
				System.out.println("Senha não encontrada, por favor tente novamente.");
				 searchPass = " " + scn.next();
			}
		}
		
		cadastrado = true;
		return;
	}
}
