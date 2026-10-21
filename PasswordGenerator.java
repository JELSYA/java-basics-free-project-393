public class PasswordGenerator{
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    public static String generatePassword(int length) {
        String word = LOWERCASE;
        int number = word.length();
        StringBuilder newWord = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = i % number;
            newWord.append(word.charAt(index));
        }
        return newWord.toString();
    }
}