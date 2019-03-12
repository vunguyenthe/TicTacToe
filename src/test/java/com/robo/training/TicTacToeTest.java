package com.robo.training;

import com.robo.training.constant.ePlayer;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A TicTacToeTest class which try to verify some test cases to make sure the app works perfectly
 *
 * @author  Vu Nguyen
 */
public class TicTacToeTest extends TestCase {
	private final Logger logger = LoggerFactory.getLogger(TicTacToeTest.class);
	// assigning the values
	Game game = null;
	Board board = null;
	protected void setUp(){
		System.out.println("init");
		Board board = new Board();
		game = new Game(board);
	}
	/**
	 * testInvalidAttempColumn
	 * Expected: the function return false when validation
	 */
	@Test
	public void testInvalidAttempColumn(){
		int[] attempt = new int[3];
		Board board = game.getBoard();
		board.clearBoard();
		attempt[0] = 1;
		attempt[1] = 0;
		boolean ret = board.setPosition(attempt, ePlayer.Player1);
		assertTrue(ret == false);
	}
	/**
	 * testPlaceAlreadyMarked
	 * Expected: the position is rejected b/c it is marked
	 */
	@Test
	public void testPlaceAlreadyMarked(){
		int[] attempt = new int[3];
		Board board = game.getBoard();
		board.clearBoard();
		attempt[0] = 1;
		attempt[1] = 1;
		board.setPosition(attempt, ePlayer.Player1);
		boolean ret = board.checkTry(attempt, board);
		assertTrue(ret == false);
	}
	@Test
	/**
	 * testPayer1WonInDiagonals
	 *
	 * data input: (player 1 marked X)
	 * 		 X | O | O
	 * 		   | X |
	 * 		   |   | X
	 * expected: Player 1 won
	 */
	public void testPayer1WonInDiagonals(){
		int[] attempt = new int[3];
		Board board = game.getBoard();
		board.clearBoard();
		attempt[0] = 1;
		attempt[1] = 1;
		board.setPosition(attempt, ePlayer.Player1);
		attempt[0] = 1;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player2);

