package com.workintech.s19d1.util;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.exceptions.ApiException;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class HollywoodValidation {

    public static void validateActor(Actor actor) {
        if (actor.getBirthDate().isAfter(LocalDate.now())) {
            throw new ApiException("Birth date cannot be in the future", HttpStatus.BAD_REQUEST);
        }
    }
}
