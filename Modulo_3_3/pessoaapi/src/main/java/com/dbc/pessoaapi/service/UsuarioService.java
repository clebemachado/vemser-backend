package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.UsuarioCreateDTO;
import com.dbc.pessoaapi.dto.UsuarioDTO;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final ObjectMapper objectMapper;

    private UsuarioEntity convertToUsuarioEntity(UsuarioCreateDTO usuarioCreate){
        return objectMapper.convertValue(usuarioCreate, UsuarioEntity.class);
    }

    private UsuarioDTO convertToUsuarioDTO(UsuarioEntity usuario){
        return objectMapper.convertValue(usuario, UsuarioDTO.class);
    }

    private String encodePassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }

    public UsuarioDTO createUser(UsuarioCreateDTO usuarioCreate){
        UsuarioEntity usuario = convertToUsuarioEntity(usuarioCreate);
        usuario.setSenha(encodePassword(usuario.getSenha()));
        usuario = usuarioRepository.save(usuario);
        return convertToUsuarioDTO(usuario);
    }

    public Optional<UsuarioEntity> findByLogin(String login){
        return usuarioRepository.findByLogin(login);
    }
}
