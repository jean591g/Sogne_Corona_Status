package com.example.sogne.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Sogn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int sognekode;
    private String navn;
    private double smittetryk;
    private LocalDate nedlukningStart;

    /**
     * Flere sogne kan tilhøre en kommune
     */
    @ManyToOne
    @JoinColumn(name = "kommuneId", nullable = false)
    private Kommune kommune;

    public Sogn(int sognekode, String navn, double smittetryk, LocalDate nedlukningStart) {
        this.sognekode = sognekode;
        this.navn = navn;
        this.smittetryk = smittetryk;
        this.nedlukningStart = nedlukningStart;
    }
}