package com.veiculo.veiculoprodutorconsumidor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.veiculo.veiculoprodutorconsumidor.DTO.VeiculoDTO;
import com.veiculo.veiculoprodutorconsumidor.Repository.VeiculoRepository;
import com.veiculo.veiculoprodutorconsumidor.entity.VeiculoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final ObjectMapper objectMapper;
    private final VeiculoRepository veiculoRepository;

    public VeiculoDTO convertToVeiculoDTO(VeiculoEntity veiculo){
        return objectMapper.convertValue(veiculo, VeiculoDTO.class);
    }

    public VeiculoEntity convertToVeiculoEntity(VeiculoDTO veiculoDTO){
        return objectMapper.convertValue(veiculoDTO, VeiculoEntity.class);
    }

    public void create(VeiculoDTO veiculoDTO)  {
        VeiculoEntity veiculoEntity = convertToVeiculoEntity(veiculoDTO);
        veiculoRepository.save(veiculoEntity);
    }

    public List<VeiculoDTO> getList()  {
        return veiculoRepository.findAll().stream().map(this::convertToVeiculoDTO).toList();
    }

    public Double velocidadeMedia(){
        return veiculoRepository.avgVelocidade();
    }

    public Double rotacaoMedia(){
        return veiculoRepository.avgRotatcao();
    }

    public Long contarTodosOsRegistros(){
        return veiculoRepository.contarTodosOsRegistros();
    }


}
