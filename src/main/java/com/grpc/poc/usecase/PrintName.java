package com.grpc.poc.usecase;

import javax.inject.Singleton;

@Singleton
public class PrintName {

    public void execute(String name) {
        System.out.println(name);
    }
}
