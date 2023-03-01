package org.junit;

import java.util.Objects;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greet(String name) {
        if (Objects.isNull(name) || name.length() == 0) {
            throw new IllegalArgumentException();
        }
        return "Hello " + name;
    }
}
