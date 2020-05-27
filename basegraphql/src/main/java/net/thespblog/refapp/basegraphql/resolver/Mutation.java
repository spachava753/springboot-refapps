package net.thespblog.refapp.basegraphql.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import net.thespblog.refapp.basegraphql.model.Post;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Mutation implements GraphQLMutationResolver {

    public Post createPost(String text) {
        Post post = new Post(new Random().nextLong());
        post.setText(text);
        return post;
    }
}