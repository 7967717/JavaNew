package io.rr.java8.ionio;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTTPserver {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8080), 0);

        server.createContext("/",
                new HttpHandler() {
                    public void handle(HttpExchange exchange) throws IOException {
                        URI uri = exchange.getRequestURI();
                        String query = uri.getQuery() == null ? "" : uri.getQuery();
                        System.out.println(query);
                        Map<String, String> map = queryToMap(query);
                        String code = map.getOrDefault("code", "no params");
                        System.out.println(code);
                        exchange.sendResponseHeaders(200, code.length());
                        exchange.getResponseBody().write(code.getBytes());
                        exchange.getResponseBody().close();
                    }
                }
        );

        server.start();
    }

    private static Map<String, String> queryToMap(String query) {
        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length > 1) {
                result.put(pair[0], pair[1]);
            } else {
                result.put(pair[0], "");
            }
        }
        return result;
    }
}

class HTTPclient {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        System.out.println();
        List<String> list = List.of("code=myCode", "param=", "par");
        sendRequests(client, "localhost:8080", list);

    }

    private static void sendRequests(HttpClient client, String path, List<String> params) throws IOException, InterruptedException {
        for (String param : params) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://" + path + "?" + param))
                    .GET()
                    .build();
            HttpResponse<String> response1 = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response1.body());
        }
    }
}

class HTTPclient1 {
    private static String authorizationCode = "17afd21c93d34971a1d12aef3511977a";
    private static String redirectUri = "http://localhost:8080";
    public static void main(String[] args) {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create("https://accounts.spotify.com/api/token"))
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=authorization_code" +
                        "&code=" + authorizationCode + "&redirect_uri=" + redirectUri +
                        "&client_id=17afd21c93d34971a1d12aef3511977a" +
                        "&client_secret=f5aef08f1301445b8801dc3dc92dae10"))
                .build();
        System.out.println(request);
        System.out.println(request.bodyPublisher().get());
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

//        System.out.println("response:\n" + response.body());

    }
}
