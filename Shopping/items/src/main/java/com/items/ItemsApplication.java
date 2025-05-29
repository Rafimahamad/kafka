package com.items;

import com.items.entity.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.items.")
public class ItemsApplication {

	public static void main(String[] args) {
//		Item it=new Item("1234","shirt","40","red",500);
//		System.out.println(it);
		SpringApplication.run(ItemsApplication.class, args);
	}

}
