package io.rr.consul.rickfast;

import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.cache.ServiceHealthCache;
import com.orbitz.consul.cache.ServiceHealthKey;
import com.orbitz.consul.model.health.ServiceHealth;

import java.util.Map;

public class Subscribe {
    public static void main(String[] args) throws InterruptedException {

        Consul client = Consul.builder().withUrl("http://0.0.0.0:8500").build();
        HealthClient healthClient = client.healthClient();
        String serviceName = "kafka-9092";

        ServiceHealthCache svHealth = ServiceHealthCache.newCache(healthClient, serviceName);
        svHealth.addListener((Map<ServiceHealthKey, ServiceHealth> newValues) -> {
            System.out.println("!!! Service update !!!");
            System.out.println(newValues.entrySet());
        });
        svHealth.start();
// ...
//        svHealth.stop();
        while (true) {
            System.out.println("---");
            Thread.sleep(5000);
        }
    }
}
