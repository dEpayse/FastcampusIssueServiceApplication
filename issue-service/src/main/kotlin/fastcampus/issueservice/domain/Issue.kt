package fastcampus.issueservice.domain

import fastcampus.issueservice.domain.enums.IssuePriority
import fastcampus.issueservice.domain.enums.IssueStatus
import fastcampus.issueservice.domain.enums.IssueType
import jakarta.persistence.*

@Entity
@Table
class Issue (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    var userId: Long,
    @Column
    var summary: String,
    @Column
    var description: String,
    @Column
    @Enumerated(value = EnumType.STRING)
    var type: IssueType,
    @Column
    @Enumerated(value = EnumType.STRING)
    var priority: IssuePriority,
    @Column
    @Enumerated(value = EnumType.STRING)
    var status: IssueStatus
) : BaseEntity()