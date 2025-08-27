import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author: yang
 * @Date: 2025/08/26/09:51
 */
public class FreeMarkerTest {
    @Test
    public void test() throws IOException, TemplateException {
        // 创建 FreeMarker 配置实例
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 设置模板加载目录
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        // 设置默认编码
        configuration.setDefaultEncoding("UTF-8");

        Template template = configuration.getTemplate("myweb.html.ftl");

        Map<String, Object> dataModel = getObjectMap();

        // 生成
        Writer out = new FileWriter("myweb.html");
        template.process(dataModel, out);
        out.close();




    }

    private static Map<String, Object> getObjectMap() {
        Map<String,Object> dataModel = new HashMap<>();
        dataModel.put("currentYear",2025);
        List<Map<String,Object>> menuItems = new ArrayList<>();
        Map<String,Object> menuItem1 = new HashMap<>();
        menuItem1.put("url","https://www.google.com");
        menuItem1.put("label","Google");
        menuItems.add(menuItem1);
        Map<String,Object> menuItem2 = new HashMap<>();
        menuItem2.put("url","https://www.bing.com");
        menuItem2.put("label","Bing");
        menuItems.add(menuItem2);
        dataModel.put("menuItems",menuItems);
        return dataModel;
    }
}
