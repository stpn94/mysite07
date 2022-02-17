package com.home.mysite07.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User extends BaseEntity{
    @Id // 엔티티에는 식별자가 필요한데 @ID로 표현.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GenerationType (IDENTITY, SEQUENCE, TABLE, AUTO)
    private Long id;

    @NotEmpty
    @Length(min=2, max=8)
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Length(min=4, max=16)
    private String password;

}
