package kr.com.djam.eatgo.interfaces;

import kr.com.djam.eatgo.application.CategoryService;
import kr.com.djam.eatgo.domain.Category;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
class CategoryControllerTests {

    @Autowired
    MockMvc mvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void list() throws Exception {
        List<Category> categorys = new ArrayList<>();
        categorys.add(Category.builder().name("Korean Food").build());

        given(categoryService.getCategorys()).willReturn(categorys);
        mvc.perform(get("/categorys"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Korean Food")));
    }
}