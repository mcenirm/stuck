package stuck;

public class Tet {

    public final static Tet I = new Tet(1, 1, 1, 1, 0, 0, 0, 0);
    public final static Tet O = new Tet(1, 1, 0, 0, 1, 1, 0, 0);
    public final static Tet T = new Tet(1, 1, 1, 0, 0, 1, 0, 0);
    public final static Tet J = new Tet(1, 1, 1, 0, 0, 0, 1, 0);
    public final static Tet L = new Tet(1, 1, 1, 0, 1, 0, 0, 0);
    public final static Tet S = new Tet(0, 1, 1, 0, 1, 1, 0, 0);
    public final static Tet Z = new Tet(1, 1, 0, 0, 0, 1, 1, 0);
    private static final int COLUMNS = 4;
    private static final int ROWS = 2;
    private boolean[][] squares;

    private Tet(int i, int i0, int i1, int i2, int i3, int i4, int i5, int i6) {
        int arr[][] = {{i, i0, i1, i2}, {i3, i4, i5, i6}};
        squares = new boolean[ROWS][COLUMNS];
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                squares[row][column] = (arr[row][column] == 1);
            }
        }
    }
}
