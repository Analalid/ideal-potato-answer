package com.example.woc;

import org.apache.ibatis.annotations.ConstructorArgs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.invoke.ConstantCallSite;
import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
