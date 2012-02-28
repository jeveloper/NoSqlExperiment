/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeveloper.beta.nosqlexperiment;

import com.jeveloper.beta.nosqlexperiment.model.Comment;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author serge
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="/MongoDB-context.xml")
public class CommentServiceTest {

    @Autowired
    CommentRepository repo;
    @Autowired
    MongoTemplate template;

    @Before
    public void setUp() {
        repo.save(new Comment("test", 5, "Serge"));
    }

    @Test
    public void shouldFindByCustomerQuery() {
        List<Comment> comments;

        // when
        comments = repo.findByTheUsersNickname("Serge"); // then
        Assert.assertNotNull(comments);
        Assert.assertEquals("Mismatch user count", 1, comments.size());
    }

    @After
    public void tearDown() {
        repo.deleteAll();
    }
}
