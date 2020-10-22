package com.step.maths;

public class Matrix{
  private int rows;
  private int columns;
  private int[][] arr;

  public Matrix(int[][] arr, int rows, int columns){
    this.rows = rows;
    this.columns = columns;
    this.arr = new int[rows][columns];
    for(int row = 0; row < rows; row++){
      for(int col = 0; col <columns; col++){
        this.arr[row][col] = arr[row][col]; 
      }
    }
  }

  public Matrix add(Matrix matrix){
    int[][] result = new int[this.rows][this.columns];
    for(int row = 0; row <this.rows; row++){
      for(int col = 0; col <this.columns; col++){
        result[row][col] = this.arr[row][col] + matrix.arr[row][col];
      }
    }
    return new Matrix(result, this.rows, this.columns);
  }

  public Matrix subtract(Matrix matrix) {
    int[][] result = new int[this.rows][this.columns];
    for(int row = 0; row <this.rows; row++){
      for(int col = 0; col <this.columns; col++){
        result[row][col] = this.arr[row][col] - matrix.arr[row][col];
      }
    }
    return new Matrix(result, this.rows, this.columns);
  }

  public Matrix multiply(Matrix matrix){
    int[][] result = new int[this.rows][matrix.columns];
    for(int i = 0; i <this.rows; i++){
      for(int j = 0; j <this.columns; j++){
        result[i][j] = 0;
        for(int k = 0; k <this.columns; k++){
          result[i][j] += this.arr[i][k] * matrix.arr[k][j];
        }
      }
    }
    return new Matrix(result, this.rows, matrix.columns);
  }

  private static int[][] createSubMatrix(int[][] matrix, int matrixColumn) {
    int length = matrix.length;
    int[][] subMatrix = new int[length - 1][length - 1];
    for (int row = 1; row < length; row++) {
      for (int column = 0; column < length; column++) {
        int subColumn = column > matrixColumn ? column - 1 : column;
        int subRow = row - 1;
        if (column != matrixColumn) {
          subMatrix[subRow][subColumn] = matrix[row][column];
        }
      }
    }
    return subMatrix;
  }

  public static int findDeterminant(int[][] matrix) {
    if(matrix.length == 1){
      return matrix[0][0];
    } 

    if (matrix.length == 2) {
      return ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
    }

    int determinant = 0;
    for (int matrixColumn = 0; matrixColumn < matrix.length; matrixColumn++) {
      int[][] subMatrix = createSubMatrix(matrix, matrixColumn);
      determinant +=
        Math.pow (-1, matrixColumn) *
        matrix[0][matrixColumn] *
        findDeterminant(subMatrix);
    }
    return (determinant);
  }

  public int determinant(){
    return findDeterminant(this.arr);
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Matrix\n");
    for(int[] row: this.arr){
      for(int num: row){
        sb.append(num).append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  private boolean areDeepEqual(Matrix matrix){
    for(int i = 0; i <this.rows; i++){
      for(int j = 0; j <this.columns; j++){
        if(this.arr[i][j] != matrix.arr[i][j]){
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public boolean equals(Object other){
    if(this == other) return true;
    if(!(other instanceof Matrix))
      return false;
    Matrix otherMatrix = (Matrix)other;
    if(this.rows != otherMatrix.rows || this.columns != otherMatrix.columns) return false;
    return areDeepEqual(otherMatrix);
  }
}
