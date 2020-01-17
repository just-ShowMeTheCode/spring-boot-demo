package cn.com.citydo.generate;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author fumj
 * @projectName credit
 * @description: TODO
 * @date 2019/7/2210:24
 */
public class GeneratorJsonParameter {


//    SELECT T.`COLUMN_NAME`,T.`COLUMN_COMMENT` FROM COLUMNS T WHERE TABLE_SCHEMA = 'credit' AND TABLE_NAME = 't_source';


    @Test
    public void test1(){
        System.out.println(calculate(CodeGeneration.class));
    }

    public String calculate(Class targetCalss){
        StringBuffer buffer = new StringBuffer("{\n");
        Field[] fieldArr = targetCalss.getDeclaredFields();
        for(Field field : fieldArr){
            buffer.append("\"").append(field.getName()).append("\":").append("\"").append("\"").append(",\n");
        }
        String str = buffer.toString();
        return str.substring(0,(str.length() - 2)) + "\n}";
    }
}
