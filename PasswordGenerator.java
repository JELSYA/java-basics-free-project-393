public class PasswordGenerator{
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*";

    public static String generatePassword(int length, boolean useUppercase, boolean useDigits, boolean useSpecial) {
        String word = LOWERCASE;
        if (useUppercase) {
            word += UPPERCASE;
        }
        if (useDigits) {
            word += DIGITS;
        }
        if (useSpecial) {
            word += SPECIAL;
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