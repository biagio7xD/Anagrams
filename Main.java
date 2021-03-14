import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // write your code here
    while (true) {
      int numOfAnagrams = 0;
      Scanner inputScanner = new Scanner(System.in);
      System.out.println("\nInsert the word : ");
      String word = inputScanner.nextLine();
      if (word.isEmpty() || !word.matches("[A-Za-z]+")) {
        System.out.println("Please insert a valid word");
        continue;
      }
      MultiSetPermutation maxNumOfPermutations = new MultiSetPermutation(word);
      maxNumOfPermutations.calculateFactorial();
      if (maxNumOfPermutations.getMaxNumberOfPermutation() < 0) {
        System.out.println("\nOPS, I got an error. Sorry :(");
        continue;
      }
      System.out.println("The maximum numbers of anagrams available for the word: " + word.toUpperCase() + " is: "
          + maxNumOfPermutations.getMaxNumberOfPermutation());

      System.out.println(
          "Insert an integer in range [ " + 1 + ", " + maxNumOfPermutations.getMaxNumberOfPermutation() + " ] : ");
      numOfAnagrams = inputScanner.nextInt();
      if (numOfAnagrams < 0) {
        System.out.println("Please insert a valid integer :)");
        continue;
      } else {
        if (numOfAnagrams == 0) {
          System.out.print("You inserted 0 as integer value, so I find for you all possible anagrams");
        }
        Anagrams anagrams = new Anagrams(word, numOfAnagrams);
        anagrams.makeAnagrams(anagrams.getWordInLetter(), anagrams.getFixedLetter());
      }
    }
  }
}