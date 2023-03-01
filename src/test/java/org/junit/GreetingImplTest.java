package org.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GreetingImplTest {

    @Mock
    private GreetingService service;

    @InjectMocks
    private GreetingImpl greeting;


    @Test
    public void greetShouldReturnAValidOutput() {
        when(service.greet("Junit")).thenReturn("Hello Junit");
        assertEquals("Hello Junit", greeting.greet("Junit"));
    }

    @Test
    public void greetShouldThrowAnExceptionForNullName() {
        when(service.greet(null)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> {
            greeting.greet(null);
        });
    }

    @Test
    public void greetShouldThrowAnExceptionForBlankName() {
        doThrow(IllegalArgumentException.class).when(service).greet("");
        assertThrows(IllegalArgumentException.class, () -> {
            greeting.greet("");
        });
    }

    @AfterEach
    public void teardown() {
        greeting = null;
    }
}