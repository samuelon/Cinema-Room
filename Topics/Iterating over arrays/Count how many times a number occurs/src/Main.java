import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int count = 0;
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] array = new int[size];  // creating an array with the specified length

        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt(); // read the next number of the array
        }
        int n = scan.nextInt();
        for (int i = 0; i < size; i++){
            if(array[i] == n){
                count++;
            }
        }
        System.out.println(count);
    }
}