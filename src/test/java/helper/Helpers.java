package helper;

import helper.popup.CongratsPopup;
import helper.popup.InviteFriendsPopup;
import helper.tabs.TabsHelper;
import helper.tabs.games.*;
import helper.tabs.home.HomeTabHelper;

public class Helpers {

    public static LoginView login() {
        return new LoginView();
    }

    public static TutorialHelper tutorial() {
        return new TutorialHelper();
    }

    public static HomeTabHelper home() {
        return new HomeTabHelper();
    }

    public static TabsHelper tabs() {
        return new TabsHelper();
    }

    public static DrawerHelper drawer() {
        return new DrawerHelper();
    }

    public static ToolbarHelper toolbar() {
        return new ToolbarHelper();
    }

    public static GamesHelper games() {
        return new GamesHelper();
    }

    public static LiveGameBlockHelper liveGameBlock() {
        return new LiveGameBlockHelper();
    }

    public static LiveGameHelper liveGame() {
        return new LiveGameHelper();
    }

    private static LiveBetPlayerHelper liveBetPlayer() {
        return new LiveBetPlayerHelper();
    }

    private static LiveBetTeamHelper liveBetTeam() {
        return new LiveBetTeamHelper();
    }

    public static CongratsPopup congratsPopup() {
        return new CongratsPopup();
    }

    public static InviteFriendsPopup inviteFriendsPopup() {
        return new InviteFriendsPopup();
    }
}
