package com.example.sogne.service;

import com.example.sogne.model.Sogn;
import com.example.sogne.repository.KommuneRepository;
import com.example.sogne.repository.SogneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * man uddelegerer ansvar for kommunikation til databasen fra repository klassen til service klassen, som et mellemlag (separation of concerns)
 */
@Service
@AllArgsConstructor
public class SogneService
{
    private final SogneRepository sogneRepository;
    private final KommuneRepository kommuneRepository;

    public List<Sogn> findAll()
    {
        return sogneRepository.findAll();
    }

    public Sogn findById(Integer id)
    {
        return sogneRepository.findById(id).get();
    }

    public Sogn create(Sogn sogn)
    {
        var kommune = kommuneRepository.findById(1).get();
        sogn.setKommune(kommune);
        return sogneRepository.save(sogn);
    }

    public Sogn update(Sogn sogn)
    {
        return sogneRepository.save(sogn);
    }

    public void deleteById(int id)
    {
        sogneRepository.deleteById(id);
    }
}