public class Anagram {
  private String word;
  private int numOfAnagrams;
  private char[] wordInLetter;
  private int fixedLetter;
  private int counter;

  public Anagram(String word, int numPermunations) {
    this.word = word;
    this.wordInLetter = new char[this.word.trim().length()];
    this.wordInLetter = this.word.toLowerCase().trim().toCharArray();
    this.fixedLetter = 0;
    this.counter = 0;
    if (numPermunations > 0) {
      this.numOfAnagrams = numPermunations;
    } else {
      MathUtils mathUtils = new MathUtils(word);
      this.numOfAnagrams = mathUtils.calculateFactorial();
    }
  }

  public void makeAnagrams() {
    makeAnagrams(this.wordInLetter, this.fixedLetter);
  }

  private void makeAnagrams(char[] wordInletters, int fixedLetters) {
    if (fixedLetters == wordInletters.length - 1) {
      if (getCounter() < getMaxNumOfAnagrams()) {
        incrementCounter();
        printAnagram(wordInletters);
      }
    } else {
      for (int j = fixedLetters; j < wordInletters.length; j++) {
        // c is created just to switch wordInletters[fixedLetters] with wordInletters[j]
        char c = wordInletters[fixedLetters];
        wordInletters[fixedLetters] = wordInletters[j];
        wordInletters[j] = c;
        makeAnagrams(wordInletters, fixedLetters + 1);
        // swap back, to avoid errors
        c = wordInletters[fixedLetters];
        wordInletters[fixedLetters] = wordInletters[j];
        wordInletters[j] = c;
      }
    }
  }

  public int incrementFixedLetters() {
    return this.fixedLetter++;
  }

  public void incrementCounter() {
    this.counter++;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public long getMaxNumOfAnagrams() {
    return numOfAnagrams;
  }

  public void setMaxNumOfAnagrams(int maxNumOfAnagrams) {
    this.numOfAnagrams = maxNumOfAnagrams;
  }

  public char[] getWordInLetter() {
    return wordInLetter;
  }

  public void setWordInLetter(char[] wordInLetter) {
    this.wordInLetter = wordInLetter;
  }

  public int getFixedLetter() {
    return fixedLetter;
  }

  public void setFixedLetter(int fixedLetter) {
    this.fixedLetter = fixedLetter;
  }

  public int getCounter() {
    return counter;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }

  private void printAnagram(char[] wordInletters) {
    System.out.print("\n" + getCounter() + ": ");
    for (int i = 0; i < wordInletters.length; i++) {
      if (i == 0) {
        char letter = Character.toUpperCase(wordInletters[i]);
        System.out.print(letter);
      } else {
        System.out.print(wordInletters[i]);
      }
    }
  }
}