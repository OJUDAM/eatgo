package kr.com.djam.eatgo.application;

import kr.com.djam.eatgo.domain.Review;
import kr.com.djam.eatgo.domain.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

class ReviewServiceTests {

    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        reviewService = new ReviewService(reviewRepository);
    }
   @Test
    public void getReviews(){
       List<Review> mockReviews = reviewRepository.findAll();
       mockReviews.add(Review.builder().description("Cool").build());
       given(reviewRepository.findAll()).willReturn(mockReviews);

       List<Review> reviews = reviewService.getReviews();
       Review review = reviews.get(0);

       assertThat(review.getDescription(),is("Cool"));
    }
}