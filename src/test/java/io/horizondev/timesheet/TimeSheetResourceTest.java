package io.horizondev.timesheet;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@Testcontainers
public class TimeSheetResourceTest {


    @Container
    private static final PostgreSQLContainer DATABASE = new PostgreSQLContainer<>("postgres:10.5")
            .withDatabaseName("timesheet")
            .withUsername("username")
            .withPassword("password")
            .withExposedPorts(5432)
            .withCreateContainerCmdModifier(cmd -> {
                cmd
                        .withHostName("localhost")
                        .withPortBindings(List.of(new PortBinding(Ports.Binding.bindPort(5432), new ExposedPort(5432))));
            });
    ;

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/timesheet")
                .then()
                .statusCode(200)
                .body(is("hello"));
    }

}