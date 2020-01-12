package io.horizondev.timesheet;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import com.google.inject.Inject;

import io.horizondev.timesheet.domain.model.TimeRegistry;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import groovy.json.JsonBuilder;

import java.time.LocalDateTime;
import java.util.List;

import javax.json.bind.JsonbBuilder;

import static io.restassured.RestAssured.given;

@QuarkusTest
@Testcontainers
public class TimeSheetResourceTest {

    @Container
    private static final PostgreSQLContainer DATABASE = new PostgreSQLContainer<>("postgres:10.5")
            .withDatabaseName("timesheet").withUsername("username").withPassword("password").withExposedPorts(5432)
            .withCreateContainerCmdModifier(cmd -> {
                cmd.withHostName("localhost").withPortBindings(
                        List.of(new PortBinding(Ports.Binding.bindPort(5431), new ExposedPort(5432))));
            });;

    @Test
    public void shoultReturnStatusOkGivenCorrectGetRequest() {
        given().when().get("/timesheet").then().statusCode(200);
    }

    @Test
    public void shouldCreateTimeRegistryGivenCorrectRequest() {

        final var data = new TimeRegistry();
        data.setDescription("description");
        data.setStartDate(LocalDateTime.now());
        data.setEndDate(LocalDateTime.now());

        var response = given().body(data).contentType(ContentType.JSON).when().post();

        System.out.println(response.asString());

    }

}