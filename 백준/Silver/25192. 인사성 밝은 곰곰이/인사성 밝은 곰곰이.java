import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet enterMember = new HashSet(); //유저 닉네임둘 저장하는 (한 ENTER의)

        int N = Integer.parseInt(br.readLine()); //채팅방 기록 수
        int count = 0; // 곰곰 이모티콘을 사용한 횟수를 저장하는

        while(N --> 0) { //N이 0이 될까지 반복 (N--; N > 0; 이 두 가지를 합쳐놓은 것)
            String str = br.readLine();

            if(str.equals("ENTER")) { //들어옴 (기존 유저 초기화)
                count += enterMember.size(); //기존에 저장된 유저의 닉네임 중복제거한 개수를 누적 더하기
                enterMember.clear(); //누적 더하기 한 후에 초기화한다. (새로 세야하기 때문)
                continue; //ENTER은 유저 닉네임에 속하지 않으므로 다음 반복문으로 넘어간다.
            }

            enterMember.add(str);
        }

        //모두 입력 받았으면 마지막 ENTER의 곰곰임티 횟수(들어온 사람의 수)를 누적 더하기 해줘야함
        count += enterMember.size();

        bw.write(count + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}