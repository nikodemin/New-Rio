package com.dBuider.app.Repo;

import com.dBuider.app.Model.Order;
import com.dBuider.app.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<Order, Long>
{
    @Query(value = "FROM orders ORDER BY date DESC LIMIT 10",nativeQuery = true)
    List<Order> findRecentOrders();
}