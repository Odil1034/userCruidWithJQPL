package uz.pdp.maven.usercruidwithjpql.service.userService;

import uz.pdp.maven.usercruidwithjpql.entity.user.User;
import uz.pdp.maven.usercruidwithjpql.service.BaseService;

public interface UserService extends BaseService<User> {

    User login(String username, String email, String password);
    void signUp(User user);

}
