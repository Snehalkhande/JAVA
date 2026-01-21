import java.util.Scanner;
import java.util.Arrays;
class TicTacToeGame
{
    public static void main(String[] args)
    {
        int rows = 3, columns = 3;
        char [][] grid = createGrid(rows,columns);
        Arrays.fill(grid[0],' ');
        Arrays.fill(grid[1],' ');
        Arrays.fill(grid[2],' ');
        System.out.println("\n********* WELCOME ************");
        startGame(grid);
    }   
    public static void startGame(char [][] grid)
    {
        boolean winner = false;
        char x = 'X', o = 'O';
        boolean playerO = false;

        while(!winner)
        {
            if(playerO == false)
            {
                boolean playerX = player(grid,'X');
                checkWinner(grid);
                if(playerX==false)
                {
                    continue;
                }
            }
            playerO = player(grid, 'O');
            checkWinner(grid);
            if(playerO==false)
            {
                playerO=true;
                continue;
            }
            playerO=false;
        }
    }
    public static boolean player(char[][] grid, char player)
    {
        displayGrid(grid);
        System.out.println();
        System.out.print("Enter your response player: "+player+" | ");
        String response = new Scanner(System.in).next().toUpperCase();
        boolean check = checkResponse(grid,response,player);
        if(!check)
        {
            System.out.println("\nPlayer "+player+" should get another chance ");
            return false;
        }
        return true;
    }
    public static void checkWinner(char[][] grid)
    {
        // Horizontal
        for(int i = 0; i < 3; i++)
        {
            int cntX = 0, cntO = 0;
            for(int j = 0; j < 3; j++)
            {
                if(grid[i][j] == 'X') cntX++;
                if(grid[i][j] == 'O') cntO++;
            }
            if(cntX == 3) { displayGrid(grid); System.out.println("\nX is Winner"); System.exit(0); }
            if(cntO == 3) { displayGrid(grid); System.out.println("\nO is Winner"); System.exit(0); }
        }

        // Vertical
        for(int j = 0; j < 3; j++)
        {
            int cntX = 0, cntO = 0;
            for(int i = 0; i < 3; i++)
            {
                if(grid[i][j] == 'X') cntX++;
                if(grid[i][j] == 'O') cntO++;
            }
            if(cntX == 3) { displayGrid(grid); System.out.println("\nX is Winner"); System.exit(0); }
            if(cntO == 3) { displayGrid(grid); System.out.println("\nO is Winner"); System.exit(0); }
        }

        // Diagonal
        if((grid[0][0]=='X' && grid[1][1]=='X' && grid[2][2]=='X') ||
        (grid[0][2]=='X' && grid[1][1]=='X' && grid[2][0]=='X'))
        {
            displayGrid(grid);
            System.out.println("\nX is Winner");
            System.exit(0);
        }

        if((grid[0][0]=='O' && grid[1][1]=='O' && grid[2][2]=='O') ||
        (grid[0][2]=='O' && grid[1][1]=='O' && grid[2][0]=='O'))
        {
            displayGrid(grid);
            System.out.println("\nO is Winner");
            System.exit(0);
        }

        // Draw
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(grid[i][j] == ' ')
                    return;

        System.out.println("\nIt's a draw");
        System.exit(0);
    }

    public static boolean checkResponse(char[][] grid, String response,char player)
    {
        int i = response.charAt(0)-65;
        int j = response.charAt(1)-49;

        if(i<0 || i>2 || j<0 || j>2)
        {
            System.out.println("\nINVALID Response");
            return false;
        }
        if(grid[i][j] == ' ')
        {
            grid[i][j] = player;
            return true;
        }
        else{
            System.out.println("\n Response already submitted");
            return false;
        }
    }
    public static char[][] createGrid(int rows,int columns)
    {
        char[][] grid = new char[rows][columns];
        return grid;
    }
    public static void displayGrid(char[][] grid)
    {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                System.out.printf("%2c",grid[i][j]);
                if(j<2)
                {
                    System.out.printf("%s"," | ");
                }                        
            }
            if(i<2)
            {
                System.out.printf("%n %5s %n","_____________");
            }
        }
    }
}

