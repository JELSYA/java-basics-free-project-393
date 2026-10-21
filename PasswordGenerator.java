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

    public static String checkPassword(String password){
        int score = 0;
        
        if (password.length() >= 8) {
            score++;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
        if (!hasLower && LOWERCASE.indexOf(c) >= 0) hasLower = true;
        if (!hasUpper && UPPERCASE.indexOf(c) >= 0) hasUpper = true;
        if (!hasNumber && DIGITS.indexOf(c) >= 0) hasNumber = true;
        if (!hasSpecial && SPECIAL.indexOf(c) >= 0) hasSpecial = true;

        // Все признаки найдены — дальше перебирать незачем
        if (hasLower && hasUpper && hasNumber && hasSpecial) break;
    }

        if (hasLower) score++;
        if (hasUpper) score++;
        if (hasNumber) score++;
        if (hasSpecial) score++;

        String verdict;

        if (score <= 2){
            verdict = "Слабый";
        } else if (score == 3) {
            verdict = "Средний";
        } else if (score == 4) {
            verdict = "Надежный";
        } else {
            verdict = "Очень надежный";
        }

        return verdict + " пароль (оценка " + score + " из 5)";
    }
}