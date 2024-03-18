package org.javarevised.moviecatelogservice.models;

public record UserRating(String userId, String movieId, int rating) {
}
