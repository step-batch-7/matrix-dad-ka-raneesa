package com.step.maths;

import java.util.Arrays;

public class Matrix{
  private int rowsCount;
  private int columnsCount;
  private int[][] arr;

  public Matrix(int[][] arr, int rowsCount, int columnsCount){
    this.rowsCount = rowsCount;
    this.columnsCount = columnsCount;
    this.arr = new int[rowsCount][columnsCount];
    for(int rowsNo = 0; rowsNo < rowsCount; rowsNo++){
      this.arr[rowsNo] = Arrays.copyOf(arr[rowsNo], columnsCount);
    }
  }

  public Matrix add(Matrix matrix){
    int[][] result = new int[this.rowsCount][this.columnsCount];
    for(int rowsNo = 0; rowsNo <this.rowsCount; rowsNo++){
      for(int colNo = 0; colNo <this.columnsCount; colNo++){
        result[rowsNo][colNo] = this.arr[rowsNo][colNo] + matrix.arr[rowsNo][colNo];
      }
    }
    return new Matrix(result, this.rowsCount, this.columnsCount);
  }

  public Matrix subtract(Matrix matrix) {
    int[][] result = new int[this.rowsCount][this.columnsCount];
    for(int rowNo = 0; rowNo <this.rowsCount; rowNo++){
      for(int colNo = 0; colNo <this.columnsCount; colNo++){
        result[rowNo][colNo] = this.arr[rowNo][colNo] - matrix.arr[rowNo][colNo];
      }
    }
    return new Matrix(result, this.rowsCount, this.columnsCount);
  }

  public Matrix multiply(Matrix matrix){
    int[][] result = new int[this.rowsCount][matrix.columnsCount];
    for(int rowNo = 0; rowNo <this.rowsCount; rowNo++){
      for(int columnNo = 0; columnNo  <this.columnsCount; columnNo ++){
        result[rowNo][columnNo] = 0;
        for(int index = 0; index <this.columnsCount; index++){
          result[rowNo][columnNo] += this.arr[rowNo][index] * matrix.arr[index][columnNo];
        }
      }
    }
    return new Matrix(result, this.rowsCount, matrix.columnsCount);
  }

  private static int[][] createSubMatrix(int[][] matrix, int matrixColumn) {
    int length = matrix.length;
    int[][] subMatrix = new int[length - 1][length - 1];
    for (int rowNo = 1; rowNo < length; rowNo++) {
      for (int columnNo = 0; columnNo < length; columnNo++) {
        int subColumn = columnNo > matrixColumn ? columnNo - 1 : columnNo;
        int subRow = rowNo - 1;
        if (columnNo != matrixColumn) {
          subMatrix[subRow][subColumn] = matrix[rowNo][columnNo];
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
    for (int columnNo = 0; columnNo < matrix.length; columnNo++) {
      int[][] subMatrix = createSubMatrix(matrix, columnNo);
      determinant +=
        Math.pow (-1, columnNo) *
        matrix[0][columnNo] *
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
    sb.append("Matrix ");
    sb.append(Arrays.deepToString(this.arr));
    return sb.toString();
  }

  @Override
  public boolean equals(Object other){
    if(this == other) return true;
    if(!(other instanceof Matrix))
      return false;
    Matrix otherMatrix = (Matrix)other;
    return Arrays.deepEquals(this.arr, otherMatrix.arr);
  }
}
