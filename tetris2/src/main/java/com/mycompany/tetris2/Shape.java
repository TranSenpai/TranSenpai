package com.mycompany.tetris2;

import java.util.Random;
 
public class Shape {
    // Khai bao truong du lieu Tetrominoes de luu cac hinh dang cua vien gach
    protected enum Tetrominoes { NoShape, ZShape, SShape, LineShape, 
               TShape, SquareShape, LShape, MirroredLShape };
    // Create variable to get one shape in Tetrominoes
    private Tetrominoes pieceShape;
    // Create 2D array
    private int coords[][];
    // Create 3D array
    private int[][][] coordsTable;
 
 
    public Shape() {
        // New array and set size of array
        coords = new int[4][2];
        // Set Tetrominoes no shape
        setShape(Tetrominoes.NoShape);
    }
 
    public void setShape(Tetrominoes shape) {
        //[]array []row []col
        //array n{ row{col, col}, row{col, col} }
         coordsTable = new int[][][] {
            { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } },
            { { 0,-1 },   { 0, 0 },   {-1, 0 },   {-1, 1 } },
            { { 0,-1 },   { 0, 0 },   { 1, 0 },   { 1, 1 } },
            { { 0,-1 },   { 0, 0 },   { 0, 1 },   { 0, 2 } },
            { {-1, 0 },   { 0, 0 },   { 1, 0 },   { 0, 1 } },
            { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },
            { {-1,-1 },   { 0,-1 },   { 0, 0 },   { 0, 1 } },
            { { 1,-1 },   { 0,-1 },   { 0, 0 },   { 0, 1 } }
        };
 
        for (int i = 0; i < 4 ; i++) {
             
            for (int j = 0; j < 2; ++j) {
                 
                coords[i][j] = coordsTable[shape.ordinal()][i][j];
            }
        }
         
        pieceShape = shape;
    }
    // 
    private void setX(int index, int x) { coords[index][0] = x; }
    private void setY(int index, int y) { coords[index][1] = y; }
    public int x(int index) { return coords[index][0]; }
    public int y(int index) { return coords[index][1]; }
    public Tetrominoes getShape()  { return pieceShape; }
 
    public void setRandomShape() {
         
        Random r = new Random();
        //maxinum x = 8
        int x = Math.abs(r.nextInt()) % 7 + 1;
        Tetrominoes[] values = Tetrominoes.values(); 
        setShape(values[x]);
    }
 
    public int minX() {
         
        int m = coords[0][0];
       
        for (int i=0; i < 4; i++) {
           
            m = Math.min(m, coords[i][0]);
        }
       
      return m;
    }
 
 
    public int minY() {
         
      int m = coords[0][1];
       
      for (int i=0; i < 4; i++) {
           
          m = Math.min(m, coords[i][1]);
      }
       
      return m;
    }
 
    public Shape rotateLeft() {
         
        if (pieceShape == Tetrominoes.SquareShape)
            return this;
 
        Shape result = new Shape();
        result.pieceShape = pieceShape;
 
        for (int i = 0; i < 4; ++i) {
             
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
         
        return result;
    }
 
    public Shape rotateRight() {
         
        if (pieceShape == Tetrominoes.SquareShape)
            return this;
 
        Shape result = new Shape();
        result.pieceShape = pieceShape;
 
        for (int i = 0; i < 4; ++i) {
 
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
         
        return result;
    }
}