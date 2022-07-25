package com.cg.pizzaorder.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.pizzaorder.model.PizzaOrder;
import java.time.LocalDate;

@Repository
public interface IPizzaOrderRepository  extends JpaRepository<PizzaOrder, Integer> {
	
	
	
	@Query(value="select *from Pizza_order_table where size=?1 and quantity=?2",nativeQuery = true)
	public List<PizzaOrder> viewPizzaOrderByCost(String size, int quantity);
	
	@Query(value="select *from Pizza_order_table where order_date=?1",nativeQuery = true)

	public List<PizzaOrder> viewPizzaOrderByDate(LocalDate date);

}
