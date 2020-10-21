package com.surak.issuemanagement.service;

import com.surak.issuemanagement.entity.IssueHistory;
import com.surak.issuemanagement.entity.User;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface UserService {

    User save(User user);

    User getById(long id);

    Page<User> getAllPageable(Pageable pageable);

    User getByUsername(String username);
}
