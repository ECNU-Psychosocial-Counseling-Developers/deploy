package cn.edu.ecnu.stu.deployservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootTest
class DeployServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void deployTest() {
        String COMMAND_PATH = "/bin/sh";
        String RESOURCE_PATH = "/Users/pankaiming/IdeaProjects/Psychosocial-Counseling-Platform-Backend/deploy.sh";
        try {
            Process process = Runtime.getRuntime().exec(String.join(" ", COMMAND_PATH, RESOURCE_PATH));
            System.out.println("process.waitFor(): " + process.waitFor());
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
