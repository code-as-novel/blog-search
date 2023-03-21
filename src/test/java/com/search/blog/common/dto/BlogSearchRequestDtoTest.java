package com.search.blog.common.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BlogSearchRequestDtoTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void cleanUp() {
        validatorFactory.close();
    }

    @Test
    void givenBlank_whenValidatorValidates_thenThrowError() {
        // given
        BlogSearchRequestDto blogSearchRequestDto = BlogSearchRequestDto.builder()
                                                                        .query(null)
                                                                        .size(10)
                                                                        .build();

        // when
        Set<ConstraintViolation<BlogSearchRequestDto>> violations = validator.validate(blogSearchRequestDto);
        
        // then
        assertThat(violations).isNotEmpty();
        violations
                .forEach(error -> {
                    assertThat(error.getMessage()).isEqualTo("Input is mandatory");
                });
    }

    @Test
    void givenNormalInput_whenValidatorValidates_thenSuccess() {
        // given
        BlogSearchRequestDto blogSearchRequestDto = BlogSearchRequestDto.builder()
                                                                        .query("test")
                                                                        .size(10)
                                                                        .build();

        // when
        Set<ConstraintViolation<BlogSearchRequestDto>> violations = validator.validate(blogSearchRequestDto);

        // then
        assertThat(violations).isEmpty();
    }
}
