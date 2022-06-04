/**
 * The Word class is used for initializing word objects in the SceneJobGame class
 *
 * <h3>Draft 3</h3>
 * <p>
 * Version 1 - 30 min
 * Added variables
 * Added getter/setter
 * - Alisa
 * </p>
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 06.03.22
 *
 * <h2> Course Info:</h2>
 * ICS4U0
 * Mrs. Krasteva
 *
 */
public class Word {
    /** This variable stores the string value of the word */
    String word;
    /** These variables store the x,y coords of the word */
    int x, y;

    /**
     * The constructor
     * @param word Word string
     */
    Word (String word) {
        this.word = word;
        this.x = (int) (Math.random() * 100) + 1000 - SceneJobGame.backgroundX;
        this.y = (int) (Math.random() * 150) + 350;
        //System.out.println("initalize " + x + " " + y + " " + SceneJobGame.backgroundX);
    }

    /**
     * This method gets the x coord
     * @return x coord
     */
    public int getX() {
        return x + SceneJobGame.backgroundX;
    }

    /**
     * This method gets the y coord
     * @return y coord
     */
    public int getY() {
        return y;
    }

    /**
     * This method gets the word
     * @return Word
     */
    public String getWord() {
        return word;
    }

    /**
     * This method sets the x coordinate
     */
    public void setX() {
        //System.out.print(x + " ");
        if (x >= 3200) x -= 3200;
        //System.out.println(word + " " + x);
    }

    /**
     * This method sets the word
     * @param substring String to be changed to
     */
    public void setWord(String substring) {
        word = substring;
    }
}
