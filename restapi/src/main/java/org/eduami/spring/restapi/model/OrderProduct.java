package org.eduami.spring.restapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@ToString
@EqualsAndHashCode
@Data
@Entity(name = "pedido")
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private List<Product> products;

    @Column
    private Integer totalValue;

    public OrderProduct() {
    }

    public OrderProduct(Long id, Integer totalValue) {
        this.id = id;
       // this.products = products;
        totalValue = totalValue;
    }
    public OrderProduct(Integer totalValue) {
        this.id = id;
        //this.products = products;
        totalValue = totalValue;
    }

    public OrderProduct(List<Product> products) {
        this.products = products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        this.products.forEach(p -> {
            this.totalValue = this.totalValue + p.getPrice();
        });
    }
}