		attempt[0] = 2;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player1);

		attempt[0] = 0;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player2);

		attempt[0] = 3;
		attempt[1] = 3;
		board.setPosition(attempt, ePlayer.Player1);

		ePlayer winner = game.winner();
		board.showBoard();
		System.out.println("winner: " + winner.toString());
		assertTrue(winner == ePlayer.Player1);
	}
	/**
	 * testPayer2WonInDiagonals
	 *
	 * data input: (player 1 marked X, player 2 - O)
	 * 		 O | X | X
	 * 		 X | O | X
	 * 		   |   | O
	 * expected: Player 2 won
	 */
	@Test
	public void testPayer2WonInDiagonals(){
		int[] attempt = new int[3];
		Board board = game.getBoard();
		board.clearBoard();
		// player 1 -> (1 , 2)
		attempt[0] = 1;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player1);
		//Turn  player 2 -> (0 , 0)
		attempt[0] = 1;
		attempt[1] = 1;
		board.setPosition(attempt, ePlayer.Player2);
		//Turn Player1 -> (1, 3)
		attempt[0] = 1;
		attempt[1] = 3;
		board.setPosition(attempt, ePlayer.Player1);
		// player 2 -> (2 , 2)
		attempt[0] = 2;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player2);
		//Turn  player 1 -> (2 , 3)
		attempt[0] = 2;
		attempt[1] = 3;
		board.setPosition(attempt, ePlayer.Player1);
		//Turn  player 2 -> (3 , 3)
		attempt[0] = 3;
		attempt[1] = 3;
		board.setPosition(attempt, ePlayer.Player2);
		ePlayer winner = game.winner();
		board.showBoard();
		System.out.println("winner: " + winner.toString());
		assertTrue(winner == ePlayer.Player2);
	}
	/**
	 * testPayer1WonInColumns
	 *
	 * data input: (player 1 marked X, player 2 - O)
	 * 		 X | X | X
	 * 		 O | O | X
	 * 		 O | X | O
	 * expected: Player 1 won
	 */
	@Test
	public void testPayer1WonInColumns(){
		int[] attempt = new int[3];
		Board board = game.getBoard();
		board.clearBoard();
		//player 1 -> (1 , 1), (1 , 2), (3 , 2), (2 , 3), (1 , 3) -> Won
		//player 2 -> (2 , 1), (3 , 1), (2 , 2), (3 , 3)
		//player 1 -> (1 , 1),
		attempt[0] = 1;
		attempt[1] = 1;
		board.setPosition(attempt, ePlayer.Player1);
		//Turn player 2 -> (2 , 1),
		attempt[0] = 2;
		attempt[1] = 1;
		board.setPosition(attempt, ePlayer.Player2);
		//Turn player 1 -> (1 , 2),
		attempt[0] = 1;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player1);
		//Turn player 2 -> (3 , 1),
		attempt[0] = 3;
		attempt[1] = 1;
		board.setPosition(attempt, ePlayer.Player2);
		//Turn player 1 -> (3 , 2),
		attempt[0] = 3;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player1);
		//Turn player 2 -> (2 , 2),
		attempt[0] = 2;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player2);
		//Turn player 1 -> (2 , 3),
		attempt[0] = 2;
		attempt[1] = 3;
		board.setPosition(attempt, ePlayer.Player1);
		//Turn player 2 -> (3 , 3),
		attempt[0] = 3;
		attempt[1] = 3;
		board.setPosition(attempt, ePlayer.Player2);
		//Turn player 1 -> (1 , 3),
		attempt[0] = 1;
		attempt[1] = 3;
		board.setPosition(attempt, ePlayer.Player1);
		ePlayer winner = game.winner();
		board.showBoard();
		System.out.println("winner: " + winner.toString());
		assertTrue(winner == ePlayer.Player1);
	}
	/**
	 * testPayer2WonInColumns
	 *
	 * data input: (player 1 marked X, player 2 - O)
	 * 		 X | X | O
	 * 		 O | X | O
	 * 		 X | O | O
	 * expected: Player 2 won
	 */
	@Test
	public void testPayer2WonInColumns(){
		int[] attempt = new int[3];
		Board board = game.getBoard();
		board.clearBoard();
		//Player2 -> (1 , 3), (2 , 1), (3 , 2), (3 , 3), (2 , 3)
		//Player1 -> (1 , 1), (1 , 2), (2 , 2), (3 , 1)
		//Player2 goes first
		//Player2 -> (1 , 1),
		attempt[0] = 1;
		attempt[1] = 3;
		board.setPosition(attempt, ePlayer.Player2);
		//Turn Player1 -> (1 , 1),
		attempt[0] = 1;
		attempt[1] = 1;
		board.setPosition(attempt, ePlayer.Player1);
		//Player2 -> (2 , 1),
		attempt[0] = 2;
		attempt[1] = 1;
		board.setPosition(attempt, ePlayer.Player2);
		//Turn Player1 -> (1 , 2),
		attempt[0] = 1;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player1);
		//Player2 -> (2 , 2),
		attempt[0] = 3;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player2);
		//Turn Player1 -> (2 , 2),
		attempt[0] = 2;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player1);
		//Player2 -> (3 , 3),
		attempt[0] = 3;
		attempt[1] = 3;
		board.setPosition(attempt, ePlayer.Player2);
		//Turn Player1 -> (3 , 1),
		attempt[0] = 3;
		attempt[1] = 1;
		board.setPosition(attempt, ePlayer.Player1);
		//Player2 -> (2 , 3) -> Won
		attempt[0] = 2;
		attempt[1] = 3;
		board.setPosition(attempt, ePlayer.Player2);
		ePlayer winner = game.winner();
		board.showBoard();
		System.out.println("winner: " + winner.toString());
		assertTrue(winner == ePlayer.Player2);
	}
	/**
	 * testNoAnyPlayerCanWin
	 *
	 * data input: (player 1 marked X, player 2 - O)
	 * 		 X | X | O
	 * 		 O | X | X
	 * 		 X | O | O
	 * expected: No any player can win
	 */
	@Test
	public void testNoAnyPlayerCanWin() {
		int[] attempt = new int[3];
		Board board = game.getBoard();
		board.clearBoard();
		//Player1 -> (1 , 1), (1 , 2), (2 , 2), (2 , 3), (3 , 1)
		//Player2 -> (1 , 3), (2 , 1), (3 , 2), (3 , 3)
		//Player1 goes first
		//Turn Player1 -> (1 , 1),
		attempt[0] = 1;
		attempt[1] = 1;
		board.setPosition(attempt, ePlayer.Player1);
		//Player2 -> (1 , 3),
		attempt[0] = 1;
		attempt[1] = 3;
		board.setPosition(attempt, ePlayer.Player2);

		//Turn Player1 -> (1 , 1),
		attempt[0] = 1;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player1);
		//Player2 -> (1 , 3),
		attempt[0] = 2;
		attempt[1] = 1;
		board.setPosition(attempt, ePlayer.Player2);

		//Turn Player1 -> (2 , 2),
		attempt[0] = 2;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player1);
		//Player2 -> (3 , 2),
		attempt[0] = 3;
		attempt[1] = 2;
		board.setPosition(attempt, ePlayer.Player2);

		//Turn Player1 -> (2 , 3),
		attempt[0] = 2;
		attempt[1] = 3;
		board.setPosition(attempt, ePlayer.Player1);
		//Player2 -> (3 , 3),
		attempt[0] = 3;
		attempt[1] = 3;
		board.setPosition(attempt, ePlayer.Player2);

		//Turn Player1 -> (3 , 1),
		attempt[0] = 3;
		attempt[1] = 1;
		board.setPosition(attempt, ePlayer.Player1);

		ePlayer winner = game.winner();
		board.showBoard();
		if(winner == ePlayer.None) {
			System.out.println("Game over, No any player wins!!!");
		}
		assertTrue(winner != ePlayer.Player2 && winner != ePlayer.Player1);

	}
}

