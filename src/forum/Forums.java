package forum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Forums {
	Random r = new Random();
	private int numTotalPosts = 9; //isso faz o id dos posts
	private int numTotalForums = 3; //isso faz o id dos forums
	String[][] dft = {
			{},
			{},
			{}
	};
	ArrayList<String> forumPosts = new ArrayList<>();
	
	public void overviewPost() {
		
		int id = r.nextInt(0, titulos.length);
		int votes = r.nextInt(-100, 100);
		System.out.println("\nForum: " + forums[id] + "\n-Titulo: " + titulos[id] +  "\n-Id: " + id
				+  "\n-Conteudo: " + conteudos[id] + "\n-Votos: " + votes);
		//TODO: talvez ver isso ai sla tem que fazer os negocio
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