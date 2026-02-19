package model;

import com.github.javafaker.Faker;

public class CourierGenerator {
    private static final Faker faker = new Faker();

    public static CourierCreation getRandomCourier() {
        return new CourierCreation(
                faker.name().username() + faker.number().digits(3),
                "pass1234",
                faker.name().firstName()
        );
    }
}