package ecommerce.myProject.Controller;

import ecommerce.myProject.Domain.Review;
import ecommerce.myProject.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @PatchMapping("/reviews/{id}/approve")
    public Review approveReview(@PathVariable long id){
        return reviewService.approveReview(id);
    }
}
