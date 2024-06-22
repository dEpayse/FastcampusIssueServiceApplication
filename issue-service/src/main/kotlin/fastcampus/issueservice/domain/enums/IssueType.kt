package fastcampus.issueservice.domain.enums

enum class IssueType {
    BUG, TASK;

    companion object {
        operator fun invoke(type: String): IssueType {
            return valueOf(type.uppercase())
        }
    }
}