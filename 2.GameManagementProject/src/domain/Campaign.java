package domain;

public class Campaign {
	
	private long id;
	private String name;
	private String description;
	private int discountRate;
	
	public Campaign(String name, String description, int discountRate) {
		this.name = name;
		this.description = description;
		this.discountRate = discountRate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	
	
	

}
