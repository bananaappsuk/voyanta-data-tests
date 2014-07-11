package com.voyanta.data.utils.utils;



public class BrowserFactory {

//    private static final Logger LOGGER = Logger.getLogger(com.venkyold.org.adv.utils.BrowserFactory.class);
//    static final String LOCAL_SELENIUM_GRID_URL = "http://localhost:4444/wd/hub";
//
//    public static WebDriver getBrowser() {
//        LOGGER.info("getBrowser()");
//        WebDriver mBrowser;
//        String browserType = System.getProperty(AutomationConstants.BROWSER_TYPE);
//        if (browserType != null) {
//            if (browserType.equalsIgnoreCase("firefox")) {
//                mBrowser = getFirefoxBrowser("15");
//            } else if (browserType.equalsIgnoreCase("firefox7")) {
//                mBrowser = getFirefoxBrowser("7");
//            } else if (browserType.equalsIgnoreCase("ie8")) {
//                mBrowser = getIEDriver("8");
//            } else if (browserType.equalsIgnoreCase("ie6")) {
//                mBrowser = getIEDriver("6");
//            } else if (browserType.equalsIgnoreCase("ios")) {
//                mBrowser = getIOSDriver();
//            } else if (browserType.equalsIgnoreCase("android")) {
//                mBrowser = getAndroidDriver();
//            } else if (browserType.equalsIgnoreCase("chrome")) {
//                mBrowser = getChromeDriver();
//            } else if (browserType.equalsIgnoreCase("safari")) {
//                mBrowser = getSafariDriver();
//            } else {
//                // Default browser is set to firefox browser
//                mBrowser = getFirefoxBrowser("15");
//            }
//        } else {
//            // Default browser is set remote firefox browser
//            LOGGER.info("No browser type specified. Defaulting to using a remote firefox browser");
//            System.setProperty(AutomationConstants.REMOTE_BROWSER, "true");
//            mBrowser = getFirefoxBrowser("15");
//        }
//        return mBrowser;
//    }
//
//    public static WebDriver getMobileDriver() {
//        return createFirefoxDriver(getFirefoxProfile(true));
//    }
//
//
//    public static class ScreenShotRemoteWebDriver extends RemoteWebDriver implements TakesScreenshot {
//        public ScreenShotRemoteWebDriver(URL url, DesiredCapabilities dc) {
//            super(url, dc);
//        }
//
//
//        public <X> X getScreenshotAs(OutputType<X> target)
//                throws WebDriverException {
//            if ((Boolean) getCapabilities().getCapability(CapabilityType.TAKES_SCREENSHOT)) {
//                return target.convertFromBase64Png(execute(DriverCommand.SCREENSHOT).getValue().toString());
//            }
//            return null;
//        }
//    }
//
//
//    public static WebDriver getFirefoxBrowser(String version) {
//        LOGGER.info("getFirefoxBrowser()");
//        WebDriver mBrowser;
//
//        try {
//            String remoteValue = System.getProperty(AutomationConstants.REMOTE_BROWSER);
//            if (remoteValue != null && remoteValue.equalsIgnoreCase("true")) {
//                LOGGER.info("Getting remote firefox web driver");
//                DesiredCapabilities firefox = DesiredCapabilities.firefox();
//                firefox.setVersion(version);
//                firefox.setPlatform(Platform.ANY);
//                firefox.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
//                mBrowser = new ScreenShotRemoteWebDriver(new URL(LOCAL_SELENIUM_GRID_URL), firefox);
//
//                //Uncomment line below to enable remote testing from your build machine with VM images
//                //mBrowser = new RemoteWebDriver(new URL("http://9.79.12.251:4444/wd/hub"), DesiredCapabilities.firefox());
//
//                mBrowser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                //mBrowser.manage().window().setPosition(new Point(0,0));
//                //java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
//                //Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
//                //mBrowser.manage().window().setSize(dim);
//
//            } else {
//                LOGGER.info("Preparing local firefox profile");
//                FirefoxProfile firefoxProfile = getFirefoxProfile(false);
//
//  LOGGER.info("Getting local firefox web driver");
//                mBrowser = createFirefoxDriver(firefoxProfile);
//            }
//
//
//        } catch (Exception e) {
//            LOGGER.error("Could not start browser for reason " + e.getMessage());
//            throw new RuntimeException("could not start Browser Factory", e);
//        }
//        return mBrowser;
//    }
//
//    private static WebDriver createFirefoxDriver(FirefoxProfile firefoxProfile) {
//        WebDriver mBrowser;
//        mBrowser = new FirefoxDriver(firefoxProfile);
//        mBrowser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        mBrowser.manage().window().setPosition(new Point(0, 0));
//        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
//        Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
//        mBrowser.manage().window().setSize(dim);
//        return mBrowser;
//    }
//
//    private static FirefoxProfile getFirefoxProfile(boolean mobileAgent) {
//        File file = CoreResources.getFile("firebug/firebug-1.9.2.xpi");
//        FirefoxProfile firefoxProfile = new FirefoxProfile();
//        try {
//            firefoxProfile.addExtension(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Reference: http://getfirebug.com/wiki/index.php/Firebug_Preferences
//        firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.9.2");  // Avoid startup screen
//        firefoxProfile.setPreference("extensions.firebug.script.enableSites", true);
//        firefoxProfile.setPreference("extensions.firebug.console.enableSites", true);
//        firefoxProfile.setPreference("extensions.firebug.allPagesActivation", true);
//        firefoxProfile.setPreference("extensions.firebug.delayLoad", false);
//        if (mobileAgent) {
//            firefoxProfile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16");
//            //firefoxProfile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 crap/7A341 Safari/528.16");
//        }
//        return firefoxProfile;
//    }
//
//
//    private static WebDriver getChromeDriver() {
//        LOGGER.info("getChromeDriver()");
//        WebDriver mBrowser;
//        String remoteValue = System.getProperty(AutomationConstants.REMOTE_BROWSER);
//        try {
//
//            if (remoteValue != null && remoteValue.equalsIgnoreCase("true")) {
//                LOGGER.info("Getting remote chrome web driver");
//                DesiredCapabilities chrome = DesiredCapabilities.chrome();
//                chrome.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
//                chrome.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
//                mBrowser = new ScreenShotRemoteWebDriver(new URL(LOCAL_SELENIUM_GRID_URL), chrome);
//            } else {
//                System.setProperty("webdriver.chrome.driver", "/Users/nick/Downloads/chromedriver");
//                LOGGER.info("Getting local chrome web driver");
//                mBrowser = new ChromeDriver();
//            }
//
//            mBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//        } catch (Exception e) {
//            LOGGER.info("Error with chrome driver initialisation. " + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//        return mBrowser;
//    }
//
//    private static WebDriver getAndroidDriver() {
//        LOGGER.info("getAndroidDriver()");
//        WebDriver mBrowser;
//        try {
//            String remoteValue = System.getProperty(AutomationConstants.REMOTE_BROWSER);
//            if (remoteValue != null && remoteValue.equalsIgnoreCase("true")) {
//                LOGGER.info("Getting remote android web driver");
//                mBrowser = new ScreenShotRemoteWebDriver(new URL("http://192.168.180.31:8081/wd/hub"), DesiredCapabilities.android());
//            } else {
//                LOGGER.info("Getting local android web driver");
//                mBrowser = new ScreenShotRemoteWebDriver(new URL("http://localhost:8080/wd/hub"), DesiredCapabilities.android());
//            }
//        } catch (Exception e) {
//            LOGGER.info("Error with android driver initialisation. " + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//        return mBrowser;
//    }
//
//    private static WebDriver getIOSDriver() {
//        LOGGER.info("getIOSBrowser()");
//        WebDriver mBrowser;
//        try {
//            if (CoreProperties.getBooleanSystemProperty(CoreSystemProperty.USE_REMOTE_BROWSER)) {
//                mBrowser = new ScreenShotRemoteWebDriver(new URL(LOCAL_SELENIUM_GRID_URL), DesiredCapabilities.iphone());
//                mBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            } else {
//                mBrowser = new IPhoneDriver();
//                mBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return mBrowser;
//    }
//
//
//    private static WebDriver getIEDriver(String version) {
//        LOGGER.info("getIEBrowser()");
//        WebDriver mBrowser;
//
//        try {
//            String remoteValue = System.getProperty(AutomationConstants.REMOTE_BROWSER);
//            DesiredCapabilities ie = DesiredCapabilities.internetExplorer();
//            ie.setPlatform(Platform.ANY);
//            ie.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
//            if (remoteValue != null && remoteValue.equalsIgnoreCase("true")) {
//                ie.setVersion(version);
//                LOGGER.info("Getting remote IE" + version + " web driver");
//                mBrowser = new ScreenShotRemoteWebDriver(new URL(LOCAL_SELENIUM_GRID_URL), ie);
//            } else {
//                LOGGER.info("Getting local IE web driver");
//                mBrowser = new InternetExplorerDriver(ie);
//            }
//            mBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            //mBrowser.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//
//        } catch (Exception e) {
//            LOGGER.info("Error with ie initialisation. Version " + version);
//            LOGGER.info(e.getMessage());
//            return null;
//        }
//        return mBrowser;
//    }
//
//    private static WebDriver getSafariDriver() {
//        LOGGER.info("getSafariDriver()");
//        WebDriver mBrowser;
//
//        try {
//            String remoteValue = System.getProperty(AutomationConstants.REMOTE_BROWSER);
//
//            if (remoteValue != null && remoteValue.equalsIgnoreCase("true")) {
//                LOGGER.info("Getting remote safari web driver");
//                mBrowser = new ScreenShotRemoteWebDriver(new URL(LOCAL_SELENIUM_GRID_URL), DesiredCapabilities.safari());
//            } else {
//                LOGGER.info("Getting local safari web driver");
//                mBrowser = new SafariDriver();
//            }
//            mBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            //mBrowser.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//
//        } catch (Exception e) {
//            LOGGER.info("Error with safari initialisation.");
//            LOGGER.info(e.getMessage());
//            return null;
//        }
//        return mBrowser;
//    }


}
