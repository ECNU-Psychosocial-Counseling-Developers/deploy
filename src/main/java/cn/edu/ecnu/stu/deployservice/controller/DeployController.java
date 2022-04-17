package cn.edu.ecnu.stu.deployservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@CrossOrigin
@RestController
public class DeployController {

    @PostMapping("/deploy")
    public void deployProjectByRunShellScript() {
        String COMMAND_PATH = "/bin/sh";
        String RESOURCE_PATH = "deploy.sh";
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
