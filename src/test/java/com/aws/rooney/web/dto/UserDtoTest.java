package com.aws.rooney.web.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDtoTest {

    @Test
    @DisplayName("DTO 테스트")
    public void dtoTest() {
        String name = "test";
        Integer age = 28;

        UserDto dto = new UserDto(name, age);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAge()).isEqualTo(age);
    }
}
