package com.example.websocketdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class WebsocketDemoApplication {

	public static void main(String[] args) {


			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
			System.setProperty("current.date.time", dateFormat.format(new Date()));


		SpringApplication.run(WebsocketDemoApplication.class, args);
	}
}
