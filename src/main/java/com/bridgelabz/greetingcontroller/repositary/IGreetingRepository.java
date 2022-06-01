package com.bridgelabz.greetingcontroller.repositary;


import com.bridgelabz.greetingcontroller.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IGreetingRepository extends JpaRepository<Greeting, Long> {
}