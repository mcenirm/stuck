package stuck;

public class Piece {

    public static final Piece T = new Piece("T", new int[][]{{1, 2, 1}, {1, 3}, {3, 1}});
    public static final Piece Z = new Piece("Z", new int[][]{{1, 2, 1}, {2, 2}});
    public static final Piece J = new Piece("J", new int[][]{{1, 1, 2}, {1, 3}, {2, 1, 1}, {3, 1}});
    public static final Piece O = new Piece("O", new int[][]{{2, 2}});
    public static final Piece I = new Piece("I", new int[][]{{1, 1, 1, 1}, {4}});
    private final String name;
    private final int[][] sums;

    private Piece(String name, int[][] sums) {
        this.name = name;
        this.sums = sums;
    }

    public String getName() {
        return name;
    }

    public int[][] getSums() {
        return sums;
    }

    public int[] getSums(int index) {
        return sums[index];
    }

    @Override
    public String toString() {
        return getName();
    }
}
