package client;

import base.BaseMethod;
import io.restassured.response.ValidatableResponse;
import model.Order;
import io.qameta.allure.Step;

public class OrderClient extends BaseMethod {
    private static final String ORDER_PATH = BASE_URI + "/orders";

    @Step("Создать заказ")
    public ValidatableResponse create(Order order) {
        return spec()
                .body(order)
                .when()
                .post(ORDER_PATH)
                .then().log().all();
    }

    @Step("Получить список заказов")
    public ValidatableResponse getOrderList() {
        return spec()
                .when()
                .get(ORDER_PATH)
                .then().log().all();
    }

    @Step("Отменить заказ")
    public ValidatableResponse cancelOrder(int track) {
        return spec()
                .queryParam("track", track)
                .when()
                .put(ORDER_PATH + "/cancel")
                .then().log().all();
    }
}