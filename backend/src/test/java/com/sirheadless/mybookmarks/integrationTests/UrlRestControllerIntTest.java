package com.sirheadless.mybookmarks.integrationTests;

import com.sirheadless.mybookmarks.url.repository.UrlRepository;
import com.sun.glass.ui.Application;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by
 * User: creuter
 * Date: 9/24/2017
 * Time: 1:35 PM
 * Test
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = Application.class)
@AutoConfigureMockMvc
//@TestPropertySource(
//        locations = "classpath:application-integrationtest.properties")
public class UrlRestControllerIntTest {

//    @LocalServerPort
//    private String port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveStudentCourse() {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/url/3"),
                HttpMethod.GET, entity, String.class);

        String expected = "{\n" +
                "    \"urlId\": 3,\n" +
                "    \"url\": \"www.tutorial2.com\",\n" +
                "    \"name\": \"Tutorial2\",\n" +
                "    \"description\": \"Super cool Tutorial2\",\n" +
                "    \"urlType\": \"Tutorial\",\n" +
                "    \"rating\": 5,\n" +
                "    \"pageCreatedAt\": null,\n" +
                "    \"entryUpdatedAt\": null,\n" +
                "    \"entryCreatedAt\": null\n" +
                "}";

        try {
            JSONAssert.assertEquals(expected, response.getBody(), false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:8080"  + uri;
    }

}