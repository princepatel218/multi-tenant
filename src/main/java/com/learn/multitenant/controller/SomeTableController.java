package com.learn.multitenant.controller;

import com.learn.multitenant.domain.SomeTable;
import com.learn.multitenant.repository.SomeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/table")
public class SomeTableController {

    @Autowired
    private SomeTableRepository someTableRepository;

    @PreAuthorize("hasPermission(null, 'VIEW_SOME_TABLE')")
    @GetMapping("/get/{id}")
    public Object get(@PathVariable(required = false) Long id) {
        if(id == null) {
            return someTableRepository.findAll();
        } else {
            return someTableRepository.findOneById(id);
        }
    }

    @PreAuthorize("hasPermission(null, 'WRITE_SOME_TABLE')")
    @GetMapping("/set")
    public SomeTable set() {

        SomeTable someTable = new SomeTable();
        someTable.setName("Some Name");
        someTable.setValue("Some Value");

        return someTableRepository.save(someTable);
    }
}
