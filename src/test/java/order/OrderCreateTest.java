package order;

import client.OrderClient;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class OrderCreateTest {

    private final OrderClient orderClient = new OrderClient();
    private final String[] colors;

    public OrderCreateTest(String[] colors) {
        this.colors = colors;
    }

    @Parameterized.Parameters(name = "Тест с цветом: {0}")
    public static Object[][] data() {
        return new Object[][]{
                {new String[]{"BLACK"}},
                {new String[]{"GREY"}},
                {new String[]{"BLACK", "GREY"}},
                {null}
        };
    }

    @Test
    @Description("Создание заказа с разными вариантами цветов")
    public void createOrderWithParams() {
        Order order = new Order("Naruto", "Uzumaki", "Konoha", "4", "+79991112233", 5, "2024-12-12", "Dattebayo!", colors);
        sendCreateRequest(order);
    }

    @Step("Отправка запроса на создание заказа")
    private void sendCreateRequest(Order order) {
        orderClient.create(order)
                .statusCode(SC_CREATED)
                .body("track", notNullValue());
    }
}