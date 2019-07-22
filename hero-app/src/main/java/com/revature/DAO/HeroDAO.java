package com.revature.DAO;

import java.util.List;

import com.revature.beans.Hero;

public interface HeroDAO {

	Hero createHero(Hero hero);
	List<Hero> getAllHeroes();
	void updateHero(Hero hero);
	void deleteHero(Hero hero);
	
	
}
