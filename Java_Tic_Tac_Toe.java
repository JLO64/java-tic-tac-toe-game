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
		playerMove();
		printBoard();
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
  }

  public static void playerMove()
  {
    Scanner Coord = new Scanner(System.in);

    System.out.print("What X coordinate (between 0 and 2) do you want to move to? ");
    int xCoord = Coord.nextInt();
    System.out.print("What Y coordinate (between 0 and 2) do you want to move to? ");
    int yCoord = Coord.nextInt();

		boardMove(xCoord, yCoord);
	}
	
  public static void boardMove(int X, int Y)
  {
    gameboard[X][Y] = "X";
  }

}
