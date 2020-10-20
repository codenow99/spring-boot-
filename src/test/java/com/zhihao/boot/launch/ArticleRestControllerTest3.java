//package com.zhihao.boot.launch;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.zhihao.boot.launch.controller.ArticleController;
//import com.zhihao.boot.launch.model.Article;
//import com.zhihao.boot.launch.service.ArticleService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpMethod;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import javax.annotation.Resource;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//@Slf4j
//@AutoConfigureMockMvc
//@WebMvcTest(ArticleController.class)
//@ExtendWith(SpringExtension.class)
//public class ArticleRestControllerTest3 {
//
//    //mock对象
//    @Resource
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ArticleService articleService;
//
//  /*@BeforeAll
//  static void setUP(){
//    mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
//  }*/
//
//    @Test
//    public void  saveArticle() throws  Exception{
//
//        String article = "{\n" +
//                "    \"id\": 1,\n" +
//                "    \"author\": \"zimug\",\n" +
//                "    \"title\": \"手摸手教你开发spring boot\",\n" +
//                "    \"content\": \"c\",\n" +
//                "    \"createTime\": \"2017-07-16 05:23:34\",\n" +
//                "    \"reader\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
//                "}";
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        Article articleObj = objectMapper.readValue(article, Article.class);
//        //打桩
//        when(articleService.saveArticle(articleObj)).thenReturn("ok");
//
//        MvcResult mvcResult = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .request(HttpMethod.POST, "/rest/articles")
//                        .contentType("application/json")
//                        .content(article)
//        ).andExpect(MockMvcResultMatchers.jsonPath("$.data").value("ok"))
//                .andDo(print())
//                .andReturn();
//
//        mvcResult.getResponse().setCharacterEncoding("UTF-8");
//        log.info(mvcResult.getResponse().getContentAsString());
//
//    }
//
//}
