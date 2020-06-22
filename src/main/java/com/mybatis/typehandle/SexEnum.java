package com.mybatis.typehandle;

/**
 * @description:性别枚举
 * @author: Cherry
 * @time: 2020/6/2 17:22
 */
public enum SexEnum {
    MALE("M","男"),FEMAL("F","女");
    private String k;
    private String v;

    SexEnum(String k, String v) {
        this.k = k;
        this.v = v;
    }

    public String getK() {
        return k;
    }

    public String getV() {
        return v;
    }

    public static SexEnum getSexEnumByKey(String k){
        for (SexEnum sex : SexEnum.values()) {
            String s = sex.getK();
            if(s.contentEquals(k)){
                return sex;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "SexEnum{" +
                "k='" + k + '\'' +
                ", v='" + v + '\'' +
                '}';
    }
}
