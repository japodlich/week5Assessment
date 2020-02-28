package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="game_shopper")
public class GameShopper 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SHOPPER_ID")
	private int id;
	@Column(name="SHOPPER_NAME")
	private String shopperName;
	
	public GameShopper() {
		super();
	}

	public GameShopper(int id, String shopperName) {
		super();
		this.id = id;
		this.shopperName = shopperName;
	}

	public GameShopper(String shopperName) {
		super();
		this.shopperName = shopperName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShopperName() {
		return shopperName;
	}

	public void setShopperName(String shopperName) {
		this.shopperName = shopperName;
	}

	@Override
	public String toString() {
		return "GameShopper [id=" + id + ", shopperName=" + shopperName + "]";
	}
	
	
	
}
