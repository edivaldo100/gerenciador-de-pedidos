package org.eduami.spring.restapi.service;

import org.eduami.spring.restapi.dto.OrderProductDto;
import org.eduami.spring.restapi.exceptions.RestException;
import org.eduami.spring.restapi.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderService {

    ResponseEntity<Response<OrderProductDto>> listProducts(Long id) throws RestException;
    ResponseEntity<Response<OrderProductDto>> salveOrder(OrderProductDto orderProductEntity) throws RestException;

}
