package com.jhipsv1.shopping_yt.cucumber;

import com.jhipsv1.shopping_yt.Jhipsv1App;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = Jhipsv1App.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
