import java.util.Scanner;

class MultipleFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        System.out.println(f(x));
    }

    public static double f(double x) {
        if (x < 1 || x > 0) {
            return f3(x);
        } else if (x >= 1) {
            return f2(x);
        } else {
            return f1(x);
        }
    }

    //implement your methods here
    public static double f1(double x) {
        return (x * x) + 1D;
    }

    public static double f2(double x) {
        return (x * x) - 1D;
    }

    public static double f3(double x) {
        return 1D / (x * x);
    }
}