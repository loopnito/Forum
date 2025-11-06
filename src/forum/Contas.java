package forum;

import java.util.Arrays;
import java.util.Scanner;

public class Contas {

	String[] contas = {
			"vinicius2011x",
			"admin",
			"Estou"
	};
	String[] senhas = {
			"senha2011x",
			"sysadmin",
			"eeeste"
	};
	
	boolean cadastrado;
	
	public boolean cadastro() {
		Misc m = new Misc();
		Misc.linha();
		Scanner scn = new Scanner(System.in);
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
	
	public int login() {
		String[] contasOrg = contas.clone();
		Arrays.sort(contasOrg);
		String[] senhasOrg;
		for(int i = 0; contasOrg.length <= i; i++ ) {
			for (int i2 = 0; contasOrg.length <= i2; i2 ++) {
				if (i2 == i) {
					
				}
			}
		} // EU NÃO SEI OQ ISSO FAZ EU SO TIVE UMA VISÃO E FIZ
		return Arrays.binarySearch(contasOrg, "vinicius2011x");
	}
}
