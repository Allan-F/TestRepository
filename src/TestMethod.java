
public class TestMethod {

    private static final int ASCII_CHARS_NUMBER = 128;

    public static void main(String[] args) {
        String alphabet1 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(getOrderedString("bca", alphabet1));
        System.out.println(getOrderedString("azzbycx", alphabet1));

        String alphabet2 = "agbfced";

        System.out.println(getOrderedString("fbga", alphabet2));
        System.out.println(getOrderedString("daegcabf", alphabet2));
    }

    /**
     * Method orders chars in text with complexity O(N + M)
     * @param text Arbitrary text to order (length of text is N chars)
     * @param alphabet Arbitrary alphabet (length of alphabet is M chars)
     * @return Ordered text
     */
    private static String getOrderedString(String text, final String alphabet) {
        int[] charsCounter = new int[ASCII_CHARS_NUMBER]; //initialized with all 0
        for (int i = 0; i < text.length(); i++) { // N actions
            int asciiCode = text.charAt(i); //charAt - constant time operation
            charsCounter[asciiCode] += 1; // set value to n-th array element - constant time operation
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < alphabet.length(); i++) { // M actions
            char alphabetChar = alphabet.charAt(i); //charAt - constant time operation
            int numberOfSuchChars = charsCounter[alphabetChar]; // get value of n-th array element - constant time operation
            if (numberOfSuchChars > 0) {
                for (int j = 0; j < numberOfSuchChars; j++) { // X actions which represent number of duplications
                    result.append(alphabetChar); //adding single char to StringBuilder - constant time operation
                }
            }
        }

        return result.toString(); // not more than O(M) actions
    }
}
