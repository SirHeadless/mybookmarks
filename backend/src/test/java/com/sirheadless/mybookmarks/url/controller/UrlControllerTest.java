package com.sirheadless.mybookmarks.url.controller;

import com.sirheadless.mybookmarks.url.entity.Url;
import com.sirheadless.mybookmarks.url.service.UrlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by
 * User: creuter
 * Date: 9/24/2017
 * Time: 11:22 AM
 * Test
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UrlControllerTest.class)
public class UrlControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UrlService urlService;

    @Test
    public void givenUrls_whenGetUrls_thenReturnJsonArray() throws Exception{

        Url url1 = new Url();
        url1.setUrl("www.test.de");
        url1.setName("test");

        List<Url> allUrls = Arrays.asList(url1);

        given(urlService.getAllUrls()).willReturn(allUrls);

        mvc.perform(get("/url/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(1)))
                ;
    }

}
