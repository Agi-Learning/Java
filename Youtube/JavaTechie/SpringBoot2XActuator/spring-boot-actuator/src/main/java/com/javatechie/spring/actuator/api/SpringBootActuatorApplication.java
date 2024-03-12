package com.javatechie.spring.actuator.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootActuatorApplication {

    // You can check here or get endpoint mapped here. and its giving only two
    // endpoints. One is the actuator health "Mapped "{[/actuator/health]" and
    // another one is the actuator input Mapped "{[/actuator/info]".
    // This is the New concept introduced springboard version to only these two is
    // like enable for us as of now, but in Varson 1 it will mapped like like info
    // beans and thread doms. All those endpoints are enabled by default. So let us
    // check these two, then we will find a approach, and we will implement that.
    // How to enable all the endpoint in person 2Lets copy the url.
    public static void main(String[] args) {
        SpringApplication.run(SpringBootActuatorApplication.class, args);
    }
    // And then in a full It's giving empty so now if I'll access like. Paint arrays
    // near pins You don't give anything like 404 as this end point is not enabled
    // yet. So to enable rest of all endpoint provided by actuator, you need to
    // exclude them in properties file

    // Instead of use this predefined health matrix. The salesmen tricks UK,
    // customize our own health matrix. Suppose, in case of suppose I am consuming
    // one client and based on that You need to perform our business issue. That is
    // my first primary logic and that application is off and I am trying to access
    // so in that case my application will not work. So in similar case we want to
    // implement one health integrator customized health indicator. So how to create
    // our customized health indicator So let's creep on decades. Let's copy that.
    // Similar way As you can mark here. There are 49 points. Those are provided by
    // Arcturus in my. in my project I have some requirement I want to customize my
    // specific endpoint instead of use this actuator be in 7th conditions I want to
    // specify my own endpoint so. That also we can do. And the approach of doing
    // custom endpoint is very impersonal and in person to win personal who need to
    // like implement from endpoint. Endpoint is one interface provided by inversion
    // 1 and 8 or else we can use the abstract end point. Person two, there is a
    // approach we can use. We can achieve this using only annotation. Okay, now
    // let's see how we can create our own custom endpoint.
}