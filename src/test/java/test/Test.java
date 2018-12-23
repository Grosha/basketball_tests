package test;

import helper.TutorialHelper;

public class Test extends SetUpAppium {
    private TutorialHelper tutorialHelper;

    @Override
    public void initDriver() {
        super.initDriver();
        tutorialHelper = new TutorialHelper(driver);
    }



    @org.junit.Test
    public void testFirst() {
        capabilities.setCapability("noReset", true);
        waitForElement(tutorialHelper.startBetInfoButton(),5);
        tutorialHelper.startBetInfoButton().click();
        tutorialHelper.assertTutorialTeamPage();
//        System.out.println("test");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
