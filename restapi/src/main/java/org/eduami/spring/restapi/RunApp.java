package org.eduami.spring.restapi;

import org.eduami.spring.restapi.model.OrderProduct;
import org.eduami.spring.restapi.model.Product;
import org.eduami.spring.restapi.repository.OrderRepository;
import org.eduami.spring.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Classe de execução
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
@Component
public class RunApp {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Transactional
	public void appStart() {

		Product laranja = productRepository.save(new Product("Laranja", 15));
		Product banana = productRepository.save(new Product("banana", 20));
		Product maca = productRepository.save(new Product("maça", 5));
		Product pera = productRepository.save(new Product("pera", 10));
		List<Product> products1 = Arrays.asList(laranja, banana, maca, pera);
		List<Product> products2 = Arrays.asList(banana, maca);
		List<Product> products3 = Collections.singletonList(banana);
		orderRepository.save(new OrderProduct(products1));
		orderRepository.save(new OrderProduct(products2));
		orderRepository.save(new OrderProduct(products3));
	}

	public static int generate(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	private Date getDateMoth() {
		Date date = new Date();
		date.setDate(generate(1, 7));
		return date;

	}
}
