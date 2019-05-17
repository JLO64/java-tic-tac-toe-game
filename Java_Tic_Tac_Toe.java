//Made by Julian Lopez

import java.io.*;
import java.util.*;

public class Java_Tic_Tac_Toe
{
	private static String [][] gameboard = new String [3][3];

  public static void main(String[] args)
  {
		setBoard();
		printBoard();
		String winner = aiGame();
		System.out.println(winner + " wins");
  }

  public static void setBoard()
  {
    for(int i = 0; i < gameboard.length; i++)
    {
      for(int j = 0; j < gameboard[0].length; j++)
      {
        gameboard[i][j] = " ";
      }
    }
  }

  public static void printBoard()
  {
    for(int i = 0; i < 7; i++)
    {
      System.out.print("-");
    }

    System.out.println();
    for(int i = 0; i < gameboard.length; i++)
    {
      for(int j = 0; j < gameboard[0].length; j++)
      {
        System.out.print("|" + gameboard[i][j]);
      }
      System.out.println("|");
    }

    for(int i = 0; i < 7; i++)
    {
      System.out.print("-");
		}
		System.out.println();
  }

  public static void playerMove()
  {
		Scanner Coord = new Scanner(System.in);
		boolean confirm = false;

		int xCoord = 0;
		int yCoord = 0;

		while(confirm == false)
		{
			System.out.print("What X coordinate (between 0 and 2) do you want to move to? ");
			xCoord = Coord.nextInt();
			while(xCoord > 2)
			{
				System.out.println("  Please enter a value between 0 and 2");
				System.out.print("What X coordinate (between 0 and 2) do you want to move to? ");
				xCoord = Coord.nextInt();
			}

    	System.out.print("What Y coordinate (between 0 and 2) do you want to move to? ");
			yCoord = Coord.nextInt();
			while(yCoord > 2)
			{
				System.out.println("  Please enter a value between 0 and 2");
				System.out.print("What Y coordinate (between 0 and 2) do you want to move to? ");
				yCoord = Coord.nextInt();
			}
			confirm = isEmpty(xCoord, yCoord);
			if(confirm == false)
				System.out.println("  Please enter in coordinates that are not taken");
		}
		boardMove(xCoord, yCoord, "X");
	}

	public static void aiMove()
	{
		Random randCoord = new Random();
		boolean confirm = false;
		int xCoord = 0;
		int yCoord = 0;

		while(confirm == false)
		{
			xCoord = randCoord.nextInt(3);
			yCoord = randCoord.nextInt(3);
			confirm = isEmpty(xCoord, yCoord);
		}
		boardMove(xCoord, yCoord, "O");		
	}
	
  public static void boardMove(int X, int Y, String player)
  {
    gameboard[Y][X] = player;
  }

	public static String aiGame()
	{
		boolean win = false;
		boolean moves = true;
		String whoWon = "";

		while( win == false && moves == true )
		{
			playerMove();
			win = ifWon("X");
			if(win == true)
			{
				printBoard();
				whoWon = "player";
				return whoWon;
			}			
			moves = canMove();
			if( win == false && moves == true )
			{
				aiMove();
				moves = canMove();
			}
			printBoard();
		}
		whoWon = "nobody";
		return whoWon;
	}

	public static boolean canMove()
	{
		for(int i = 0; i < gameboard.length; i++)
    {
      for(int j = 0; j < gameboard[0].length; j++)
      {
				if(isEmpty(i, j))
					return true;
      }
		}
		return false;
	}

	public static boolean isEmpty(int X, int Y)
	{
		if(gameboard[Y][X].equals(" "))
		{
			return true;
		}
		return false;
	}
	public static boolean ifWon(String player)
	{
		for(int i = 0; i < gameboard.length; i++)
    {
			if( gameboard[i][0].equals(player) && gameboard[i][1].equals(player) && gameboard[i][2].equals(player) )
				return true;
		}
		for(int j = 0; j < gameboard[0].length; j++)
    {
			if( gameboard[0][j].equals(player) && gameboard[1][j].equals(player) && gameboard[2][j].equals(player) )
				return true;
		}

		return false;
	}
}
