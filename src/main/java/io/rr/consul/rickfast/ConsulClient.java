package io.rr.consul.rickfast;

import com.orbitz.consul.*;
import com.orbitz.consul.model.health.ServiceHealth;

import java.util.List;


public class ConsulClient {
    public static void main(String[] args) {
        Consul client = Consul.builder().build();
        HealthClient healthClient = client.healthClient();
        // Discover only "passing" nodes
        List<ServiceHealth> nodes = healthClient.getHealthyServiceInstances("kafka-9092").getResponse();
        System.out.println(nodes);
    }
}
