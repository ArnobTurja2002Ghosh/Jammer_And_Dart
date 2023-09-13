import java.awt.Color;
import java.util.Arrays;
public class Model
{   private int x,y;            // x-by-y grid of cells
    private int magnification;  // pixel-width of each cell
    private int[][] cells;      // cells to be randomly coloured
    private Picture pic;        // picture to be drawn on screen
    public Model(int x, int y, int magnification)
    {
        this.x = x;
        this.y = y;
        this.magnification = magnification;
        cells = new int[x][y];
        pic = new Picture(x * magnification, y * magnification);
    }
    
    public void show()
    {
        pic.show();     // without calling this the pic will not show
    }
    private void drawCell(int i, int j, int[][]grid)
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
    static int[][] nextGeneration(int[][] nextGrid) {
        // next generation grid that will be returned at end
        int future[][] = new int[nextGrid.length][nextGrid.length];

        // these 2 loops will examine each cell individually 
        for (int i = 0; i < nextGrid.length; i++) {
            for (int j = 0; j < nextGrid.length; j++) {
                int lifeSum = 0;

                // if any cell on the edge is considered
                // if ((i == 0 || i == (nextGrid.length - 1)) || (j == 0 || j == (nextGrid.length - 1))) {
                //     // then that cell is set to DEAD. -- this creates a lifeless
                //     // barrier around the edge of the grid
                //     if(j==0 && i>0 && i!=nextGrid.length-1){
                //         for (int m = -1; m <= 1; m++) {
                //             for (int n = 0; n <= 1; n++) {
                //                 lifeSum += nextGrid[i + m][j + n];
                //             }
                //         }
                //     }
                //     if(i==0 && j>0 && j!=nextGrid.length-1){
                //         for (int m = 0; m <= 1; m++) {
                //             for (int n = -1; n <= 1; n++) {
                //                 lifeSum += nextGrid[i + m][j + n];
                //             }
                //         }
                //     }
                //     lifeSum = lifeSum - nextGrid[i][j];
                //     if (nextGrid[i][j] == 0) {
                //         // becomes alive with 3 alive neighbors
                //         if (lifeSum == 3) {
                //             future[i][j] = 1;
                //         } else // stays dead
                //         {
                //             future[i][j] = 0;
                //         }

                //     } // if the cell is alive
                //     else {
                //         // dies of lonliness
                //         if (lifeSum <= 1) {
                //             future[i][j] = 0;
                //         } //stays alive -- can only have 2 or 3 alive neighbors
                //         else if (lifeSum < 4) {
                //             future[i][j] = 1;
                //         } // dies of overpopulation -- has 4 or more neighbors
                //         else {
                //             future[i][j] = 0;
                //         }
                //     }
                // } // end if statement
                //else {
                    for (int m = -1; m <= 1; m++) {
                        for (int n = -1; n <= 1; n++) {
                            if((i+m >= nextGrid.length || i+m <0)&&(j+n >= nextGrid.length || j+n <0)){
                                lifeSum += nextGrid[nextGrid.length - Math.abs(i+m)][nextGrid.length - Math.abs(j+n)];
                                System.out.println("0 0 ok");
                            }
                            else{
                                if((i+m >= nextGrid.length || i+m <0)&&(j+n < nextGrid.length || j+n >=0)){
                                    System.out.println("" + i + " " + j + " " + m + " " + n + " ok1");
                                    lifeSum += nextGrid[nextGrid.length - Math.abs(i+m)][j+n];
                                }
                                else{
                                    if(j+n >= nextGrid.length || j+n <0){
                                        System.out.println("" + i + " " + j + " " + m + " " + n + " ok2");
                                        lifeSum += nextGrid[i + m][nextGrid.length - Math.abs(j+n)];
                                    }
                                    else{
                                        System.out.println("" + i + " " + j + " " + m + " " + n + " ok3");
                                        lifeSum += nextGrid[i + m][j + n];
                                    }
                                }
                            }   
                            
                        }
                    }
                    System.out.println("Okay till here");

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

                //}// end else

            }// end second outer loop - j
        }// end most outer loop -- i

        // retuns new grid
        return future;
    } // ends nextGeneration method
    public static void main(String[] args)
    {
        int x = 80;
        int y = 80;
        int m = Integer.parseInt(args[0]);
        int k1 = Integer.parseInt(args[1]);
        
        Model picDemo = new Model(x,y,m);
        int[][]grid11 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        int[][]grid1 = new int[80][80];
        for (int j = 0; j<grid1.length; j++){
            for(int i=0; i<grid1.length; i++){
                grid1[j][i] = 0;
            }
        }

        for (int j = 0; j<grid11.length; j++){
            for(int i=0; i<grid11.length; i++){
                grid1[j][i] = grid11[j][i];
            }
        }
        
        for (int j = 0; j < y; j++)
        {
            for (int i = 0; i < x; i++)
            {
                picDemo.drawCell(i,j, grid1);
            }
        }
        picDemo.show();
        // try 
        //     {
        //         Thread.sleep(2000);
        //     } 
        //     catch(InterruptedException e)
        //     {
        //         System.out.println("omg");
        //     }
        // grid1 = nextGeneration(grid1);
        // for (int j = 0; j < y; j++)
        // {
        //     for (int i = 0; i < x; i++)
        //     {
        //         System.out.println(""+grid1[j][i]+"\t");
        //     }
        //     System.out.println("\n");
        // }
        for(int k=1; k<=k1; k++)
        {
            grid1 = nextGeneration(grid1);
            
            //System.out.println(Arrays.deepToString(grid1));
            try 
            {
                Thread.sleep(2000);
            } 
            catch(InterruptedException e)
            {
                System.out.println("omg");
            }
            for (int j = 0; j < y; j++)
            {
                for (int i = 0; i < x; i++)
                {
                    picDemo.drawCell(i,j, grid1);
                }
            }
            picDemo.show();
        }

    }
}