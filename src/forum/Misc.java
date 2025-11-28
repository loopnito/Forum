package forum;

import java.text.Normalizer;
import java.util.ArrayList;

public class Misc {
	
	/* aqui tem coisas de verificação
	e coisas visuais */
	
	//VISUAIS
	
	public static void linha() {
		System.out.println("----------------------");
	}
	
	public void loading() {
		String loadingText = "Carregando...";
		char[] loadingTable = loadingText.toCharArray();
		for (int i = 0; i < loadingTable.length; i ++) {
			System.out.print(loadingTable[i]);
			
			try
		    {
		        Thread.sleep(150);
		    }
		    catch(InterruptedException ex)
		    {
		        Thread.currentThread().interrupt();
		    }
			/* vou ser honesto, eu so copiei isso da net, eu faço menor idea de como fazer o programa esperar
			 no luau é bem mais facil, é tipo so task.wait() */
			
		};
		System.out.println("\r\nCarregado!");
	}
	
	//VERIFICAÇÃO
	
	public boolean verificacao(String linhaVerificacao) {
		boolean valido = true;
		char[] lvArray = linhaVerificacao.toCharArray();
		//TODO: Anotações da verificação		
		if (linhaVerificacao.length() >= 3 && Normalizer.isNormalized(linhaVerificacao, Normalizer.Form.NFD) &&  linhaVerificacao.length() <= 20) {
			for (int i = 0; i < lvArray.length; i ++) {
				if (Character.isLetterOrDigit(lvArray[i]) == false ) {
					if (lvArray[i] != '_') {
						valido = false;
					} else {
						valido = true;
					}
				}
			} 
		} else {
			valido = false;
		};
		
		return valido;
	}
	
	public int arrayVerUser(ArrayList<String> array, String search) {
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).contains(search)) {
				i = array.size();
				return i;
			}
		}
		return -1;
	}
	
	public int arrayVerSenha(ArrayList<String> array, String pass, String user) {
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).contains(pass)) {
				if (array.get(i).contains(user)) {
					return i;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}
	//TUTORIAIS DE COMANDOS
	
	void perfilComandos(String contaCadastrada) {
		System.out.println("Nome de usuário : " + contaCadastrada +
				"\r\nComunidades que você participa:" + //TODO: Depois implementar
				"Opções: "
				+ " Mudar senha: digite 'mudarsenha' para mudar a senha.\r\n"
				+ " Mudar nome de usuário: digite 'mudarnome' para mudar o nome de usuário. \r\n"
				+ " Deslogar: digite 'deslogar' para deslogar.\r\n"
				+ " Voltar: digite 'voltar' para voltar para a tela de comandos.\r\n"
				+ "Por favor digite o comando.");
	}
	void comandos() {
		System.out.println("Aqui estão todos os comandos:"
				+ "\r\n'cmd', 'comando', 'comandos': Mostram os comandos disponiveis");
		//TODO: Colocar todos os comandos.
	}
	
	//TITULOS
	
	void loginTitulo() {
		Misc.linha();
		System.out.println("░██                               ░██           \r\n"
				+ "░██                                             \r\n"
				+ "░██          ░███████   ░████████ ░██░████████  \r\n"
				+ "░██         ░██    ░██ ░██    ░██ ░██░██    ░██ \r\n"
				+ "░██         ░██    ░██ ░██    ░██ ░██░██    ░██ \r\n"
				+ "░██         ░██    ░██ ░██   ░███ ░██░██    ░██ \r\n"
				+ "░██████████  ░███████   ░█████░██ ░██░██    ░██ \r\n"
				+ "                              ░██               \r\n"
				+ "                        ░███████                \r\n");
		Misc.linha();
	}
	
	void perfilTitulo() {
		Misc.linha();
		System.out.println("                                 .-.            ___  \r\n"
				+ "                                /    \\    .-.  (   ) \r\n"
				+ "   .-..     .--.    ___ .-.     | .`. ;  ( __)  | |  \r\n"
				+ "  /    \\   /    \\  (   )   \\    | |(___) (''\")  | |  \r\n"
				+ " ' .-,  ; |  .-. ;  | ' .-. ;   | |_      | |   | |  \r\n"
				+ " | |  . | |  | | |  |  / (___) (   __)    | |   | |  \r\n"
				+ " | |  | | |  |/  |  | |         | |       | |   | |  \r\n"
				+ " | |  | | |  ' _.'  | |         | |       | |   | |  \r\n"
				+ " | |  ' | |  .'.-.  | |         | |       | |   | |  \r\n"
				+ " | `-'  ' '  `-' /  | |         | |       | |   | |  \r\n"
				+ " | \\__.'   `.__.'  (___)       (___)     (___) (___) \r\n"
				+ " | |                                                 \r\n"
				+ "(___)                                                ");
		Misc.linha();
	}
	
	void cadastroTitulo() {
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
	}
	
	public void introducao() {
		linha();
		System.out.println("Bem vindo(a)..."
				+ "\r\n ________                   __                            __       __                        __     \r\n"
				+ "/        |                 /  |                          /  \\     /  |                      /  |    \r\n"
				+ "$$$$$$$$/______    _______ $$ |____   _______    ______  $$  \\   /$$ |  ______    ______   _$$ |_   \r\n"
				+ "   $$ | /      \\  /       |$$      \\ /       \\  /      \\ $$$  \\ /$$$ | /      \\  /      \\ / $$   |  \r\n"
				+ "   $$ |/$$$$$$  |/$$$$$$$/ $$$$$$$  |$$$$$$$  |/$$$$$$  |$$$$  /$$$$ |/$$$$$$  |/$$$$$$  |$$$$$$/   \r\n"
				+ "   $$ |$$    $$ |$$ |      $$ |  $$ |$$ |  $$ |$$ |  $$ |$$ $$ $$/$$ |$$    $$ |$$    $$ |  $$ | __ \r\n"
				+ "   $$ |$$$$$$$$/ $$ \\_____ $$ |  $$ |$$ |  $$ |$$ \\__$$ |$$ |$$$/ $$ |$$$$$$$$/ $$$$$$$$/   $$ |/  |\r\n"
				+ "   $$ |$$       |$$       |$$ |  $$ |$$ |  $$ |$$    $$/ $$ | $/  $$ |$$       |$$       |  $$  $$/ \r\n"
				+ "   $$/  $$$$$$$/  $$$$$$$/ $$/   $$/ $$/   $$/  $$$$$$/  $$/      $$/  $$$$$$$/  $$$$$$$/    $$$$/  \r\n"
				);
		linha();
		System.out.println("Comandos basicos:"
				+ "\r\n- Cadastro: Leva você a tela de cadastro."
				+ "\r\n- Login: Leva você a tela de login."
				+ "\r\n- Profile: Leva você a tela do seu perfil."
				+ "\r\n- Comandos: Mostra todos os comandos."
				+ "\r\nO comando converte quaisquer acentos e letras maisculas."
				+ "\r\nPara ver essa introdução novamente, digite 'intro' ou 'introdução'.");
		//TODO: Colocar outros comandos + atualizar
	}
}
