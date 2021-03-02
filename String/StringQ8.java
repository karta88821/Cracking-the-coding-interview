package String;

public class StringQ8 {

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, 
                         {1,1,1},
                         {1,1,0}};
                         
        int[][] zeroMatrix = StringQ8.setZero(matrix);

        
        for (int i = 0; i < zeroMatrix.length; i++) {
            for (int j = 0; j < zeroMatrix[0].length; j++) {
                System.out.println(zeroMatrix[i][j]);
            }
        }
    }

    static int[][] setZero(int[][] matrix) {
        boolean hasZeroInFirstRow = false;
        boolean hasZeroInFirstCol = false;

        // 1.1 檢查第一列是否有0
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                hasZeroInFirstRow = true;
                break;
            }
        }

        // 1.2 檢查第一行是否有0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                hasZeroInFirstCol = true;
                break;
            }
        }

        // 2. 將剩餘的矩陣(除了第一行和第一列以外的矩陣)中為0元素者，將其對應的matrix[i][0] / matrix[0][j] 設為0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 3. 根據(2)中的matrix[i][0] / matrix[0][j]，將剩餘的矩陣中設定為0
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullifyAtColumn(matrix, j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyAtRow(matrix, i);
            }
        }

        // 4.1 將第一列設定為0
        if (hasZeroInFirstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // 4.2 將第一行設定為0
        if (hasZeroInFirstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        return matrix;
    }

    static int[][] getZeroMatrix(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        // 紀錄哪幾列/行存在0元素
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }


        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                nullifyAtRow(matrix, i);
            }
        }

        for (int j = 0; j < columns.length; j++) {
            if (columns[j]) {
                nullifyAtColumn(matrix, j);
            }
        }

        return matrix;
    }

    static void nullifyAtRow(int[][] matrix, Integer row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    static void nullifyAtColumn(int[][] matrix, Integer column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }
}
