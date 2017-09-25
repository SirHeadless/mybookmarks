package com.sirheadless.mybookmarks.url.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import com.sirheadless.mybookmarks.url.repository.UrlRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UrlRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UrlRepository urlRepository;

    // write test cases here

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Url url1 = new Url();
        url1.setUrl("www.test.de");
        url1.setName("test");
        entityManager.persist(url1);
        entityManager.flush();

        // when
        Url found = urlRepository.findByUrlId(1);

        // then
        assertThat(found.getUrl())
          .isEqualTo(url1.getUrl());
    }

}