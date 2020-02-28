package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="list_details")
public class ListDetails 
{
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name="LIST_ID")
	private int id; 
	@Column(name="LIST_NAME")
	private String listName; 
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="SHOPPER_ID")  
	private GameShopper shopper; 
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
		(
			name="games_on_list",joinColumns={ @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },inverseJoinColumns={ @JoinColumn(name="GAME_ID", referencedColumnName="ID", unique=true) }
		)
	private List<ListGame> listOfGames;
	
	public ListDetails() {
		super();
	}

	public ListDetails(int id, String listName, LocalDate createdDate, GameShopper shopper, List<ListGame> listOfGames) {
		super();
		this.id = id;
		this.listName = listName;
		this.createdDate = createdDate;
		this.shopper = shopper;
		this.listOfGames = listOfGames;
	}

	public ListDetails(String listName, LocalDate createdDate, GameShopper shopper, List<ListGame> listOfGames) {
		super();
		this.listName = listName;
		this.createdDate = createdDate;
		this.shopper = shopper;
		this.listOfGames = listOfGames;
	}

	public ListDetails(String listName, LocalDate createdDate, GameShopper shopper) {
		super();
		this.listName = listName;
		this.createdDate = createdDate;
		this.shopper = shopper;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public GameShopper getShopper() {
		return shopper;
	}

	public void setShopper(GameShopper shopper) {
		this.shopper = shopper;
	}

	public List<ListGame> getListOfGames() {
		return listOfGames;
	}

	public void setListOfGames(List<ListGame> listOfGames) {
		this.listOfGames = listOfGames;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", createdDate=" + createdDate + ", shopper=" + shopper
				+ ", listOfGames=" + listOfGames + "]";
	}
	
	
	
	
	
}
