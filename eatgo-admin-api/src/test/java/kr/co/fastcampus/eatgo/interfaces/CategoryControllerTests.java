package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.CategoryService;
import kr.co.fastcampus.eatgo.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void list() throws Exception {

        List<Category> categoies = new ArrayList<>();
        categoies.add(Category.builder().name("Korean Food").build());

        given(categoryService.getCategories()).willReturn(categoies);

        mockMvc.perform(get("/categories"))
                .andExpect(content().string(containsString("Korean Food")))
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void create() throws Exception {
        Category category = Category.builder().name("Korean Food").build();

        given(categoryService.addCategory("Korean Food"))
                .willReturn(category);

        mockMvc.perform(post("/categories")
                .content("{\"name\":\"Korean Food\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string("{}"))
        ;

        verify(categoryService).addCategory("Korean Food");
    }


}
