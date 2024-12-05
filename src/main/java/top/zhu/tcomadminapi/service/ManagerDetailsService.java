package top.zhu.tcomadminapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.model.entity.Manager;

public interface ManagerDetailsService {
    UserDetails getManagerDetails(Manager manager);
}
