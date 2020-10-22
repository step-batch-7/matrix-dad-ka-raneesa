package com.step.maths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class MatrixTest{
  @Test
  public void shouldGiveStringRepresentationOfMatrix(){
    int[][] data = {{1,2}, {4,5}};
    Matrix matrix = new Matrix(data, 2, 2);
    assertEquals(matrix.toString(), "Matrix [[1, 2], [4, 5]]");
  }

  @Test
  public void shouldGiveTrueForMatricesOfSameReference(){
    int[][] data = {{1,2}, {4,5}};
    Matrix matrix = new Matrix(data, 2, 2);
    assertTrue(matrix.equals(matrix));
  }

  @Test
  public void shouldGiveTrueForSameMatrices(){
    int[][] data1 = {{1,2}, {4,5}};
    Matrix matrix1 = new Matrix(data1, 2, 2);
    int[][] data2 = {{1,2}, {4,5}};
    Matrix matrix2 = new Matrix(data2, 2, 2);
    assertTrue(matrix1.equals(matrix2));
  }

  @Test
  public void shouldGiveFalseForDifferentMatrices(){
    int[][] data1 = {{1,2}, {4,5}};
    Matrix matrix1 = new Matrix(data1, 2, 2);
    int[][] data2 = {{1,2}};
    Matrix matrix2 = new Matrix(data2, 1, 2);
    assertFalse(matrix1.equals(matrix2));
  }

  @Test
  public void shouldGiveFalseForDifferenceInstanceObjects(){
    int[][] data = {{1,2}, {4,5}};
    Matrix matrix = new Matrix(data, 2, 2);
    assertFalse(matrix.equals(new Object()));
  }

  @Test
  public void shouldAddEqualRowAndColumnLengthOfMatrices(){
    int[][] arr1 = {{1,2,3},{2,3,4},{3,4,5}};
    Matrix matrix1 = new Matrix(arr1, 3, 3);
    int[][] arr2 ={{1,3,4},{1,5,4},{2,4,3}};
    Matrix matrix2 = new Matrix(arr2, 3, 3);
    int[][] data = {{2,5,7},{3,8,8},{5,8,8}};
    Matrix expected = new Matrix(data,3, 3);
    assertEquals(matrix1.add(matrix2), expected);
  }

}