package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Games")

public class ListGame 
{
	@Id
	@GeneratedValue(strategy=GenerationType. IDENTITY )
	@Column(name="ID")
	private int id;
	@Column(name="TYPE") 
	private String type;
	@Column(name="PRICE")
	private String price;

	public ListGame() {
		super();
	}
	

	public ListGame(String type, String price) {
		super();
		this.type = type;
		this.price = price;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String returnGameDetails()
	{
		return ("Type of game: " + type + " --- " + "Price of game: " + price);
	}
	
}
