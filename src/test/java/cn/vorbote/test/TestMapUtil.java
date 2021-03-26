package cn.vorbote.test;

import cn.vorbote.commons.MapUtil;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;

import java.util.HashMap;

public class TestMapUtil {

    @Test
    public void run01() {
        var map = new HashMap<String, Object>();
        map.put("name", "张三");
        map.put("age", 18);

        var person = new Person();

        MapUtil.SetObject(map, person);
        System.out.println(person);
    }
}

@Data
@ToString
class Person {
    private String name;
    private Integer age;
}
