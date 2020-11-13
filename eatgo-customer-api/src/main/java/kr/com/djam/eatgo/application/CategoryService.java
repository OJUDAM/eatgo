package kr.com.djam.eatgo.application;

import kr.com.djam.eatgo.domain.Category;
import kr.com.djam.eatgo.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategorys() {
        return categoryRepository.findAll();
    }

}
