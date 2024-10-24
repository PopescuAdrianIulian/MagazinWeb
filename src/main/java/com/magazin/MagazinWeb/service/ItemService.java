package com.magazin.MagazinWeb.service;

import com.magazin.MagazinWeb.entity.Items;
import com.magazin.MagazinWeb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {


    @Autowired
    private ItemRepository itemRepository;

    public Items savedItem(Items item){
       return itemRepository.save(item);
    }

    public List<Items>getAllItems(){
        return itemRepository.findAll();
    }

    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }


}
