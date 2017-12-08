package kz.salta.ssdb.service;

import kz.salta.ssdb.dao.RoleDao;
import kz.salta.ssdb.dao.UserDao;
import kz.salta.ssdb.model.Role;
import kz.salta.ssdb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

/**
 * Implementation of {@link UserService} interface.
 *
 * @author Saltanat Alikhanova
 */

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name = "securityService")
    private SecurityService securityService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

	@Override
	public User getCurrentUser() {
		String username = securityService.findLoggedInUsername();
		User user = findByUsername(username);
		return user;
	}
}
