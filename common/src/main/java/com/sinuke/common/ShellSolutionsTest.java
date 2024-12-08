package com.sinuke.common;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShellSolutionsTest {

    private GenericContainer<?> container = new GenericContainer<>("alpine:latest")
            //.withFileSystemBind("/local/path/to/your/script.sh", "/container/path/to/script.sh")
            .withCommand("sh", "-c", "while :; do sleep 1; done");

    @BeforeAll
    protected final void setUp() {
        container.start();
    }

    @AfterAll
    protected final void tearDown() {
        if (container != null) container.stop();
    }

    @Test
    void testShell() throws Exception{
        var result = container.execInContainer("ls");
        System.out.println(result.getStdout());
    }

}
