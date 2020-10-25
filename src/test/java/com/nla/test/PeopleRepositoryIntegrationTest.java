package com.nla.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.nla.model.Book;
import com.nla.model.People;
import com.nla.repository.PeopleRepository;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PeopleRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PeopleRepository peopleRepository;


    @Test
    public void whenFindById_thenReturnEmployee() {
        People ppl = new People("test","a@a.com","123");
        entityManager.persistAndFlush(ppl);

        People fromDb = peopleRepository.findById(ppl.getId()).orElse(null);
        assertThat(fromDb.getName()).isEqualTo(ppl.getName());
    }

    @Test
    public void whenInvalidId_thenReturnNull() {
        People fromDb = peopleRepository.findById(-11l).orElse(null);
        assertThat(fromDb).isNull();
    }

    @Test
    public void givenSetOfPeople_whenFindAll_thenReturnAllPeople() {
        People alex = new People("alex","a@a.com","123");
        People bob = new People("bob","a@a.com","123");
        People ron = new People("ron","a@a.com","123");

        entityManager.persist(alex);
        entityManager.persist(bob);
        entityManager.persist(ron);
        entityManager.flush();

        List<People> all = peopleRepository.findAll();

        assertThat(all).hasSize(6).extracting(People::getName).contains(alex.getName(), ron.getName(), bob.getName());
    }
}