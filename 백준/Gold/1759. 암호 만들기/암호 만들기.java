import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        dfs(0, 0, 0, "");

        System.out.print(sb.toString());
    }

    private static void dfs(int start, int vowel, int consonant, String result) {
        if (result.length() == L) {
            if (vowel >= 1 && consonant >= 2) {
                sb.append(result).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            char current = arr[i];
            if (isVowel(current)) {
                dfs(i + 1, vowel + 1, consonant, result + current);
            } else {
                dfs(i + 1, vowel, consonant + 1, result + current);
            }
        }
    }

    private static boolean isVowel(char current) {
        for (char vowel : vowels) {
            if (current == vowel) {
                return true;
            }
        }
        return false;
    }
}