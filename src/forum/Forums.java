package forum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Forums {
	Random r = new Random();
	Misc m = new Misc();
	
	private int numTotalPosts = 9; //isso faz o id dos posts
	private int numTotalForums = 3; //isso faz o id dos forums
	
	private String f1Nome = "forum1";
	private String f2Nome = "forum2";
	private String f3Nome = "forum3";
	private String f4Nome = "";
	private String f5Nome = "";
	private String f6Nome = "";
	private String f7Nome = "";
	private String f8Nome = "";
	private String f9Nome = "";
	private String f10Nome = "";
	
	private String[] f1info = {"forum 1, post 1", "Forum 1, post 2", "forum 1, post 3"};
	private ArrayList<String> f1 = new ArrayList<>(Arrays.asList(f1info));
	private String[] f2info = {"forum 2, post 1", "forum 2, post 2", "forum 2, post 3"};
	private ArrayList<String> f2 = new ArrayList<>(Arrays.asList(f2info));
	private String[] f3info = {"forum 3, post 1", "forum 3, post 2", "forum 3, post 3"};
	private ArrayList<String> f3 = new ArrayList<>(Arrays.asList(f3info));
	//hard-coding my odiado
	private ArrayList<String> f4 = new ArrayList<>();
	private ArrayList<String> f5 = new ArrayList<>();
	private ArrayList<String> f6 = new ArrayList<>();
	private ArrayList<String> f7 = new ArrayList<>();
	private ArrayList<String> f8 = new ArrayList<>();
	private ArrayList<String> f9 = new ArrayList<>();
	private ArrayList<String> f10 = new ArrayList<>();
	
	private String[] aFPinfo = {"forum 1, post 1", "forum 1, post 2", "forum 1, post 3",
				"forum 2, post 1", "forum 2, post 2", "forum 2, post 3",
				"forum 3, post 1", "forum 3, post 2", "forum 3, post 3"};
	private ArrayList<String> allForumPosts = new ArrayList<>(Arrays.asList(aFPinfo));
	private String[] aFinfo = {f1Nome, f2Nome, f3Nome};
	private ArrayList<String> allForums = new ArrayList<>(Arrays.asList(aFinfo));
	private int votes;
	
	public void overviewPost() {

		Scanner scn = new Scanner(System.in);
		int id = r.nextInt(0 , 1); //1, allForumPosts.size()
		votes = r.nextInt(-100, 100);
		String post = allForumPosts.get(id);
		int idpraverbonito = id + 1;
		System.out.println("\nForum: " + allForums.get(getForum(post)) +  "\n-Id: " + idpraverbonito
				+  "\n-Conteudo: " + allForumPosts.get(id) + "\n-Votos: " + votes);
		System.out.println("Como desejas interagir com o post?\r\n 'down' - colocar um voto a menos"
				+ "\r\n 'up' - colocar um voto a mais \r\n 'comentar' - escrever um comentário \r\n"
				+ " 'retornar' - para retornar");
		String comando = scn.nextLine();
		comando = m.normalizar(comando);
		comando = comando.toLowerCase();
		String status = "";
		boolean quersair = false;
	
		while (!quersair) {
			switch (comando.toLowerCase()) {
			case "down":
				if (status == "desvotado") {
					System.out.println("Você ja desvotou!");
				}
				status = "desvotado";
				votes--;
				System.out.println("Votos: " + votes + "\r\nDesvotado.");
				break;
			case "up":
				if (status == "upvotado") {
					System.out.println("Você ja votou!");
				}
				status = "upvotado";
				votes++;
				System.out.println("Votos: " + votes + "\r\nDesvotado.");
				break;
			case "comentar":
				System.out.println("Por favor digite o que deseje comentar.");
				String com = scn.next();
				System.out.println("Tem certeza que quer postar esse comentario? Se lembre que se infrigir as regras ele pode ser"
						+ " deletado ou você pode até ser banido.");
				if (scn.next().equalsIgnoreCase("sim")) {
					System.out.println("Postado! Aqui esta seu comentario: \r\n"+com);
				}
				break;
			case "retornar":
				quersair = true;
				System.out.println("Retornando...");
				return;
			} 
			comando = scn.next();
		}
		
		//TODO: talvez ver isso ai sla tem que fazer os negocio
	}
	
	public int getForum(String str) {
		if (f1.contains(str)) {
			return 0;
		} else if (f2.contains(str)) {
			return 1;
		} else if (f3.contains(str)) {
			return 2;
		} else if (f4.contains(str)) {
			return 3;
		} else if (f5.contains(str)) {
			return 4;
		} else if (f6.contains(str)) {
			return 5;
		} else if (f7.contains(str)) {
			return 6;
		} else if (f8.contains(str)) {
			return 7;
		} else if (f9.contains(str)) {
			return 8;
		} else if (f10.contains(str)) {
			return 9;
		}
		return -1; 
	}
}
/*
 * "forum1"
 * "forum2"
 * "forum3"
 * 
 * "post 1 forum 1"
 * "post 2 forum 1"
 * "post 3 forum 1"
 * 
 * "post 1 forum 2"
 * "post 2 forum 2"
 * "post 3 forum 2"
 * 
 * "post 1 forum 3"
 */
/*
String[] titulos = {
"Amadores de carro.com",
"Nozes damos boa noite pro william boner",
"Buzologos realmente existem?",
"Placeholder",
"Kolossos é op demais, nerfem ele por favor",
"Kolossos é fraco demais, buffem ele por favor",
"Kolossos é normal demais, fazem nada por favor",
"PAREM DE PENSAR NO KOLOSSOS!!!",
"Mais um titulo",
"Eu gosto de pão",
"DJU 28UI , 2?9 ( (8."
};
String[] conteudos = {
"Eu amo carregar carros",
"Globo lixo lol nãop!!!!",
"Tabom (em busca dessa raça misteriosa)",
"Placeholder",
"Mano o Kolossos mata em 294857255 hits, muito op na moral, Kolossos nem devia matar",
"QUEM PENSOU QUE UM KILLER DEVIA MATAR EM 294857255 HITS??? OQUE??????",
"Os outros killers matam em 9359823984 hits, Kolossos foi sortudo.",
"LE O TITULO!!!!",
"acabou a criatividade nesse galerinha :(",
"eu realmente gosto de pão",
"11,,9,,37\r\n 1:)2,K,,.0,?6,43:,2?':#30 18,1?,KOO?\\r\\n 3410. 17.2?,2 :? ,,19,,F?'9"
};
String[] forums = {
"gostadoresDeCarro",
"williamLovers",
"buzologos",
"placeholder",
"outcomeHaters",
"outcomeLovers",
"outcomeNothings",
"outcomeSomethings",
"maisUmForum",
"pãoAmores",
"tecladoSmashers"
};
*/