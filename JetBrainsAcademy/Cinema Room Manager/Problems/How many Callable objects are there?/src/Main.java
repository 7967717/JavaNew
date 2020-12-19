import java.util.concurrent.*;


class FutureUtils {

    public static int determineCallableDepth(Callable callable) throws Exception {
        // write your code here
        Object call = callable.call();
        if (call instanceof Callable) {
            return 1 + determineCallableDepth((Callable) call);
        } else {
            return 1;
        }
    }

//    private static int go(Callable callable, int res) {
//        res++;
//        try {
//            if(callable.call() instanceof Callable) {
//                go((Callable) callable.call(), res);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return res;
//    }
}

//public class Main {
//    public static void main(String[] args) throws Exception {
//        Callable callable = () -> (Callable) () -> (Callable) () -> (Callable) () -> null;
//        System.out.println(FutureUtils.determineCallableDepth(callable));
//    }
//}