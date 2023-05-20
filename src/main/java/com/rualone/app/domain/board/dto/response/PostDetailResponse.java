package com.rualone.app.domain.board.dto.response;

import com.rualone.app.domain.board.entity.Comment;
import com.rualone.app.domain.board.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class PostDetailResponse {
    private Long id;
    private String subject;
    private String content;
    private int hit;
    private String authorName;
    private LocalDateTime createDate;
    private List<CommentResponse> commentList = new ArrayList<>();
    public PostDetailResponse(Long id, String subject, String content, int hit, String authorName, LocalDateTime createDate){
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.hit = hit;
        this.authorName = authorName;
        this.createDate = createDate;
    }
}
