package com.tienda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.ApplicationRunner;
import org.springframework.mock.env.MockEnvironment;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TiendaOnlineApplicationProdValidationTest {

    @Test
    void validateProdEnv_throwsWhenMissingProps() throws Exception {
        MockEnvironment env = new MockEnvironment();
        env.setActiveProfiles("prod");

        TiendaOnlineApplication app = new TiendaOnlineApplication();
        ApplicationRunner runner = app.validateProdEnv(env);

        assertThrows(IllegalStateException.class, () -> runner.run(null));
    }
}

