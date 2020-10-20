package com.zhihao.boot.launch;


import com.zhihao.boot.launch.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@Slf4j
public class ArticleRestControllerTest {
    //mock对象
    public static MockMvc mockMvc;

    @BeforeAll
    static void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

    @Test
    public void saveArticle() throws Exception {
        String article = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"zimug\",\n" +
                "    \"title\": \"手摸手教你开发spring boot\",\n" +
                "    \"content\": \"c\",\n" +
                //"    \"createTime\": \"2017-07-16 05:23:34\",\n" +
                "    \"reader\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";
        MvcResult result = mockMvc.perform(
                //模拟一个RequestBuilder构建的HTTP请求, 会执行SpringMVC的流程,并映射到相应的控制器controller执行
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/rest/articles")
                        //发送请求的序列化格式,"application/json"表示的是json格式
                        .contentType("application/json")
                        .content(article)
        )
                //添加ResultMatchers验证规则,并验证执行完成结果是否正确,或者说是否与我们期望(Expect)的一致
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                //添加RequestHandler结果处理器,比如调试是打印结果到控制台
                .andDo(print())
                //最后返回相应的MvcResult, 然后进行自定义验证/进行下一步的异步处理
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());
    }


}
