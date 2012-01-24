package stuck;

import java.util.List;

public class Stuck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Piece[] pieces = {Piece.T, Piece.Z, Piece.J, Piece.O, Piece.I};
        int[] goal = {2, 3, 4, 2, 3, 2};
        Attempt blank = new Attempt(goal, pieces, new Move[pieces.length]);
        System.out.println(blank);
        List<Attempt> solutions = blank.solve();
        System.out.println(solutions);
    }
}
