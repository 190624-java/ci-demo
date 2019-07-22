package com.revature.beans;

public class Hero {

	private int id;
	private String name;
	private int level;
	private String heroClass;
	
	public Hero() {}
	
	public Hero(int id, String name, int level, String heroClass) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.heroClass = heroClass;
	}
	
	public Hero(String name, int level, String heroClass) {
		this.id = -1;
		this.name = name;
		this.level = level;
		this.heroClass = heroClass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getHeroClass() {
		return heroClass;
	}

	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
	}
	
}
