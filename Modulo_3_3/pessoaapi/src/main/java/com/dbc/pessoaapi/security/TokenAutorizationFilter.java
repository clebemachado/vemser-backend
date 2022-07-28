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


@RequiredArgsConstructor
public class TokenAutorizationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    public static final String BEARER = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String token = getTokenFromHeader(request);

        UsernamePasswordAuthenticationToken userName = tokenService.isValid(token);
        SecurityContextHolder.getContext().setAuthentication(userName);

        filterChain.doFilter(request, response);
    }

    private String getTokenFromHeader(HttpServletRequest request){
        return request.getHeader("Authorization");
    }

}
