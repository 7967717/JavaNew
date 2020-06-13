package io.rr.javapuzzlers._8classierpuzzlers.puzzle73.client;

import io.rr.javapuzzlers._8classierpuzzlers.puzzle73.library.Api;

/**
 * This class must make use of some member or constructor exported by
 * library.Api, such that this class (client.Client) compiles if and only if
 * the commented-out private declaration in the source file for library.Api
 * remains commented out.
 */
public class Client {
    String s = Api.newString();

    int answer = Api.ANSWER;
}
