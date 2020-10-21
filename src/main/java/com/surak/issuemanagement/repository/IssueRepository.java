package com.surak.issuemanagement.repository;

import com.surak.issuemanagement.entity.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface IssueRepository extends JpaRepository<Issue, Long> {



}
