package com.revature.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.beans.Hero;

public class HeroDAOImplStatic implements HeroDAO {
	
	private static Map<Integer, Hero> heroesMap = new HashMap<>();

	@Override
	public Hero createHero(Hero hero) {
		hero.setId(heroesMap.size() + 1);
		heroesMap.put(hero.getId(), hero);
		return hero;
	}

	@Override
	public List<Hero> getAllHeroes() {
		return new ArrayList<>(heroesMap.values());
	}

	@Override
	public void updateHero(Hero hero) {
		heroesMap.put(hero.getId(), hero);
	}

	@Override
	public void deleteHero(Hero hero) {
		heroesMap.remove(hero.getId());
	}

}
