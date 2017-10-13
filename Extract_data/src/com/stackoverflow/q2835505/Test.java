package com.stackoverflow.q2835505;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

	public static void main(String[] args) throws Exception {
		String url = "https://stackoverflow.com/questions/2835505";
		Document document = Jsoup.connect(url).get();

		String question = document.select("#question .post-text").text();
		System.out.println("Question: " + question);
		
		System.out.println("--------------------------------------");
		
		Elements answerers = document.select("#answers .user-details a");
		for (Element answerer : answerers) {
			System.out.println("Answerer: " + answerer.text());
		}
		
		System.out.println("--------------------------------------");
		
		Elements karmas = document.select("#answers .vote > span.vote-count-post");
		for (Element karma : karmas) {
			System.out.println("Karma: " + karma.text());
		}
	}
}
