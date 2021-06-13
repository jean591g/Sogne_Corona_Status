package com.example.sogne.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Kommune
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kommuneId;
    private String navn;

    /**
     * En kommune kan have flere sogn
     */
    @OneToMany
    private Set<Sogn> sogn;

    public Kommune(String navn) {
        this.navn = navn;
    }
}
