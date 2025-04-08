package com.profile_service.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Node("user_profile")
public class UserProfile {
    @Id
//    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    String id = UUID.randomUUID().toString();

    @Property("userId")
    String userId;

    String firstName;
    String lastName;
    LocalDate dob;
    String address;
}
