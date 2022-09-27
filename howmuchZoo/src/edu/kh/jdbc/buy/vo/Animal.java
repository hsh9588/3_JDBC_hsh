package edu.kh.jdbc.buy.vo;

public class Animal {
	
	private int Ranking;
	private String animalType;
	private String sellDate;
	private int point;
	private int price;
	
	public void Animal() {}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getSellDate() {
		return sellDate;
	}

	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRanking() {
		return Ranking;
	}

	public void setRanking(int ranking) {
		Ranking = ranking;
	}

}
