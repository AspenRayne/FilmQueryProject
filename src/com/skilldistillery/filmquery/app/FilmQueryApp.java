package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.test();
		app.launch();
	}

	private void test() throws SQLException {
		Film film = db.findFilmById(1);
		System.out.println(film);

	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		System.out.println("Please enter in a Film ID: ");
		int userInput = input.nextInt();
		List<Actor> findActorsByFilmId = db.findActorsByFilmId(userInput);
		System.out.println(findActorsByFilmId);
		
//		System.out.println("Please enter in a keyword: ");
//		String strInput = input.next();
//		List<Actor> findActorsBySearch = db.findActorsBySearch(strInput);
//		System.out.println(findActorsBySearch);
	}

}
