import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordPhilosophy {


    public static void main(String[] args) {
        List<String> input = List.of("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");
        int countValidPassword = countValidPassword(input);

        System.err.println(countValidPassword);

    }

    public static int countValidPassword(List<String> passwordPolicies) {
        int result = 0;
        String regex = "^(\\d+)-(\\d+) (\\w): (.+)$";
        Pattern pattern = Pattern.compile(regex);

        for (String passwordPolicy : passwordPolicies) {
            Matcher matcher = pattern.matcher(passwordPolicy);

            if (matcher.find()) {
                int minCount = Integer.parseInt(matcher.group(1));
                int maxCount = Integer.parseInt(matcher.group(2));
                String characterToTrack = matcher.group(3);
                String password = matcher.group(4);

                int count = 0;

                for (int i = 0; i < password.length(); i++) {
                    if (characterToTrack.equals(String.valueOf(password.charAt(i)))) {
                        count++;
                    }
                }
                if (count >= minCount && count <= maxCount) {
                    result++;
                }
            }

        }

        return result;
    }
}
