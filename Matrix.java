/**
 * @(#)Matrix.java
 *
 * Matrix application
 *
 * @author Nate Fox
 * @version 1.00 2011/1/22
 *
 * Matrix functions supported:
 * Add/Subtract to second matrix
 * Multiply by constant
 * Multiply by a second matrix
 * Augment to second matrix
 * ERO (elementary row operations)
 * Row-Reduce to RREF
 * Invert
 */

public class Matrix {

	private double[][] matrix; // 2-Dimensional array representing matrix
	private final int ROWS; // Number of rows in the matrix
	private final int COLS; // Number of columns in the matrix

	// Constructor
	//  @param matrix --> 2-Dimensional array of doubles
	public Matrix(double[][] matrix) {
		this.matrix = matrix;
		this.ROWS = matrix.length;
		this.COLS = matrix[0].length;
	}

	// Returns new matrix formed by adding matrix to matrix defined by paramater
	public Matrix add(Matrix m) {

		// Test for same sizes
		if(ROWS != m.rows() || COLS != m.cols()) {
			System.err.println("Cannot add matrices of different sizes");
			return null;
		}

		// Calculate new matrix
		double[][] temp = new double[ROWS][COLS];
		for(int x = 0; x < ROWS; x++) {
			for(int y = 0; y < COLS; y++) {
				temp[x][y] = matrix[x][y] + m.getValue(x,y);
			}
		}
		return new Matrix(temp);
	}

	// Returns new matrix formed by subtracting matrix from matrix defined by parameter
	public Matrix subtract(Matrix m) {
		Matrix temp = m.multConstant(-1);
		return this.add(temp);
	}

	// Returns new matrix formed by multiplying constant defined by parameter
	public Matrix multConstant(double constant) {
		double[][] temp = new double[ROWS][COLS];
		for(int x = 0; x < ROWS; x++)
			for(int y = 0; y < COLS; y++)
				temp[x][y] = matrix[x][y] * constant;
		return new Matrix(temp);
	}

	// Returns new matrix formed by multiplying by matrix defined by parameter
	public Matrix multiply(Matrix m) {

		// Test for appropriate dimensions
		if(COLS != m.rows()) {
			System.err.println("Columns of first matrix must equal rows of second matrix " +
				                "in order to multiply");
			return null;
		}

		// Multiply
		double[][] temp = new double[ROWS][m.cols()];
		int i = 0; // row of second matrix
		int j = 0; // column of second matrix
			for(j = 0; j < m.cols(); j++) {
				for(int x = 0; x < ROWS; x++) {
					int sum = 0;
					for(int y = 0; y < COLS; y++) {
						sum += matrix[x][y] * m.getValue(i,j);
						i++;
					}
					temp[x][j] = sum;
					i = 0;
				}
			}
		return new Matrix(temp);
	}

	// Returns new matrix formed by performing ERO1: multiply row by constant
	public Matrix eroMultiply(int row, double constant) {

		// Test to make sure row exists
		if(row > ROWS) {
			System.err.println("Row does not exist");
			return null;
		}

		// Transfer row information to temporary array and multiply by constant
		double[] tempRow = new double[COLS];
		for(int x = 0; x < COLS; x++)
			tempRow[x] = matrix[row-1][x] * constant;

		// Create new double[][], replacing row-1 with tempRow
		double[][] temp = new double[ROWS][COLS];
		for(int x = 0; x < ROWS; x++) {
			for(int y = 0; y < COLS; y++) {
				if(x == row-1)
					temp[x][y] = tempRow[y];
				else
					temp[x][y] = matrix[x][y];
			}
		}
		return new Matrix(temp);
	}

