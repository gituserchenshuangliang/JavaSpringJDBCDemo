package com.mybatis.typehandle;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:自定义Mybatis的TypeHandle
 * @author: Cherry
 * @time: 2020/6/2 16:40
 */
public class MyStringTypeHandle implements TypeHandler<String> {
    Logger logger = LogManager.getLogger(MyStringTypeHandle.class.getName());
    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        logger.info("设置String参数:"+parameter);
        ps.setString(i,parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        String result = rs.getString(columnName);
        logger.info("读取String参数1:"+result);
        return result;
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        String result = rs.getString(columnIndex);
        logger.info("读取String参数2:"+result);
        return result;
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String result = cs.getString(columnIndex);
        logger.info("读取String参数3:"+result);
        return result;
    }
}
