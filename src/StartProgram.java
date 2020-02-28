

import java.util.List;
import java.util.Scanner;

import controller.ListGameHelper;
import model.ListGame;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListGameHelper lgh = new ListGameHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a type of game: ");
			String type = in.nextLine();
			System.out.print("Enter a price of a game: ");
			String price = in.nextLine();
			
			ListGame toAdd = new ListGame(type, price);
			lgh.insertGame(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the type of game to delete: ");
			String type = in.nextLine();
			System.out.print("Enter the price of a game to delete: ");
			String price = in.nextLine();
			
			ListGame toDelete = new ListGame(type, price);
			lgh.deleteGame(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Game type");
			System.out.println("2 : Search by Game price");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListGame> foundGames;
			if (searchBy == 1) {
				System.out.print("Enter the game type: ");
				String typeName = in.nextLine();
				foundGames = lgh.searchForGameByType(typeName);
			} else {
				System.out.print("Enter the game price: ");
				String priceName = in.nextLine();
				foundGames = lgh.searchForGameByPrice(priceName);

			}

			if (!foundGames.isEmpty()) {
				System.out.println("Found Results.");
				for (ListGame l : foundGames) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListGame toEdit = lgh.searchForGameById(idToEdit);
				System.out.println("Retrieved " + toEdit.getPrice() + " from " + toEdit.getType());
				System.out.println("1 : Update Type of game");
				System.out.println("2 : Update Price of game");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Type of game: ");
					String newType = in.nextLine();
					toEdit.setType(newType);
				} else if (update == 2) {
					System.out.print("New Price of game: ");
					String newPrice = in.nextLine();
					toEdit.setPrice(newPrice);
				}

				lgh.updateGame(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our game list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a game");
				System.out.println("*  2 -- Edit a game");
				System.out.println("*  3 -- Delete a game");
				System.out.println("*  4 -- View the list of games");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lgh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListGame> allGames = lgh.showAllGames();
			for (ListGame singleItem : allGames)
			{
				System.out.println(singleItem.toString());
			}
			

		}

	}
