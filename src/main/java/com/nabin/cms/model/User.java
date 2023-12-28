package com.nabin.cms.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author nabin
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<Address> addresses;

    // Constructors, getters, setters, etc.
}
