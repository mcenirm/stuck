package stuck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Attempt {

    private final int[] goal;
    private final Piece[] pieces;
    private final Move[] moves;

    public Attempt(int[] goal, Piece[] pieces, Move[] moves) {
        this.goal = goal;
        this.pieces = pieces;
        this.moves = moves;
        assert pieces.length == moves.length;
    }

    public boolean isMetGoal() {
        boolean metGoal = true;
        for (int total : goal) {
            if (total != 0) {
                metGoal = false;
            }
        }
        return metGoal;
    }

    public boolean isGoodAttempt() {
        boolean goodAttempt = true;
        for (int total : goal) {
            if (total < 0) {
                goodAttempt = false;
            }
        }
        return goodAttempt;
    }

    public List<Attempt> solve() {
        ArrayList<Attempt> successes = new ArrayList<Attempt>();
        if (isMetGoal()) {
            successes.add(this);
        } else if (isGoodAttempt()) {
            int moveIndex = -1;
            for (int i = 0; i < moves.length; i++) {
                if (null == moves[i]) {
                    moveIndex = i;
                    break;
                }
            }
            if (moveIndex >= 0) {
                System.out.println("recursing: " + this);
                ArrayList<Attempt> subAttempts = new ArrayList<Attempt>();
                Piece piece = pieces[moveIndex];
                for (int sumsIndex = 0; sumsIndex < piece.getSums().length; sumsIndex++) {
                    int[] sums = piece.getSums(sumsIndex);
                    int maxPosition = goal.length - sums.length;
                    for (int position = 0; position < maxPosition; position++) {
                        int[] subGoal = Arrays.copyOf(goal, goal.length);
                        for (int i = 0; i < sums.length; i++) {
                            subGoal[i + position] -= sums[i];
                        }
                        Move newMove = new Move(sumsIndex, position);
                        subAttempts.add(makeSubAttempt(moveIndex, newMove, subGoal));
                    }
                }
                subAttempts.add(makeSubAttempt(moveIndex, Move.EMPTY, goal));
                for (Attempt subAttempt : subAttempts) {
                    successes.addAll(subAttempt.solve());
                }
            }
        }
        return successes;
    }

    private Attempt makeSubAttempt(int moveIndex, Move newMove, int[] subGoal) {
        Move[] subMoves = Arrays.copyOf(moves, moves.length);
        subMoves[moveIndex] = newMove;
        return new Attempt(subGoal, pieces, subMoves);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("Attempt(");
        b.append("goal: ");
        b.append(Arrays.toString(goal));
        b.append(", ");
        b.append("pieces: ");
        b.append(Arrays.toString(pieces));
        b.append(", ");
        b.append("moves: ");
        String[] moveStrings = new String[moves.length];
        for (int i = 0; i < moves.length; i++) {
            Move move = moves[i];
            if (null == move) {
                moveStrings[i] = null;
            } else if (move.isEmpty()) {
                moveStrings[i] = "_";
            } else {
                Piece piece = pieces[i];
                int[] sums = piece.getSums(move.sumsIndex);
                StringBuilder m = new StringBuilder();
                m.append(Arrays.toString(sums));
                m.append('@');
                m.append(move.position);
                moveStrings[i] = m.toString();
            }
        }
        b.append(Arrays.toString(moveStrings));
        b.append(")");
        return b.toString();
    }
}
