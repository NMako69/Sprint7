package order;

import client.OrderClient;
import io.qameta.allure.Description;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.notNullValue;

public class OrderListTest {

    private final OrderClient orderClient = new OrderClient();

    @Test
    @Description("Проверка получения списка заказов")
    public void getOrderListTest() {
        orderClient.getOrderList()
                .statusCode(SC_OK)
                .body("orders", notNullValue());
    }
}
