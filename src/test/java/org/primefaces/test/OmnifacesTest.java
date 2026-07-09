package org.primefaces.test;

import org.junit.jupiter.api.Test;

import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;


public class OmnifacesTest {

    //Use a cookieManager so the same JSESSIONID is used
    HttpClient client = HttpClient.newBuilder().cookieHandler(new CookieManager()).build();

    @Test
    public void keyFilterTest() throws InterruptedException {
        doRequest(); //Do a first request to load the jsessionId cookie
        var threads = new ArrayList<Thread>();
        for (var i = 0; i < 15; i++) {
            var t = new Thread(() -> doRequest());
            threads.add(t);
            t.start();
        }
        for (var t : threads) {
            t.join();
        }
    }

    private void doRequest() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/primefaces-test/?param=param"))
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status: " + response.statusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
