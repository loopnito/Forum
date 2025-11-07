package forum;

import java.text.Normalizer;
import java.util.Scanner;

public class Misc {
	
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
				+ "\r\n- PlaceholderViewForum: Leva você a tela de um forum."
				+ "\r\n- PlaceholderViewPost: Leva você a um post."
				+ "\r\n- PlacehlolderComandosAvancados: Mostra comandos mais avançados.");
	}
	
	public boolean verificacao(String linhaVerificacao) {
		boolean valido = true;
		
		if (linhaVerificacao == null) {
			Scanner scn = new Scanner(System.in);
			linhaVerificacao = scn.nextLine();
		}
		
		/* isso vê se a linhaVerificação ta vazia, c tiver ela faz você completar
		honestamente isso foi mais para facilitar um pouco minha vida... se eu esquecer de colocar o scanner pelo menos isso auto completa
		mas eu vou admitir eu podia ter feito o comando "SAIR" aqui... ja foi né... mas também isso faria essa função bem especifica...
		quer saber? funciona, isso que importa
		eu não sei falar se funciona BEM... mas funciona */
		
		char[] lvArray = linhaVerificacao.toCharArray();
				
		if (linhaVerificacao.length() >= 3 && Normalizer.isNormalized(linhaVerificacao, Normalizer.Form.NFD) &&  linhaVerificacao.length() <= 20) {
			for (int i = 0; i < lvArray.length; i ++) {
				if (Character.isLetterOrDigit(lvArray[i]) == false ) {
					if (lvArray[i] != '_') {
						valido = false;
					}
				}
			} 
		} else {
			valido = false;
		};
		
		/* isso checa por tipo... quase todos os negocio que você não quer em um username ou senha
		os length é meio explicatorio, mas o isNormalized v c as letras tem accento
		'tem um jeito mas eficiente usando a-' SHIIIIUUUU NÃO QUERO OUVIR
		eu gastei tipo uma aula INTEIRA procurando um jeito 'mais eficiente' de fazer isso
		e honestamente performance não é algo que eu quero me preocupar, pelo menos não agora
		cara tipo, é uma DEMONSTRAÇÃO. quem liga se a demonstração demora tipo uns 0.000009 segundos a mais
		eu SEIII que em outros programas eu tenho que ser mais cuidadoso mas...
		Isso funciona.
		
		vou ser honesto, não quero tocar isso nunca mais */
		
		return valido;
	}
	
}
