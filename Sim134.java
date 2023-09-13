import java.awt.Color;
import java.util.Arrays;
import java.util.Random;
public class Sim134{
    public static void main(String[] args)
    {
        String var1 = args[0];
        
        if(var1.equals("J"))
        {
            int x = 80;
            int y = 80;
            int m = 10;
            int k1 = Integer.parseInt(args[1]);
            Initial picDemo = new Initial(m);
            int[][]grid11 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
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

            for (int j = 0; j < y; j++)
            {
                for (int i = 0; i < x; i++)
                {
                    picDemo.drawCell(i,j, grid1);
                }
            }
            picDemo.show();
            try 
                {
                    Thread.sleep(2000);
                } 
                catch(InterruptedException e)
                {
                    System.out.println("omg");
                }
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
                grid1 = picDemo.nextGeneration(grid1);
                
                //System.out.println(Arrays.deepToString(grid1));
                try 
                {
                    Thread.sleep(k1*10);
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
        else
        {
            
            int x = 80;
            int y = 80;
            int m = 5;
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
            if(var1.equals("D"))
            {
                for (int j = 0; j<grid11.length; j++){
                    for(int i=0; i<grid11.length; i++){
                        grid1[j][i] = grid11[j][i];
                    }
                }
            }
            if(var1.equals("R"))
            {
                for (int j = 0; j<grid1.length; j++){
                    for(int i=0; i<grid1.length; i++){
                        grid1[j][i] = new Random().nextBoolean() ? 1: 0;;
                    }
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
            
            for(int k=1; k<=k1; k++)
            {
                grid1 = picDemo.nextGeneration(grid1);
                
                //System.out.println(Arrays.deepToString(grid1));
                // try 
                // {
                //     Thread.sleep(2000);
                // } 
                // catch(InterruptedException e)
                // {
                //     System.out.println("omg");
                // }
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

}