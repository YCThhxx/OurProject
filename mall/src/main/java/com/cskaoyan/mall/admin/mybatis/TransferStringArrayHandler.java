package com.cskaoyan.mall.admin.mybatis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(long[].class)
public class TransferStringArrayHandler implements TypeHandler<long[]> {
    ObjectMapper objectMapper = new ObjectMapper();

    /*插入数据 由javabean转换为数据库接收的类型*/
    @Override
    public void setParameter(PreparedStatement preparedStatement, int index, long[] longs, JdbcType jdbcType) throws SQLException {
        try {
            String jsonArray = objectMapper.writeValueAsString(longs);
            preparedStatement.setString(index,jsonArray);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    //由数据中查询出的结果转换成javabean中的类型
    @Override
    public long[] getResult(ResultSet resultSet, String parameterName) throws SQLException {
        String value = resultSet.getString(parameterName);
        return parseString2LongArray(value);
    }

    private long[] parseString2LongArray(String value) {

        long[] longs = new long[0];
        if (value == null){
            return longs;
        }
        try {
            longs = objectMapper.readValue(value, long[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return longs;
    }

    @Override
    public long[] getResult(ResultSet resultSet, int index) throws SQLException {
        String value = resultSet.getString(index);
        return parseString2LongArray(value);
    }

    @Override
    public long[] getResult(CallableStatement callableStatement, int index) throws SQLException {
        String value = callableStatement.getString(index);
        return parseString2LongArray(value);
    }
}
