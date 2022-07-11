package com.ketul.entity;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "image", nullable = false)
    private byte[] image;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "name")
    private String name;

    @Column(name = "height")
    private long height;

    @Column(name = "width")
    private long width;
}