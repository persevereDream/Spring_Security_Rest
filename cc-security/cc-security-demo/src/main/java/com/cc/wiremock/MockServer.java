package com.cc.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class MockServer {
    public static void main(String[] args) throws IOException {
        WireMock.configureFor(8062);  //WireMock server 服务的运行端口
        WireMock.removeAllMappings();  //清除以前所有服务

        mock("/order/1","01");
        mock("/order/2","02");
    }

    private static void mock(String url, String file) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/response/"+file+".txt");
        String content = FileUtils.readFileToString(resource.getFile(),"UTF-8");
//        String c = StringUtils.join(FileUtils.readLines(resource.getFile(),"UTF-8"),"\n");
        System.out.println("content:"+content);

        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(url))
                .willReturn(WireMock.aResponse().withBody(content ).withStatus(200)));
    }
}
