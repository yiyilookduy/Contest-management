/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duypn.classes;

import javafx.application.Application;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author duypnse63523
 */
public class ActionHelper {
    
    private static final Map<String, String> MapAction;
    
    static{
        MapAction = new HashMap<>();

        // Controllers
        MapAction.put("Login", ApplicationContants.LOGINCONTROLLER);
        MapAction.put("Error", ApplicationContants.ERROR);
        // Profile
        MapAction.put("Profile", ApplicationContants.PROFILECONTROLLER);
        MapAction.put("UpdateProfile", ApplicationContants.UPDATEPROFILECONTROLLER);

        // Contest
        MapAction.put("EditContest", ApplicationContants.EDITCONTROLLER);
        MapAction.put("UpdateContest", ApplicationContants.UPDATECONTESTCONTROLLER);
        MapAction.put("DeleteContest", ApplicationContants.DELETECONTESTCONTROLLER);
        MapAction.put("CreateContest", ApplicationContants.CREATECONTESTCONTROLLER);
        MapAction.put("LoadContest", ApplicationContants.LOADCONTESTSCONTROLLER);
        MapAction.put("InfoContest", ApplicationContants.CONTESTINFO);
        MapAction.put("PageContest", ApplicationContants.CONTEST);



        // Role
        MapAction.put("admin", ApplicationContants.ADMIN);

        // Url page
        MapAction.put("LoginPage", ApplicationContants.LOGIN);
    }
    
    public static String Match (String action){
        return MapAction.getOrDefault(action, ApplicationContants.ERROR);
    }
}
