package com.veiculo.veiculoprodutorconsumidor.Repository;

import com.veiculo.veiculoprodutorconsumidor.entity.VeiculoEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface VeiculoRepository extends MongoRepository<VeiculoEntity, String> {

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$avg: $velocidade }}}" })
    public Double avgVelocidade();

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$avg: $rotacao }}}" })
    public Double avgRotatcao();

    @Query(value = "{}", count = true)
    Long contarTodosOsRegistros();

}
