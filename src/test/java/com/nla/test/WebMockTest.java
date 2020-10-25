package com.nla.test;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import java.util.ArrayList;
import com.nla.model.People;
import com.nla.controller.MainController;
import com.nla.repository.PeopleRepository;
import com.nla.repository.BookRepository;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeopleRepository peopleRepository;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void shouldReturnPeopleFromController() throws Exception {

        List<People> list = new ArrayList<People>();
        People alex = new People("alex","a@a.com","123");
        list.add(alex);

        when(peopleRepository.findAll()).thenReturn(list);
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("alex")));
    }

}