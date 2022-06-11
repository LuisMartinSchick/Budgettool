package Database;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TransactionController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
public class TransactionControllerTest {
/*
    @Autowired
    private MockMvc mvc;


    @Autowired
    private TransactionRepository repository;


    @MockBean
    private Transaction transaction;

    @Before
    public void setUp() throws Exception {

    }
*/
    @Test
    public void whenPostTransaction_thenCreateTransaction()throws Exception{
        Transaction test = new Transaction();
       // given(service.save(Mockito.any())).willReturn(test);
    }


}
