package com.nla;

import com.nla.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// junit 4
//@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureWebTestClient(timeout = "10000")//10 seconds
public class TestBooksWebApplication {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void testListBooks() {

        List<Book> books = webClient
                .get().uri("/books")
                .accept(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .exchange().expectStatus().isOk()
                .returnResult(Book.class)
                .getResponseBody()
                .take(3)
                .collectList()
                .block();

        books.forEach(x -> System.out.println(x));

        assertEquals(3, books.size());

    }

}
