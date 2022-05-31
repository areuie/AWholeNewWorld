
public class Word {
    String word;
    int x, y;
    Word (String word) {
        this.word = word;
        this.x = (int) (Math.random() * 100) + 1200 - SceneJobGame.backgroundX;
        this.y = (int) (Math.random() * 150) + 350;
        System.out.println("initalize " + x + " " + y + " " + SceneJobGame.backgroundX);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getWord() {
        return word;
    }

    public void setWord(String substring) {
        word = substring;
    }
}