	// Returns new matrix formed by performing ERO2: add row to multiple of another row
	public Matrix eroAdd(int row1, double constant, int row2) {

		// Test to make sure both rows exist
		if(row1 > ROWS || row2 > ROWS) {
			System.err.println("Cannot swap rows that do not exist");
			return null;
		}

		// Create temporary arrays to hold row data for each row, multiply row2 by constant
		double[] tempRow1 = new double[COLS];
		double[] tempRow2 = new double[COLS];
		for(int x = 0; x < COLS; x++) {
			tempRow1[x] = matrix[row1-1][x];
			tempRow2[x] = matrix[row2-1][x] * constant;
		}

		// Create new matrix, swapping row1 with tempRow1 + tempRow2
		double[][] temp = new double[ROWS][COLS];
		for(int x = 0; x < ROWS; x++) {
			for(int y = 0; y < COLS; y++) {
				if(x == row1-1)
					temp[x][y] = tempRow1[y] + tempRow2[y];
				else
					temp[x][y] = matrix[x][y];
			}
		}
		return new Matrix(temp);
	}

	// Returns new matrix formed by performing ERO3: swap two rows
	public Matrix eroSwap(int row1, int row2) {

		// Test to make sure both rows exist
		if(row1 > ROWS || row2 > ROWS) {
			System.err.println("Cannot swap rows that do not exist");
			return null;
		}

		// Create temporary arrays to hold row data for each row
		double[] tempRow1 = new double[COLS];
		double[] tempRow2 = new double[COLS];
		for(int x = 0; x < COLS; x++) {
			tempRow1[x] = matrix[row1-1][x];
			tempRow2[x] = matrix[row2-1][x];
		}

		// Create new matrix, swapping the two rows
		double[][] temp = new double[ROWS][COLS];
		for(int x = 0; x < ROWS; x++) {
			for(int y = 0; y < COLS; y++) {
				if(x == row1-1)
					temp[x][y] = tempRow2[y];
				else if(x == row2-1)
					temp[x][y] = tempRow1[y];
				else
					temp[x][y] = matrix[x][y];
			}
		}
		return new Matrix(temp);
	}

	// Returns new matrix formed by computing RREF
	public Matrix RREF(int round) {

		// Create temporary matrix to work with
		double[][] tempArray = new double[ROWS][COLS];
		for(int x = 0; x < ROWS; x++)
			for(int y = 0; y < COLS; y++)
				tempArray[x][y] = matrix[x][y];
		Matrix temp = new Matrix(tempArray);

		// Test for first nonzero column
		int pivotColumn = -1;
		int y = round;
		while(pivotColumn == -1) {
			for(int x = round; x < ROWS; x++) {
				if(temp.getValue(x,y) != 0) {
					pivotColumn = y;
					break;
				}
			}
			y++;
		}

		// Test for first nonzero entry in pivot column and swap that row with the first row
		for(int x = round; x < ROWS; x++) {
			if(temp.getValue(x,pivotColumn) != 0) {
				temp = temp.eroSwap(round+1,x+1);
				break;
			}
		}

		// Multiply first row by 1 / temp.getValue(round,pivotColumn) to create a leading 1
		double multiple = 1/(temp.getValue(round,pivotColumn));
		temp = temp.eroMultiply(round+1, multiple);

		// Clear other values in pivot column by eroAdd
		for(int x = 0; x < ROWS; x++)
			if(round != x)
				temp = temp.eroAdd(x+1,-temp.getValue(x,pivotColumn),round+1);

		// Clear out negative 0's
		for(int r = 0; r < ROWS; r++)
			for(int c = 0; c < COLS; c++)
				if(temp.getValue(r,c) == -0)
					temp.setValue(r,c,0);

		System.out.println(temp.toString());

		// Call recursively until done
		if(temp.isRREF())
			return temp;
		else return temp.RREF(++round);
	}

	// Returns inverse of matrix
	public Matrix inverse() {

		// Test for square
		if(ROWS != COLS) {
			System.err.println("Not square matrix, cannot take inverse");
			return null;
		}

		// Create augmented matrix
		Matrix temp = augment(Matrix.identity(ROWS));

		// Take RREF
		temp = temp.RREF(0);

		// Test if 1st half is identity matrix
		boolean isInverse = true;
		for(int x = 0; x < ROWS; x++) {
			for(int y = 0; y < COLS; y++) {
				if(y == x && temp.getValue(x,y) != 1)
					isInverse = false;
				else if( y!=x && temp.getValue(x,y) != 0)
					isInverse = false;
			}
		}


		// If so, return second half as inverse
		double[][] inverse = new double[ROWS][COLS];
		if(isInverse) {
			for(int x = 0; x < ROWS; x++)
				for(int y = COLS; y < COLS+COLS; y++)
					inverse[x][y-COLS] = temp.getValue(x,y);
		}
		else
			return null;

		return new Matrix(inverse);
	}

