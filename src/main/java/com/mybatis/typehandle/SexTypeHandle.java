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
 * @description:数据库性别字段对应Java枚举处理
 * @author: Cherry
 * @time: 2020/6/2 17:57
 */
public class SexTypeHandle implements TypeHandler<SexEnum> {
    Logger logger = LogManager.getLogger(SexTypeHandle.class.getName());
    @Override
    public void setParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        logger.info("设置sex");
        ps.setString(i,parameter.getK());
    }

    @Override
    public SexEnum getResult(ResultSet rs, String columnName) throws SQLException {
        String sex = rs.getString(columnName);
        logger.info("取值sex1:"+sex);
        return SexEnum.getSexEnumByKey(sex);
    }

    @Override
    public SexEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        String sex = rs.getString(columnIndex);
        logger.info("取值sex2:"+sex);
        return SexEnum.getSexEnumByKey(sex);
    }

    @Override
    public SexEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String sex = cs.getString(columnIndex);
        logger.info("取值sex3:"+sex);
        return SexEnum.getSexEnumByKey(sex);
    }
}
