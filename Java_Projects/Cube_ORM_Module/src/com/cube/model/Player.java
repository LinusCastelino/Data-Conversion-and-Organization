package com.cube.model;

public class Player {
	
	//Instance variables
	private int playerId;
	private String name;
	private int age;
	private String team;
	
	/**
	 * Getter for playerr id
	 * @return playerId
	 */
	public int getPlayerId(){
		return playerId;
	}
	
	/**
	 * Setter for player id
	 * @param pPlayerId
	 */
	public void setPlayerID(int pPlayerId){
		this.playerId = pPlayerId;
	}
	/**
	 * Getter for player name
	 * @return name
	 */
	public String getPlayerName() {
		return name;
	}
	
	/**
	 * Setter for player name
	 * @param name
	 */
	public void setPlayerName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for player age
	 * @return age
	 */
	public int getPlayerAge() {
		return age;
	}
	
	/**
	 * Setter for player age
	 * @param age
	 */
	public void setPlayerAge(int age) {
		this.age = age;
	}
	
	/**
	 * Getter for player team
	 * @return team
	 */
	public String getPlayerTeam() {
		return team;
	}
	
	/**
	 * Setter for player team
	 * @param team
	 */
	public void setPlayerTeam(String team) {
		this.team = team;
	}
	
}
