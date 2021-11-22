package com.example.hibernate.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persons implements Serializable {

    @EmbeddedId
    private PersonId personId;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String cityOfLiving;

}
