package com.qa.automation.helpers;

public class BaseSetup {

    public static PropertyReader properties;
    private static BaseSetup baseObject = null;

    private BaseSetup(){
        properties = new PropertyReader(TestConfig.ProfileFilePath);
        System.out.println("properties --- :: "+properties);
    }

    public static BaseSetup getInstance(){
        if(baseObject == null) {
            synchronized (BaseSetup.class) {
                if(baseObject == null) {
                    baseObject = new BaseSetup();
                }
            }
        }
        return baseObject;
    }

    public static void killInstance() throws Throwable {
        try {
            baseObject = null;
            properties = null;
            killDriverInstance();
        } catch (Throwable t) {

        }
    }

    public static void setProfilePath(){
        String env="dev";
        System.out.println("Environment --- :: "+env);

        TestConfig.ProfileFilePath=TestConfig.baseDir +"\\src\\test\\resources\\profiles\\"+env+"\\config.properties";
        System.out.println("Path --- :: "+TestConfig.ProfileFilePath);
    }

    public static void killDriverInstance() throws Throwable{
        try {
            Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
        } catch (Throwable t){

        }
    }
}
