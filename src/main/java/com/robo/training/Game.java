package com.robo.training;

import com.robo.training.constant.ePlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Game class which manages board, players, check whether a player wins or not
 *
 * @author  Vu Nguyen
 */
public class Game {
        private final Logger logger = LoggerFactory.getLogger(Game.class);
        private Board board;
        private int turn = 1, whoTurns = 1;
        private Player player1;
        private Player player2;

        public Game() {
            board = new Board();
            startPlayers();

            while (gameNotOver());
        }
        public Game(Board board) {
            this.board = board;
            startPlayers();

        }
        public Player getPlayer1() {
            return player1;
        }
        public Player getPlayer2() {
            return player2;
        }
        public Board getBoard() {
            return board;
        }
        public void  setBoard(Board board) {
            this.board = board;
        }
        public void startPlayers() {
            this.player1 = new Player(ePlayer.Player1);
            this.player2 = new Player(ePlayer.Player2);
        }

        public boolean gameNotOver() {
            board.showBoard();
            if (winner() == ePlayer.None) {
                logger.info("----------------------");
                logger.info("\nTurn " + turn);
                logger.info("It's turn of Player " + whoTurns());

                if (whoTurns() == 1)
                    player1.play(board);
                else
                    player2.play(board);

                if (board.itsADraw()) {
                    logger.info("Draw!");
                    return false;
                }
                if (whoTurns == 1) whoTurns=2;
                else whoTurns=1;
                turn++;

                return true;
            } else {
                if (winner() == ePlayer.Player1)
                    logger.info("Player 1 won!");
                else
                    logger.info("Player 2 won!");

                return false;
            }

        }

        public int whoTurns() {
            if (whoTurns == 1)
                return 1;
            else
                return 2;
        }

        public ePlayer winner() {
            if (board.checkLines() == 1)
                return ePlayer.Player2;
            if (board.wonInColumns() == 1)
                return ePlayer.Player2;
            if (board.wonInDiagonals() == 1)
                return ePlayer.Player2;

            if (board.checkLines() == -1)
                return ePlayer.Player1;
            if (board.wonInColumns() == -1)
                return ePlayer.Player1;
            if (board.wonInDiagonals() == -1)
                return ePlayer.Player1;

            return ePlayer.None;
        }

    }
