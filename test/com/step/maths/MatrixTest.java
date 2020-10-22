package com.step.maths;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MatrixTest{
  @Test
  public void shouldGiveStringRepresentationOfMatrix(){
    int[][] data = {{1,2}, {4,5}};
    Matrix matrix = new Matrix(data, 2, 2);
    assertEquals(matrix.toString(), "Matrix [[1, 2], [4, 5]]");
  }
}