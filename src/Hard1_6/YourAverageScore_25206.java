package Hard1_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class YourAverageScore_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double scoreSum=0;
        double creditSum =0;

        for(int i=0;i<20;i++){
            //입력값 받기 (한줄단위)
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();        //과목명
            double credit = Double.parseDouble(st.nextToken());      //학점
            String grade = st.nextToken();       //등급
            double score = 0;

            if(grade.equals("A+")) score=4.5;
            else if(grade.equals("A0")) score=4.0;
            else if(grade.equals("B+")) score=3.5;
            else if(grade.equals("B0")) score=3.0;
            else if(grade.equals("C+")) score=2.5;
            else if(grade.equals("C0")) score=2.0;
            else if(grade.equals("D+")) score=1.5;
            else if(grade.equals("D0")) score=1.0;
            else if(grade.equals("F")) score=0.0;
            else if(grade.equals("P")) continue;

            scoreSum+=credit*score;
            creditSum+=credit;
        }
        System.out.printf("%.6f", scoreSum/creditSum);
    }
}
