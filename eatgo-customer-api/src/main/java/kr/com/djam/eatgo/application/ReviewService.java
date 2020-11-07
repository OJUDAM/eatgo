package kr.com.djam.eatgo.application;

import kr.com.djam.eatgo.domain.Review;
import kr.com.djam.eatgo.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(Long restaurantId,Review review) {
        review.setRestaurantId(restaurantId);
        return reviewRepository.save(review);
    }
}
