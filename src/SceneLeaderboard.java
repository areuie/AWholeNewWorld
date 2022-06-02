import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SceneLeaderboard extends JPanel {
    private static String[] playerName;
    private static int[] playerScore;

    SceneLeaderboard() {
        playerName = new String[10];
        playerScore = new int[10];
        openFile();
    }

    public void openFile ()  //opens class file
    {
        BufferedReader input;
        boolean fileExists = false;

        try
        {
            File file = new File("src/data/Leaderboard.txt"); ///checks if file exists
            fileExists = file.exists ();
            System.out.println("hi");
            if (fileExists)
            {
                input = new BufferedReader (new FileReader ("src/data/Leaderboard.txt"));
                System.out.println("hi2");
                String line = "";

                int count = 0;

                while (count < 3) //stores student names and marks until there are no more lines to read
                 {
                     line = input.readLine ();

                     String[] words = line.split ("\\ ");
                     playerName [count] = words [0];
                     playerScore [count] = Integer.parseInt (words [1]);
                     System.out.println(playerName[count] + " " + playerScore[count]);
                     count++;
                 }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void addLeaderboard (String name, long score)  //adds data to leaderboard
    {
        int i = 0;
        boolean scoreAdded = false; //stops while loop if score already is added

        while (i < 10 && !scoreAdded)
        {
            if ((score != -1 && score < playerScore [i]) || (score != -1 && playerScore [i] == -1)) //if all 10 leaderboard spots are taken
            {
                moveLeaderboard (i);
                playerName [i] = name;
                playerScore [i] = (int) score;
                scoreAdded = true;

            }
            else if (playerName [i] == null) //if score is not high enough and theres space in the leaderboard, it will fit the lowest avalible spot
            {
                playerName [i] = name;
                playerScore [i] = (int) score;
                scoreAdded = true;
            }
            i++;
        }
    }


    private void moveLeaderboard (int position)  //moves leaderboard down to fit new score
    {
        String lastPlayerName = null;
        int lastPlayerScore = -1;

        for (int i = 10 ; i > position ; i--)
        {
            if (playerName [i] == null) //fits lowest empty space
            {
                lastPlayerName = playerName [i];
                lastPlayerScore = playerScore [i];
            }
            try
            {
                if (playerName [i] != null) //if there are no empty spaces on the leaderboard, the leaderboard removes the worst score to fit better score

                {
                    playerName [i] = playerName [i - 1];
                    playerScore [i] = playerScore [i - 1];
                }
            }
            catch (Exception e)
            {
            }

        }
    }


    private void saveFile ()  //saves leaderboard file
    {
        PrintWriter output;
        try
        {
            output = new PrintWriter (new FileWriter("Leaderboard.txt")); //creates new printwriter to write to file

            output.println ("AWNW"); //writes file header and class size
            output.println ("10");

            int i = 0;
            while (i < 10 && playerName [i] != null)
            {
                output.println (playerName [i] + " " + playerScore [i]);
                i++;
            }
            output.close (); //saves
        }


        catch (IOException e)
        {

        }
    }

    private void resetHighScores ()  //resets high scores
    {
        for (int i = 0 ; i < 10 ; i++) //changes all player names to null/empty
        {
            playerName [i] = null;
        }


        saveFile ();
    }

    /**
     * This method creates the background and graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.setFont(Game.font.deriveFont(30f));

        int counter = 0;
        while (playerName [counter] != null && counter < 10) //displays all scores until last submission until 10
        {
            String scoreText = Integer.toString (playerScore [counter]) + " pts";
            if (playerScore [counter] == -1) //all failed scores are -1
                scoreText = "FAILED";

            g.drawString (playerName[counter] + " " + scoreText, 100, 225 + counter * 40);
            counter++;
        }


        g.drawString ("Press 1 to reset leaderboards", 100, 250 + counter * 40);
        g.drawString ("Press space to go back to the menu", 100, 250 + (counter + 1) * 40);

    }

    /**
     * This method determines the dimensions of the panel
     * @return The dimensions of the panel
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
}
