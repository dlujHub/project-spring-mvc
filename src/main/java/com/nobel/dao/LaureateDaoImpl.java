package com.nobel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.nobel.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.nobel.model.Laureate;

@Repository
public class LaureateDaoImpl implements LaureateDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static Map<String, String> countryNameCode = new LinkedHashMap<>();


    public LaureateDaoImpl() {
        String[] locales = Locale.getISOCountries();
        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            countryNameCode.put(obj.getDisplayCountry(), obj.getCountry());
        }

    }

    @Override
    public Laureate findId(Integer id) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);

        String sql = "SELECT * FROM laureates WHERE id=:id";

        Laureate pers = null;
        try {
            pers = namedParameterJdbcTemplate.queryForObject(sql, parameters, new LaureateMapper());
        } catch (EmptyResultDataAccessException ignored) {
        }

        return pers;
    }

    @Override
    public List<Laureate> findAll() {

        String sql = "SELECT * FROM laureates ORDER BY first_name ASC";

        return namedParameterJdbcTemplate.query(sql, new LaureateMapper());

    }

    @Override
    public List<Country> laureatesPerCapita() {

        String sql = "SELECT countries.name, COUNT(laureates.born_country_code) AS NumberOfLaureates, countries.population,(10000000*COUNT(laureates.born_country_code))/countries.population AS capita " +
                "FROM countries " +
                "LEFT JOIN laureates ON laureates.born_country_code = countries.iso GROUP BY countries.name, countries.population ORDER BY capita DESC LIMIT 49";

        return namedParameterJdbcTemplate.query(sql, new CountryMapper());
    }


    @Override
    public void update(Laureate laureate) {

        String sql = "UPDATE laureates SET first_name=:first_name, last_name=:last_name, born=:born, died=:died, " +
                "born_country=:born_country, born_country_code=:born_country_code, born_city=:born_city," +
                " died_country=:died_country, died_country_code=:died_country_code, gender=:gender, prize_year=:prize_year, " +
                "category=:category, motivation=:motivation WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(laureate));

    }

    @Override
    public void delete(Integer id) {

        String sql = "DELETE FROM laureates WHERE id= :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

    }

    @Override
    public void save(Laureate laureate) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO laureates(first_name, last_name, born, died, born_country, born_country_code, born_city," +
                " died_country, died_country_code, gender, prize_year, category, motivation) "
                + "VALUES ( :first_name, :last_name, :born, :died, :born_country, :born_country_code, :born_city, " +
                ":died_country, :died_country_code, :gender, :prize_year, :category, :motivation)";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(laureate), keyHolder);
        laureate.setId(keyHolder.getKey().intValue());

    }

    private SqlParameterSource getSqlParameterByModel(Laureate laureate) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", laureate.getId());
        parameterSource.addValue("first_name", laureate.getFirst_name());
        parameterSource.addValue("last_name", laureate.getLast_name());
        parameterSource.addValue("born", laureate.getBorn());
        parameterSource.addValue("died", laureate.getDied());
        parameterSource.addValue("born_country", laureate.getBorn_country());
        parameterSource.addValue("born_country_code", laureate.getBorn_country_code());
        parameterSource.addValue("born_city", laureate.getBorn_city());
        parameterSource.addValue("died_country", laureate.getDied_country());
        parameterSource.addValue("died_country_code", laureate.getDied_country_code());
        parameterSource.addValue("gender", laureate.getGender());
        parameterSource.addValue("prize_year", laureate.getPrize_year());
        parameterSource.addValue("category", laureate.getCategory());
        parameterSource.addValue("motivation", laureate.getMotivation());

        return parameterSource;
    }

    static String getCountryCode(String country) {

        return countryNameCode.get(country);
    }

    private static final class CountryMapper implements RowMapper<Country> {

        public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
            Country country = new Country();

            country.setName(rs.getString("name"));
            country.setNrOfNobelLaureates(rs.getInt("NumberOfLaureates"));
            country.setPopulation(rs.getInt("population"));
            country.setLaureatesPer10Mln(rs.getInt("capita"));

            return country;
        }
    }

    private static final class LaureateMapper implements RowMapper<Laureate> {

        public Laureate mapRow(ResultSet rs, int rowNum) throws SQLException {
            Laureate laureate = new Laureate();
            laureate.setId(rs.getInt("id"));
            laureate.setFirst_name(rs.getString("first_name"));
            laureate.setLast_name(rs.getString("last_name"));
            laureate.setBorn(rs.getString("born"));
            laureate.setDied(rs.getString("died"));
            laureate.setBorn_country(rs.getString("born_country"));
            laureate.setBorn_country_code(rs.getString("born_country_code"));
            laureate.setBorn_city(rs.getString("born_city"));
            laureate.setDied_country(rs.getString("died_country"));
            if (laureate.getBorn_country_code() == null) {
                laureate.setBorn_country_code(getCountryCode(rs.getString("born_country")));
            }
            laureate.setDied_country_code(getCountryCode(rs.getString("died_country")));
            laureate.setGender(rs.getString("gender"));
            laureate.setPrize_year(rs.getInt("prize_year"));
            laureate.setCategory(rs.getString("category"));
            laureate.setMotivation(rs.getString("motivation"));
            return laureate;
        }
    }
}