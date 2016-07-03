package com.company.datastructures;

/**
 * Created by vnagpurkar on 6/9/16.
 */
public class Matrix {

    // A Boolean Matrix Question
    //modify matrix [M X N], such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1
    public static boolean[][] modifyBooleanMatrix(boolean[][] input) {

        boolean[] rowFlag = new boolean[input.length]; // get rowCount
        boolean[] columnFlag = new boolean[input[0].length]; // get columnCount

        for(int row=0; row<input.length; row++) {
            for(int col=0; col<input[0].length; col++) {
                if(input[row][col]) {
                    rowFlag[row]= true;
                    columnFlag[col]=true;
                }
            }
        }

        for(int row=0; row<input.length; row++) {
            for(int col=0; col<input[0].length; col++) {
                if(!input[row][col] && (rowFlag[row] || columnFlag[col])) {
                    input[row][col] = true;
                }
            }
        }
        return input;
    }

    public static boolean[][] modifyBooleanMatrixMethod2(boolean[][] input) {

        for(int row=0; row<input.length; row++) {
            for(int col=0; col<input[0].length; col++) {
                if(input[row][col]) {
                    input[0][col]= true;
                    input[row][0]=true;
                }
            }
        }
        for(int row=0; row<input.length; row++) {
            for(int col=0; col<input[0].length; col++) {
                if(!input[row][col] && (input[0][col] || input[row][0])) {
                    input[row][col] = true;
                }
            }
        }
        return input;
    }

