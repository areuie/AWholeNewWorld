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
    /** This variable stores the original value of the word */
    String ogWord;
    /** These variables store the x,y coords of the word */
    int x, y;
    char type;
    static String[] bad = {
            "IGNORESTRESS",
            "LEAVEUNRESOLVED",
            "KEEPTOSELF" ,
            "RESENTMENT",
            "HATRED",
            "UNGRATEFUL"
    };

    static String[][] good = {
            { //MAKING FRIENDS
                    "COMMUNICATION",
                    "COMMUNITYCENTRE" ,
                    "FINDSIMILARBACKGROUND",
                    "TAKEINITATIVE"
            },
            { //GENERAL STRESS
                    "MEDITATION",
                    "DEEPBREATHS",
                    "REACHOUT"
            },
            {// ACCENT
                    "STANDUP",
                    "TELLTEACHER",
                    "TELLPARENTS" ,
                    "BEPROUD",
            },
            { // MISS FAMILY
                    "CALLFAMILY",
                    "SENDMAIL",
            },
            { //FEEL LIKE YOU DON'T BELONG
                    "CULTURALMEDIA",
                    "NEWCOUNTRYMEDIA",
            },
            { //FINANCE
                    "EMPATHETIC",
                    "UNDERSTANDING",
                    "GRATEFUL",
            },
            { //LUNCH
                    "STANDUP",
                    "TELLTEACHER",
                    "TELLPARENTS",
                    "BEPROUD",
            },
            {// SUPPORT PARENTS
                    "HELPCHORES",
                    "EDUCATION",
                    "TRANSLATOR"
            },
    };

    /**
     * The constructor
     * @param type Type of word (good/bad)
     */
    Word (char type) {
        this.type = type;
        if (type == 'g') {
            word = good[SceneJobGame.stage][(int) (Math.random() * good[SceneJobGame.stage].length)];
            ogWord = word;
        } else {
            word = bad[(int) (Math.random() * bad.length)];
            ogWord = word;
        }
        this.x = (int) (Math.random() * 100) + 800 - SceneJobGame.backgroundX;
        this.y = (int) (Math.random() * 280) + 250;
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
     * This method gets the type of word (good/bad)
     * @return type Type
     */
    public int getType() { return type; }

    /**
     * This method gets the word
     * @return Word
     */
    public String getWord() {
        return word;
    }

    /**
     * This method gets the original word
     * @return Word
     */
    public String getOgWord() {
        return ogWord;
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
