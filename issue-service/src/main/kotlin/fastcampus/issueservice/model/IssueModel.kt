package fastcampus.issueservice.model

import com.fasterxml.jackson.annotation.JsonFormat
import fastcampus.issueservice.domain.Issue
import fastcampus.issueservice.domain.enums.IssuePriority
import fastcampus.issueservice.domain.enums.IssueStatus
import fastcampus.issueservice.domain.enums.IssueType
import java.time.LocalDateTime

data class IssueRequest(
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus
)

data class IssueResponse(
    val id: Long,
    val summary: String,
    val description: String,
    val userId: Long,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var createdAt: LocalDateTime?,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var updatedAt: LocalDateTime?
) {
    companion object {
        operator fun invoke(issue: Issue): IssueResponse {
            return IssueResponse(
                id = issue.id!!,
                summary = issue.summary,
                description = issue.description,
                userId = issue.userId,
                type = issue.type,
                priority = issue.priority,
                status = issue.status,
                createdAt = issue.createdAt,
                updatedAt = issue.updatedAt
            )
        }
    }
}