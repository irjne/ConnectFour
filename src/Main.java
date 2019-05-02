import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        int choice;
        ConnectFour game = new ConnectFour ();

        do
        {
            System.out.println("--- MENU --- \n");
            System.out.println("0- new match; ");
            System.out.println("1- new round; ");
            System.out.println("2- grid; ");
            System.out.println("3- exit. ");

            System.out.print("\nChoice: ");
            Scanner scanIn = new Scanner(System.in);
            choice = scanIn.nextInt();

            switch (choice)
            {
                case 1:
                {
                    System.out.println("--- NEW ROUND ---\n");
                    System.out.print("Choose your colour, only '1' (red) or '5' (yellow) accepted: ");
                    int colour = scanIn.nextInt();
                    System.out.print("Type the position where you want to put your money: ");
                    int x = scanIn.nextInt();

                    int result=game.setColourAt(x, colour);

                    if (result==0)
                    {
                        System.out.println("Round accepted.\n");
                        int winner = game.checkWinner();

                        if (winner==0) System.out.println("Player '"+ game.getLastColour() +"' wins!\n");
                        else if (winner==1) System.out.println("Match finished in a draw.\n");
                    }
                    else if (result==4) System.out.println("The column "+x+" doesn't exist.\n");
                    else if (result==3) System.out.println("You can't move in position "+x+", it's full!\n");
                    else if (result==2) System.out.println("It's not your turn.\n");
                    else if (result==1) System.out.println("Invalid colour. Please choose '1' (red) or '5' (yellow).\n");
                }
                break;

                case 2:
                {
                    System.out.println("--- STAMP GRID ---\n");

                    game.stampGrid();
                }
                break;
                default: System.out.println("Error: invalid choice. Please select an option between 0 and 2.\n");
            }

        } while (choice!=3);
    }
}
