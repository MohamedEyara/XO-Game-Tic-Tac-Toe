
package frist.xogame;


public class Player {
    private String name;
    private char op;
    
   
    public Player( String name, char op) {
        this.name = name;
        this.op = op;
    }

    Player() {}
        

    public  String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }
    
    
}