package com.sirheadless.mybookmarks.url.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sirheadless.mybookmarks.url.dao.UrlDAO;
import com.sirheadless.mybookmarks.url.entity.UrlEntity;
import com.sirheadless.mybookmarks.url.service.impl.UrlServiceImpl;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class UrlServiceImplTest {
 
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public UrlService urlService() {
            return new UrlServiceImpl();
        }
    }
 
    @Autowired
    private UrlService urlService;
 
    @MockBean
    private UrlDAO urlDAO;
 
    @Before
    public void setUp() {
        UrlEntity url1 = new UrlEntity();
        url1.setUrlId(1);
        url1.setUrl("www.test.de");
     
        Mockito.when(urlDAO.getUrlEntityById(1))
          .thenReturn(url1);
    }
    
    @Test
    public void whenValidId_thenUrlShouldBeFound() {
        String url = "www.test.de";
        UrlEntity found = urlService.getUrlById(1);
      
         assertThat(found.getUrl())
          .isEqualTo(url);
     }
    
//    http://www.baeldung.com/spring-boot-testing chapter 6
    
//    Validation After
    
}