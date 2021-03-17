public class MathUtils {
  private final String word;
  private int lengthOfWord;

  public MathUtils(String word) {
    this.word = word.trim();
    this.lengthOfWord = word.length();
  }

  public int getLengthOfWord() {
    return lengthOfWord;
  }

  public void setLengthOfWord(int lengthOfWord) {
    this.lengthOfWord = lengthOfWord;
  }

  public int calculateFactorial() {
    int result = getLengthOfWord();

    for (int i = 1; i < getLengthOfWord(); i++) {
      result = result * i;
    }
    return result;
  }
}