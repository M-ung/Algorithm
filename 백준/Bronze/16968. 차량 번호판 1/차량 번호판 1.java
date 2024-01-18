import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();

        int total = 1; // 전체 횟수
        char pre_index = 'n'; // 반복문 첫 번째 일 땐, 앞 문자가 없기 때문에 대비용으로 'n'이라고 가정했다.

        for(int i = 0; i < st.length(); i++) {
            char now_index = st.charAt(i);
            if (now_index == 'c') { // 인덱스가 c 일 때,
                if(pre_index == now_index) {
                    total = total * 25;
                }
                else {
                    total = total * 26;
                }
            }
            else { // 인덱스가 d 일 때,
                if(pre_index == now_index) {
                    total = total * 9;
                }
                else {
                    total = total * 10;
                }
            }
            pre_index = now_index;
        }
        System.out.println(total);
    }
}