package com.sirheadless.mybookmarks.integrationTests;

import com.sirheadless.mybookmarks.MybookmarksApplication;
import com.sirheadless.mybookmarks.url.repository.UrlRepository;
import com.sun.glass.ui.Application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

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
        classes = MybookmarksApplication.class)
//@AutoConfigureMockMvc
//@TestPropertySource(
//        locations = "classpath:application-integrationtest.properties")
public class UrlRestControllerIntTest {

    @LocalServerPort
    private String port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveStudentCourse() throws Exception {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/url/3"),
                HttpMethod.GET, entity, String.class);

        String expected = "{\"urlId\":3,\"url\":\"www.tutorialdffds3.com\",\"name\":\"Tutorial55\",\"description\":\"Super cool Tutorial323\",\"urlType\":\"Tutorial\",\"rating\":5,\"pageCreatedAt\":null,\"entryUpdatedAt\":null,\"entryCreatedAt\":1505151069928}";
        
        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port  + uri;
    }

}