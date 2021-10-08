package modul;

import model.UserRoles;
import model.Roles;

import java.util.HashMap;
import java.util.Map;

public class RoleHandler {


    private static Map<UserRoles, Roles> roleMap = new HashMap<>();

    public static void loadRoles() {
        for (UserRoles role : UserRoles.values()) {
            roleMap.putIfAbsent(role, Roles.Roles(role));
        }
    }

    public static void checkRole(){
        //TODO
    }


}
