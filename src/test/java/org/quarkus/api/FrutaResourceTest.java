package org.quarkus.api;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.quarkus.api.model.Fruta;
import org.quarkus.api.resource.FrutasResource;
import org.quarkus.api.service.FrutaService;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

@QuarkusTest
@TestHTTPEndpoint(FrutasResource.class)
class FrutaResourceTest {

    @Inject
    FrutaService  frutaService;

    @Test
    void testHelloEndpoint() {
        given()
          .when().get()
          .then()
             .statusCode(200)
             .body(is("[{\"id\":1,\"nome\":\"Maça\",\"qtd\":3},{\"id\":2,\"nome\":\"Pera\",\"qtd\":5},{\"id\":3,\"nome\":\"Uva\",\"qtd\":4}]"));
    }

    @Test
    public void testListFrutasTwo(){
        List<Fruta> list = frutaService.list();
        assertFalse(list.isEmpty());
    }

}