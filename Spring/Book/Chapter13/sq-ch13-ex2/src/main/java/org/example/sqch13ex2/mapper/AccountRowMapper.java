package org.example.sqch13ex2.mapper;

import org.example.sqch13ex2.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    public Account mapRow(ResultSet resultSet, int id) throws SQLException{
        Account account = new Account();
        account.setId(resultSet.getLong("id"));
        account.setName(resultSet.getString("name"));
        account.setAmount(resultSet.getBigDecimal("amount"));
        return account;
    }
}
