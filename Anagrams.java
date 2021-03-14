public class Anagrams {
  private String word;
  private int maxNumOfAnagrams;
  private char[] wordInLetter;
  private int fixedLetter;
  private int counter;

  public Anagrams(String word, int numPermunations) {
    this.word = word;
    this.wordInLetter = new char[this.word.trim().length()];
    this.wordInLetter = this.word.toLowerCase().trim().toCharArray();
    this.fixedLetter = 0;
    this.counter = 0;
    MultiSetPermutation maxNumPermutations = new MultiSetPermutation(word);
    maxNumPermutations.calculateFactorial();
    if (numPermunations > 0 && numPermunations <= maxNumPermutations.getMaxNumberOfPermutation()) {
      this.maxNumOfAnagrams = numPermunations;
    } else {
      this.maxNumOfAnagrams = maxNumPermutations.getMaxNumberOfPermutation();
    }

  }

  public Anagrams(String word) {
    this.word = word;
    this.wordInLetter = new char[this.word.length()];
    this.wordInLetter = this.word.toLowerCase().trim().toCharArray();
    this.fixedLetter = 0;
    this.counter = 0;
    MultiSetPermutation maxNumPermutations = new MultiSetPermutation(word);
    maxNumPermutations.calculateFactorial();
    this.maxNumOfAnagrams = maxNumPermutations.getMaxNumberOfPermutation();
  }

  public void makeAnagrams(char[] letters, int fixedLetters) {
    if (fixedLetters == letters.length - 1) {
      if (getCounter() < getMaxNumOfAnagrams()) {
        incrementCounter();
        output(letters);
      }
    } else {
      for (int j = fixedLetters; j < letters.length; j++) {
        // c is created just to switch letters[fixedLetters] with letters[j]
        char c = letters[fixedLetters];
        letters[fixedLetters] = letters[j];
        letters[j] = c;
        makeAnagrams(letters, fixedLetters + 1);

        // swap back, to avoid errors
        c = letters[fixedLetters];
        letters[fixedLetters] = letters[j];
        letters[j] = c;
      }
    }
  }

  public int incrementFixedLetters() {
    return this.fixedLetter + 1;
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

  public int getMaxNumOfAnagrams() {
    return maxNumOfAnagrams;
  }

  public void setMaxNumOfAnagrams(int maxNumOfAnagrams) {
    this.maxNumOfAnagrams = maxNumOfAnagrams;
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

  private void output(char[] letters) {
    System.out.print("\n" + getCounter() + ": ");
    for (int i = 0; i < letters.length; i++) {
      if (i == 0) {
        char letter = Character.toUpperCase(letters[i]);
        System.out.print(letter);
      } else {
        System.out.print(letters[i]);
      }
    }
  }
}