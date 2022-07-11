package com.ketul.controller;

import com.ketul.BASE64DecodedMultipartFile;
import com.ketul.dto.UserDto;
import com.ketul.entity.User;
import com.ketul.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@RestController
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/saveUser")
    public User saveUser(@ModelAttribute UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setFileName(userDto.getImage().getOriginalFilename());

        BufferedImage img = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(userDto.getImage().getBytes()));
            user.setImage(userDto.getImage().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        user.setHeight(img.getHeight());
        user.setWidth(img.getWidth());
        User save = userRepository.save(user);
        System.out.println(userDto.getImage().getOriginalFilename());
        System.out.println(userDto.getName());
        System.out.println(save);
        return save;
    }
}
