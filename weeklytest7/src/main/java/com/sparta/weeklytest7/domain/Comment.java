package com.sparta.weeklytest7.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.weeklytest7.dto.ArticleCommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String comment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="article_idx", nullable = false)
    private Article article;

    public Comment(ArticleCommentRequestDto requestDto, Article article) {
        this.comment = requestDto.getComment();
        this.article = article;
    }

}