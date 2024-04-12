package gr.codehub.mockito.p01_test_doubles.q02_dummy;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    @Test
    public void testFake(){
        PhoneRepository phoneRepository = new DummyPhoneRepository();
        EmailService emailService = new DummyEmailService();
        PhoneService phoneService = new PhoneService(phoneRepository, emailService);

        phoneService.addPhone(new Phone("1234", "CodeHub Pro", 300, LocalDate.now()));
        phoneService.addPhone(new Phone("1235", "CodeHub Standard", 250, LocalDate.now()));

        assertEquals(2, phoneService.findNumberOfPhones());
    }

}
