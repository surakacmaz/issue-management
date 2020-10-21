package com.surak.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "issue")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Issue extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description", length = 400)
    private String description;

    @Column(name = "details", length = 400)
    private String details;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;


}
