package kr.com.djam.eatgo.interfaces;

import kr.com.djam.eatgo.application.ReviewService;
import kr.com.djam.eatgo.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> list(){
        List<Review> reviews = reviewService.getReviews();

        return reviews;
    }
    @PostMapping("/restaurants/{restaurantId}/reviews")
    public ResponseEntity<?> create(
            @PathVariable("restaurantId") Long restaurantId,
            @Valid @RequestBody Review resource)
            throws URISyntaxException {
        Review review = reviewService.addReview(restaurantId,resource);
        String url = "/restaurants/"+restaurantId+"/reviews/"+review.getId();
        return ResponseEntity.created(new URI(url))
                .body("{}");
    }
}
