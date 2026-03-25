package frist.xogame;

import java.util.Scanner;

public class Game {

    private Board b = new Board();
    private Player p1 = new Player();
    private Player p2 = new Player();
    private int count = 0;
    Scanner cin = new Scanner(System.in);

    public void readPlayerData() {
        System.out.println("Enter Player 1 name : ");
        String s = cin.next();
        p1.setName(s);

        System.out.println("Enter Player 1 op (X,O) : ");
        char op = cin.next().toUpperCase().charAt(0);
        p1.setOp(op);

        System.out.println("Enter Player 2 name : ");
        s = cin.next();   
        p2.setName(s);

        if (p1.getOp() == 'X') {
            p2.setOp('O');
        } else {
            p2.setOp('X');
        }
    }

    public void play() {
        readPlayerData();
        b.draw();

        while (!b.isFull()) {

            Player cp = p1;
            if (count % 2 == 1) {
                cp = p2;
            }

            while (true) {
                System.out.print("Choose position (1-9): ");
                int pos = cin.nextInt();

                if (b.repChar(pos, cp)) {
                    break;
                } else {
                    System.out.println("Invalid move, try again!");
                }
            }

            b.draw();

            if (b.isWin(cp)) {
                System.out.println("Winner is = " + cp.getName());
                return; 
            }

            count++;
        }

        System.out.println("Game is Draw");
    }
}