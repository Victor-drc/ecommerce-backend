package com.educative.ecommerce.model;
//Classe de categoria de produtos

//Importação da biblioteca completa de persistência
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private @NotBlank String categoryName;

    private @NotBlank String description;

    private @NotBlank String imgUrl;

    public Category(){
    }

    public Category(@NotBlank  String categoryName, @NotBlank  String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public Category(@NotBlank String categoryName, @NotBlank  String description, @NotBlank String imgUrl) {
        this.categoryName = categoryName;
        this.description = description;
        this.imgUrl = imgUrl;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "User {category id=" + id + ", category name='" + categoryName + "', description='" + description + "'}";
    }
}

