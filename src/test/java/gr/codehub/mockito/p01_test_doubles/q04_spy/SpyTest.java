package gr.codehub.mockito.p01_test_doubles.q04_spy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class SpyTest {

    @Test
    public void demoSpyWithMockito() {
        PhoneRepository phoneRepositorySpy =  spy(PhoneRepository.class);
        PhoneService phoneService = new PhoneService(phoneRepositorySpy);

        Phone phone1 = new Phone("1234", "CodePhone Pro", 600, LocalDate.now());
        Phone phone2 = new Phone("1235", "CodePhone Standard", 500, LocalDate.now());

        phoneService.addPhone(phone1); // return
        //assertEquals(0, phoneRepositorySpy.timesCalled());
        verify(phoneRepositorySpy, Mockito.times(0)).save(phone1);

        phoneService.addPhone(phone2); // save will be called
        verify(phoneRepositorySpy, Mockito.times(1)).save(phone2);
        //assertEquals(1, phoneRepositorySpy.timesCalled());
    }

}
