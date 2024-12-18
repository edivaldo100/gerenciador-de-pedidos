package org.eduami.spring.restapi.controller;

import org.eduami.spring.restapi.dto.OrderProductDto;
import org.eduami.spring.restapi.exceptions.RestException;
import org.eduami.spring.restapi.model.OrderProduct;
import org.eduami.spring.restapi.response.Response;
import org.eduami.spring.restapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * Classe de controller
 *
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
//@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
@RestController
public class OrderController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Response<OrderProductDto>> salve(@RequestBody OrderProductDto orderProductEntity) throws RestException {
        System.out.println("------------------> salve pela porta: " + serverPort);
        System.out.println("------------------> orderProductEntity: " + orderProductEntity);
        return orderService.salveOrder(orderProductEntity);
    }

    /**
     * metodo que busca um carro pelo ID
     *
     * @param id
     * @return ResponseEntity<Response<CarDto>>
     *
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Response<OrderProductDto>> findById(@PathVariable("id") Long id)throws RestException {
        System.out.println("------------------> consulta pela porta: " + serverPort);
        System.out.println("------------------> id: " + id);
        return orderService.listProducts(id);
    }
}
