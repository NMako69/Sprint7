package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Все геттеры, сеттеры и return
@AllArgsConstructor // Конструктор со всеми полями
@NoArgsConstructor  // Пустой конструктор для Jackson
public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;
}
