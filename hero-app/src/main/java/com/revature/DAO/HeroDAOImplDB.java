package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Hero;

public class HeroDAOImplDB implements HeroDAO {

	private Connection conn;

	public HeroDAOImplDB() throws SQLException {
		this.conn = ConnectionFactory.getConnection();
	}
	
	public Connection getDBConnection() {
		return this.conn;
	}

	@Override
	public Hero createHero(Hero hero) {
		String sql = "INSERT INTO Hero(hero_name, hero_level, hero_class)" + " VALUES (?,?,?)";
		String[] primaryKeys = { "hero_id" };
		try {
			PreparedStatement stmnt = conn.prepareStatement(sql, primaryKeys);
			stmnt.setString(1, hero.getName());
			stmnt.setInt(2, hero.getLevel());
			stmnt.setString(3, hero.getHeroClass());

			stmnt.executeUpdate();
			ResultSet rs = stmnt.getGeneratedKeys();
			while (rs.next()) {
				hero.setId(rs.getInt(1));
			}
			return hero;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Hero> getAllHeroes() {
		try {
			String sql = "SELECT * FROM Hero";
			ResultSet results = conn.prepareStatement(sql).executeQuery();
			List<Hero> heroes = new ArrayList<>();
			while(results.next()) {
				heroes.add(new Hero(results.getInt("hero_id"),
						results.getString("hero_name"),
						results.getInt("hero_level"),
						results.getString("hero_class")));
			}
			return heroes;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateHero(Hero hero) {
		String sql = "UPDATE Hero"
				+ "SET hero_name = ?, hero_level = ?, hero_class = ?"
				+ "WHERE hero_id = ?";
		try {
			PreparedStatement stmnt = conn.prepareStatement(sql);
			stmnt.setString(1, hero.getName());
			stmnt.setInt(2, hero.getLevel());
			stmnt.setString(3, hero.getHeroClass());
			stmnt.setInt(4, hero.getId());

			int rowsUpdated = stmnt.executeUpdate();
			System.out.println("Heroes updated: " + rowsUpdated);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteHero(Hero hero) {
		System.out.println("Not yet available!");
	}

}