	// Returns value found at row, col defined by parameters
	public double getValue(int row, int col) {
		return matrix[row][col];
	}

	// Sets value at row, col defined by parameters
	public void setValue(int row, int col, int val) {
		matrix[row][col] = val;
	}

	// Returns row count
	public int rows() {
		return ROWS;
	}

	// Returns column count
	public int cols() {
		return COLS;
	}

	// Returns matrix augmented with matrix defined by parameter
	public Matrix augment(Matrix m) {

		// Test for same row number
		if(ROWS != m.rows()) {
			System.err.println("Cannot augment matrices with different row count");
			return null;
		}

		// Augment the two matrices
		double[][] temp = new double[ROWS][COLS + m.cols()];
		for(int x = 0; x < ROWS; x++)
			for(int y = 0; y < COLS; y++)
				temp[x][y] = matrix[x][y];
		for(int x = 0; x < ROWS; x++)
			for(int y = COLS; y < COLS + m.cols(); y++)
				temp[x][y] = m.getValue(x,y-COLS);

		return new Matrix(temp);
	}

	// Returns true if matrix is in RREF
	public boolean isRREF() {

		boolean[] pivotColumns = new boolean[COLS];
		for(int x = 0; x < COLS; x++) pivotColumns[x] = false;

		// Test if all rows are 0 or have leading ones
		for(int row = 0; row < ROWS; row++) {
			for(int y = 0; y < COLS; y++) {
				if(matrix[row][y] == 0);
				else if(matrix[row][y] == 1) {
					pivotColumns[y] = true;
					break;
				}
				else
					return false;
			}
		}

		// Test if all pivot columns have all 0 values
		for(int c = 0; c < COLS; c++) {
			if(pivotColumns[c]) {
				int oneCount = 0;
				for(int r = 0; r < ROWS; r++) {
					if(matrix[r][c] == 0);
					else if(matrix[r][c] == 1)
						oneCount++;
					else
						return false;
				}
				if(oneCount > 1) return false;
			}
		}

		return true;
	}

	// Returns identity matrix of size defined by parameter
	public static Matrix identity(int size) {
		double[][] temp = new double[size][size];
		for(int x = 0; x < size; x++) {
			for(int y = 0; y < size; y++) {
				if(x == y)
					temp[x][y] = 1;
				else
					temp[x][y] = 0;
			}
		}
		return new Matrix(temp);
	}

	// Returns String representation of matrix, including row and column count
	public String toString() {
		String matString = "Rows: " + ROWS + "\nColumns: " + COLS + "\n";
		for(int x = 0; x < ROWS; x++) { // Loop through rows
			matString += "{";
			for(int y = 0; y < COLS; y++) { // Loop through each item in each row
				if(y < matrix[x].length - 1)
					matString += matrix[x][y] + ", ";
				else
					matString += matrix[x][y];
			}
			matString += "}\n";
		}
		return matString;
	}

	// Main
	//  @param args --> no arguments required
	public static void main(String[] args) {
		double[][] array1 = {{1,2},
					{1.5,1}};
		double[][] array2 = {{240000},
					{180000}};
		double[][] array3 = {{1,4,5,3},{3,4,7,6},{9,5,5,3}};
		double[][] array4 = {{1,1,-1},
					{1,1,2},
					{2,2,1}};
		double[][] array5 = {{1,4,-1,-1},
					{2,1,2,3},
					{4,9,0,1},
					{5,6,3,4}};
		Matrix m1 = new Matrix(array1);
		Matrix m2 = new Matrix(array2);
		Matrix m3 = new Matrix(array3);
		Matrix m4 = new Matrix(array4);
		Matrix m5 = new Matrix(array5);
/*
		Matrix m7 = m1.inverse();
		Matrix m8 = m7.multiply(m2);
		System.out.println(m8.toString());
*/
		System.out.println(m1.inverse().multiply(m2).toString());
	}
}
