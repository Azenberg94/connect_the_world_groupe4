package com.pachimari.auth;

import com.jayway.restassured.RestAssured;
import com.pachimari.user.UserDTO;
import com.pachimari.user.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Created by Pierre on 02/03/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)

public class UserControllerIT {
    @Autowired
    private UserRepository repo;
    @LocalServerPort
    private int localServerPort;
    @Before
    public void init(){
        repo.deleteAll();
        RestAssured.port=localServerPort;
    }
    @Test
    public void should_get_list_user_0(){

        given().log().all().when()
                .get("/user")
                .then()
                .statusCode(200)
                .body("$",hasSize(0)).log().all();
    }
    @Test
    public void should_fails_get_list_user_not_3(){

        given().log().all().when()
                .get("/user")
                .then()
                .statusCode(200)
                .body("$",hasSize(3)).log().all();
    }
    @Test
    public void should_create_user(){
        long id = 5;
        UserDTO userDTO=UserDTO.builder().id(id).name("fifth").login("test").email("test@email.fr").build();

        given().log().all().contentType(JSON).body(userDTO).when()
                .post("/user")
                .then()
                .statusCode(200)
                .body("id",is(5))
                .body("name",is("fifth")).log().all();
    }
}

