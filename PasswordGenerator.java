public class PasswordGenerator{
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";

    public static String generatePassword(int length, boolean useUppercase, boolean useDigits) {
        String word = LOWERCASE;
        if (useUppercase) {
            word += UPPERCASE;
        }
        if (useDigits) {
            word += DIGITS;
        }
        int number = word.length();
        StringBuilder newWord = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = i % number;
            newWord.append(word.charAt(index));
        }
        return newWord.toString();
    }
}