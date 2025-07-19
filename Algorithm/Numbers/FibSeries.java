package Numbers;

public class FibSeries {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ,");
        }

        System.out.println(" ");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci2(i) + " ,");
        }

    }

    static int fibonacci(int n) {

        if(n <= 1) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }

    }

    static int fibonacci2(int n) {
        return n <= 1 ? n : fibonacci2(n-1) + fibonacci2(n-2);
    }
}
