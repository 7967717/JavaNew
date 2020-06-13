package io.rr.concurrent.sync;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author roman on 5/2/17.
 */
public class Preloader {
    private final FutureTask<ProductInfo> future =
            new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
                public ProductInfo call() throws Exception {
                    return loadProductInfo();
                }
            });

    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws Throwable {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            throw new Throwable(cause);
        }
    }

    private ProductInfo loadProductInfo() {
        return new ProductInfo();
    }
}

class ProductInfo {

}