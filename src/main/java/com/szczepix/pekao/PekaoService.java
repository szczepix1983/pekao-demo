package com.szczepix.pekao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.pekao24.api.Credentials;
import pl.pekao24.api.auth.AuthService;

import javax.annotation.PostConstruct;

@Service
public class PekaoService {

    private final Logger log = LoggerFactory.getLogger(PekaoService.class);
    private final Credentials credentials;
    private final AuthService authService;

    public PekaoService(final Credentials credentials,
                        final AuthService authService) {
        this.credentials = credentials;
        this.authService = authService;
    }

    @PostConstruct
    public void init() {
        try {
            boolean status = this.authService.authorize(
                    this.credentials.getLogin(),
                    this.credentials.getPassword());
            log.info("Authorization is done with status: {}", status);
        } catch (Exception e) {
            log.error("Error while authorizing: {}", e.getMessage());
        }
    }
}
