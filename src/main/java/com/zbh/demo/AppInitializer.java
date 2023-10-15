package com.zbh.demo;

import com.zbh.demo.entity.GenderEnum;
import com.zbh.demo.entity.User;
import com.zbh.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AppInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<User> userList = List.of(
                new User( "John Smith", "john.smith@example.com", "555-123-4567", GenderEnum.MALE, "123 Oak St"),
                new User( "Alice Johnson", "alice.johnson@example.com", "555-987-6543", GenderEnum.FEMALE, "456 Maple Rd"),
                new User( "Michael Brown", "michael.brown@example.com", "555-789-1234", GenderEnum.MALE, "789 Birch Ave"),
                new User( "Emily Davis", "emily.davis@example.com", "555-234-5678", GenderEnum.FEMALE, "567 Cedar Ln"),
                new User( "David Wilson", "david.wilson@example.com", "555-345-6789", GenderEnum.MALE, "234 Pine Dr"),
                new User( "Sophia Lee", "sophia.lee@example.com", "555-876-5432", GenderEnum.FEMALE, "890 Elm St"),
                new User( "James Miller", "james.miller@example.com", "555-654-3210", GenderEnum.MALE, "432 Birch Rd"),
                new User( "Olivia Harris", "olivia.harris@example.com", "555-432-1098", GenderEnum.FEMALE, "678 Oak Ave"),
                new User( "Daniel Clark", "daniel.clark@example.com", "555-210-9876", GenderEnum.MALE, "321 Maple Ln"),
                new User( "Ava Martinez", "ava.martinez@example.com", "555-987-2109", GenderEnum.FEMALE, "987 Pine Rd")
        );
        userRepository.saveAll(userList);
        System.out.println("Users are saved successfully");
    }
}
