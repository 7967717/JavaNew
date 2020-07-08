package io.rr.javapuzzlers._8classierpuzzlers.puzzle70.hack;

import io.rr.javapuzzlers._8classierpuzzlers.puzzle70.click.CodeTalk;

public class TypeIt {
    private static class ClickIt extends CodeTalk {
        protected void printMessage() {
            System.out.println("Hack");
        }
    }

    public static void main(String[] args) {
        ClickIt clickit = new ClickIt();
        clickit.doIt();
    }
}
