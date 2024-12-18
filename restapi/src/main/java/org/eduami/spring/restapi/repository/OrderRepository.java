package org.eduami.spring.restapi.repository;

import org.eduami.spring.restapi.dto.ResumeOrderProductDto;
import org.eduami.spring.restapi.model.OrderProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderProduct, Long> {

//    @Query(value =
//            "SELECT p.total_value as totalValue, " +
//            "pr.id as id, " +
//            "pr.name as name, " +
//            "pr.price as price " +
//            "FROM pedido p " +
//            "INNER JOIN produto pr ON p.id = PR.pedido_id " +
//            "WHERE p.id = ?1", nativeQuery = true)
//    List<ResumeOrderProductDto> findByCodigoComProdutos(Long id);
}
