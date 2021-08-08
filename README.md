# Wallethub Assignments

This library has been created and designed to test Facebook and WalletHub

## Components

#### Selenium - 3 + Junit 4 + Cucumber 1 + Gradle

## Configurations

### Update Credentials.properties (inside WalletHub/src/test/resources/properties/)

Update the below details in Credentials file to get the tests executed
```
facebook.username.TestUser=
facebook.password.TestUser=
wallethub.username=
wallethub.password=

```

## How to Execute the Tests

### Using build.gradle


```java
task cucumber() {
    group="cucumberRunner"
    description="Task to execute tag specific features"
    dependsOn assemble, testClasses
    doLast {
        javaexec {
            main = "cucumber.api.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = ['--plugin', 'pretty', '--glue', 'stepdefinitions',"--tags", "$$testtoexecute$$", 'src/test/resources']
        }
    }

```
Replace **$$testtoexecute$$** with relevant tag to execute the cases.Refer *"Tag-Feature Mapping"* table in table section

### Using Runcukes.java (WalletHub/src/test/java/utilities/)


```java
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {"pretty","html:target/cucumber-reports"},glue = {"stepdefinitions"},monochrome = false,tags= {"$$testtoexecute$$"})
public class Runcukes {

}
```
Replace **$$testtoexecute$$** with relevant tag to execute the cases.Refer *"Tag-Feature Mapping"* table in table section

## Reports

Reports will be automatically generated under *"WalletHub/target/cucumber-reports/"* upon execution of the cases


### Table 

#### Tag-Feature Mapping

| Tag |  Situation  |
|:-----|:--------:|
| @All   | To Run all cases |
| @Assignment1   |  To run the Assignment 1  |
| @Assignment2   |  To run the Assignment 2  |
| @Facebook   |  To run all Facebook related test cases  |
| @Wallethub    |  To run all Wallethub related test cases  |
