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
    aiGame();
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

    	System.out.print("What Y coordinate (between 0 and 2) do you wat to move to? ");
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

	}
	
  public static void boardMove(int X, int Y, String player)
  {
    gameboard[Y][X] = player;
  }

	public static boolean aiGame()
	{
		boolean win = false;
		boolean moves = true;
		while( win == false && moves == true )
		{
			playerMove();
			printBoard();
			moves = canMove();
			if( win == false && moves == true )
			{

			}
		}
		return win;
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

}
