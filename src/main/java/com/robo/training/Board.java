package com.robo.training;

import com.robo.training.constant.ePlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * A Board class which simulate a matrix 3x3 and store information about the positions of players
 *
 * @author  Vu Nguyen
 */
public class Board {

        private final Logger logger = LoggerFactory.getLogger(Board.class);

        private int[][] dataGrid = new int[3][3];

        public Board() {
            clearBoard();
        }

        public void clearBoard() {
            for (int line = 0; line < 3; line++)
                for (int column = 0; column < 3; column++)
                    dataGrid[line][column] = 0;
        }

        public void showBoard() {
            System.out.println();
            for (int line = 0; line < 3; line++) {

                for (int column = 0; column < 3; column++) {

                    if (dataGrid[line][column] == -1) {
                        System.out.print(" X ");
                    }
                    if (dataGrid[line][column] == 1) {
                        System.out.print(" O ");
                    }
                    if (dataGrid[line][column] == 0) {
                        System.out.print("   ");
                    }

                    if (column == 0 || column == 1)
                        System.out.print("|");
                }
                System.out.println();
            }

        }

        public int getPosition(int[] attempt) {
            return dataGrid[attempt[0]][attempt[1]];
        }
        public boolean checkTry(int[] attempt, Board board) {
            if (board.getPosition(attempt) == 0)
                return true;
            else
                return false;

        }
        public boolean setPosition(int[] attempt, ePlayer player) {
            if(attempt[0] < 1 || attempt[0] > 3) {
                logger.warn("Invalid line {}, only [1..3] ", attempt[0]);
                return false;
            }
            if(attempt[1] < 1 || attempt[1] > 3) {
                logger.warn("Invalid column {}, only [1..3] ", attempt[1]);
                return false;
            }
            attempt[0]--;
            attempt[1]--;
            if (player == ePlayer.Player1)
                dataGrid[attempt[0]][attempt[1]] = -1;
            else
                dataGrid[attempt[0]][attempt[1]] = 1;
            return true;
        }

        public int checkLines() {
            for (int line = 0; line < 3; line++) {

                if ((dataGrid[line][0] + dataGrid[line][1] + dataGrid[line][2]) == -3)
                    return -1;
                if ((dataGrid[line][0] + dataGrid[line][1] + dataGrid[line][2]) == 3)
                    return 1;
            }

            return 0;

        }

        public int wonInColumns() {
            for (int column = 0; column < 3; column++) {

                if ((dataGrid[0][column] + dataGrid[1][column] + dataGrid[2][column]) == -3)
                    return -1;
                if ((dataGrid[0][column] + dataGrid[1][column] + dataGrid[2][column]) == 3)
                    return 1;
            }

            return 0;

        }

        public int wonInDiagonals() {
            if ((dataGrid[0][0] + dataGrid[1][1] + dataGrid[2][2]) == -3)
                return -1;
            if ((dataGrid[0][0] + dataGrid[1][1] + dataGrid[2][2]) == 3)
                return 1;
            if ((dataGrid[0][2] + dataGrid[1][1] + dataGrid[2][0]) == -3)
                return -1;
            if ((dataGrid[0][2] + dataGrid[1][1] + dataGrid[2][0]) == 3)
                return 1;

            return 0;
        }

        public boolean itsADraw() {
            for (int line = 0; line < 3; line++)
                for (int column = 0; column < 3; column++)
                    if (dataGrid[line][column] == 0)
                        return false;
            return true;
        }
    }

