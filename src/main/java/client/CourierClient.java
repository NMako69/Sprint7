package client;

import base.BaseMethod;
import io.restassured.response.ValidatableResponse;
import model.CourierCreation;
import model.CourierLoginDetails;
import io.qameta.allure.Step;

public class CourierClient extends BaseMethod {
    private static final String COURIER_PATH = BASE_URI + "/courier";

    @Step("Создать курьера")
    public ValidatableResponse create(CourierCreation courier) {
        return spec().body(courier).when().post(COURIER_PATH).then().log().all();
    }

    @Step("Логин курьера")
    public ValidatableResponse login(CourierLoginDetails creds) {
        return spec().body(creds).when().post(COURIER_PATH + "/login").then().log().all();
    }

    @Step("Удалить курьера")
    public ValidatableResponse delete(int id) {
        return spec().when().delete(COURIER_PATH + "/" + id).then().log().all();
    }
}
