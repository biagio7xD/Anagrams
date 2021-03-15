public class Anagram {
    private String word;
    private int maxNumOfAnagrams;
    private char[] wordInLetter;
    private int fixedLetter;
    private int counter;

    public Anagram(String word, int numPermunations) {
        this.word = word;
        this.wordInLetter = new char[this.word.trim().length()];
        this.wordInLetter = this.word.toLowerCase().trim().toCharArray();
        this.fixedLetter = 0;
        this.counter = 0;
        MultiSetPermutation maxNumPermutations = new MultiSetPermutation(word);
        maxNumPermutations.calculateFactorial();
        if(numPermunations > 0 && numPermunations <= maxNumPermutations.getMaxNumberOfPermutation()) {
            this.maxNumOfAnagrams = numPermunations;
        } else {
            this.maxNumOfAnagrams = maxNumPermutations.getMaxNumberOfPermutation();
        }

    }

    public Anagram(String word) {
        this.word = word;
        this.wordInLetter = new char[this.word.length()];
        this.wordInLetter = this.word.toLowerCase().trim().toCharArray();
        this.fixedLetter = 0;
        this.counter = 0;
        MultiSetPermutation maxNumPermutations = new MultiSetPermutation(word);
        maxNumPermutations.calculateFactorial();
        this.maxNumOfAnagrams = maxNumPermutations.getMaxNumberOfPermutation();
    }

    public void makeAnagrams(char[] wordInletters, int fixedLetters) {
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