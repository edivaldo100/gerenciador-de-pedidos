package org.eduami.spring.restapi.dto;

import java.io.Serializable;
import java.util.Objects;


public class ResumeOrderProductDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer totalValue;
    private Long id;
    private String name;
    private Integer price;

    public ResumeOrderProductDto() {
    }
    public ResumeOrderProductDto(Integer totalValue, Long id, String name, Integer price) {
        this.totalValue = totalValue;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Integer totalValue) {
        this.totalValue = totalValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResumeOrderProductDto that = (ResumeOrderProductDto) o;
        return Objects.equals(totalValue, that.totalValue) && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalValue, id, name, price);
    }
}
