import java.util.List;

public class PasswordPhilosophy {


    public static void main(String[] args) {
        List<String> input = List.of("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");
        var countValidPassword = countValidPassword(input);

        System.err.println(countValidPassword);

    }

    public static int countValidPassword(List<String> passwordPolicies) {
        int result = 0;

        for (String passwordPolicy : passwordPolicies) {
            String[] passwordPolicyArray = passwordPolicy.replace(":", "").split("[\s-]");

            String characterToTrack = passwordPolicyArray[2];

            int count = 0;

            String password = passwordPolicyArray[3];

            for (int i = 0; i < password.length(); i++) {
                if (characterToTrack.equals(String.valueOf(password.charAt(i)))) {
                    count++;
                }
            }

            if (count >= Integer.parseInt(passwordPolicyArray[0]) && count <= Integer.parseInt(passwordPolicyArray[1])) {
                result++;
            }
        }

        return result;
    }
}
