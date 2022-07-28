package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.LoginDTO;
import com.dbc.pessoaapi.dto.UsuarioCreateDTO;
import com.dbc.pessoaapi.dto.UsuarioDTO;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.exception.RegraDeNegocioException;
import com.dbc.pessoaapi.security.TokenService;
import com.dbc.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/create-user")
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody UsuarioCreateDTO usuarioCreateDTO){
        return ResponseEntity.ok(usuarioService.createUser(usuarioCreateDTO));
    }

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO login) throws RegraDeNegocioException {

        UsernamePasswordAuthenticationToken userPassAuthToken =
                new UsernamePasswordAuthenticationToken(login.getLogin(), login.getSenha());

        Authentication authentication =
                authenticationManager.authenticate(userPassAuthToken);

        Object usuarioLogado =  authentication.getPrincipal();
        UsuarioEntity usuarioEntity = (UsuarioEntity) usuarioLogado;

        return tokenService.getToken(usuarioEntity);
    }

}
