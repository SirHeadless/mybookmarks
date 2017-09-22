package com.sirheadless.mybookmarks.url.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import com.sirheadless.mybookmarks.url.dao.UrlDAO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UrlDAOImplTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private UrlDAO urlDAO;
 
    // write test cases here
    
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        UrlEntity url1 = new UrlEntity();
        url1.setUrlId(1);
        url1.setUrl("www.test.de");
        entityManager.persist(url1);
        entityManager.flush();
     
        // when
        UrlEntity found = urlDAO.getUrlEntityById(1);
     
        // then
        assertThat(found.getUrl())
          .isEqualTo(url1.getUrl());
    }
 
}