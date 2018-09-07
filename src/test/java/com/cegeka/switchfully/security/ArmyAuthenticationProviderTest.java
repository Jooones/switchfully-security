package com.cegeka.switchfully.security;

import com.cegeka.switchfully.security.external.authentication.ExternalAuthenticaton;
import com.cegeka.switchfully.security.external.authentication.FakeAuthenticationService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static com.cegeka.switchfully.security.external.authentication.ExternalAuthenticaton.externalAuthenticaton;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArmyAuthenticationProviderTest {

    private static final String USERNAME = "Niels";
    private static final String PASSWORD = "DaBest";
    private static final String WRONG_PASSWORD = "wrongPassword";
    private static final String ROLE = "BOSS";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private FakeAuthenticationService authenticationService;

    @InjectMocks
    private ArmyAuthenticationProvider armyAuthenticationProvider;

    @Test
    public void authenticateWhenUserExistsReturnsAuthentication() {
        ExternalAuthenticaton externalAuthenticaton = externalAuthenticaton().withRoles(singletonList(ROLE));
        when(authenticationService.getUser(USERNAME, PASSWORD)).thenReturn(externalAuthenticaton);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(USERNAME, PASSWORD);
        Authentication actual = armyAuthenticationProvider.authenticate(authenticationToken);

        assertThat(actual).isNotNull();
        assertThat(actual.getAuthorities()).hasSize(1);
        assertThat(actual.getAuthorities().stream().findFirst().get().getAuthority()).isEqualTo(ROLE);
    }

    @Test
    public void authenticateWhenUserDoesNotExistThrowsBadCredentialsException() {
        expectedException.expect(BadCredentialsException.class);
        expectedException.expectMessage("Nope, just nope");

        when(authenticationService.getUser(USERNAME, WRONG_PASSWORD)).thenReturn(null);

        armyAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(USERNAME, WRONG_PASSWORD));
    }

    @Test
    public void authenticateWhenUsingUsernamePasswordAuthenticationTokenThenReturnTrue() {
        assertThat(armyAuthenticationProvider.supports(UsernamePasswordAuthenticationToken.class)).isTrue();
    }

    @Test
    public void authenticateWhenUsingStringThenReturnFalse() {
        assertThat(armyAuthenticationProvider.supports(String.class)).isFalse();
    }
}