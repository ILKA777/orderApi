package ru.ilka.app.orderRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ilka.app.orderRestApi.model.Dish;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findAll();

    Dish save(Dish dish);

}
