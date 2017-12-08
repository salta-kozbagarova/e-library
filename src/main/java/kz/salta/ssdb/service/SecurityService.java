package kz.salta.ssdb.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
