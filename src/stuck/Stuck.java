package stuck;

import java.util.Arrays;

public class Stuck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tet[] them = {Tet.I, Tet.J, Tet.L, Tet.O, Tet.S, Tet.T, Tet.Z};
        for (Tet tet : them) {
            System.out.println(tet);
            int[] sums = tet.getColumnSums();
            System.out.println(Arrays.toString(sums));
        }
    }
}
