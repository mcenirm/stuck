package stuck;

import java.util.ArrayList;
import java.util.Arrays;
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
        for (Attempt solution : solutions) {
            int size = solution.getSize();
            ArrayList<String> pieceStrings = new ArrayList<String>();
            for (int i = 0; i < size; i++) {
                Piece piece = solution.getPiece(i);
                Move move = solution.getMove(i);
                if (null != move && !move.isEmpty()) {
                    StringBuilder b = new StringBuilder();
                    b.append(piece.getName());
                    b.append(Arrays.toString(piece.getSums(move.sumsIndex)));
                    b.append('@');
                    b.append(move.position);
                    pieceStrings.add(b.toString());
                }
            }
            System.out.println("Solution: " + pieceStrings);
        }
    }
}
