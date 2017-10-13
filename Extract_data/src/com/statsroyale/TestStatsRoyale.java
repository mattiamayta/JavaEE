package com.statsroyale;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestStatsRoyale {
	public static void main(String[] args) throws Exception {
		String url = "http://statsroyale.com/profile/";
		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci l'ID dell'utente che vuoi cercare:");
		String ID = in.nextLine();
		url = url + ID;
		
		System.out.println("Vuoi aggiornare? y/n");
		String conferma = in.nextLine();
		if(conferma.equals("y")) {
			String url2 = url + "/refresh?web=1";
			Document doc2 = Jsoup.connect(url2).get();
		}
		Document document = Jsoup.connect(url).get();
		
		//stampa l'utente e il livello 
		String name = document.select(".profileHeader__name").text();
		System.out.println("Utente: " + name);
		System.out.println(document.select(".refresh__time").text());
		
		System.out.println("--------------------------------------");
		//stampo le statistiche
		Elements stats = document.select("div.statistics.profile__statistics > *");
		for(Element stat : stats) {
			System.out.println(stat.text());
		}
		
		System.out.println("--------------------------------------");
		//stampa le prossime chest
		System.out.println("Next chests:");
		Elements chests = document.select("div.ui__tooltip.ui__tooltipTop.ui__tooltipMiddle.chests__tooltip");
		for(Element chest : chests) {
			System.out.println(chest.text());
		}
	}
}
