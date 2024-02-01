public class LowerCase {
    public static void main(String[] args) {

        String x = args[0];
        System.out.println(lowerCase(x));
    }

    /**
     * Returns a string which is identical to the original string,
     * except that all the upper-case letters are converted to lower-case letters.
     * Non-letter characters are left as is.
     */
    public static String lowerCase(String s) {
        // Replace the following statement with your code String str = args[0];
        StringBuilder snew = new StringBuilder(s);
        char c1;
        for (int i = 0; i < s.length(); i++) {

            if ((s.charAt(i) >= 'A') && (s.charAt(i) <= 'Z')) {
                c1 = (char) (s.charAt(i) + 32);
                snew.setCharAt(i, c1);
            }
        }
        return snew.toString();

    }
}
