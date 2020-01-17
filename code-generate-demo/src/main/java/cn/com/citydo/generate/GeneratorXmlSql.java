package cn.com.citydo.generate;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author fumj
 * @projectName credit
 * @description: TODO
 * @date 2019/7/1910:14
 */
public class GeneratorXmlSql {

    final String template = " <if test=\"${wrapper}.${property} != null and ${wrapper}.${property} != '' \">\n" +
            "            and ${column} like concat('%',#{${wrapper}.${property}},'%')\n" +
            "        </if>";

    final static String COLUMN = "column";
    final static String PROPERTY = "property";
    final static String RESULT = "result";
    final static String WRAPPER_NAME = "wrapper";


    @Test
    public void client() throws Exception {
        String fileDir = "D:\\work_code\\credit\\credit-service\\credit-part\\src\\main\\resources\\mapper\\part\\DataUseOrganizationMapper.xml";
        String tableName = "t_data_use_organization";
        String excludeProperty = "asc";
        Map<String, String> replaceValue = Maps.newHashMap();
        replaceValue.put("wrapper", WRAPPER_NAME);

        Set<String> voPropertySet = getVoFieldSet(CodeGeneration.class);
        String dtoStr = getDTOFieldStr(CodeGeneration.class);



        voPropertySet.remove(excludeProperty);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append("select ").append(dtoStr).append(" \nfrom ").append(tableName)
                .append(" \nwhere 1 = 1 and state = 0 \n");

        File file = new File(fileDir);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        NodeList mapperList = doc.getElementsByTagName(RESULT);
        for (int i = 0; i < mapperList.getLength(); i++) {
            Node node = mapperList.item(i);
            Element element = (Element) node;
            String column = element.getAttribute(COLUMN);
            String property = element.getAttribute(PROPERTY);
            if (voPropertySet.contains(property)) {
                replaceValue.put(PROPERTY, property);
                replaceValue.put(COLUMN, column);
                StrSubstitutor strSubstitutor = new StrSubstitutor(replaceValue);
                String str = strSubstitutor.replace(template);
                sqlBuffer.append(str);
            }

        }
        String order = "\n<if test=\"wrapper.orderBy != null and wrapper.orderBy != '' \">\n" +
                "            order by ${wrapper.orderBy}\n" +
                "            <if test=\"wrapper.asc == true\">\n" +
                "                asc\n" +
                "            </if>\n" +
                "            <if test=\"wrapper.asc == false\">\n" +
                "                desc\n" +
                "            </if>\n" +
                "        </if>";
        sqlBuffer.append(order);

        System.out.println(sqlBuffer.toString());

    }

    private String getDTOFieldStr(Class dtoClass) {
        StringBuffer buffer = new StringBuffer();
        Field[] fields = dtoClass.getDeclaredFields();
        for (Field field : fields) {
            buffer.append(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field.getName())
            ).append(",");
        }
        String str = buffer.toString();
        return str.substring(0, (str.length() - 1));
    }

    private Set<String> getVoFieldSet(Class classVo) {
        Set<String> sets = new HashSet<>();
        Field[] fields = classVo.getDeclaredFields();
        for (Field field : fields) {
            sets.add(field.getName());
        }
        return sets;
    }


}
