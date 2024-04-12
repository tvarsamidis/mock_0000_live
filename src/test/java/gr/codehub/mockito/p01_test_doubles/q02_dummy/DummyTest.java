package gr.codehub.mockito.p01_test_doubles.q02_dummy;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DummyTest {

    @Test
    public void dummyTest() {
        PhoneRepository phoneRepository = new DummyPhoneRepository();
        EmailService emailService = new DummyEmailService();
        PhoneService phoneService = new PhoneService(phoneRepository, emailService);

        phoneService.addPhone(new Phone("1234", "CodeHub Pro", 300, LocalDate.now()));
        phoneService.addPhone(new Phone("1235", "CodeHub Standard", 250, LocalDate.now()));

        assertEquals(2, phoneService.findNumberOfPhones());
    }

    @Test
    public void dummyTestWithMockito() {
        PhoneRepository phoneRepository = mock(PhoneRepository.class);
        EmailService emailService = mock(EmailService.class);
        PhoneService phoneService = new PhoneService(phoneRepository, emailService);

        Phone phone1 = new Phone("1234", "CodeHub Pro", 300, LocalDate.now());
        Phone phone2 = new Phone("1235", "CodeHub Standard", 250, LocalDate.now());
        List<Phone> phones = new ArrayList<>();
        phones.add(phone1);
        phones.add(phone2);

        phoneService.addPhone(phone1);
        phoneService.addPhone(phone2);

        when(phoneRepository.findAll()).thenReturn(phones);
        assertEquals(2, phoneService.findNumberOfPhones());

    }

}
