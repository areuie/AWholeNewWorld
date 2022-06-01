
public class Word {
    String word;
    int x, y;
    Word (String word) {
        this.word = word;
        this.x = (int) (Math.random() * 100) + 1000 - SceneJobGame.backgroundX;
        this.y = (int) (Math.random() * 150) + 350;
        //System.out.println("initalize " + x + " " + y + " " + SceneJobGame.backgroundX);
    }
    public int getX() {
        return x + SceneJobGame.backgroundX;
    }
    public int getY() {
        return y;
    }
    public String getWord() {
        return word;
    }

    public void setX() {
        //System.out.print(x + " ");
        if (x >= 3200) x -= 3200;
        //System.out.println(word + " " + x);
    }
    public void setWord(String substring) {
        word = substring;
    }
}
