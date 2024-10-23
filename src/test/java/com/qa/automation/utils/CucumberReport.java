package com.qa.automation.utils;

import com.qa.automation.helpers.TestConfig;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.qa.automation.helpers.BaseSetup.properties;

@Component
public class CucumberReport {

    private static final Logger LOGGER = LoggerFactory.getLogger(CucumberReport.class);
    public static void generateCucumberReport() {
        try {
            File reportOutputDirectory = new File(TestConfig.baseDir, TestConfig.CucumberHtmlReport);
            List<String> jsonFiles = new ArrayList<>();
            jsonFiles.add(new File(TestConfig.baseDir, TestConfig.CucumberJsonReport + "/cucumber-json-report.json").getPath());

            String projectName = "Spring Backend Automation";

            Configuration configuration = new Configuration(reportOutputDirectory, projectName);
            configuration.setSortingMethod(SortingMethod.NATURAL);
            configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);

            String environment = properties.getProp("Environment");
            configuration.addClassifications("Environment", environment);

            if (new File(TestConfig.baseDir, TestConfig.CucumberJsonReport).exists()) {
                createCucumberPropertiesFile(environment);
                ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
                reportBuilder.generateReports();
            }
        } catch (Exception e) {

        }
    }

    private static void createCucumberPropertiesFile(String environment) {
        Map<String, String> propertiesMap = new LinkedHashMap<>();
        propertiesMap.put("Environment", environment);
        propertiesMap.put("Developed By", "Rohit");

        File propertiesFile = new File(TestConfig.baseDir + "/" + TestConfig.CucumberJsonReport, "cucumber.properties");
        try (PrintWriter writer = new PrintWriter(new FileWriter(propertiesFile))) {
            for (Map.Entry<String, String> entry : propertiesMap.entrySet()) {
                writer.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
