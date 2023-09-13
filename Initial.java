import java.awt.Color;
import java.util.Arrays;
public class Initial
{   private int x,y;            // x-by-y grid of cells
    private int magnification;  // pixel-width of each cell
    private int[][] cells;      // cells to be randomly coloured
    private Picture pic;        // picture to be drawn on screen
    public Initial(int magnification)
    {
        x = 80;
        y = 80;
        this.magnification = magnification;
        cells = new int[x][y];
        pic = new Picture(x * magnification, y * magnification);
    }
    
    public void show()
    {
        pic.show();     // without calling this the pic will not show
    }
    public void drawCell(int i, int j, int[][]grid)
    {
        float r = (float) Math.random();
        float g = (float) Math.random();
        float b = (float) Math.random();
        Color col = grid[j][i]==1?Color.BLACK:Color.WHITE;
        
        for (int offsetX = 0; offsetX < magnification; offsetX++)
        {
            for (int offsetY = 0; offsetY < magnification; offsetY++)
            {
                // set() colours an individual pixel
                pic.set((i*magnification)+offsetX,
                        (j*magnification)+offsetY, col);
            }
        }
    }
    public int[][] nextGeneration(int[][] nextGrid) {
        // next generation grid that will be returned at end
        int future[][] = new int[nextGrid.length][nextGrid.length];

        // these 2 loops will examine each cell individually 
        for (int i = 0; i < nextGrid.length; i++) {
            for (int j = 0; j < nextGrid.length; j++) {
                int lifeSum = 0;

                // if any cell on the edge is considered
                if ((i == 0 || i == (nextGrid.length - 1)) || (j == 0 || j == (nextGrid.length - 1))) {
                    // then that cell is set to DEAD. -- this creates a lifeless
                    // barrier around the edge of the grid
                    if(j==0 && i>0 && i!=nextGrid.length-1){
                        for (int m = -1; m <= 1; m++) {
                            for (int n = 0; n <= 1; n++) {
                                lifeSum += nextGrid[i + m][j + n];
                            }
                        }
                    }
                    if(i==0 && j>0 && j!=nextGrid.length-1){
                        for (int m = 0; m <= 1; m++) {
                            for (int n = -1; n <= 1; n++) {
                                lifeSum += nextGrid[i + m][j + n];
                            }
                        }
                    }
                    lifeSum = lifeSum - nextGrid[i][j];
                    if (nextGrid[i][j] == 0) {
                        // becomes alive with 3 alive neighbors
                        if (lifeSum == 3) {
                            future[i][j] = 1;
                        } else // stays dead
                        {
                            future[i][j] = 0;
                        }

                    } // if the cell is alive
                    else {
                        // dies of lonliness
                        if (lifeSum <= 1) {
                            future[i][j] = 0;
                        } //stays alive -- can only have 2 or 3 alive neighbors
                        else if (lifeSum < 4) {
                            future[i][j] = 1;
                        } // dies of overpopulation -- has 4 or more neighbors
                        else {
                            future[i][j] = 0;
                        }
                    }
                } // end if statement
                else {
                    for (int m = -1; m <= 1; m++) {
                        for (int n = -1; n <= 1; n++) {
                            lifeSum += nextGrid[i + m][j + n];
                        }
                    }

                    // subtracts value of current cell so as to not affect lifeSum
                    // because it was counted above
                    lifeSum = lifeSum - nextGrid[i][j];

                    // if the cell is dead
                    if (nextGrid[i][j] == 0) {
                        // becomes alive with 3 alive neighbors
                        if (lifeSum == 3) {
                            future[i][j] = 1;
                        } else // stays dead
                        {
                            future[i][j] = 0;
                        }

                    } // if the cell is alive
                    else {
                        // dies of lonliness
                        if (lifeSum <= 1) {
                            future[i][j] = 0;
                        } //stays alive -- can only have 2 or 3 alive neighbors
                        else if (lifeSum < 4) {
                            future[i][j] = 1;
                        } // dies of overpopulation -- has 4 or more neighbors
                        else {
                            future[i][j] = 0;
                        }
                    }

                }// end else

            }// end second outer loop - j
        }// end most outer loop -- i

        // retuns new grid
        return future;
    } // ends nextGeneration method
    
}