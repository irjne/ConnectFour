import java.util.Arrays;

public class ConnectFour
{
    private int [][] grid;
    private int checkRow [];
    private int lastColour=0;
    private int numberOfRounds=0;

    public ConnectFour()
    {
        this.grid = new int[7][6];
        this.checkRow = new int [7];
    }

    public int getLastColour() {return lastColour;}

    public int setColourAt (int column, int colour)
    {
        if (colour!=1 && colour!=5) return 1; //colore errato
        if (lastColour==colour) return 2; //turno errato
        if (checkRow[column]==6) return 3; //colonna piena
        if (column <0 || column >6) return 4; //fuori griglia

        this.grid[column][checkRow[column]]=colour;
        checkRow[column]++;
        lastColour=colour;
        numberOfRounds++;
        return 0; //turno accettato
    }
	
	private int checkWinnerOnFirstDiagonal ()
	{
		int index=0;
        for (int i=0; i<3; i++)
        {
            int aux = i;
            for (int j = 3 + index; j < 4 ; j--)
            {
                int sum = grid[i][j] + grid[i + 1][j - 1] + grid[i + 2][j - 2] + grid[i + 3][j - 3];
                if (sum == 4 || sum == 20) return 0; //vittoria
                else
                {
                    if (index < 3) index++;
                    else index=0;

                    j = 3 + index;
                    i = aux-1;
                }
            }
		}

        return -1;
	}

    public int checkWinner ()
    {
        int index;

        // verifica forza 4 per le righe: shift da 0 a 4 -> [x+shift][y]
        for (int i=0; i<6; i++) //righe
            for (int shift=0; shift<4; shift++) //colonne
            {
                int sum=grid[shift][i]+grid[1+shift][i]+grid[2+shift][i]+grid[3+shift][i];
                if (sum==4 || sum==20) return 0; //vittoria
            }

        for (int i=0; i<7; i++)
            for (int shift=0; shift<3; shift++)
            {
                int sum=grid[i][shift]+grid[i][1+shift]+grid[i][2+shift]+grid[i][3+shift];
                if (sum==4 || sum==20) return 0; //vittoria
            }

        if (this.numberOfRounds==21) return 1;

        //diagonali mancanti
        return -1;
    }

    public void stampGrid()
    {
        for (int i=5; i>-1; i--)
        {
            for (int j=0; j<7; j++) {
                if (grid[j][i] != 0) System.out.print("|\t" + grid[j][i] + "\t");
                else System.out.print("|\t \t");
            }
            System.out.print("|\n");
        }
        System.out.print("\n");
    }
}
