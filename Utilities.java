public class Utilities {
  private int maxNumberOfPermutation;
  private StringBuffer wordInLetters;
  private String word;
  private int lengthOfWord;

  public Utilities(String word) {
    this.word = word.toLowerCase().trim();
    this.lengthOfWord = word.length();
    this.wordInLetters = new StringBuffer(word);
    this.maxNumberOfPermutation = 0;

  }

  public StringBuffer getWordInLetters() {
    return wordInLetters;
  }

  public void setWordInLetters(StringBuffer wordInLetters) {
    this.wordInLetters = wordInLetters;
  }

  public int getLengthOfWord() {
    return lengthOfWord;
  }

  public void setLengthOfWord(int lengthOfWord) {
    this.lengthOfWord = lengthOfWord;
  }

  public int getMaxNumberOfPermutation() {
    return maxNumberOfPermutation;
  }

  public void setMaxNumberOfPermutation(int maxNumberOfPermutation) {
    this.maxNumberOfPermutation = maxNumberOfPermutation;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public void calculateFactorial() {
    int lenghtWord = getLengthOfWord();
    int result = getLengthOfWord();

    for (int i = 1; i < lenghtWord; i++) {
      result = result * i;
    }
    setMaxNumberOfPermutation(result);
  }
}