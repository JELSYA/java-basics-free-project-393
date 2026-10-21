public class Main {
    public static void main(String[] args) {
        System.out.println(PasswordGenerator.generatePassword(27, false, false, false));
        System.out.println(PasswordGenerator.generatePassword(70, true, true, true));
    }
}