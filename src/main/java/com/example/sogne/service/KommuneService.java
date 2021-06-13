package com.example.sogne.service;

import com.example.sogne.model.Kommune;
import com.example.sogne.repository.KommuneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class KommuneService
{
    KommuneRepository kommuneRepository;

    public List<Kommune> findAll()
    {
        return kommuneRepository.findAll();
    }

    public Kommune findById(Integer id)
    {
        return kommuneRepository.findById(id).get();
    }

    public Kommune create(Kommune kommune)
    {
        return kommuneRepository.save(kommune);
    }

    public Kommune update(Kommune kommune)
    {
        return kommuneRepository.save(kommune);
    }

    public void deleteById(int id)
    {
        kommuneRepository.deleteById(id);
    }
}