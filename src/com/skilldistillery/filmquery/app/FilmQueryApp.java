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
		Film film = db.findFilmById(4);
		System.out.println(film);

	}

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);

		userMenu(input);

		input.close();
	}

	private void userMenu(Scanner input) throws SQLException {
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("1. Look up a film by its id");
			System.out.println("2. Look up a film by a search keyword");
			System.out.println("3. Exit the application");
			int userInput = input.nextInt();

			switch (userInput) {
			case 1:
				System.out.println("Please enter in a Film ID: ");
				userInput = input.nextInt();
				Film findFilmById = db.findFilmById(userInput);
				if (findFilmById == null) {
					System.out.println("SORRY no films with that ID");
				} else {
					findFilmById.displayFilmDetails();
				}
				break;
			case 2:
				System.out.println("Please enter in a keyword: ");
				String strInput = input.next();
				List<Film> findActorsBySearch = db.findFilmsBySearch(strInput);
				
				if (findActorsBySearch.isEmpty()) {
					System.out.println("SORRY no films with that name");
				} else {
					for (Film f : findActorsBySearch) {
						f.displayFilmDetails();
					}
				}
				break;
			case 3:
				System.out.println("Goodbye");
				keepGoing = false;
				break;
			default:
				keepGoing = false;
			}
		}
		keepGoing = true;
	}

}
