package com.learn.multitenant.controller;

import com.learn.multitenant.domain.SomeOtherTable;
import com.learn.multitenant.repository.SomeOtherTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/table2")
public class SomeOtherTableController {

    @Autowired
    private SomeOtherTableRepository someOtherTableRepository;

    @PreAuthorize("hasPermission(null, 'VIEW_SOME_OTHER_TABLE')")
    @GetMapping("/get/{id}")
    public Object get(@PathVariable(required = false) Long id) {
        if(id == null) {
            return someOtherTableRepository.findAll();
        } else {
            return someOtherTableRepository.findById(id);
        }
    }

    @PreAuthorize("hasPermission(null, 'WRITE_SOME_OTHER_TABLE')")
    @GetMapping("/set")
    public SomeOtherTable set() {

        SomeOtherTable someTable = new SomeOtherTable();
        someTable.setName("Some Name");
        someTable.setValue("Some Value");

        return someOtherTableRepository.save(someTable);
    }

}
