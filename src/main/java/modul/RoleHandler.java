package modul;

import model.User;
import model.UserRoles;
import model.Roles;

import java.util.HashMap;
import java.util.Map;

public class RoleHandler extends Handler {


    private static Map<UserRoles, Roles> roleMap = new HashMap<>();

    public static void loadRoles() {
        for (UserRoles role : UserRoles.values()) {
            roleMap.putIfAbsent(role, Roles.Roles(role));
        }
    }

    public static Roles getUserRole(User user){
        return roleMap.get(user.getRole());
    }


}
