public class PasswordGenerator{
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*";

    public static String generatePassword(int length, long seed, boolean useUppercase, boolean useDigits, boolean useSpecial) {
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
        long current = seed;

        for (int i = 0; i < length; i++) {
            current = nextRandom(current);
            int index = (int) (current % number);
            newWord.append(word.charAt(index));
        }
        return newWord.toString();
    }

    private static long nextRandom(long number) {
        return (16807L * number) % 2147483647L;
    }
}