package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Все геттеры, сеттеры и return
@AllArgsConstructor // Конструктор со всеми полями
@NoArgsConstructor  // Пустой конструктор для Jackson
public class CourierLoginDetails {
private String login;
private String password;
}
