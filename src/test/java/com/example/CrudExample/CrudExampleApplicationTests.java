package com.example.CrudExample;

import com.example.CrudExample.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class CrudExampleApplicationTests {

	@Test
	void testGetProducts() {
		RestTemplate restTemplate= new RestTemplate();
		Product p= restTemplate.getForObject("http://localhost:9091/products/1",Product.class);
		assertNotNull(p);
		assertEquals("Iphone",p.getName());
	}
	@Test
	void testCreateProduct(){
		RestTemplate restTemplate= new RestTemplate();
		Product p= new Product();
		p.setName("Samsung Mobile");
		p.setDescription("Its Awesome");
		p.setPrice(1500);
		Product newProduct= restTemplate.postForObject("http://localhost:9091/products/",p, Product.class);
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Samsung Mobile",newProduct.getName());


	}
	@Test
	public void updateProduct(){
		RestTemplate restTemplate= new RestTemplate();
		Product p= restTemplate.getForObject("http://localhost:9091/products/5", Product.class);
		p.setPrice(2500);
		restTemplate.put("http://localhost:9091/products/", p);
	}

}
