package net.thespblog.refapp.basegraphql.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import net.thespblog.refapp.basegraphql.model.Comment;
import net.thespblog.refapp.basegraphql.model.Post;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
class PostResolver implements GraphQLResolver<Post> {

    public List<Comment> getComments(Post post) {
        return Collections.emptyList();
    }

}