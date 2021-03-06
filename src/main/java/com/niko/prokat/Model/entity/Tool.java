package com.niko.prokat.Model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Table(name = "tools")
@Entity
public class Tool extends AbstractEntity {
    private String prevImage;
    private String image1;
    private String image2;
    private String image3;

    @ManyToOne
    private Category category;

    @Column(unique = true, nullable = false)
    private String name;
    private String description;

    @ManyToOne
    private Brand brand;
    private String power;
    private Integer weight;
    private Integer price;
    private Integer pledge;
    private Integer quantity;
    private Long sortIndex;
}


