package com.cegeka.switchfully.security;

import com.cegeka.switchfully.security.external.authentication.FakeAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Component
public class ArmyAuthenticationProvider implements AuthenticationProvider {

    private FakeAuthenticationService authenticationService;

    @Autowired
    public ArmyAuthenticationProvider(FakeAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return ofNullable(authenticationService.getUser((String) authentication.getPrincipal(), (String) authentication.getCredentials()))
                .map(a -> new UsernamePasswordAuthenticationToken(a.getUsername(), a.getPassword(), a.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())))
                .orElseThrow(() -> new BadCredentialsException("Nope, just nope"));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
