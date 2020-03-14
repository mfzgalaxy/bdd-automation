# FirdausProj: CIMB Interview Test


Java + Junit + Cucumber + Selenium testing cases + Cluecumber Reporting

This repo contains the Maven setup for Cucumber / Selenium, with the functional test scripts made for CIMB Job Interview test, which can be run on local or connect to remote SaucsLabs / TestingBot for cross browser testings. Also it can be configured in your CI server (i.e. Bamboo) for continuous testing. It helps to setup a BDD environment for User Acceptance tests.

This repo can be run on local Windows / Mac / Linux Platform, as long as you have Java/Maven setup correctly.

## Setup

### Install on Local Machine

Install Java & Maven on your local machine

= To Run (Maven command line) =

Local machine with browser name (ie / chrome / firefox / safari)

- Test with Google Chrome (Mac / Windows for machineType):
```
> mvn test cluecumber-report:reporting -DbrowserName="googlechrome" -DmachineType="mac"
```

- Test with Firefox (Mac / Windows for machineType):
```
> mvn test cluecumber-report:reporting -DbrowserName="firefox" -DmachineType="mac"
```

- Test with IE (Windows Only):
```
> mvn test cluecumber-report:reporting -DbrowserName="ie"
```

- Test with Safari (After install Safari extension, see /drivers/README.md):
```
> mvn test cluecumber-report:reporting -DbrowserName="safari"
```

Remote Webdriver:

- Testingbot (You can pass through Bamboo build variable for api key)
```
> mvn test cluecumber-report:reporting -DenvName="remote" -DremoteWebDriver="http://<testingbot api key>@hub.testingbot.com:4444/wd/hub"
```

- SauceLabs (You can pass through Bamboo build variable for api key)
```
> mvn test cluecumber-report:reporting -DenvName="remote" -DremoteWebDriver="http://<saucelabs api key>@ondemand.saucelabs.com:80/wd/hub"
```

# WebDriver Update
See README inside /drivers folder


# Flexibility and Scalability
- The Scripts made already implement data driven which we can reuse for infinite number of test data.
- There is also fuctionality to determine test browser, resolution, which able to support cross platform browsers including mobile
- There is always room for improvise and can integrates with Continues Integration Tools like Jenkins or TeamCity