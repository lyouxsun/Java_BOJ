package implement;


import java.util.Scanner;

public class bubble_sort_implement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int input = sc.nextInt();       //정렬할 원소의 개수
        int[] arr = new int[input];
        for(int i=0;i<input;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=1;i<input;i++){
            for(int j=0;j<input-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
        for(int i=0;i<input;i++){
            sb.append(arr[i]+"\n");
        }
        System.out.println(sb);
    }

    private static void swap(int[] arr, int j, int i) {
        int tmp=arr[j];
        arr[j]=arr[i];
        arr[i]=tmp;
    }
}
