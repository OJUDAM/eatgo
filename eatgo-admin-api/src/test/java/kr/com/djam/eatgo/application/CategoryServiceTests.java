package kr.com.djam.eatgo.application;

import kr.com.djam.eatgo.domain.Category;
import kr.com.djam.eatgo.domain.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class CategoryServiceTests {

    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void addCategory(){

        Category category = categoryService.addCategory("Seoul");
        verify(categoryRepository).save(any());

        assertThat(category.getName(),is("Seoul"));
    }
    @Test
    public void getCategorys(){
        List<Category> mockCategorys = new ArrayList<>();
        mockCategorys.add(Category.builder().name("Korean Food").build());

        given(categoryRepository.findAll()).willReturn(mockCategorys);
        List<Category> categorys = categoryService.getCategorys();

        Category category = categorys.get(0);
        assertThat(category.getName(), is("Korean Food"));
    }


}