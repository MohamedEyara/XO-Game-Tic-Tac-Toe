package frist.xogame;

public class Board implements boardInetrface {

    public char[][] arr;

    public Board() {
        this.arr = new char[][]{
            {'1','2','3'},
            {'4','5','6'},
            {'7','8','9'}
        };
    }

    public int getRow(int index) {
        return (index - 1) / 3;
    }

    public int getColumn(int index) {
        return (index - 1) % 3;
    }

    public boolean isEmpty(int index) {
        if (index < 1 || index > 9) return false;

        int row = getRow(index);
        int column = getColumn(index);

        if (arr[row][column] == 'X' || arr[row][column] == 'O')
            return false;

        return true;
    }

    public boolean repChar(int index, Player p) {
        if (isEmpty(index)) {
            int row = getRow(index);
            int column = getColumn(index);
            arr[row][column] = p.getOp();
            return true;
        }
        return false;
    }

    public void draw() {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + arr[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public boolean isFull() {
        for (int i = 1; i <= 9; i++) {
            if (isEmpty(i)) return false;
        }
        return true;
    }

    @Override
    public boolean isWin(Player p) {

        char op = p.getOp();

        // rows
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] == op && arr[i][1] == op && arr[i][2] == op)
                return true;
        }

        // columns
        for (int i = 0; i < 3; i++) {
            if (arr[0][i] == op && arr[1][i] == op && arr[2][i] == op)
                return true;
        }

        // diagonals
        if (arr[0][0] == op && arr[1][1] == op && arr[2][2] == op)
            return true;

        if (arr[0][2] == op && arr[1][1] == op && arr[2][0] == op)
            return true;

        return false;
    }
}