package com.surak.issuemanagement.service;

import com.surak.issuemanagement.entity.Issue;
import com.surak.issuemanagement.entity.IssueHistory;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface IssueHistoryService {

    IssueHistory save(IssueHistory issueHistory);

    IssueHistory getById(long id);

    Page<IssueHistory> getAllPageable(Pageable pageable);

    Boolean delete(IssueHistory issueHistory);
}
