package com.hmy.pythagorean.model;

public record RegisterBody(
        String email,
        String password,
        String firstName,
        String lastName
) {
}
