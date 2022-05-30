import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int size = scanner.nextInt();
        int[] arr = new int[size];

        for ( int i = 0; i < size ; i++){
            arr[i]= scanner.nextInt();
        }
        int n = scanner.nextInt();

        for (int ele : arr){
            if ( ele > n){
                sum += ele;
            }
        }
        System.out.println(sum);
    }
}