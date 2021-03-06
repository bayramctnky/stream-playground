package countries;

import java.io.InputStream;
import java.io.IOException;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class CountryRepository {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());

    private List<Country> countries;

    public CountryRepository() throws IOException {
        loadCountries(CountryRepository.class.getResourceAsStream("countries.json"));
    }

    private void loadCountries(InputStream is) throws IOException {
        countries = OBJECT_MAPPER.readValue(is, new TypeReference<List<Country>>() {});
    }

    public List<Country> getAll() {
        return countries;
    }

}
