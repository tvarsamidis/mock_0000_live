package gr.codehub.mockito.p01_test_doubles.q04_spy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpyTest {

    @Test
    public void demoSpyWithMockito() {
        PhoneRepositorySpy phoneRepositorySpy = new PhoneRepositorySpy();
        PhoneService phoneService = new PhoneService(phoneRepositorySpy);

        Phone phone1 = new Phone("1234", "CodePhone Pro", 600, LocalDate.now());
        Phone phone2 = new Phone("1235", "CodePhone Standard", 500, LocalDate.now());

        phoneService.addPhone(phone1); // return
        assertEquals(0, phoneRepositorySpy.timesCalled());

        phoneService.addPhone(phone2); // save will be called
        assertEquals(1, phoneRepositorySpy.timesCalled());
    }

}
