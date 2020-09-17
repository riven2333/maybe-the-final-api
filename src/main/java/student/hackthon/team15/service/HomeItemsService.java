package student.hackthon.team15.service;

import student.hackthon.team15.entity.HomeItems;
import student.hackthon.team15.entity.ItemEntity;

import java.util.List;

public interface HomeItemsService {
    public List<ItemEntity> getHomeItems();
}
