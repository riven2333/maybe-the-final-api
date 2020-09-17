package student.hackthon.team15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import student.hackthon.team15.entity.HomeItems;
import student.hackthon.team15.entity.ItemEntity;
import student.hackthon.team15.service.HomeItemsService;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    HomeItemsService homeItemsService;

    @GetMapping(value="/home", produces={"application/json","application/xml"})
    public List<ItemEntity> getAllItems() {
        return homeItemsService.getHomeItems();
    }
}
