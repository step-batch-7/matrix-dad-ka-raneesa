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

}