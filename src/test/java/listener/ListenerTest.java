package listener;

import allure.AllureHelper;
import loger.LoggerConfig;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import restClient.BaseClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ListenerTest implements ITestListener {
    LoggerConfig loggerConfig = new LoggerConfig();

    @Override
    public void onFinish(ITestContext arg0) {

        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext arg0) {

        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        Logger logger = loggerConfig.createInstance(arg0.getName());
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(new FileOutputStream(new File(loggerConfig.getFilePath()), true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BaseClient.setPrintStream(printStream);
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        AllureHelper.attachLog(loggerConfig.getFilePath());
        // TODO Auto-generated method stub

    }
}