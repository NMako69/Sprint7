package courier;

import client.CourierClient;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import model.CourierCreation;
import model.CourierGenerator;
import model.CourierLoginDetails;
import org.junit.After;
import org.junit.Test;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.equalTo;

public class CourierCreateTest {

    private final CourierClient courierClient = new CourierClient();
    private int courierId;

    @After
    @Step("Удаление курьера после теста")
    public void cleanup() {
        if (courierId != 0) {
            courierClient.delete(courierId);
        }
    }

    @Test
    @Description("Проверка успешного создания курьера")
    public void courierCanBeCreated() {
        CourierCreation courier = CourierGenerator.getRandomCourier();

        createCourierStep(courier);
        loginAndGetId(courier); // Получаем ID для удаления в @After
    }

    @Test
    @Description("Проверка создания дубликата курьера (ошибка 409)")
    public void cannotCreateDuplicateCourier() {
        CourierCreation courier = CourierGenerator.getRandomCourier();

        createCourierStep(courier);
        loginAndGetId(courier);

        courierClient.create(courier)
                .statusCode(SC_CONFLICT)
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }

    @Step("Запрос на создание курьера")
    private void createCourierStep(CourierCreation courier) {
        courierClient.create(courier)
                .statusCode(SC_CREATED)
                .body("ok", equalTo(true));
    }

    @Step("Логин курьера для извлечения ID")
    private void loginAndGetId(CourierCreation courier) {
        CourierLoginDetails creds = new CourierLoginDetails(courier.getLogin(), courier.getPassword());
        courierId = courierClient.login(creds)
                .statusCode(SC_OK)
                .extract()
                .path("id");
    }
}
