package com.example.appdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HostController {

    @RequestMapping(path = "/host", method = RequestMethod.GET)
    String home() throws UnknownHostException {
        InetAddress ip4 = Inet4Address.getLocalHost();
        return ip4.getHostAddress();
    }
}
