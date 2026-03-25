package frist.xogame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testInitialBoardNotFull() {
        Board b = new Board();
        assertFalse(b.isFull());
    }

    @Test
    void testIsEmptyValid() {
        Board b = new Board();
        assertTrue(b.isEmpty(1));
    }

    @Test
    void testIsEmptyInvalid() {
        Board b = new Board();
        assertFalse(b.isEmpty(10));
    }

    @Test
    void testRepChar() {
        Board b = new Board();
        Player p = new Player("Ali", 'X');

        assertTrue(b.repChar(1, p));
        assertFalse(b.isEmpty(1));
    }

    @Test
    void testRepCharInvalidMove() {
        Board b = new Board();
        Player p = new Player("Ali", 'X');

        b.repChar(1, p);
        assertFalse(b.repChar(1, p)); // نفس المكان
    }

    @Test
    void testWinRow() {
        Board b = new Board();
        Player p = new Player("Ali", 'X');

        b.repChar(1, p);
        b.repChar(2, p);
        b.repChar(3, p);

        assertTrue(b.isWin(p));
    }

    @Test
    void testWinColumn() {
        Board b = new Board();
        Player p = new Player("Ali", 'X');

        b.repChar(1, p);
        b.repChar(4, p);
        b.repChar(7, p);

        assertTrue(b.isWin(p));
    }

    @Test
    void testWinDiagonal() {
        Board b = new Board();
        Player p = new Player("Ali", 'X');

        b.repChar(1, p);
        b.repChar(5, p);
        b.repChar(9, p);

        assertTrue(b.isWin(p));
    }

    @Test
    void testDrawBoardFull() {
        Board b = new Board();
        Player p1 = new Player("A", 'X');
        Player p2 = new Player("B", 'O');

        int[] moves = {1,2,3,5,4,6,8,7,9};

        for (int i = 0; i < moves.length; i++) {
            b.repChar(moves[i], (i % 2 == 0) ? p1 : p2);
        }

        assertTrue(b.isFull());
    }
}