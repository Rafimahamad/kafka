package com.user.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Data
@Entity
@AllArgsConstructor

public class User {
    @Id
    private long userId;
    private String name;
    @NotNull
    @Column(unique = true, nullable = false)
    private String emailId;
    @Column(length = 10)
    private Long mobileNo;

    @Transient
    private List<Address> address;


    private static User user;

    private User() {
        super();
    }

    public synchronized static User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }


}
