import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.ShopperHelper;
import model.GameShopper;
import model.ListDetails;
import model.ListGame;

public class ShoppingTester {

	public static void main(String[] args) 
	{
		GameShopper susan = new GameShopper("Susan");
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListGame action = new ListGame("Action", "10.99");
		ListGame fun = new ListGame("Fun", "12.99");
		List<ListGame> susansGames = new ArrayList<ListGame>();
		susansGames.add(action);
		susansGames.add(fun);
		ListDetails susansList = new ListDetails("Susan's GameList", LocalDate.now(), susan);
		susansList.setListOfGames(susansGames);
		ldh.insertNewListDetails(susansList);
		
		List<ListDetails> allLists = ldh.getLists();
				
		for(ListDetails a: allLists) 
		{
			System.out.println(a.toString());
		}
		
		//ListDetailsHelper.deleteListDetails(susansList);
		
		for(ListDetails a: allLists) 
		{
			System.out.println(a.toString());
		}
		
	}

}
