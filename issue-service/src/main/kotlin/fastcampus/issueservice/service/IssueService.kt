package fastcampus.issueservice.service

import fastcampus.issueservice.domain.Issue
import fastcampus.issueservice.domain.IssueRepository
import fastcampus.issueservice.domain.enums.IssueStatus
import fastcampus.issueservice.model.IssueRequest
import fastcampus.issueservice.model.IssueResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class IssueService(
    private val issueRepository: IssueRepository
) {
    @Transactional
    fun create(userId: Long, request: IssueRequest): IssueResponse =
        IssueResponse(
            issueRepository.save(
                Issue(
                    userId = userId,
                    summary = request.summary,
                    description = request.description,
                    type = request.type,
                    priority = request.priority,
                    status = request.status
                )
            )
        )

    @Transactional(readOnly = true)
    fun getAll(status: IssueStatus) =
        issueRepository.findAllByStatusOrderByCreatedAtDesc(status)
            ?.map { IssueResponse(it) }
}