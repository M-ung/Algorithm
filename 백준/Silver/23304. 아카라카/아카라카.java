import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        System.out.println(isAKARAKA(s) ? "AKARAKA" : "IPSELENTI");


    }

    private static boolean isAKARAKA(String s) {
        if(!isPalindrome(s)) {
            return false;
        }

        if (s.length() == 1) {
            return true;
        }

        int halfLength = s.length() / 2;
        String prefix = s.substring(0, halfLength);
        String suffix = s.length() % 2 == 0 ? s.substring(halfLength) : s.substring(halfLength + 1);

        return isAKARAKA(prefix) && isAKARAKA(suffix);
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}