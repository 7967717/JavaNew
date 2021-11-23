package io.rr.tests.test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ToUpperCase {
    public static void main(String[] args) throws IOException {
//        System.out.println("suspected".toUpperCase());
        Path path = Paths.get(Paths.get("-/test/path/tofile").toFile().getCanonicalPath());
        System.out.println(path);
    }
}
