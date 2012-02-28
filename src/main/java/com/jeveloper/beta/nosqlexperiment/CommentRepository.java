package com.jeveloper.beta.nosqlexperiment;

import com.jeveloper.beta.nosqlexperiment.model.Comment;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author serge
 */
public interface CommentRepository extends MongoRepository<Comment, String> {

 
    @Query("{ user.nickname: ?0 }")
    List<Comment> findByTheUsersNickname(String nickname);

    List<Comment> getCommentsBytext(String text, Sort sort);

    List<Comment> getCommentsBytext(String text, Pageable paging);
}
