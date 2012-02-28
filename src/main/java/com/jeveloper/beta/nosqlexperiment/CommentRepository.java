
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
    
    //To Be implemented
    @Query("{ user.nickname: ?0 }")
    List<Comment> findByTheUsersNickname(String nickname);

    public List<Comment> getCommentsByAirid(long airlineid, Sort sort);

    public List<Comment> getCommentsByAirid(long airlineid, Pageable paging);
    
    
}
