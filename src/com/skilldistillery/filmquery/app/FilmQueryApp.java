package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);
		userMenu(input);
		input.close();
	}

	private void userMenu(Scanner input) throws SQLException {
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("=============== MENU ===============");
			System.out.println("1. Look up a Film by its Film ID");
			System.out.println("2. Look up a Film by a search keyword");
			System.out.println("3. Exit the application");
			System.out.println("====================================");
			System.out.print("Select from the menu above: ");
			keepGoing = menuSelection(input);
		}
	}

	public boolean menuSelection(Scanner input) throws SQLException {
		try {
			int userInput = input.nextInt();
			switch (userInput) {
			case 1:
				System.out.print("Please enter in a Film ID: ");
				userInput = input.nextInt();
				Film findFilmById = db.findFilmById(userInput);
				if (findFilmById == null) {
					System.out.println("SORRY no Films with that ID");
				} else {
					findFilmById.displayFilmDetails();
				}
				break;
			case 2:
				System.out.print("Please enter in a keyword: ");
				String strInput = input.next();
				List<Film> findActorsBySearch = db.findFilmsBySearch(strInput);

				if (findActorsBySearch.isEmpty()) {
					System.out.println("SORRY no Films with that name, Please try again!");
				} else {
					for (Film f : findActorsBySearch) {
						f.displayFilmDetails();
					}
				}
				break;
			case 3:
				System.out.println("Goodbye");
				return false;
			default:
				System.out.println("Sorry thats not a valid Entry, Select 1-3");

			}

		} catch (InputMismatchException e) {
			System.err.println("Not a valid Entry");
			input.nextLine();
		}
		return true;
	}

}
