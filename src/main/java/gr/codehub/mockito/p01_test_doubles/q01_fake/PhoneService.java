package gr.codehub.mockito.p01_test_doubles.q01_fake;

import java.util.List;

public class PhoneService {

    private final PhoneRepository phoneRepository;



    public PhoneService(PhoneRepository phoneRepository1) {
        phoneRepository = phoneRepository1;
    }

    public void addPhone(Phone phone) {
        System.out.println("Dear customer, your phone is ready");
        phoneRepository.save(phone);
    }

    public int findNumberOfPhones() {
        System.out.println("Here is the number of phones in the database");
        List<Phone> allPhones =  phoneRepository.findAll();
        return allPhones.size();
    }
}
