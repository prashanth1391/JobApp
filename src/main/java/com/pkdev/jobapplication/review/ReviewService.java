package com.pkdev.jobapplication.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId,Review review);

    Review getReviewById(Long companyId, Long reviewId);

    boolean updateReviewByReviewId(Long companyId, Long reviewId, Review review);

    boolean deleteReviewById(Long companyId, Long reviewId);
}
