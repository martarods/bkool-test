package com.bkool.component.postgresql.dao;

import com.bkool.component.postgresql.entity.BikeEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeDao extends JpaRepository<BikeEntity, Long> {

    @Query("SELECT b FROM BikeEntity b " +
            "LEFT JOIN b.items i " +
            "WHERE (:name IS NULL OR b.name = :name) " +
            "AND (:manufacturer IS NULL OR b.manufacturer = :manufacturer) " +
            "AND (:type IS NULL OR i.type = :type) ")
    List<BikeEntity> findAllByCriteria(@Param("name") String name, @Param("manufacturer") String manufacturer,
                                       @Param("type") String type, Sort sort);

}
