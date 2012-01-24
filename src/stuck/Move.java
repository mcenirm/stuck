package stuck;

public class Move {

    public final static Move EMPTY = new Move();
    public final int sumsIndex;
    public final int position;

    public Move(int sumsIndex, int position) {
        this.sumsIndex = sumsIndex;
        this.position = position;
    }

    public Move() {
        this.sumsIndex = -1;
        this.position = -1;
    }

    public boolean isEmpty() {
        return (sumsIndex < 0) || (position < 0);
    }

    @Override
    public String toString() {
        return "(" + sumsIndex + "x" + position + ")";
    }
}
