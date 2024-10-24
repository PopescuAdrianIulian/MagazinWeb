package com.magazin.MagazinWeb.controller;

import com.magazin.MagazinWeb.entity.Items;
import com.magazin.MagazinWeb.repository.ItemRepository;
import com.magazin.MagazinWeb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ItemController {


    private final ItemService itemService;
    private final ItemRepository itemRepository;

    public ItemController(ItemService itemService, ItemRepository itemRepository) {
        this.itemService = itemService;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/all")
    public List<Items>showAllItems(){
        return itemService.getAllItems();

    }
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("item", new Items());
        return "index";
    }

    @PostMapping("/addItem")
    public String addItem(@ModelAttribute Items item) {
        itemService.savedItem(item);
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String viewItems(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "items";
    }

    @GetMapping("/deleteItem")
    public String deleteItem(@RequestParam Long id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }




}
