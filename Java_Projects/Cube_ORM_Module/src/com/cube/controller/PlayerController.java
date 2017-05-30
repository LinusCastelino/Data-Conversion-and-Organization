package com.cube.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.cube.model.Player;

public class PlayerController {
	
	private final String Connection_URL="jdbc:oracle:thin:TRUK_CORE/toys#123@localhost:1521:JOND";
	
	/**
	 * ORM method to create a player in the database
	 * @param pPlayer
	 * @return
	 */
	public void createPlayer(Player pPlayer){
		Connection conn=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try{
				conn = DriverManager.getConnection(Connection_URL);
			}
			catch(Exception e){
				System.out.println("Could not connect to database");
			}
			Statement stmt= conn.createStatement();
			String query= "insert into TRUK_CORE.Player values("+pPlayer.getPlayerId()+",'"+pPlayer.getPlayerName()+"',"+pPlayer.getPlayerAge()+",'"+pPlayer.getPlayerTeam()+"')";
			
			stmt.executeUpdate(query);
			System.out.println("\n***Created player "+pPlayer.getPlayerName()+" in database ");

			conn.close();
		}
		catch(Exception e){
			System.out.println("Unable to create player");
			System.out.println(e.getMessage() +"\n"+ e.getStackTrace()+e);
		}
		
	}    //createPlayer()
	
	/**
	 * ORM method to find player using player  Id
	 * @param playerId
	 * @return Player
	 */
	public Player findPlayer(int playerId){
		Player player= new Player();
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn=null;
			try{
				conn = DriverManager.getConnection(Connection_URL);
			}
			catch(Exception e){
				System.out.println("Could not connect to database");
			}
			Statement stmt= conn.createStatement();
			String query= "Select playerid, name, age, team from TRUK_CORE.Player where playerid="+playerId;
			ResultSet rs= stmt.executeQuery(query);
			
			if(rs !=null){
				while(rs.next()){
					player.setPlayerID(rs.getInt("playerid"));
					player.setPlayerName(rs.getString("name"));
					player.setPlayerAge(rs.getInt("age"));
					player.setPlayerTeam(rs.getString("team"));
				}
			}
			
			rs.close();
			conn.close();
		}
		catch(Exception e){
			System.out.println("Error encountered while finding player");
			System.out.println(e.getMessage() +"\n"+ e.getStackTrace());
		}
		return player;
	}    //findPlayer()
}    //PlayerController
