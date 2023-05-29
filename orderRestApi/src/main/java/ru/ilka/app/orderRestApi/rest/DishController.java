package ru.ilka.app.orderRestApi.rest;

import org.springframework.web.bind.annotation.*;
import ru.ilka.app.orderRestApi.model.Dish;
import ru.ilka.app.orderRestApi.repository.DishRepository;

import java.util.List;

@RestController
@RequestMapping("/dishes")
class DishController {
    private final DishRepository dishRepository;

    public DishController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @PostMapping
    public Dish createDish(@RequestBody Dish dish) {
        return dishRepository.save(dish);
    }

}