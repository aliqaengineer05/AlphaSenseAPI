
# AlphaSense Document Viewer Automation Serenity Rest BBD

AlphaSense Document Viewer automated using Serenity Rest BBD & Maven

# Framework 

- Framework designed in BDD with Maven , Restassured , Serenity , log4j and log2j properties .
- Serenity reporting utilized for reporting purpose.
```
 restapi {
      baseurl = "https://rc.alpha-sense.com/doc/PR-386ea743f2a90399fb0e4300ddf37d0697abc743"
}
```

- Updated TestRunner class and added `glue` & `tag` CucumberOptions. `glue` that describes the location and path of the step definition file and `tag` to controll test execution
- Implemented log4j2 for logging test information. Added log4j2.xml file under `Test\resources\log4j2.xml`. Logs will be created under logs folder present at root level
```
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="warn">
    <Properties>
        <Property name="basePath">logs</Property>
    </Properties>

    <Appenders>
        <RollingFile name="fileLogger"
                     fileName="${basePath}/apitest.log"
                     filePattern="${basePath}/test-%d{yyyy-MM-dd}.log">
            <PatternLayout>
                <pattern>[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n
                </pattern>
            </PatternLayout>
            <Policies>
                <TimeBasedTriggeringPolicy interval="1" modulate="true" />
                <SizeBasedTriggeringPolicy size="10MB" />
            </Policies>
            <!-- Max 10 files will be created everyday -->
            <DefaultRolloverStrategy max="10">
                <Delete basePath="${basePathr}" maxDepth="10">
                    <!-- Delete all files older than 30 days -->
                    <IfLastModified age="30d" />
                </Delete>
            </DefaultRolloverStrategy>
        </RollingFile>
    </Appenders>
    <Loggers>
        <Root level="info" additivity="false">
            <appender-ref ref="fileLogger" />
        </Root>
    </Loggers>
</Configuration>

```

- Implemented Pojo class for all endpoints for  `Deserialization` purpose using `Jackson-core`,`Jackson data-bind` & `Jackson annotation` maven dependencies. Logic behind to validate complex responses
```
 <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.13.1</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.13.1</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>2.13.1</version>
        </dependency>
```
- Added Restassured schema validator maven dependencies
```
 <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>json-schema-validator</artifactId>
            <version>4.5.1</version>
        </dependency>
```
## How to add new test cases?
- Creat a feature file under `src/test/resources/features/search/AlphaSense.feature`
- Create a stepdefinition class under `src/test/java/starter/stepdefinitions` and implements steps `Given` `When` `Then`
- Create a step class which implements steps for definition class under `src/test/java/starter/stepdefinitions` 


## Running Tests

To run tests, run the following command on terminal. Navigate to project folder where POM.xml resides. for example
`AlphaSenseAPI-20220212T074150Z-001\AlphaSenseAPI>`


```bash
  mvn clean verify
```
## Reports

At the end of test execution, report is generated under `target\site\serenity\index.html`

## Dockerfile
Since gitlab cicd runs on docker image. I've created customer docker images that's capable of running selenium tests in headless mode as well
restassured. Image can be pulled from dockerhub registry

```
FROM Window:10
MAINTAINER Ahmed Ali  "ali.qaengineer@gmail.com"

WORKDIR /root
ENV USER /root

RUN sed -i 's/# \(.*multiverse$\)/\1/g' /etc/apt/sources.list
RUN apt-get autoclean
RUN apt-get clean
RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y upgrade
RUN apt-get -y --no-install-recommends install openjdk-8-jdk
RUN apt-get -y --no-install-recommends install maven
RUN apt-get -y install curl
RUN apt-get -y install git
RUN curl https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb -o /chrome.deb
RUN dpkg -i /chrome.deb || apt-get install -yf
RUN rm /chrome.deb

```

## .gitlab-ci.yml 
gitlab cici pipeline. It has three stages 
- clean
- test
- deploy

```
image: ali.qaengineer/test_automation_images:latest

build:
  stage: build
  script:
    - mvn clean
test:
  stage: test
  script:
    - mvn verify
  artifacts:
    when: always
    paths:
      - target/site/serenity/index.html
    expire_in: 1 week

deploy:
  stage: deploy
  script:
    - mkdir report
    - mv target/site/serenity/index.html report
  artifacts:
    when: always
    paths:
      - report
    expire_in: 1 week

```


## API Reference

#### Get Keyword 


Please Take a fresh API link along with fresh Parameters and you can access this API 
1.Go to Network tab
2.Write a keyword in Search Field
3.In network tab a new call generated lik "https://rc.alpha-sense.com/services/i/public-document-data/document/PR-386ea743f2a90399fb0e4300ddf37d0697abc743/keyword-search/?keyword=alphasense&slop=15&positiveOnly=false&negativeOnly=false&released=1633003200000"
4. Please copy the Link and get the below param for this API 
```http
  GET https://rc.alpha-sense.com/doc/PR-386ea743f2a90399fb0e4300ddf37d0697abc743t
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `keyword` | `string` | **AlphaSense**. |
| `slop` | `string` | **15**. |
| `positiveOnly` | `string` | **false**. |
| `negativeOnly` | `string` | **false**. |
| `released` | `string` | **1633003200000**. |




## Authors

- [@Ahmed Ali](github)

