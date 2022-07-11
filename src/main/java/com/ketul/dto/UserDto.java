package com.ketul.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserDto {

    private MultipartFile image;
    private String name;
}
