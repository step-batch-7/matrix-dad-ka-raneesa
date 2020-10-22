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

  private Matrix createSubMatrix(int index){
    int[][] subMatrix = new int[this.rowsCount - 1][this.columnsCount -1];
    for(int rowNo = 1; rowNo < this.rowsCount; rowNo++){
      for(int columnNo = 0; columnNo < this.columnsCount; columnNo++){
        int subColumn = columnNo > index? columnNo - 1 : columnNo;
        int subRow = rowNo - 1;
        if (columnNo != index) {
          subMatrix[subRow][subColumn] = this.arr[rowNo][columnNo];
        }
      }
    }
    return new Matrix(subMatrix, this.rowsCount -1, this.columnsCount - 1);
  }

  public int determinant(){
    if(this.rowsCount == 1) return this.arr[0][0];
    if(this.rowsCount == 2) {
      return ((this.arr[0][0] * this.arr[1][1]) - (this.arr[0][1] * this.arr[1][0]));
    }

    int det = 0;
    for(int index = 0; index < this.columnsCount; index++){
      Matrix subMatrix = createSubMatrix(index);
      det += Math.pow(-1, index) * this.arr[0][index] * subMatrix.determinant(); 
    }
    return det;
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
