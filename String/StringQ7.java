package String;

public class StringQ7 {

    static final int N = 3;
    public static void main(String[] args) {
        int[][] matrix = new int[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        System.out.println(StringQ7.rotateMatrix(matrix));

    }

    static boolean rotateMatrix(int[][] matrix) {

        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int n = matrix.length;

        // 從最外layer開始做rotate，直到最內層
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - layer - 1;
            for (int i = first; i < last; i++) {

                int offset = i - layer;

                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];

                matrix[last - offset][first] = matrix[last][last - offset];

                matrix[last][last - offset] = matrix[i][last];

                matrix[i][last] = top;
            }
        }

        return true;
    }
}
