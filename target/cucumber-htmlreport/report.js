$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/voyanta/data/datasubmission_validation.feature");
formatter.feature({
  "id": "data-submission-test-for-validating-the-data-at-cell-level",
  "description": "",
  "name": "Data Submission Test for validating the Data at cell level",
  "keyword": "Feature",
  "line": 1
});
formatter.before({
  "duration": 17173839000,
  "status": "passed"
});
formatter.before({
  "duration": 403000,
  "status": "passed"
});
formatter.scenario({
  "id": "data-submission-test-for-validating-the-data-at-cell-level;data-submission-test-to-load-the-data-and-check-the-data-uploaded-matches-the-data-from-database;;2",
  "tags": [
    {
      "name": "@inprogress",
      "line": 4
    }
  ],
  "description": "",
  "name": "Data Submission Test to load the data and check the data uploaded matches the data from Database",
  "keyword": "Scenario Outline",
  "line": 17,
  "type": "scenario"
});
formatter.step({
  "name": "The DataSheet exits in the QA Box with name \u0027Building.xlsx\u0027",
  "keyword": "Given ",
  "line": 7,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "the datasheet data is saved",
  "keyword": "And ",
  "line": 8
});
formatter.step({
  "name": "user uploads the Data from \u0027UI\u0027 with file \u0027Building.xlsx\u0027",
  "keyword": "When ",
  "line": 9,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "it also passed through the Validation and Approval",
  "keyword": "And ",
  "line": 10
});
formatter.step({
  "name": "data should be saved in database table with query name \u0027Building.sql\u0027",
  "keyword": "Then ",
  "line": 11,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "data in all the cells should match",
  "keyword": "And ",
  "line": 12
});
formatter.match({
  "arguments": [
    {
      "val": "Building.xlsx",
      "offset": 45
    }
  ],
  "location": "DataModelSteps.the_DataSheet_exits_in_the_QA_Box_with_name(String)"
});
formatter.result({
  "duration": 379633000,
  "status": "passed"
});
formatter.match({
  "location": "DataModelSteps.the_datasheet_data_is_saved()"
});
formatter.result({
  "duration": 2778063000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Building.xlsx",
      "offset": 43
    }
  ],
  "location": "UIStepDefs.user_uploads_the_Data_from_UI(String)"
});
formatter.result({
  "duration": 15377265000,
  "status": "passed"
});
formatter.match({
  "location": "UIStepDefs.the_uploaded_file_is()"
});
formatter.result({
  "duration": 10599071000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Building.sql",
      "offset": 56
    }
  ],
  "location": "DataModelSteps.data_should_be_saved_in_database(String)"
});
formatter.result({
  "duration": 820986000,
  "status": "passed"
});
formatter.match({
  "location": "DataModelSteps.data_in_all_the_cells_should_match()"
});
formatter.result({
  "duration": 44406000,
  "status": "passed"
});
formatter.after({
  "duration": 350643000,
  "status": "passed"
});
formatter.before({
  "duration": 14179537000,
  "status": "passed"
});
formatter.before({
  "duration": 203000,
  "status": "passed"
});
formatter.scenario({
  "id": "data-submission-test-for-validating-the-data-at-cell-level;data-submission-test-to-load-the-data-and-check-the-data-uploaded-matches-the-data-from-database;;3",
  "tags": [
    {
      "name": "@inprogress",
      "line": 4
    }
  ],
  "description": "",
  "name": "Data Submission Test to load the data and check the data uploaded matches the data from Database",
  "keyword": "Scenario Outline",
  "line": 18,
  "type": "scenario"
});
formatter.step({
  "name": "The DataSheet exits in the QA Box with name \u0027Lease (v5.1).xlsx\u0027",
  "keyword": "Given ",
  "line": 7,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "the datasheet data is saved",
  "keyword": "And ",
  "line": 8
});
formatter.step({
  "name": "user uploads the Data from \u0027UI\u0027 with file \u0027Lease (v5.1).xlsx\u0027",
  "keyword": "When ",
  "line": 9,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "it also passed through the Validation and Approval",
  "keyword": "And ",
  "line": 10
});
formatter.step({
  "name": "data should be saved in database table with query name \u0027Lease.sql\u0027",
  "keyword": "Then ",
  "line": 11,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "data in all the cells should match",
  "keyword": "And ",
  "line": 12
});
formatter.match({
  "arguments": [
    {
      "val": "Lease (v5.1).xlsx",
      "offset": 45
    }
  ],
  "location": "DataModelSteps.the_DataSheet_exits_in_the_QA_Box_with_name(String)"
});
formatter.result({
  "duration": 1915000,
  "status": "passed"
});
formatter.match({
  "location": "DataModelSteps.the_datasheet_data_is_saved()"
});
formatter.result({
  "duration": 560234000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Lease (v5.1).xlsx",
      "offset": 43
    }
  ],
  "location": "UIStepDefs.user_uploads_the_Data_from_UI(String)"
});
formatter.result({
  "duration": 13743934000,
  "status": "passed"
});
formatter.match({
  "location": "UIStepDefs.the_uploaded_file_is()"
});
formatter.result({
  "duration": 84480674000,
  "status": "failed",
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"link text\",\"selector\":\"History\"}\nCommand duration or timeout: 99 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.42.2\u0027, revision: \u00276a6995d\u0027, time: \u00272014-06-03 17:42:03\u0027\nSystem info: host: \u0027sriram-pc\u0027, ip: \u0027192.168.1.54\u0027, os.name: \u0027Windows 8.1\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.3\u0027, java.version: \u00271.8.0_05\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, handlesAlerts\u003dtrue, databaseEnabled\u003dtrue, version\u003d30.0, platform\u003dXP, browserConnectionEnabled\u003dtrue, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webStorageEnabled\u003dtrue, locationContextEnabled\u003dtrue, browserName\u003dfirefox, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3564e976-16e0-4b41-b8db-7ff3ccedcacd\nCommand duration or timeout: 81.95 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.42.2\u0027, revision: \u00276a6995d31c7c56c340d6f45a76976d43506cd6cc\u0027, time: \u00272014-06-03 10:52:47\u0027\nSystem info: host: \u0027Srirams-MacBook-Pro.local\u0027, ip: \u0027192.168.1.35\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.9.3\u0027, java.version: \u00271.7.0_25\u0027\nSession ID: 68c6a932-cca6-4adb-89a3-0fc09abd7ec8\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities [{platform\u003dXP, javascriptEnabled\u003dtrue, acceptSslCerts\u003dtrue, browserName\u003dfirefox, rotatable\u003dfalse, locationContextEnabled\u003dtrue, webdriver.remote.sessionid\u003d68c6a932-cca6-4adb-89a3-0fc09abd7ec8, version\u003d30.0, cssSelectorsEnabled\u003dtrue, databaseEnabled\u003dtrue, handlesAlerts\u003dtrue, browserConnectionEnabled\u003dtrue, webStorageEnabled\u003dtrue, nativeEvents\u003dfalse, applicationCacheEnabled\u003dtrue, takesScreenshot\u003dtrue}]\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:57)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:526)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:204)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:156)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:599)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:352)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByLinkText(RemoteWebDriver.java:401)\n\tat org.openqa.selenium.By$ByLinkText.findElement(By.java:242)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:344)\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:59)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:34)\n\tat com.sun.proxy.$Proxy23.click(Unknown Source)\n\tat com.voyanta.data.pageobject.voyanta.pageobject.DataManager.go_to_History(DataManager.java:127)\n\tat com.voyanta.data.UIStepDefs.the_uploaded_file_is(UIStepDefs.java:75)\n\tat ✽.And it also passed through the Validation and Approval(com/voyanta/data/datasubmission_validation.feature:10)\nCaused by: org.openqa.selenium.remote.ScreenshotException: Screen shot has been taken\nBuild info: version: \u00272.42.2\u0027, revision: \u00276a6995d31c7c56c340d6f45a76976d43506cd6cc\u0027, time: \u00272014-06-03 10:52:47\u0027\nSystem info: host: \u0027Srirams-MacBook-Pro.local\u0027, ip: \u0027192.168.1.35\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.9.3\u0027, java.version: \u00271.7.0_25\u0027\nDriver info: driver.version: RemoteWebDriver\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:136)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:599)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:352)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByLinkText(RemoteWebDriver.java:401)\n\tat org.openqa.selenium.By$ByLinkText.findElement(By.java:242)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:344)\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:59)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:34)\n\tat com.sun.proxy.$Proxy23.click(Unknown Source)\n\tat com.voyanta.data.pageobject.voyanta.pageobject.DataManager.go_to_History(DataManager.java:127)\n\tat com.voyanta.data.UIStepDefs.the_uploaded_file_is(UIStepDefs.java:75)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:606)\n\tat cucumber.runtime.Utils$1.call(Utils.java:34)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:13)\n\tat cucumber.runtime.Utils.invoke(Utils.java:30)\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:35)\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:298)\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:48)\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:91)\n\tat org.junit.runners.Suite.runChild(Suite.java:127)\n\tat org.junit.runners.Suite.runChild(Suite.java:26)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\n\tat org.junit.runners.Suite.runChild(Suite.java:127)\n\tat org.junit.runners.Suite.runChild(Suite.java:26)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:89)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:40)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:94)\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:160)\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:74)\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:202)\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:65)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:606)\n\tat com.intellij.rt.execution.application.AppMain.main(AppMain.java:120)\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"link text\",\"selector\":\"History\"}\nCommand duration or timeout: 99 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.42.2\u0027, revision: \u00276a6995d\u0027, time: \u00272014-06-03 17:42:03\u0027\nSystem info: host: \u0027sriram-pc\u0027, ip: \u0027192.168.1.54\u0027, os.name: \u0027Windows 8.1\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.3\u0027, java.version: \u00271.8.0_05\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, handlesAlerts\u003dtrue, databaseEnabled\u003dtrue, version\u003d30.0, platform\u003dXP, browserConnectionEnabled\u003dtrue, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webStorageEnabled\u003dtrue, locationContextEnabled\u003dtrue, browserName\u003dfirefox, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 3564e976-16e0-4b41-b8db-7ff3ccedcacd\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.42.2\u0027, revision: \u00276a6995d31c7c56c340d6f45a76976d43506cd6cc\u0027, time: \u00272014-06-03 10:52:47\u0027\nSystem info: host: \u0027Srirams-MacBook-Pro.local\u0027, ip: \u0027192.168.1.35\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.9.3\u0027, java.version: \u00271.7.0_25\u0027\nDriver info: driver.version: EventFiringWebDriver\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:204)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:156)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:599)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:352)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByLinkText(RemoteWebDriver.java:401)\n\tat org.openqa.selenium.By$ByLinkText.findElement(By.java:242)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:344)\n\tat sun.reflect.GeneratedMethodAccessor23.invoke(Unknown Source)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\n\tat java.lang.reflect.Method.invoke(Unknown Source)\n\tat org.openqa.selenium.support.events.EventFiringWebDriver$2.invoke(EventFiringWebDriver.java:101)\n\tat com.sun.proxy.$Proxy3.findElement(Unknown Source)\n\tat org.openqa.selenium.support.events.EventFiringWebDriver.findElement(EventFiringWebDriver.java:184)\n\tat org.openqa.selenium.remote.server.handler.FindElement.call(FindElement.java:47)\n\tat org.openqa.selenium.remote.server.handler.FindElement.call(FindElement.java:1)\n\tat java.util.concurrent.FutureTask.run(Unknown Source)\n\tat org.openqa.selenium.remote.server.DefaultSession$1.run(DefaultSession.java:169)\n\tat java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)\n\tat java.lang.Thread.run(Unknown Source)\n"
});
formatter.match({
  "arguments": [
    {
      "val": "Lease.sql",
      "offset": 56
    }
  ],
  "location": "DataModelSteps.data_should_be_saved_in_database(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DataModelSteps.data_in_all_the_cells_should_match()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 55652257000,
  "status": "passed"
});
});