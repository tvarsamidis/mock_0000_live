package gr.codehub.mockito.p01_test_doubles.q01_fake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FakeTest {

    @Test
    public void testFake(){
        PhoneRepository phoneRepository = new FakePhoneRepository();
        PhoneService phoneService = new PhoneService(phoneRepository);

        phoneService.addPhone(new Phone("1234", "CodeHub Pro", 300, LocalDate.now()));
        phoneService.addPhone(new Phone("1235", "CodeHub Standard", 250, LocalDate.now()));

        assertEquals(2, phoneService.findNumberOfPhones());
    }

}
