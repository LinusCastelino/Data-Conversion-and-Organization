package com.cube.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.cube.model.Player;
import com.cube.controller.PlayerController;

public class MainActivity {
	
	public static void main(String ...a){
		
		try{			
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
			PlayerController pc = new PlayerController();
			int cont;
			
			System.out.println("*****Cube ORM*****");

			do{
				System.out.println();
				System.out.println("Press 1. to create a player");
				System.out.println("Press 2. to find a player using Id");

				int input = Integer.parseInt(br.readLine());
				
				switch(input){
				
				case 1:
					Player p1= new Player();
					System.out.println("\nEnter player details:-");
					System.out.println("Player Id :\t");
					p1.setPlayerID(Integer.parseInt(br.readLine()));
					System.out.println("Player name :\t");
					p1.setPlayerName(br.readLine());
					System.out.println("Player age :\t");
					p1.setPlayerAge(Integer.parseInt(br.readLine()));
					System.out.println("Player team :\t");
					p1.setPlayerTeam(br.readLine());
					pc.createPlayer(p1);
					break;
				case 2:
					System.out.print("Please enter player id :\t");
					int pId = Integer.parseInt(br.readLine());
					Player p2 = pc.findPlayer(pId);
					System.out.println("\nPlayer information:-");
					printPlayerInfo(p2);
					break;
				default:
					System.out.println("Please enter a valid input");
				}    //switch case
				System.out.println("\nPress 1 to continue");
				cont= Integer.parseInt(br.readLine());
			}while(cont==1);	
			System.out.println("\nFin!");
		}
		catch(Exception e){
			System.out.println("Error in processing in main() :"+e);
		}
	}    //main()
	
	/**
	 * Method to print player information
	 * @param player
	 */
	public static void printPlayerInfo(Player player){
		
		System.out.println("Player id :\t"+player.getPlayerId());
		System.out.println("Name :\t"+player.getPlayerName());
		System.out.println("Age :\t"+player.getPlayerAge());
		System.out.println("Team :\t"+player.getPlayerTeam());
		
	}    //printPlayerInfo()
	
	

}



/*
create table TRUK_CORE.Player (playerid number(3) NOT NULL PRIMARY KEY , name varchar(30), age number(3), team varchar(20));

desc TRUK_CORE.Player;

Select * from TRUK_CORE.Player;
 */