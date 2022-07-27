package com.dbc.pessoaapi.security;

import com.dbc.pessoaapi.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;


@RequiredArgsConstructor
public class TokenAutorizationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    public static final String BEARER = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // Recuperar token da request...
        String token = getTokenFromHeader(request);
        Optional<UsuarioEntity> usuarioOptional = tokenService.isValid(token);

        // Validar token
        authenticate(usuarioOptional);

        filterChain.doFilter(request, response);
    }

    public void authenticate(Optional<UsuarioEntity> optionalUsuario){

        if(optionalUsuario.isPresent()){
            UsuarioEntity usuario = optionalUsuario.get();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            usuario.getLogin(),
                            null,
                            Collections.emptyList()
                    );
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }

    private String getTokenFromHeader(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token == null){
            return null;
        }
        return token.replace(BEARER, "");
    }
}
