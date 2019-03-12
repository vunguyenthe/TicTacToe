package com.robo.training;

import com.robo.training.constant.ePlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
/**
 * A Player class which can try to set and check an attempt from specific player
 *
 * @author  Vu Nguyen
 */
public class Player {

    private final Logger logger = LoggerFactory.getLogger(Player.class);
    public Scanner date = new Scanner(System.in);

     protected int[] attempt = new int[2];
     protected ePlayer player;

     public Player(ePlayer player) {
         this.player = player;
     }

     public boolean checkTry(int[] attempt, Board board) {
         if (board.getPosition(attempt) == 0)
             return true;
         else
         return false;

        }

    public void play(Board board){
        Try(board);
        board.setPosition(attempt, player);
    }

    public void Try(Board board){
        do{
            do{
                logger.info("Line [1..3]: ");
                attempt[0] = date.nextInt();

                if( attempt[0] > 3 ||attempt[0] < 1) {
                    logger.info("Invalid line. It's 1, 2 or 3");
                }

            }while( attempt[0] > 3 ||attempt[0] < 1);

            do{
                logger.info("Column [1..3]: ");
                attempt[1] = date.nextInt();

                if(attempt[1] > 3 ||attempt[1] < 1)
                    logger.info("Invalid column. É 1, 2 or 3");

            }while(attempt[1] > 3 ||attempt[1] < 1);

            attempt[0]--;
            attempt[1]--;

            if(!checkTry(attempt, board))
                logger.info("Placed already marked. Try other.");
        }while( !checkTry(attempt, board) );
    }
}

