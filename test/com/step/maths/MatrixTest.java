package com.step.maths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

public class MatrixTest{
  private Matrix matrix1;
  private Matrix matrix2;

  @Before
  public void initMatrices() {
    int[][] arr1 = {{1,2,3},{2,3,4},{3,4,5}};
    int[][] arr2 = {{1,3,4},{1,5,4},{2,4,3}};
    
    this.matrix1 = new Matrix(arr1, 3, 3);
    this.matrix2 = new Matrix(arr2, 3, 3);
  }

  @Test
  public void shouldGiveStringRepresentationOfMatrix(){
    assertEquals("Matrix [[1, 2, 3], [2, 3, 4], [3, 4, 5]]", this.matrix1.toString());
  }

  @Test
  public void shouldGiveTrueForMatricesOfSameReference(){
    assertEquals(this.matrix1, this.matrix1);
  }

  @Test
  public void shouldGiveTrueForSameMatrices(){
    int[][] data = {{1,2,3},{2,3,4},{3,4,5}};
    Matrix expected = new Matrix(data, 3, 3);
    assertEquals(expected, this.matrix1);
  }

  @Test
  public void shouldGiveFalseForDifferentMatrices(){
    assertNotEquals(this.matrix2, this.matrix1);
  }

  @Test
  public void shouldGiveFalseForDifferenceInstanceObjects(){
    assertNotEquals(new Object(), this.matrix1);
  }

  @Test
  public void shouldAddEqualRowAndColumnLengthOfMatrices(){
    int[][] data = {{2,5,7},{3,8,8},{5,8,8}};
    Matrix expected = new Matrix(data,3, 3);
    assertEquals(expected, this.matrix1.add(this.matrix2));
  }

  @Test
  public void shouldSutractEqualRowAndColumnLengthOfMatrices(){
    int[][] data = {{0,-1,-1},{1,-2,0},{1,0,2}};
    Matrix expected = new Matrix(data,3, 3);
    assertEquals(expected, this.matrix1.subtract(this.matrix2));
  }

  @Test
  public void shouldMultiplyEqualRowAndColumnLengthOfMatrices(){
    int[][] data = {{9,25,21},{13,37,32},{17,49,43}};
    Matrix expected = new Matrix(data,3, 3);
    assertEquals(expected, this.matrix1.multiply(this.matrix2));
  }

  @Test
  public void shouldGiveDetOfMatrixOfRowAndColumnOfLengthOne(){
    int[][] arr = {{2}};
    Matrix matrix = new Matrix(arr, 1, 1);
    assertEquals(2, matrix.determinant());
  }

  @Test
  public void shouldGiveDetOfMatrixOfRowAndColumnOfLengthTwo(){
    int[][] arr = {{8,2},{5,3}};
    Matrix matrix = new Matrix(arr, 2, 2);
    assertEquals(14, matrix.determinant());
  }

  @Test
  public void shouldGiveDetOfMatrixOfRowAndColumnOfLengthMoreThanTwo(){
    assertEquals(-10, this.matrix2.determinant());
  }
}