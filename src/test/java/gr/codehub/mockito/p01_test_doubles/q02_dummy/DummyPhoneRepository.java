package gr.codehub.mockito.p01_test_doubles.q02_dummy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyPhoneRepository implements PhoneRepository {


    Map<String, Phone> phoneStore = new HashMap<>();

    @Override
    public void save(Phone phone) {
        phoneStore.put(phone.getPhoneId(), phone);
    }

    @Override
    public List<Phone> findAll() {
        return new ArrayList<>(phoneStore.values());
    }
}
