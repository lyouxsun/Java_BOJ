/**
 * 666
 * 1666 / 2666 / 3666 / 4666 / 5666             -> 5개
 *
 * tmp=0
 * 6660 / 6661 / 6662 / ... / 6669              -> 10개
 * 7666 / 8666 / 9666 / 10666 / .. / 15666      -> 9개
 *
 * tmp=1
 * 16660 / ... / 16669                          -> 10개
 * 17666 / 18666 / 19666 / 20666 / .. / 25666   -> 9개
 *
 * tmp=2
 * 26660 / ... / 26669                          -> 10개
 * 27666 / ... / 35666                          -> 9개
 */
import java.util.Scanner;

public class MovieDirector_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if(input<=6){
            System.out.println(input-1+"666");
        }
        else{
            int tmp = (input-6)/19;
            int tmpR = (input-6)%19;
            if(0<tmpR || tmpR<11){
                System.out.println(tmp + "666" + (tmpR-1) );
            }
            else if(tmpR==0 || 10<tmpR){
                System.out.println();
            }
        }
    }
}