    // Maximum size square sub-matrix with all 1s
    public static void maxSubMatrixWithOnes(int[][] input) {

        // maintain auxlilary matrix
        int[][] temp = new int[input.length][input[0].length];

        // 1. copy 0th row to auxilary matrix
        // 2. copy 0th column to auxilary matrix
        // 3. if input[i][j] = 1, then temp[i][j] = min(input[i][j-1], input[i-1][j], input[i-1][j-1]
        // 4. find maximum entry in temp[][]
        // 5. using row and columns of temp, calculate maximum size submatrix of 1s

        // 1.
        for(int row=0; row<input.length; row++) {
            temp[row][0] = input[row][0];
        }

        // 2.
        for(int col=0; col<input[0].length; col++) {
            temp[0][col] = input[0][col];
        }

        // 3.
        for(int row=1; row<input.length; row++) {
            for(int col=1; col <input[0].length; col++) {
                if(input[row][col]== 1) {
                    temp[row][col] = minimum(temp[row-1][col], temp[row][col-1], temp[row-1][col-1]) + 1;
                } else {
                    temp[row][col] = 0;
                }
            }
        }

        // 4.
        int maximum = Integer.MIN_VALUE;
        int maxCol = 0;
        int maxRow = 0;
        for(int row=0; row<temp.length; row++) {
            for(int col=0; col<temp[0].length; col++) {
                if (maximum < temp[row][col]) {
                    maximum = temp[row][col];
                    maxCol = col;
                    maxRow = row;
                }
            }
        }

        // 5.
        System.out.println();
        for(int row = maxRow; row > maxRow-maximum; row--) {
            for(int col = maxCol; col > maxCol-maximum; col--) {
                System.out.print(input[row][col] +",");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int minimum(int number1, int number2, int number3) {

        if(number1 < number2) {
            if(number1 < number3) { // number1 < number2 && number1 < number3, number1 is minimum
                return number1;
            }
        } else if(number1 < number3){ // number2 < number1 < number3, number2 is minimum
            return number2;
        } return number3; // number1 > number2 > number3, number3 is minimum
    }

    // Turn an image by 90 degree
    public int[][] turnImageByNightyDegree (int[][] input) {
        return input;
    }

    // Search in a row wise and column wise sorted matrix
    public static boolean isPresent (int[][] matrix, int number) {

        int row = 0;
        int col = matrix.length-1;

        while(row < matrix[0].length && col >=0) {
            if (matrix[row][col] == number) {
                return true;
            }
            if (matrix[row][col] > number) {
                col--;
            } else if (matrix[row][col] < number) {
                row++;
            }
        }
        return false;
    }


































    /*public static boolean isPresent(int[][] input, int number) {

        int row = 0;
        int column = input[0].length - 1;

        while(row <= input.length-1 && column >=0) {

            if(number == input[row][column]) {
                return true;
            }

            if(number > input[row][column]) {
                row ++;
            }

            if(row <= input.length-1 && number < input[row][column]) {
                column--;
            }
        }
        return false;
    }*/

    // Print a given matrix in spiral form
    public static void printMatrixInSpiralForm(int[][] input) {

        int row = 0;
        int endRow = input.length-1;

        int col = 0;
        int endCol = input[0].length-1;

        while(row <= endRow && col <= endCol) {

            for(int i=col; i<=endCol; i++) {
                System.out.print(input[row][i]+",");
            }
            row++;
            for(int i=row; i<=endRow; i++) {
                System.out.print(input[i][endCol]+",");
            }
            endCol--;
            for(int i=endCol; i>=col; i--) {
                System.out.print(input[endRow][i] +",");
            }
            endRow--;
            for(int i=endRow; i>=row; i--) {
                System.out.print(input[i][col] +",");
            }
            col++;
        }
    }

    // calculate Magic Square, this method works only on odd n
    public static void printMagicSquare(int n) {

        if(n%2 == 0) {
            System.out.println("This method works only on odd number n");
        }
        //int magicConstant = (n*((n*n)+1))/2;
        int[][] magicMatrix = new int[n][n];

        int number = 1;
        int row = n/2;
        int col = n-1;

        while (number <= n*n) {
            if(row == -1 && col == n) {
                row = 0;
                col = n-2;
            } else {
                if(row < 0) {
                    row = n-1;
                }
                if(col == n) {
                    col = 0;
                }
            }
            if(magicMatrix[row][col] == 0) {
                magicMatrix[row][col] = number++;
                row--;
                col++;
            } else {
                col = col-2;
                row = row+1;
            }
        }
        System.out.println();
        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                System.out.print(magicMatrix[r][c]+",");
            }
            System.out.println();
        }
    }

    // Dynamic Programming | Set 27 (Maximum sum rectangle in a 2D matrix)
    // Kadane’s algorithm
    public static void printMaximumSumRectangle(int[][] input) {

        int maxSum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int maxUp = 0;
        int maxDown = 0;

        for(int left = 0; left<input[0].length; left++) {

            int[] temp = new int[input.length];
            for(int right = left; right<input[0].length; right++) {

                for(int i=0; i<temp.length; i++) {
                    temp[i] = temp[i] + input[i][right];
                }

                int currentSum = 0;
                int currentUp = 0;
                int currentDown = 0;
                int sumUpToHere = 0;

                for(int i=0; i<temp.length; i++) {

                    sumUpToHere = sumUpToHere+ temp[i];
                    if(sumUpToHere < 0) {
                        sumUpToHere = 0;
                        currentUp = i+1 < temp.length ? i+1 : i;
                    }
                    if(sumUpToHere > currentSum) {
                        currentSum = sumUpToHere;
                        currentDown = i;
                    }
                }

                if(maxSum < currentSum) {
                    maxSum = currentSum;
                    maxLeft = left;
                    maxRight = right;
                    maxUp = currentUp;
                    maxDown = currentDown;
                }

            }
        }

        for(int row = maxUp; row <= maxDown; row++) {
            System.out.println();
            for(int col = maxLeft; col <= maxRight; col++) {
                System.out.print(input[row][col] +",");
            }
        }
    }

    // Print Matrix Diagonally
    public static void printMatrixDiagonally(int[][] input) {

        int row;
        int col;

        for(int i=0; i<input.length-1; i++) {

            row = i;
            col = 0;
            System.out.println();
            while(row >=0 && col < input[0].length) {
                System.out.print(input[row][col] +",");
                row--;
                col++;
            }
        }
        for(int i=0; i<input[0].length; i++){
            row = input.length -1;
            col = i;
            System.out.println();
            while(col < input[0].length && row >=0) {
                System.out.print(input[row][col] +",");
                row--;
                col++;
            }
        }
    }

    // Dynamic Programming | Set 6 (Min Cost Path) in cost matrix
    // Min Cost Path  = path from a call (m,n) to (0,0) with minimum cost in cost matrix
    // Cost Matrix is a matrix with Cost values in each cell of matrix
    public static int minCostPath(int[][] costMatrix, int m, int n) {

        return minCostPathRecur(costMatrix, m, n);
    }

    private static int minCostPathRecur(int[][] costMatrix, int m, int n) {

        if(m < 0 || n <0) return 0;
        if(m == 0 && n ==0) return costMatrix[m][n];

        // minCostPathRecur(costMatrix, m-1, n-1) should be added when diagonal movements are allowed
        return ( minimum(minCostPathRecur(costMatrix, m-1, n-1),
                         minCostPathRecur(costMatrix, m, n-1),
                         minCostPathRecur(costMatrix, m-1, n))
                + costMatrix[m][n]
        );
    }

    // Print all possible paths from top left to bottom right of a mXn matrix
    public static int printAllPathsFromTopLeftToBottomRight(int[][] matrix) {

        return printPath(matrix.length, matrix[0].length);
    }

    private static int printPath(int m, int n) {

        if(m == 1 || n == 1) return 1;

        return ( printPath(m-1, n)
                 + printPath(m, n-1)
                 //+ printPath(m-1, n-1) // this condition should be allowed if diagonal movements are allowed
        );
    }

    // Print all possible paths from top left to bottom right of a mXn matrix
    public static int printAllPathsFromTLToBRNonRecursive(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] tempCount = new int[m][n];

        // paths for all elements in first column from (0,0) is 1
        for(int i=1; i<m; i++) {
            tempCount[i][0] = 1;
        }

        // paths for all elements in first row from (0,0) is 1
        for(int j=1; j<n;j++) {
            tempCount[0][j] = 1;
        }

        // using above two values, calculate path for other cells
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                tempCount[i][j] = tempCount[i-1][j] + tempCount[i][j-1];
            }
        }
        return tempCount[m-1][n-1];
    }

    // Print all possible paths from top left to bottom right of a mXn matrix
    // number of unique paths in mXn matrix = ((m-1+n-1)! / (m-1)! *(n-1)!)
    public static int printAllPathsUsingFormula(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int noOfUniquePaths = factorial(m-1+n-1) / (factorial(m-1) * factorial(n-1));

        return noOfUniquePaths;
    }

    private static int factorial(int number) {
        int fact = 1;
        while(number >= 1) {
            fact = fact* number;
            number--;
        }
        return fact;
    }

    // Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
    public static void printArrangedMatrix(int[][] input) {

        for(int row=0; row<input.length; row++) {
            System.out.println();
            for (int col = 0; col < input[0].length; col++) {
                System.out.print(input[row][col] + ",");
            }
        }
        for(int row=0; row<input.length; row++) {
            for(int col=0; col<input[0].length; col++) {
                if(input[row][col] == 0) {
                    input[0][col] = 0;
                    input[row][0] = 0;
                }
            }
        }
        for(int row=0; row<input.length; row++) {
            for(int col=0; col<input[0].length; col++) {
                if(input[0][col] == 0 || input[row][0] == 0) {
                    input[row][col] = 0;
                }
            }
        }
        System.out.println();
        System.out.println();
        for(int row=0; row<input.length; row++) {
            System.out.println();
            for (int col = 0; col < input[0].length; col++) {
                System.out.print(input[row][col] + ",");
            }
        }
    }

}
