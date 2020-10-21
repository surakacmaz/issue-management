package com.surak.issuemanagement.service.impl;

import com.surak.issuemanagement.dto.IssueDto;
import com.surak.issuemanagement.entity.Issue;
import com.surak.issuemanagement.repository.IssueRepository;
import com.surak.issuemanagement.service.IssueService;
import com.surak.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Arrays;


public class IssueServiceImpl implements IssueService {


    private final IssueRepository issueRepository;
    public final ModelMapper modelMapper;
    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate()==null)
            throw new IllegalArgumentException("Issue date cannot be null!");
        Issue issueDb = modelMapper.map(issue, Issue.class);
        issueDb = issueRepository.save(issueDb);
        return modelMapper.map(issueDb, IssueDto.class);
    }

    @Override
    public IssueDto getById(long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(), IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;


    }

    @Override
    public Boolean delete(IssueDto issue) {
        issueRepository.deleteById(issue.getId());
        return Boolean.TRUE;
    }
}
