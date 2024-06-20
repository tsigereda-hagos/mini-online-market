package ecommerce.myProject.Service;

import ecommerce.myProject.Domain.Review;

import java.util.List;


public interface ReviewService {

    List<Review> getAllReviews();

    Review getReviewById(long id);

    Review approveReview(long id);
}
