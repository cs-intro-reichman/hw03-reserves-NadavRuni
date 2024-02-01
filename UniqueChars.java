
public class UniqueChars {
    public static void main(String[] args) {
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    public static String uniqueChars(String s) {
        StringBuilder snew = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            boolean a = false;

            for (int j = 0; j < snew.length(); j++) {
                if ((s.charAt(i) == snew.charAt(j)) && (s.charAt(i) != ' ')) {
                    a = true;
                    break;
                }

            }
            if (a == false) {

                snew.append(s.charAt(i));
            }

        }

        return snew.toString();
    }
}