package com.thoughtmechanix.licenses;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(LicenseController.class)
@ExtendWith(MockitoExtension.class)
public class LicenseServiceUnitTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LicenseService licenseService;

    @Test
    public void getLicenseService() throws Exception {
        when(licenseService.greet()).thenReturn("Hello, Mock!");
        
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                                                      .andExpect(content().string(containsString("Hello, Mock!")));
    }

}
