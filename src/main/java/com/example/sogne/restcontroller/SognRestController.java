package com.example.sogne.restcontroller;

import com.example.sogne.model.Sogn;
import com.example.sogne.service.SogneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SognRestController
{
    private SogneService sogneService;

    // HTTP Get List
    @GetMapping("/sogne")
    public List<Sogn> findAll()
    {
        return sogneService.findAll();
    }

    // HTTP Get by ID
    @GetMapping("/sogn/{id}")
    public Sogn findById(@PathVariable int id)
    {
        return sogneService.findById(id);
    }

    // HTTP Post, fx. create
    @PostMapping(value = "/post", consumes = "application/json")
    public void create(@RequestBody Sogn sogn)
    {
        sogneService.create(sogn);
    }

    //HTTP PUT eller POST mapping har samme ansvar
    @PostMapping("/sogn/{id}")
    public void update(@RequestBody Sogn updatedSogn)
    {
        sogneService.update(updatedSogn);
    }

    //HTTP Delete / Slette
    @DeleteMapping("/sogn/{id}")
    public void delete(@PathVariable("id") int id)
    {
        sogneService.deleteById(id);
    }
}
