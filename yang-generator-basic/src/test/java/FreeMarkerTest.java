import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import freemarker.template.Configuration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerTest {

    @Test
    public void test() throws IOException, TemplateException {

        // new 出 Configuration 对象, 参数为 FreeMarker 的版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        // 设置模板文件的字符集
        configuration.setDefaultEncoding("UTF-8");

        // 创建模板对象, 加载指定模板

        Template template = configuration.getTemplate("myweb.html.ftl");

        // 创建数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", "2025");
        // 创建 List 集合,用于存放菜单项
        List<Map<String, Object>> menuItems = new ArrayList<>();
        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url", "https://www.baidu.com");
        menuItem1.put("label", "百度");
        menuItems.add(menuItem1);
        dataModel.put("menuItems", menuItems);

        // 生成
        Writer out = new FileWriter("myweb.html");
        template.process(dataModel, out);

        // 关闭流
        out.close();




    }

}

