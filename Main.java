
public class Main {

  public static void main(String[] args) {
    // write your code here
    System.out.println("Insert the word : ");
    Scanner inputScanner = new Scanner(System.in);
    String word = inputScanner.nextLine();
    inputScanner.close();
    if (word.isEmpty() || !word.matches("[A-Za-z]+")) {
      System.out.println("Please insert a valid word\n");
      return;
    }
    MathUtils mathUtils = new MathUtils(word);
    int maxNumOfAnagrams = mathUtils.calculateFactorial();
    if (maxNumOfAnagrams < 0) {
      System.out.println("OPS, I got an error. Sorry :(");
      return;
    }
    if (args.length > 0 && args[0] != null) {
      int numOfAnagrams = Integer.parseInt(args[0]);
      if (numOfAnagrams < 0) {
        System.out.println("Please insert a valid integer via command line :)\n");
        return;
      }
      if (numOfAnagrams == 0) {
        System.out.print("You inserted 0 as integer value, so I find for you all possible anagrams\n");
      }
      System.out.println("Anagrams to print : " + numOfAnagrams + " of " + maxNumOfAnagrams + "\n");
      Anagram anagrams = new Anagram(word, numOfAnagrams);
      anagrams.makeAnagrams();
      System.out.println("\n");
    } else {
      System.out.println("Insert an Integer via command line\n");
      return;
    }
  }
}
