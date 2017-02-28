package rico.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Rico.Chen on 2017/2/28.
 */
@Controller
@Slf4j
public class IndexController {

    @GetMapping("/")
    public String toIndex(ModelMap modelMap) {
        JavaBean javaBean = new JavaBean();
        javaBean.setFoo("tom");
        javaBean.setFruit("orange");
        modelMap.put("javaBean", javaBean);
        return "index";
    }

//    @GetMapping("/getURL")
//    public String getURL(String foo, String fruit) {
//        log.info(foo + " " + fruit);
//        return "success";
//    }

    @GetMapping("/getURL")
    public String getURL(JavaBean javaBean) {
        log.info(javaBean.toString());
        return "success";
    }

    @PostMapping("/postForm")
    public String postForm(JavaBean javaBean) {
        log.info(javaBean.toString());
        return "success";
    }

    @RequestMapping("/ajaxStringGet")
    @ResponseBody
    public String ajaxStringGet(JavaBean javaBean) {
        log.info(javaBean.toString());
        return "ajax1 response.";
    }

    @RequestMapping("/ajaxJsonPost")
    @ResponseBody
    public JavaBean ajaxJsonPost(@RequestBody JavaBean javaBean) {
        log.info(javaBean.toString());
        return javaBean;
    }

    @RequestMapping("/ajaxJsonsPost")
    @ResponseBody
    public String ajaxJsonsPost(@RequestBody List<JavaBean> list) {
        log.info(list.toString());
        return "ajax3 list response";
    }

    @RequestMapping("/test/{id}")
    public String restFullRequest(@PathVariable Long id) {
        log.info(id.toString());
        return "success";
    }
}
