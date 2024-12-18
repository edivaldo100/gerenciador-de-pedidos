package org.eduami.spring.restapi.model;

import java.io.Serializable;

import javax.persistence.*;


import lombok.*;

/**
 * Classe entidade de prod
 *
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
@ToString
@EqualsAndHashCode
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "produto")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private OrderProduct pedido;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
