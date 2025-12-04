package forum;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Contas {
	//TODO: Completar profile
	private String contaCadastrada = ""; //esse é o user
	private String contaSenha = "";
	private String[] contasadm = {
			//primeiro é user segundo é senha :)
			"admin 123admin",
			"contatest 321test"
	};
	ArrayList<String> contas = new ArrayList<>(Arrays.asList(contasadm));
	
	public void cadastro() {
		if (!contaCadastrada.isBlank()) {
			System.out.println("Usuário ja esta cadastrado.");
			return;
		}
		boolean cadastrado = false;
		String potentialUser = "";
		String potentialPass = "";
		Misc m = new Misc();
		Scanner scn = new Scanner(System.in);
		
		m.cadastroTitulo();
		
		while (cadastrado == false) {
			potentialUser = scn.nextLine();
			if (m.arrayVerUser(contas, potentialUser) >= 0) {
				System.out.println("Nome de usuário indisponivel, alguem ja esta usando ele. \r\nPor favor tente outro nome.");
			} else {
				if (potentialUser.equalsIgnoreCase("sair")) {
					System.out.println("Você decidiu sair.");
					return;
				}
				
				cadastrado = m.verificacao(potentialUser);
				if (cadastrado == false) {
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
		contaCadastrada = potentialUser;
		contaSenha = potentialPass;
		cadastrado = true;
		return;
	}
	
	public void login() {
		/* isso não funciona muito bem em grande escala,
		 mas isso devia ser feito no sql né então*/		
		Scanner scn = new Scanner(System.in);
		Misc m = new Misc();
		if (!contaCadastrada.isBlank()) {
			System.out.println("Usuario ja esta logado.");
			return;
		}
		m.loginTitulo();
		boolean success = false;
		System.out.println("Digite seu nome de usuário. \r\nSe desejas sair, digite 'sair'.");
		
		String searchUser = scn.next() + " ";
		while(!success) { //verificação do user
			int temp = m.arrayVerUser(contas, searchUser);
			if (temp > 0) {
				success = true;
			}
			if (success) {
				System.out.println("Usuário encontrado, por favor digite a senha.");
			} else {
				System.out.println("Usuário não encontrado, por favor tente novamente.");
				searchUser = scn.next() + " ";
			}
		}
		System.out.println("Escreva sua senha.");
		success = false;
		String searchPass = " " + scn.next();
		while(!success) {
			int var = m.arrayVerSenha(contas, searchPass, searchUser);
			if (var > -1) {
				String[] conta;
				conta = contas.get(var).split(" ");
				contaCadastrada = conta[0];
				contaSenha = conta[1];
				System.out.println("Senha compativel, conta logada. \r\nVoltando para comandos...");
				return;
			} else {
				System.out.println("Senha não encontrada, por favor tente novamente.");
				searchPass = " " + scn.next();
			}
		}
	}
	
	public void profile() {
		Misc m = new Misc();
		Scanner scn = new Scanner(System.in);
		
		if (contaCadastrada.isBlank()) {
			System.out.println("Usuário não cadastrado.");
			return;
		}
		
		m.perfilTitulo();
		
		m.perfilComandos(contaCadastrada);
		
		String comando = scn.nextLine();
		
		comando = Normalizer.normalize(comando, Normalizer.Form.NFD);
	    comando = comando.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    
	    switch (comando.toLowerCase()) {
		case "mudarsenha" :
			
		case "mudarnome" :
			System.out.println("Tem certeza que quer mudar o seu nome de usuário? \r\nSe sim, digite seu nome de usuário para confirmar.");
			comando = scn.next();
			if (comando.equals(contaCadastrada)) {
				System.out.println("Por favor digite seu novo nome de usuário");
				String velhonome = contaCadastrada;
				comando = scn.next();
				if (comando == velhonome) {
					System.out.println("Seu nome novo não pode ser o mesmo do que o antigo.");
					break;
				}
				int temp = m.arrayVerUser(contas, velhonome);
				int temp2 = m.arrayVerUser(contas, comando);
				//TODO: depois terminar
			}
		case "deslogar" :
			System.out.println("Você deslogou com sucesso");
			contaCadastrada = "";
			contaSenha = "";
			break;
		case "voltar" :
			
		default :
			System.out.println("Comando não encontrado.");
	    }
		
	}
}
