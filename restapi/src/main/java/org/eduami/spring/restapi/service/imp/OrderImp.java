package org.eduami.spring.restapi.service.imp;

import org.eduami.spring.restapi.dto.OrderProductDto;
import org.eduami.spring.restapi.dto.ProductDto;
import org.eduami.spring.restapi.exceptions.ResourceBadRequestException;
import org.eduami.spring.restapi.exceptions.ResourceNotFoundException;
import org.eduami.spring.restapi.exceptions.RestException;
import org.eduami.spring.restapi.model.OrderProduct;
import org.eduami.spring.restapi.model.Product;
import org.eduami.spring.restapi.repository.OrderRepository;
import org.eduami.spring.restapi.response.Response;
import org.eduami.spring.restapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResponseEntity<Response<OrderProductDto>> listProducts(Long id) throws RestException {

        OrderProduct byId = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado para o id :: " + id));

        Long id1 = byId.getId();
        List<ProductDto> productsDto = new ArrayList<>();
        Integer totalValue = byId.getTotalValue();
        byId.getProducts().forEach(p -> {
            productsDto.add(new ProductDto(p.getId(), p.getName(), p.getPrice()));
        });
        OrderProductDto orderProductDto = new OrderProductDto(id1, productsDto, totalValue);

        Response<OrderProductDto> response = new Response<>();
        response.setData(orderProductDto);
        return new ResponseEntity<Response<OrderProductDto>>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response<OrderProductDto>> salveOrder(OrderProductDto orderProduct) throws RestException {

        if(orderProduct != null && orderProduct.getId() != null && orderProduct.getId() != 0){
            Optional<OrderProduct> byId = orderRepository.findById(orderProduct.getId());
            if(byId.isPresent()){
                throw new ResourceBadRequestException("Pedido ID: "+orderProduct.getId()+" já cadastrado.");
            }
        }
        List<Product> products = new ArrayList<>();
        orderProduct.getProducts().forEach(p->products.add(new Product(p.getName(), p.getPrice())));
        OrderProduct save = orderRepository.save(new OrderProduct(products));

        Long id1 = save.getId();
        List<ProductDto> productsDto = new ArrayList<>();
        Integer totalValue = save.getTotalValue();
        save.getProducts().forEach(p -> {
            productsDto.add(new ProductDto(p.getId(), p.getName(), p.getPrice()));
        });
        OrderProductDto orderProductDto = new OrderProductDto(id1, productsDto, totalValue);

        Response<OrderProductDto> response = new Response<>();
        response.setData(orderProductDto);
        return new ResponseEntity<Response<OrderProductDto>>(response, HttpStatus.OK);
    }
}

