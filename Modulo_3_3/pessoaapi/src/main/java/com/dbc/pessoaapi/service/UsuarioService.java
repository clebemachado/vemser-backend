package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.UsuarioCreateDTO;
import com.dbc.pessoaapi.dto.UsuarioDTO;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.exception.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public Optional<UsuarioEntity> findByLogin(String login){
        return usuarioRepository.findByLogin(login);
    }

    public UsuarioEntity findById(Integer id) throws RegraDeNegocioException {
        return usuarioRepository
                .findById(id)
                .orElseThrow(()-> new RegraDeNegocioException("Usuário não encontrado"));
    }

    private Integer getIdLoggedUser() throws RegraDeNegocioException {
        Integer idUser;
        try {
            idUser =  (Integer) SecurityContextHolder.getContext()
                    .getAuthentication().getPrincipal();
        } catch (Exception e){
            throw new RegraDeNegocioException("Usuário não logado");
        }

        return idUser;
    }

    public UsuarioDTO getLoggedUser() throws RegraDeNegocioException {
        return convertToUsuarioDTO(findById(getIdLoggedUser()));
    }

    public UsuarioDTO createUser(UsuarioCreateDTO usuarioCreate){
        UsuarioEntity usuario = convertToUsuarioEntity(usuarioCreate);
        usuario.setSenha(encodePassword(usuario.getSenha()));
        usuario = usuarioRepository.save(usuario);
        return convertToUsuarioDTO(usuario);
    }


}
