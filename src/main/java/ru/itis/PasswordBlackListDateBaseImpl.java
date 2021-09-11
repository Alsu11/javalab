package ru.itis;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.moduls.Password;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Optional;

public class PasswordBlackListDateBaseImpl implements PasswordBlackList {
    //language=SQL
    public static final String SQL_SELECT_PASSWORD = "SELECT bad_password FROM bad_passwords WHERE bad_password=?";

    private JdbcTemplate jdbcTemplate;

    public PasswordBlackListDateBaseImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<Password> passwordRowMapper = (row, rowNumber) -> {
        //int id = row.getInt("id");
        String badPassword = row.getString("bad_password");

        return new Password(badPassword);
    };

    @Override
    public boolean contains(String password) {
        try {
            Optional.of(Objects.requireNonNull(jdbcTemplate.queryForObject(SQL_SELECT_PASSWORD, passwordRowMapper, password)));
            return false;
        } catch (EmptyResultDataAccessException e) {
            return true;
        }
    }
}
