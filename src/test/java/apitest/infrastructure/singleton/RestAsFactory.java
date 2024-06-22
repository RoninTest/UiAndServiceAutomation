package apitest.infrastructure.singleton;

import groovy.lang.Singleton;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import service.config.ConfigServiceReader;

import static io.restassured.http.ContentType.JSON;

@Singleton
public class RestAsFactory {

    public RequestSpecification getBaseApiRequest() {
        ConfigServiceReader _configServiceReader = new ConfigServiceReader();
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(_configServiceReader.getTestApplicationUrl())
                .build();
    }

    public RequestSpecification postApiRequest() {
        ConfigServiceReader _configServiceReader = new ConfigServiceReader();
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBody("{\"username\": \"" + _configServiceReader.getUserName()
                        + "\", \"password\": \"" + _configServiceReader.getPassword()
                        + "\"}")
                .setBaseUri(_configServiceReader.postTestApplicationUrl())
                .build();
    }
}
