package data.access.controller;

import data.access.model.Inventory;
import data.access.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping(path = "/all")
    private Iterable<Inventory> findAllInventories() {
        return inventoryRepository.findAll();
    }
}
