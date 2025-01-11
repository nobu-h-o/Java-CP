package Library;

public class Matrix {
    //https://stackoverflow.com/questions/2799755/rotate-array-clockwise
    //Rotates Matrix Clockwise 90 degrees
    static int[][] rotate(int[][] mat) {
        final int M = mat.length;
        final int N = mat[0].length;
        int[][] ret = new int[N][M];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                ret[c][M-1-r] = mat[r][c];
            }
        }
        return ret;
    }
}
