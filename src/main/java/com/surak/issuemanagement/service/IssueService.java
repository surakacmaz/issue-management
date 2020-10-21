package com.surak.issuemanagement.service;

import com.surak.issuemanagement.dto.IssueDto;
import com.surak.issuemanagement.util.TPage;

import java.awt.print.Pageable;



public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);
}
