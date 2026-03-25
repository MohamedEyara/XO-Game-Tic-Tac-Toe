package frist.xogame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testSetAndGetName() {
        Player p = new Player();
        p.setName("Mohamed");
        assertEquals("Mohamed", p.getName());
    }

    @Test
    void testSetAndGetOp() {
        Player p = new Player();
        p.setOp('X');
        assertEquals('X', p.getOp());
    }

    @Test
    void testConstructor() {
        Player p = new Player("Ali", 'O');
        assertEquals("Ali", p.getName());
        assertEquals('O', p.getOp());
    }
}